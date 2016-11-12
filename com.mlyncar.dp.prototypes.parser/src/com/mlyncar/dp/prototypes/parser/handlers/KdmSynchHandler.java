package com.mlyncar.dp.prototypes.parser.handlers;

import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmt.modisco.omg.kdm.code.ClassUnit;
import org.eclipse.gmt.modisco.omg.kdm.code.MethodUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;
import org.eclipse.modisco.java.discoverer.DiscoverKDMModelFromJavaProject;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.internal.Workbench;

public class KdmSynchHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		DiscoverKDMModelFromJavaProject discoverer = new DiscoverKDMModelFromJavaProject();
		discoverer.setSerializeTarget(true);
		IProgressMonitor monitor = new NullProgressMonitor();
		try {
			discoverer.discoverElement(getCurrentProject(), monitor);
		} catch (DiscoveryException ex) {
			throw new ExecutionException(
					"Failed to create KDM file from project", ex);
		}
		Resource kdmResource = discoverer.getTargetModel();
		IWorkbenchWindow window = HandlerUtil
				.getActiveWorkbenchWindowChecked(event);
		System.out.println("KDM Generated");
		System.out.println("KDM Content size: "
				+ kdmResource.getContents().size());

		// Model kdmModel = (Model) kdmResource.getContents().get(0);

		MessageDialog
				.openInformation(
						window.getShell(),
						"Parser",
						"KDM Generation sucessfully processed. "
								+ "Following KDM was extracted as object "
								+ kdmResource.getURI().devicePath()
								+ ". KDM contains following number of segments/elements: "
								+ checkKdmResults(kdmResource));

		return null;
	}

	public static IJavaProject getCurrentProject() {
		ISelectionService selectionService = Workbench.getInstance()
				.getActiveWorkbenchWindow().getSelectionService();

		ISelection selection = selectionService.getSelection();

		if (selection instanceof IStructuredSelection) {
			Object element = ((IStructuredSelection) selection)
					.getFirstElement();
			IProject selectedProject = (IProject) element;

			return JavaCore.create(selectedProject);
		}
		return null;
	}

	public int checkKdmResults(Resource kdmResource) {
		Iterator<EObject> it = kdmResource.getAllContents();
		int i = 0;
		while (it.hasNext()) {
			EObject next = it.next();
			if (next instanceof MethodUnit) {
				MethodUnit methodUnit = (MethodUnit) next;
				System.out.println("Method: " + methodUnit.getName());
			} else if (next instanceof ClassUnit) {
				ClassUnit classUnit = (ClassUnit) next;
				System.out.println("Class: " + classUnit.getName());
			}
			i++;
		}
		return i;
	}
}

package com.mlyncar.dp.prototypes.parser.handlers;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.internal.Workbench;

import com.mlyncar.dp.prototypes.parser.exception.UmlLoaderException;

public class UmlSynchHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil
				.getActiveWorkbenchWindowChecked(event);
		try {
			IFile umlFile = loadUmlFile();
			MessageDialog.openInformation(window.getShell(), "Parser",
					"UML analysis completed. UML " + umlFile.getName()
							+ " loaded.");

		} catch (UmlLoaderException ex) {
			throw new ExecutionException(
					"Unable to execute loading of uml file", ex);
		}

		return null;
	}

	public static IFile loadUmlFile() throws UmlLoaderException {
		ISelectionService selectionService = Workbench.getInstance()
				.getActiveWorkbenchWindow().getSelectionService();

		ISelection selection = selectionService.getSelection();

		if (selection instanceof IStructuredSelection) {
			Object element = ((IStructuredSelection) selection)
					.getFirstElement();
			IProject selectedProject = (IProject) element;
			IFile umlFile = selectedProject.getFile("model.uml");
			System.out.println("Obtained file " + umlFile.getName());
			try {
				System.out.println(IOUtils.toString(umlFile.getContents(),
						"UTF-8"));
			} catch (IOException | CoreException ex) {
				throw new UmlLoaderException("Unable to load uml file ", ex);
			}
			return umlFile;
		}
		return null;
	}
}

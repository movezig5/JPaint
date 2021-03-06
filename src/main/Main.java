package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.dialogs.DialogProvider;
import model.interfaces.IDialogProvider;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

public class Main {
    public static void main(String[] args){
        IGuiWindow guiWindow = new GuiWindow(new PaintCanvas());
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = ApplicationState.getInstance(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();
    }
}

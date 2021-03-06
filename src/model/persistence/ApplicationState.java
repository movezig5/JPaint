package model.persistence;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.StartAndEndPointMode;
import model.dialogs.DialogProvider;
import model.interfaces.IApplicationState;
import model.interfaces.ICommand;
import model.interfaces.IDialogProvider;
import view.interfaces.IUiModule;

import java.util.Stack;

public class ApplicationState implements IApplicationState {
    private final IUiModule uiModule;
    private final IDialogProvider dialogProvider;

    private ShapeType activeShapeType;
    private ShapeColor activePrimaryColor;
    private ShapeColor activeSecondaryColor;
    private ShapeShadingType activeShapeShadingType;
    private StartAndEndPointMode activeStartAndEndPointMode;

    private Stack<ICommand> commandHistory;
    private Stack<ICommand> commandsUndone;

    private static ApplicationState instance;

    private ApplicationState(IUiModule uiModule) {
        this.uiModule = uiModule;
        this.dialogProvider = new DialogProvider(this);
        this.commandHistory = new Stack<>();
        this.commandsUndone = new Stack<>();
        setDefaults();
    }

    public static ApplicationState getInstance(IUiModule uiModule) {
        if(instance == null)
            instance = new ApplicationState(uiModule);
        return instance;
    }

    public static ApplicationState getInstance() {
        if(instance != null) {
            return instance;
        } else {
            return null;
        }
    }

    @Override
    public void setActiveShape() {
        activeShapeType = uiModule.getDialogResponse(dialogProvider.getChooseShapeDialog());
    }

    @Override
    public void setActivePrimaryColor() {
        activePrimaryColor = uiModule.getDialogResponse(dialogProvider.getChoosePrimaryColorDialog());
    }

    @Override
    public void setActiveSecondaryColor() {
        activeSecondaryColor = uiModule.getDialogResponse(dialogProvider.getChooseSecondaryColorDialog());
    }

    @Override
    public void setActiveShadingType() {
        activeShapeShadingType = uiModule.getDialogResponse(dialogProvider.getChooseShadingTypeDialog());
    }

    @Override
    public void setActiveStartAndEndPointMode() {
        activeStartAndEndPointMode = uiModule.getDialogResponse(dialogProvider.getChooseStartAndEndPointModeDialog());
    }

    @Override
    public ShapeType getActiveShapeType() {
        return activeShapeType;
    }

    @Override
    public ShapeColor getActivePrimaryColor() {
        return activePrimaryColor;
    }

    @Override
    public ShapeColor getActiveSecondaryColor() {
        return activeSecondaryColor;
    }

    @Override
    public ShapeShadingType getActiveShapeShadingType() {
        return activeShapeShadingType;
    }

    @Override
    public StartAndEndPointMode getActiveStartAndEndPointMode() { return activeStartAndEndPointMode; }

    @Override
    public void executeCommand(ICommand command) {
        command.execute();
        commandHistory.push(command);
        if(!commandsUndone.empty())
            commandsUndone.removeAllElements();
    }

    @Override
    public void undo() {
        if(!commandHistory.empty()) {
            ICommand command = commandHistory.pop();
            command.unexecute();
            commandsUndone.push(command);
        }
    }

    @Override
    public void redo() {
        if(!commandsUndone.empty()) {
            ICommand command = commandsUndone.pop();
            command.execute();
            commandHistory.push(command);
        }
    }

    private void setDefaults() {
        activeShapeType = ShapeType.ELLIPSE;
        activePrimaryColor = ShapeColor.BLUE;
        activeSecondaryColor = ShapeColor.GREEN;
        activeShapeShadingType = ShapeShadingType.FILLED_IN;
        activeStartAndEndPointMode = StartAndEndPointMode.DRAW;
    }
}

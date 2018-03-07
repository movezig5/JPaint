package model.commands;

import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.shapes.ShapeList;

import java.util.ArrayList;

public class PasteShape implements ICommand {
    private ShapeList shapeList;
    private int numPasted;

    public PasteShape() {
        shapeList = ShapeList.getInstance();
        numPasted = 0;
    }

    @Override
    public void execute() {
        numPasted = shapeList.getCopiedShapes().size();
        shapeList.pasteShapes();
    }

    @Override
    public void unexecute() {
        ArrayList<IShape> shapes = shapeList.getShapes();
        int idx = shapes.size() - 1;
        for(int i = 0; i < numPasted; i++) {
            shapes.remove(idx);
            idx -= 1;
        }
    }
}

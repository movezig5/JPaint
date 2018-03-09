package model.commands;

import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.shapes.ShapeList;

import java.util.ArrayList;
import java.util.List;

public class DeleteShape implements ICommand {
    private ShapeList shapeList;
    private List<IShape> deletedShapes;
    private List<Integer> shapeIndices;

    public DeleteShape() {
        shapeList = ShapeList.getInstance();
        deletedShapes = new ArrayList<>();
        shapeIndices = new ArrayList<>();
    }

    @Override
    public void execute() {
        for(IShape shape : shapeList.getShapes()) {
            deletedShapes.add(shape);
            shapeIndices.add(shapeList.getShapes().indexOf(shape));
        }
        shapeList.deleteShapes();
    }

    @Override
    public void unexecute() {
        for(int i = 0; i < deletedShapes.size(); i++) {
            shapeList.getShapes().add(shapeIndices.get(i), deletedShapes.get(i));
        }
        shapeList.notifyObservers();
    }
}

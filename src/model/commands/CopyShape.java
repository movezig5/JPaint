package model.commands;

import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.shapes.ShapeFactory;
import model.shapes.ShapeList;

import java.util.ArrayList;
import java.util.List;

public class CopyShape implements ICommand {
    private ShapeList shapeList;
    private List<IShape> previousCopies;

    public CopyShape() {
        this.shapeList = ShapeList.getInstance();
        this.previousCopies = new ArrayList<>();
    }

    @Override
    public void execute() {
        for(IShape shape : shapeList.getCopiedShapes()) {
            previousCopies.add(ShapeFactory.copyShape(shape));
        }
        shapeList.copyShapes();
    }

    @Override
    public void unexecute() {
        shapeList.getCopiedShapes().clear();
        for(IShape shape : previousCopies) {
            shapeList.getCopiedShapes().add(shape);
        }
    }
}

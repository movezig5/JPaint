package model.commands;

import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.shapes.ShapeList;

import java.awt.*;

public class SelectShape implements ICommand {
    private Point startPoint, endPoint;
    private boolean[] previouslySelected;
    private ShapeList shapeList;

    public SelectShape(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        shapeList = ShapeList.getInstance();
        int numShapes = shapeList.getShapes().size();
        previouslySelected = new boolean[numShapes];
    }

    @Override
    public void execute() {
        for(IShape shape : shapeList.getShapes()) {
            int idx = shapeList.getShapes().indexOf(shape);
            if(shape.isSelected())
                previouslySelected[idx] = true;
            else
                previouslySelected[idx] = false;
        }
        int
                startX = (int) startPoint.getX(),
                endX = (int) endPoint.getX(),
                startY = (int) startPoint.getY(),
                endY = (int) endPoint.getY();
        shapeList.selectShapes(startX, startY, endX, endY);
        shapeList.notifyObservers();
    }

    @Override
    public void unexecute() {
        for(int i = 0; i < previouslySelected.length; i++) {
            if(previouslySelected[i])
                shapeList.getShapes().get(i).select();
            else
                shapeList.getShapes().get(i).deselect();
        }
        shapeList.notifyObservers();
    }
}

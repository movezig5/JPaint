package model.commands;

import model.interfaces.ICommand;
import model.shapes.ShapeList;

import java.awt.*;

public class MoveShape implements ICommand {
    private Point startPoint, endPoint;
    private int dx, dy;
    private ShapeList shapeList;

    public MoveShape(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        dx = (int) (endPoint.getX() - startPoint.getX());
        dy = (int) (endPoint.getY() - startPoint.getY());
        shapeList = ShapeList.getInstance();
    }

    @Override
    public void execute() {
        shapeList.moveShapes(dx, dy);
    }

    @Override
    public void unexecute() {
        shapeList.moveShapes(-dx, -dy);
    }
}

package model.commands;

import model.interfaces.ICommand;
import model.shapes.ShapeList;

import java.awt.*;

public class MoveShape implements ICommand {
    private Point startPoint, endPoint;

    public MoveShape(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    @Override
    public void run() {
        int dx = (int) (endPoint.getX() - startPoint.getX());
        int dy = (int) (endPoint.getY() - startPoint.getY());
        ShapeList.getInstance().moveShapes(dx, dy);
    }
}

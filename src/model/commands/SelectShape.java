package model.commands;

import model.interfaces.ICommand;
import model.shapes.ShapeList;

import java.awt.*;

public class SelectShape implements ICommand {
    private Point startPoint, endPoint;

    public SelectShape(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    @Override
    public void run() {
        int
                startX = (int) startPoint.getX(),
                endX = (int) endPoint.getX(),
                startY = (int) startPoint.getY(),
                endY = (int) endPoint.getY();
        ShapeList.getInstance().selectShapes(startX, startY, endX, endY);
    }
}

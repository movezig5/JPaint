package model.shapes;

import model.interfaces.IObserver;
import model.interfaces.IShape;
import model.interfaces.ISubject;

import java.awt.*;
import java.util.ArrayList;

public class ShapeList implements ISubject{
    private ArrayList<IShape> shapes;
    private ArrayList<IObserver> observers;
    private static ShapeList shapeList;

    private ShapeList() {
        shapes = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static ShapeList getInstance() {
        if(shapeList == null) {
            shapeList = new ShapeList();
        }
        return shapeList;
    }

    public ArrayList<IShape> getShapes() {
        return shapes;
    }

    public void addShape(IShape s) {
        shapes.add(s);
        notifyObservers();
    }

    public void selectShapes(int startX, int startY, int endX, int endY) {
        for(IShape shape : shapes) {
            int
                    shapeStartX = (int) shape.getStartPoint().getX(),
                    shapeStartY = (int) shape.getStartPoint().getY(),
                    shapeEndX = (int) shape.getEndPoint().getX(),
                    shapeEndY = (int) shape.getEndPoint().getY();

            if(
                    startX < shapeEndX && startY < shapeEndY &&
                    endX > shapeStartX && endY > shapeStartY) {
                shape.select();
            } else {
                shape.deselect();
            }
        }
        notifyObservers();
    }

    public void moveShapes(int dx, int dy) {
        for(IShape shape : shapes) {
            if(shape.isSelected()) {
                int
                        startX = (int) shape.getStartPoint().getX() + dx,
                        startY = (int) shape.getStartPoint().getY() + dy,
                        endX = (int) shape.getEndPoint().getX() + dx,
                        endY = (int) shape.getEndPoint().getY() + dy;

                shape.setStartPoint(new Point(startX, startY));
                shape.setEndPoint(new Point(endX, endY));
            }
        }
        notifyObservers();
    }

    public void deleteShapes() {
        for(int i = 0; i < shapes.size(); i++) {
            if(shapes.get(i).isSelected()) {
                shapes.remove(i);
            }
        }
        notifyObservers();
    }

    @Override
    public void registerObserver(IObserver o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers() {
        for(IObserver o : observers) {
            o.update();
        }
    }
}

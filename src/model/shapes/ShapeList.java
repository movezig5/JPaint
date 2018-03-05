package model.shapes;

import model.interfaces.IObserver;
import model.interfaces.IShape;
import model.interfaces.ISubject;

import java.awt.*;
import java.util.ArrayList;

public class ShapeList implements ISubject{
    private ArrayList<IShape> shapes;
    private ArrayList<IObserver> observers;
    private ArrayList<IShape> copiedShapes;
    private static ShapeList shapeList;

    private ShapeList() {
        shapes = new ArrayList<>();
        observers = new ArrayList<>();
        copiedShapes = new ArrayList<>();
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

            if( // Currently it's only possible to select by dragging top-down, right to left.
                    (startX < shapeEndX) && (startY < shapeEndY) &&
                    (endX > shapeStartX) && (endY > shapeStartY)
            ) {
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

    public void copyShapes() {
        copiedShapes.clear();
        for(IShape shape : shapes) {
            if(shape.isSelected()) {
                IShape copy = ShapeFactory.copyShape(shape);
                copy.deselect();
                int
                        dx = (int) (copy.getEndPoint().getX() - copy.getStartPoint().getX()),
                        dy = (int) (copy.getEndPoint().getY() - copy.getStartPoint().getY());
                copy.getStartPoint().setLocation(0,0);
                copy.getEndPoint().setLocation(dx, dy);
                copiedShapes.add(copy);
            }
        }
    }

    public void pasteShapes() {
        for(IShape shape : copiedShapes) {
            shapes.add(shape);
            notifyObservers();
        }
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

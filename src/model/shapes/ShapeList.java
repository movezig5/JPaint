package model.shapes;

import model.interfaces.IObserver;
import model.interfaces.IShape;
import model.interfaces.ISubject;

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

    public IShape getLatest() {
        return shapes.get(shapes.size() - 1);
    }

    public void addShape(IShape s) {
        shapes.add(s);
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

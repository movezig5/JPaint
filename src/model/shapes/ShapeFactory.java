package model.shapes;

import model.interfaces.IShape;

import java.security.InvalidParameterException;

public class ShapeFactory {
    public static IShape createShape(String shapeType) {
        IShape shape;
        shapeType = shapeType.toLowerCase();
        switch(shapeType) {
            case "triangle":
                shape = new Triangle();
                break;
            case "rectangle":
                shape = new Rectangle();
                break;
            case "ellipse":
                shape = new Ellipse();
                break;
            default:
                throw new InvalidParameterException("Parameter must be an existing shape type.");
        }
        return shape;
    }
}

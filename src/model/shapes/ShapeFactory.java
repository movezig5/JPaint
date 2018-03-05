package model.shapes;

import model.interfaces.IShape;
import model.persistence.ApplicationState;

import java.awt.*;
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

    public static IShape copyShape(IShape shape) {
        IShape newShape;
        switch(shape.getShapeType()) {
            case TRIANGLE:
                newShape = new Triangle();
                break;
            case RECTANGLE:
                newShape = new Rectangle();
                break;
            case ELLIPSE:
                newShape = new Ellipse();
                break;
            default:
                throw new InvalidParameterException("Error in type of copied shape");
        }
        newShape.setPrimaryColor(shape.getPrimaryColor());
        newShape.setSecondaryColor(shape.getSecondaryColor());
        newShape.setShadingType(shape.getShadingType());
        int
                startX = (int) shape.getStartPoint().getX(),
                startY = (int) shape.getStartPoint().getY(),
                endX = (int) shape.getEndPoint().getX(),
                endY = (int) shape.getEndPoint().getY();
        newShape.setStartPoint(new Point(startX, startY));
        newShape.setEndPoint(new Point(endX, endY));
        return newShape;
    }
}

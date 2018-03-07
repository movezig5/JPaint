package model.commands;

import model.ShapeColor;
import model.ShapeShadingType;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import model.shapes.ShapeList;

import static model.shapes.ShapeFactory.createShape;

import java.awt.*;
import java.security.InvalidParameterException;

public class CreateShape implements ICommand {
    private Point startPoint, endPoint;
    private ApplicationState state;
    private ShapeList shapeList;
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private ShapeShadingType shadingType;
    private IShape shapeToAdd;

    public CreateShape(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        state = ApplicationState.getInstance();
        primaryColor = state.getActivePrimaryColor();
        secondaryColor = state.getActiveSecondaryColor();
        shadingType = state.getActiveShapeShadingType();
        shapeList = ShapeList.getInstance();
        shapeToAdd = initializeShape();
    }

    private IShape initializeShape() {
        IShape shape;
        switch (state.getActiveShapeType()) {
            case TRIANGLE:
                shape = createShape("TRIANGLE");
                break;
            case RECTANGLE:
                shape = createShape("RECTANGLE");
                break;
            case ELLIPSE:
                shape = createShape("ELLIPSE");
                break;
            default:
                throw new InvalidParameterException("Parameter must be an existing shape type.");
        }

        // This part of the code allows the endpoint's X and Y coordinates
        // to be less than the start point's X and Y coordinates, respectively.
        double startX = startPoint.getX(),
                endX = endPoint.getX(),
                startY = startPoint.getY(),
                endY = endPoint.getY();
        boolean newPointsNeededed = false;
        if(startX > endX) {
            newPointsNeededed = true;
            startX = endX;
            endX = startPoint.getX();
        }
        if(startY > endY) {
            newPointsNeededed = true;
            startY = endY;
            endY = startPoint.getY();
        }
        if(newPointsNeededed) {
            startPoint.setLocation(startX, startY);
            endPoint.setLocation(endX, endY);
        }

        shape.setStartPoint(startPoint);
        shape.setEndPoint(endPoint);
        if(state == null) { // This shouldn't happen, but just to be safe...
            shape.setPrimaryColor(ShapeColor.BLACK);
            shape.setSecondaryColor(ShapeColor.BLACK);
            shape.setShadingType(ShapeShadingType.OUTLINE);
        } else {
            shape.setPrimaryColor(primaryColor);
            shape.setSecondaryColor(secondaryColor);
            shape.setShadingType(shadingType);
        }
        return shape;
    }

    @Override
    public void execute() {
        shapeList.addShape(shapeToAdd);
    }

    @Override
    public void unexecute() {
        shapeList.unAddShape();
    }
}

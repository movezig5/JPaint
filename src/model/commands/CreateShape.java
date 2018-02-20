package model.commands;

import model.ShapeColor;
import model.ShapeShadingType;
import model.StartAndEndPointMode;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import static model.shapes.ShapeFactory.createShape;

import java.awt.*;
import java.security.InvalidParameterException;

import static model.shapes.ShapeList.getInstance;

public class CreateShape implements ICommand {
    private Point startPoint, endPoint;
    private ApplicationState state;

    public CreateShape(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.state = ApplicationState.getInstance();
    }

    @Override
    public void run() {
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
            shape.setStartAndEndPointMode(StartAndEndPointMode.DRAW);
        } else {
            shape.setPrimaryColor(state.getActivePrimaryColor());
            shape.setSecondaryColor(state.getActiveSecondaryColor());
            shape.setShadingType(state.getActiveShapeShadingType());
            shape.setStartAndEndPointMode(state.getActiveStartAndEndPointMode());
        }

        getInstance().addShape(shape); // The getInstance() method here is from ShapeList
    }
}

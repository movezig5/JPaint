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

import static model.shapes.ShapeList.getShapeList;

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
        shape.setStartPoint(startPoint);
        shape.setEndPoint(endPoint);
        if(state == null) { // This shouldn't happen, but I don't have a good solution for this
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

        getShapeList().addShape(shape);
    }
}

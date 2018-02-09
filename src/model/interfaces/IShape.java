package model.interfaces;

import model.ShapeType;
import model.ShapeColor;
import model.ShapeShadingType;
import model.StartAndEndPointMode;
import view.interfaces.IPaintCanvas;

import java.awt.*;

public interface IShape {

    ShapeType getShapeType();

    ShapeColor getPrimaryColor();
    void setPrimaryColor(ShapeColor primaryColor);

    ShapeColor getSecondaryColor();
    void setSecondaryColor(ShapeColor secondaryColor);

    ShapeShadingType getShadingType();
    void setShadingType(ShapeShadingType shadingType);

    StartAndEndPointMode getStartAndEndPointMode();
    void setStartAndEndPointMode(StartAndEndPointMode startAndEndPointMode);

    Point getStartPoint();
    Point getEndPoint();

    void setStartPoint(Point startPoint);
    void setEndPoint(Point endPoint);

    void draw(IPaintCanvas canvas);
}

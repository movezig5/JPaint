package model.interfaces;

import model.ShapeType;
import model.ShapeColor;
import model.ShapeShadingType;

import java.awt.*;

public interface IShape {

    ShapeType getShapeType();

    ShapeColor getPrimaryColor();
    void setPrimaryColor(ShapeColor primaryColor);

    ShapeColor getSecondaryColor();
    void setSecondaryColor(ShapeColor secondaryColor);

    ShapeShadingType getShadingType();
    void setShadingType(ShapeShadingType shadingType);

    Point getStartPoint();
    Point getEndPoint();

    void setStartPoint(Point startPoint);
    void setEndPoint(Point endPoint);

    void draw(Graphics2D graphics2D);

    void select();
    void deselect();
    boolean isSelected();
}

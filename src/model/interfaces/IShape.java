package model.interfaces;

import model.ShapeType;
import model.ShapeColor;
import model.ShapeShadingType;
import model.StartAndEndPointMode;

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

    int getX();
    int getY();
    int getWidth();
    int getHeight();
    void setX(int x);
    void setY(int y);
    void setWidth(int width);
    void setHeight(int height);

}

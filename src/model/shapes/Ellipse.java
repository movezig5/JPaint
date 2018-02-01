package model.shapes;

import model.ShapeType;
import model.ShapeColor;
import model.ShapeShadingType;
import model.StartAndEndPointMode;
import model.interfaces.IShape;

class Ellipse implements IShape {

    private ShapeType shapeType;
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private ShapeShadingType shadingType;
    private StartAndEndPointMode startAndEndPointMode;
    private int x, y, width, height;

    Ellipse(
            ShapeColor primaryColor,
            ShapeColor secondaryColor,
            ShapeShadingType shadingType,
            StartAndEndPointMode startAndEndPointMode,
            int x, int y, int width, int height
    ) {
        shapeType = ShapeType.ELLIPSE;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.shadingType = shadingType;
        this.startAndEndPointMode = startAndEndPointMode;
        this.x = x; this.y = y; this.width = width; this.height = height;
    }

    Ellipse() {
        shapeType = ShapeType.ELLIPSE;
        primaryColor = ShapeColor.BLACK;
        secondaryColor = ShapeColor.BLACK;
        shadingType = ShapeShadingType.FILLED_IN;
        startAndEndPointMode = StartAndEndPointMode.SELECT;
        x = 0; y = 0; width = 1; height = 1;
    }

    @Override
    public ShapeType getShapeType() {
        return shapeType;
    }

    @Override
    public ShapeColor getPrimaryColor() {
        return primaryColor;
    }

    @Override
    public void setPrimaryColor(ShapeColor primaryColor) {
        this.primaryColor = primaryColor;
    }

    @Override
    public ShapeColor getSecondaryColor() {
        return secondaryColor;
    }

    @Override
    public void setSecondaryColor(ShapeColor secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    @Override
    public ShapeShadingType getShadingType() {
        return shadingType;
    }

    @Override
    public void setShadingType(ShapeShadingType shadingType) {
        this.shadingType = shadingType;
    }

    @Override
    public StartAndEndPointMode getStartAndEndPointMode() {
        return startAndEndPointMode;
    }

    @Override
    public void setStartAndEndPointMode(StartAndEndPointMode startAndEndPointMode) {
        this.startAndEndPointMode = startAndEndPointMode;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }
}

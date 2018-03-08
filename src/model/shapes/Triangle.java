package model.shapes;

import model.ShapeType;
import model.ShapeColor;
import model.ShapeShadingType;
import model.interfaces.IShape;
import model.interfaces.IShapeStrategy;
import model.strategies.ShapeStrategy;

import java.awt.*;

class Triangle implements IShape {

    private ShapeType shapeType;
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private ShapeShadingType shadingType;
    private Point startPoint, endPoint;
    private IShapeStrategy strategy;
    private boolean isSelected;

    Triangle() {
        shapeType = ShapeType.TRIANGLE;
        primaryColor = ShapeColor.BLACK;
        secondaryColor = ShapeColor.BLACK;
        shadingType = ShapeShadingType.FILLED_IN;
        startPoint = new Point(0,0);
        endPoint = new Point(0,0);
        strategy = new ShapeStrategy(this);
        isSelected = false;
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
    public Point getStartPoint() {
        return startPoint;
    }

    @Override
    public Point getEndPoint() {
        return endPoint;
    }

    @Override
    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    @Override
    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        strategy.draw(graphics2D);
    }

    @Override
    public void select() { isSelected = true; }

    @Override
    public void deselect() { isSelected = false; }

    @Override
    public boolean isSelected() { return isSelected; }
}

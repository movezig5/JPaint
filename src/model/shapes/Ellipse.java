package model.shapes;

import model.ShapeType;
import model.ShapeColor;
import model.ShapeShadingType;
import model.StartAndEndPointMode;
import model.interfaces.IShape;
import view.interfaces.IPaintCanvas;

import java.awt.*;

class Ellipse implements IShape {

    private ShapeType shapeType;
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private ShapeShadingType shadingType;
    private StartAndEndPointMode startAndEndPointMode;
    private Point startPoint, endPoint;

    Ellipse(
            ShapeColor primaryColor,
            ShapeColor secondaryColor,
            ShapeShadingType shadingType,
            StartAndEndPointMode startAndEndPointMode,
            int startX, int startY, int endX, int endY
    ) {
        shapeType = ShapeType.ELLIPSE;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.shadingType = shadingType;
        this.startAndEndPointMode = startAndEndPointMode;
        startPoint = new Point(startX, startY);
        endPoint = new Point(endX, endY);
    }

    Ellipse() {
        shapeType = ShapeType.ELLIPSE;
        primaryColor = ShapeColor.BLACK;
        secondaryColor = ShapeColor.BLACK;
        shadingType = ShapeShadingType.FILLED_IN;
        startAndEndPointMode = StartAndEndPointMode.SELECT;
        startPoint = new Point(0,0);
        endPoint = new Point(0,0);
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
    public void draw(IPaintCanvas canvas) {
        int x = (int) startPoint.getX();
        int y = (int) startPoint.getY();
        int width = (int) endPoint.getX() - x;
        int height = (int) endPoint.getY() - y;
        canvas.getGraphics2D().drawOval(x, y, width, height);
    }
}

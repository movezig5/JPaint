package model.strategies;

import model.interfaces.IShape;
import model.interfaces.IShapeStrategy;
import view.interfaces.IPaintCanvas;

public class RectangleStrategy implements IShapeStrategy {

    private IShape shape;

    public RectangleStrategy(IShape shape) {
        this.shape = shape;
    }

    @Override
    public void draw(IPaintCanvas canvas) {
        int
                x = (int) shape.getStartPoint().getX(),
                y = (int) shape.getStartPoint().getY(),
                width = (int) shape.getEndPoint().getX() - x,
                height = (int) shape.getEndPoint().getY() - y;
        canvas.getGraphics2D().drawRect(x, y, width, height);
    }
}

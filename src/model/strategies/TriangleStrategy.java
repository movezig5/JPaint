package model.strategies;

import model.interfaces.IShape;
import model.interfaces.IShapeStrategy;
import view.interfaces.IPaintCanvas;

public class TriangleStrategy implements IShapeStrategy{

    private IShape shape;

    public TriangleStrategy(IShape shape) {
        this.shape = shape;
    }

    @Override
    public void draw(IPaintCanvas canvas) {
        int
                x = (int) shape.getStartPoint().getX(),
                y = (int) shape.getStartPoint().getY(),
                x2 = (int) shape.getEndPoint().getX(),
                y2 = (int) shape.getEndPoint().getY();
        int[] xs = {x, x2, x};
        int[] ys = {y, y2, y2};
        canvas.getGraphics2D().drawPolygon(xs, ys, 3);
    }
}

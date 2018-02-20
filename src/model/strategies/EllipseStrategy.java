package model.strategies;

import model.interfaces.IShape;
import model.interfaces.IShapeStrategy;
import view.interfaces.IPaintCanvas;

public class EllipseStrategy implements IShapeStrategy {

    private IShape shape;

    public EllipseStrategy(IShape shape) {
        this.shape = shape;
    }

    @Override
    public void draw(IPaintCanvas canvas) {
        int
                x = (int) shape.getStartPoint().getX(),
                y = (int) shape.getStartPoint().getY(),
                width = (int) shape.getEndPoint().getX() - x,
                height = (int) shape.getEndPoint().getY() - y;
        canvas.getGraphics2D().drawOval(x, y, width, height);
    }
}

package model.strategies;

import model.ShapeColor;
import model.interfaces.IShape;
import model.interfaces.IShapeStrategy;
import view.interfaces.IPaintCanvas;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class ShapeStrategy implements IShapeStrategy {

    private IShape shape;

    public ShapeStrategy(IShape shape) {
        this.shape = shape;
    }

    private Color getJavaColor(ShapeColor sc) {
        switch(sc) {
            case BLACK:
                return Color.BLACK;
            case BLUE:
                return Color.BLUE;
            case GREEN:
                return Color.GREEN;
            case RED:
                return Color.RED;
            case CYAN:
                return Color.CYAN;
            case GRAY:
                return Color.GRAY;
            case PINK:
                return Color.PINK;
            case WHITE:
                return Color.WHITE;
            case ORANGE:
                return Color.ORANGE;
            case YELLOW:
                return Color.YELLOW;
            case MAGENTA:
                return Color.MAGENTA;
            case DARK_GRAY:
                return Color.DARK_GRAY;
            case LIGHT_GRAY:
                return Color.LIGHT_GRAY;
            default:
                throw new Error("Invalid shape color!");
        }
    }

    @Override
    public void draw(IPaintCanvas canvas) {
        int
                x = (int) shape.getStartPoint().getX(),
                y = (int) shape.getStartPoint().getY(),
                x2 = (int) shape.getEndPoint().getX(),
                y2 = (int) shape.getEndPoint().getY(),
                width = x2 - x,
                height = y2 - y;
        Graphics2D graphics2D = canvas.getGraphics2D();
        Color primary = getJavaColor(shape.getPrimaryColor());
        Color secondary = getJavaColor(shape.getSecondaryColor());
        Shape drawnShape;
        switch(shape.getShapeType()) {
            case ELLIPSE:
                drawnShape = new Ellipse2D.Double(x, y, width, height);
                break;
            case RECTANGLE:
                drawnShape = new Rectangle(x, y, width, height);
                break;
            case TRIANGLE:
                int[] xs = {x, x, x2};
                int[] ys = {y, y2, y2};
                drawnShape = new Polygon(xs, ys, 3);
                break;
            default:
                throw new Error("Invalid shape type");
        }
        switch(shape.getShadingType()) {
            case OUTLINE:
                graphics2D.setColor(primary);
                graphics2D.draw(drawnShape);
                break;
            case FILLED_IN:
                graphics2D.setColor(primary);
                graphics2D.fill(drawnShape);
                break;
            case OUTLINE_AND_FILLED_IN:
                graphics2D.setColor(secondary);
                graphics2D.fill(drawnShape);
                graphics2D.setColor(primary);
                graphics2D.draw(drawnShape);
                break;
            default:
                throw new Error("Invalid shading type");
        }
    }
}

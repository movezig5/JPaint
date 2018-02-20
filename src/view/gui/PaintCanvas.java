package view.gui;

import model.interfaces.IObserver;
import model.shapes.ShapeList;
import view.interfaces.IPaintCanvas;

import javax.swing.JComponent;
import java.awt.*;

public class PaintCanvas extends JComponent implements IPaintCanvas, IObserver {


    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }

    @Override
    public void update() {
        ShapeList.getInstance().getLatest().draw(this);
    }
}

package controller;

import model.commands.CreateShape;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Point;

public class MouseHandler extends MouseAdapter {
    private Point startPoint, endPoint;

    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endPoint = e.getPoint();
        new CreateShape(startPoint, endPoint).run();
    }

    public MouseHandler() {
        startPoint = new Point(0,0);
        endPoint = new Point(0, 0);
    }
}

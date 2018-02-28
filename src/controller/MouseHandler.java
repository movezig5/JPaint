package controller;

import model.StartAndEndPointMode;
import model.commands.CreateShape;
import model.commands.MoveShape;
import model.commands.SelectShape;
import model.persistence.ApplicationState;

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
        switch (ApplicationState.getInstance().getActiveStartAndEndPointMode()) {
            case DRAW:
                new CreateShape(startPoint, endPoint).run();
                break;
            case SELECT:
                new SelectShape(startPoint, endPoint).run();
                break;
            case MOVE:
                new MoveShape(startPoint, endPoint).run();
                break;
            default:
                throw new Error("Invalid start/end point mode");
        }
    }

    public MouseHandler() {
        startPoint = new Point(0,0);
        endPoint = new Point(0, 0);
    }
}

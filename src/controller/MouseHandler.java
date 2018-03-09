package controller;

import model.commands.CreateShape;
import model.commands.MoveShape;
import model.commands.SelectShape;
import model.interfaces.IApplicationState;
import model.persistence.ApplicationState;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Point;

public class MouseHandler extends MouseAdapter {
    private Point startPoint, endPoint;
    private IApplicationState state;

    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = e.getPoint();
        state = ApplicationState.getInstance();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endPoint = e.getPoint();
        switch (ApplicationState.getInstance().getActiveStartAndEndPointMode()) {
            case DRAW:
                state.executeCommand(new CreateShape(startPoint, endPoint));
                break;
            case SELECT:
                state.executeCommand(new SelectShape(startPoint, endPoint));
                break;
            case MOVE:
                state.executeCommand(new MoveShape(startPoint, endPoint));
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

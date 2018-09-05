package com.jiceedev.evalplus.userinterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainUI extends JFrame {
    private ActionPanel actionPanel;
    private PositionPanel positionPanel;
    private EvalPanel evalPanel;

    public MainUI() {
        super();
        initInterface();
    }

    void initInterface() {
        Dimension screenSize 	= Toolkit.getDefaultToolkit().getScreenSize();
        double width 			= screenSize.getWidth();
        double height 			= screenSize.getHeight();

        actionPanel = new ActionPanel();
        positionPanel = new PositionPanel();
        evalPanel = new EvalPanel();
        add(actionPanel, BorderLayout.WEST);
        add(positionPanel, BorderLayout.NORTH);
        add(evalPanel, BorderLayout.SOUTH);


        setLocationRelativeTo(null);

        actionPanel.reactToResize((int) width, (int) height);
        positionPanel.reactToResize((int) width, (int) height);
        evalPanel.reactToResize((int) width, (int) height);


        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                actionPanel.reactToResize(getWidth(), getHeight());
                positionPanel.reactToResize(getWidth(), getHeight());
                evalPanel.reactToResize(getWidth(),getHeight());
            }
        });


        setName("Evalplus");
        setSize(new Dimension((int) width, (int) height));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setVisible(true);

    }
}

package com.jiceedev.evalplus.userinterface;

import javax.swing.*;
import java.awt.*;

public class PositionPanel extends JPanel {

    private JPanel group;
    private JLabel xLabel, yLabel, fxLabel;
    private JTextField x,y,fx;

    PositionPanel() {
        super();
        initInterface();
    }

    private void initInterface() {
        //setBackground(Color.ORANGE);
        group = new JPanel();
        x = new JTextField();
        y = new JTextField();
        fx = new JTextField();

        x.setEditable(false);
        y.setEditable(false);
        fx.setEditable(false);

        xLabel = new JLabel("x = ", SwingConstants.RIGHT);
        yLabel = new JLabel("y = ", SwingConstants.RIGHT);
        fxLabel = new JLabel("f(x) = ", SwingConstants.RIGHT);

        xLabel.setBackground(Color.GREEN);

        group.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.insets = new Insets(2,4,2,4);

        c.gridy = 0;

        c.gridx = 0;
        group.add(xLabel, c);
        c.gridx = 1;
        group.add(x, c);

        c.gridx = 2;
        group.add(yLabel, c);
        c.gridx = 3;
        group.add(y, c);

        c.gridx = 4;
        group.add(fxLabel, c);
        c.gridx = 5;
        group.add(fx, c);

        setLayout(new GridBagLayout());
        add(group, new GridBagConstraints());

    }

    void reactToResize(int w, int h) {
        setPreferredSize(new Dimension(w, (int) (h * .05)));
        x.setPreferredSize(new Dimension((int) (getWidth() * 0.05), (int) (getHeight() * 0.4)));
        y.setPreferredSize(new Dimension((int) (getWidth() * 0.05), (int) (getHeight() * 0.4)));
        fx.setPreferredSize(new Dimension((int) (getWidth() * 0.05), (int) (getHeight() * 0.4)));
    }
}

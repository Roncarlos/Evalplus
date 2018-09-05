package com.jiceedev.evalplus.userinterface;

import javax.swing.*;
import java.awt.*;

public class EvalPanel extends JPanel {

    JButton evalBtn;
    JLabel fxLabel;
    JTextField fx;
    JPanel group;

    EvalPanel() {
        initInterface();
    }

    void initInterface() {
        //setBackground(Color.ORANGE);
        group = new JPanel();
        fx = new JTextField();

        fx.setEditable(false);

        fxLabel = new JLabel("f(x) = ", SwingConstants.RIGHT);

        evalBtn = new JButton("Eval");


        group.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.insets = new Insets(2,2,2,2);

        c.gridy = 0;

        c.gridx = 0;
        group.add(evalBtn, c);
        c.gridx = 1;
        group.add(fxLabel, c);

        c.gridx = 2;
        group.add(fx, c);


        setLayout(new BorderLayout());
        add(group, BorderLayout.WEST);
    }

    void reactToResize(int w, int h) {
        setPreferredSize(new Dimension(w, (int) (h * .05)));
        evalBtn.setPreferredSize(new Dimension((int) (getWidth() * 0.05), (int) (getHeight() * 0.8)));
        fxLabel.setPreferredSize(new Dimension((int) (getWidth() * 0.05), (int) (getHeight() * 0.4)));
        fx.setPreferredSize(new Dimension((int) (getWidth() * 0.15), (int) (getHeight() * 0.4)));
    }

}

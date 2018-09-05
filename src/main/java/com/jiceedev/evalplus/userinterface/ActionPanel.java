package com.jiceedev.evalplus.userinterface;

import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.swing.*;
import java.awt.*;

public class ActionPanel extends JPanel {

    private JTextField xMin,xMax,yMin,yMax,pas,xGrid,yGrid;
    private JLabel xMinLabel,xMaxLabel,yMinLabel,yMaxLabel,pasLabel,xGridLabel,yGridLabel;
    public JPanel textFields, pmButtons;
    private JButton refreshBtn, minusBtn, plusBtn;
    private JCheckBox autoPas;

    ActionPanel() {
        super();
        initInterface();
    }

    private void initInterface() {

        setLayout(new GridBagLayout());

        xMinLabel = new JLabel("x min", SwingConstants.LEFT);
        xMin = new JTextField();
        xMaxLabel = new JLabel("x max", SwingConstants.LEFT);
        xMax = new JTextField();
        yMinLabel = new JLabel("y min", SwingConstants.LEFT);
        yMin = new JTextField();
        yMaxLabel = new JLabel("y max", SwingConstants.LEFT);
        yMax = new JTextField();
        pasLabel = new JLabel("Pas", SwingConstants.LEFT);
        pas = new JTextField();
        xGridLabel = new JLabel("x grid", SwingConstants.LEFT);
        xGrid = new JTextField();
        yGridLabel = new JLabel("y grid", SwingConstants.LEFT);
        yGrid = new JTextField();



        textFields = new JPanel();
        textFields.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.insets = new Insets(3,0,3,0);
        c.gridx = 0;
        c.gridy = 0;
        textFields.add(xMinLabel, c);
        c.gridx = 1;
        c.gridy = 0;
        textFields.add(xMin, c);

        c.gridx = 0;
        c.gridy = 1;
        textFields.add(xMaxLabel, c);
        c.gridx = 1;
        c.gridy = 1;
        textFields.add(xMax, c);

        c.gridx = 0;
        c.gridy = 2;
        textFields.add(yMinLabel, c);
        c.gridx = 1;
        c.gridy = 2;
        textFields.add(yMin, c);

        c.gridx = 0;
        c.gridy = 3;
        textFields.add(yMaxLabel, c);
        c.gridx = 1;
        c.gridy = 3;
        textFields.add(yMax, c);

        c.gridx = 0;
        c.gridy = 4;
        textFields.add(pasLabel, c);
        c.gridx = 1;
        c.gridy = 4;
        textFields.add(pas, c);

        c.gridx = 0;
        c.gridy = 5;
        textFields.add(xGridLabel, c);
        c.gridx = 1;
        c.gridy = 5;
        textFields.add(xGrid, c);

        c.gridx = 0;
        c.gridy = 6;
        textFields.add(yGridLabel, c);
        c.gridx = 1;
        c.gridy = 6;
        textFields.add(yGrid, c);

        minusBtn = new JButton("-");
        plusBtn = new JButton("+");

        pmButtons = new JPanel();
        pmButtons.setLayout(new GridLayout(0,2));
        pmButtons.add(minusBtn);
        pmButtons.add(plusBtn);


        GridBagConstraints c2 = new GridBagConstraints();

        c2.gridx = 0;
        c2.gridy = 0;
        c2.fill = GridBagConstraints.HORIZONTAL;

        add(textFields, c2);

        c2.gridx = 0;
        c2.gridy = 1;
        refreshBtn = new JButton("Refresh");
        add(refreshBtn, c2);

        c2.gridy = 2;
        add(pmButtons, c2);

        autoPas = new JCheckBox("AutoPas");

        c2.gridy = 3;
        add(autoPas, c2);




    }

    void reactToResize(int w, int h) {
        setPreferredSize(new Dimension((int) (w * 0.15), (int) (h * .90)));
        textFields.setPreferredSize(new Dimension((int) (getWidth() * 0.95), (int) (getHeight() * 0.50)));
    }

    public void setAllBackgroundColor(Color color) {
        setBackground(color);
        for(Component c : getComponents()){
            if(!(c instanceof JButton)) {
                c.setBackground(color);
            }
        }
    }


    public String getxMin() {
        return xMin.getText();
    }

    public String getxMax() {
        return xMax.getText();
    }

    public String getyMin() {
        return yMin.getText();
    }

    public String getyMax() {
        return yMax.getText();
    }

    public String getPas() {
        return pas.getText();
    }

    public String getxGrid() {
        return xGrid.getText();
    }

    public String getyGrid() {
        return yGrid.getText();
    }
}

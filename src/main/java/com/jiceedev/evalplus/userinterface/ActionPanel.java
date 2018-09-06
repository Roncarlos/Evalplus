package com.jiceedev.evalplus.userinterface;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionPanel extends JPanel {

    private JTextField xMin,xMax,yMin,yMax,pas,xGrid,yGrid;
    private JLabel xMinLabel,xMaxLabel,yMinLabel,yMaxLabel,pasLabel,xGridLabel,yGridLabel;
    public JPanel textFields, pmButtons;
    private JButton refreshBtn, minusBtn, plusBtn;
    private JCheckBox autoPas;
    MainUI mainUI;

    ActionPanel(MainUI mainUI) {
        super();
        this.mainUI = mainUI;
        initInterface();
        initListeners();
        loadDefaultValues();
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

    private void initListeners() {
        plusBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zoom();
            }
        });

        minusBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dezoom();
            }
        });

        refreshBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refresh();
            }
        });
    }

    void reactToResize(int w, int h) {
        setPreferredSize(new Dimension((int) (w * 0.15), (int) (h * .90)));
        textFields.setPreferredSize(new Dimension((int) (getWidth() * 0.95), (int) (getHeight() * 0.50)));
    }

    private void dezoom() {
        xMin.setText(String.valueOf(getxMin() * 2));
        xMax.setText(String.valueOf(getxMax() * 2));
        yMin.setText(String.valueOf(getyMin() * 2));
        yMax.setText(String.valueOf(getyMax() * 2));
        mainUI.getGraph().repaint();
    }

    private void zoom() {
        xMin.setText(String.valueOf(getxMin() / 2));
        xMax.setText(String.valueOf(getxMax() / 2));
        yMin.setText(String.valueOf(getyMin() / 2));
        yMax.setText(String.valueOf(getyMax() / 2));
        mainUI.getGraph().repaint();
    }

    private void refresh() {
        //loadDefaultValues();
        mainUI.getGraph().repaint();
    }

    public void setAllBackgroundColor(Color color) {
        setBackground(color);
        for(Component c : getComponents()){
            if(!(c instanceof JButton)) {
                c.setBackground(color);
            }
        }
    }

    void loadDefaultValues() {
        xMin.setText("-100");
        xMax.setText("100");

        yMin.setText("-100");
        yMax.setText("100");

        pas.setText("1");

        xGrid.setText("5");
        yGrid.setText("5");

    }



    public double getxMin() {
        try {
            return Double.parseDouble(xMin.getText());
        } catch(Exception e) {
            return -100.0f;
        }
    }

    public double getxMax() {
        try {
            return Double.parseDouble(xMax.getText());
        } catch(Exception e) {
            return 100.0f;
        }
    }

    public double getyMin() {
        try {
            return Double.parseDouble(yMin.getText());
        } catch(Exception e) {
            return -100.0f;
        }
    }

    public double getyMax() {
        try {
            return Double.parseDouble(yMax.getText());
        } catch(Exception e) {
            return 100.0f;
        }
    }

    public double getPas() {
        try {
            double dPas = Double.parseDouble(pas.getText());
            return dPas > 0.00f ? dPas : 1.00f;
        } catch(Exception e) {
            return 1.0f;
        }
    }

    public double getxGrid() {
        try {
            return Double.parseDouble(xGrid.getText());
        } catch(Exception e) {
            return 5.0f;
        }
    }

    public double getyGrid() {
        try {
            return Double.parseDouble(yGrid.getText());
        } catch(Exception e) {
            return 5.0f;
        }
    }
}

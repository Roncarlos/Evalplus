package com.jiceedev.evalplus.userinterface;

import javax.swing.*;
import java.awt.*;

public class Graph extends JPanel {

    MainUI mainUI;

    Graph(MainUI mainUI) {
        super();
        this.mainUI = mainUI;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBaseline(g);
    }

    void drawBaseline(Graphics g) {
        double xMin = -100;
        double xMax = 100;
        double deltaX = 1;
        double yMin = -100;
        double yMax = 100;
        double deltaY = 1;
        double nbPas = 1;


        // obtention des transformations affines pour x et y
        Dimension d = getSize();
        double Ax = d.width / (xMax - xMin);
        double Bx = -Ax * xMin;
        double Ay = -d.height / (yMax - yMin);
        double By = -Ay * yMax;

        // tracé des axes
        Color coulPrec = g.getColor();
        g.setColor(Color.DARK_GRAY);
        if (yMin * yMax < 0) {
            int yc = (int) By;
            g.drawLine(0, yc, d.width, yc);
        }
        if (xMin * xMax < 0) {
            int xc = (int) Bx;
            g.drawLine(xc, 0, xc, d.height);
        }

        // tracé de la grille
        long p, pMax;
        p = Math.round(Math.floor(xMin / deltaX));
        pMax = Math.round(Math.ceil(xMax / deltaX));
        for ( ; p <= pMax; p++) {
            int xc = (int) (Ax * (p * deltaX) + Bx);
            g.drawLine(xc, d.height / 2 - 2, xc, d.height / 2);
        }
        p = Math.round(Math.floor(yMin / deltaY));
        pMax = Math.round(Math.ceil(yMax / deltaY));
        for ( ; p <= pMax; p++) {
            int yc = (int) (Ay * (p * deltaY) + By);
            g.drawLine(d.width / 2 + 2, yc, d.width / 2, yc);
        }
        g.setColor(coulPrec);



    }


}

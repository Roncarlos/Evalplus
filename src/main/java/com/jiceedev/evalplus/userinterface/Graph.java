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
        drawFunction(g);
    }

    private void drawFunction(Graphics g) {
        if(mainUI.getFonction() == null)
            return;
        double xMin = mainUI.getActionPanel().getxMin();
        double xMax = mainUI.getActionPanel().getxMax();
        double yMin = mainUI.getActionPanel().getyMin();
        double yMax =  mainUI.getActionPanel().getyMax();
        double nbPas = mainUI.getActionPanel().getPas();

        xMin = xMin < xMax ? xMin : xMax - 1;
        yMin = yMin < yMin ? yMin : yMin - 1;


        Dimension d = getSize();
        double Ax = d.width / (xMax - xMin);
        double Bx = -Ax * xMin;
        double Ay = -d.height / (yMax - yMin);
        double By = -Ay * yMax;
        g.setColor(Color.BLUE);

        // tracé de la fonction
        double dx = (xMax - xMin) / nbPas;
        int xp = 0, yp = 0;


        for (double x = xMin; x <= xMax; x += dx) {
            double y = mainUI.getFonction().getValue(x);
            int xc = (int) (Ax * x + Bx);
            int yc = (int) (Ay * y + By);
            if (xc != 0)
                g.drawLine(xp, yp, xc, yc);
            xp = xc;
            yp = yc;
        }
    }

    private void drawBaseline(Graphics g) {
        double xMin = mainUI.getActionPanel().getxMin();
        double xMax = mainUI.getActionPanel().getxMax();
        double yMin = mainUI.getActionPanel().getyMin();
        double yMax =  mainUI.getActionPanel().getyMax();
        double deltaX = mainUI.getActionPanel().getxGrid();
        double deltaY = mainUI.getActionPanel().getyGrid();

        xMin = xMin < xMax ? xMin : xMax - 1;
        yMin = yMin < yMin ? yMin : yMin - 1;
        deltaX = deltaX > 0 ? deltaX : 1;
        deltaY = deltaY > 0 ? deltaY : 1;

        System.out.println(xMin);




        // obtention des transformations affines pour x et y
        Dimension d = getSize();
        double Ax = d.width / (xMax - xMin);
        double Bx = -Ax * xMin;
        double Ay = -d.height / (yMax - yMin);
        double By = -Ay * yMax;

        // tracé des axes &&
        // tracé de la grille
        long p, pMax;
        g.setColor(Color.DARK_GRAY);
        if (yMin * yMax < 0) {
            int yc = (int) By;
            g.drawLine(0, yc, d.width, yc);

            // Grille -|
            p = Math.round(Math.floor(xMin / deltaX));
            pMax = Math.round(Math.ceil(xMax / deltaX));
            for ( ; p <= pMax; p++) {
                int xc = (int) (Ax * (p * deltaX) + Bx);
                g.drawLine(xc, d.height / 2 - 4, xc, d.height / 2);
            }
        }
        if (xMin * xMax < 0) {
            int xc = (int) Bx;
            g.drawLine(xc, 0, xc, d.height);

            // Grille -|
            p = Math.round(Math.floor(yMin / deltaY));
            pMax = Math.round(Math.ceil(yMax / deltaY));
            for ( ; p <= pMax; p++) {
                int yc = (int) (Ay * (p * deltaY) + By);
                g.drawLine(d.width / 2 + 4, yc, d.width / 2, yc);
            }
        }




    }


}

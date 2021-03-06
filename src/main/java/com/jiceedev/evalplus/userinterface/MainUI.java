package com.jiceedev.evalplus.userinterface;

import com.jiceedev.evalplus.arithmetics.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainUI extends JFrame {

    private ActionPanel actionPanel;
    private PositionPanel positionPanel;
    private EvalPanel evalPanel;
    private Graph graph;

    private Fonction fonction;



    public MainUI() {
        super();
        initInterface();
    }

    void initInterface() {
        Dimension screenSize 	= Toolkit.getDefaultToolkit().getScreenSize();
        double width 			= screenSize.getWidth();
        double height 			= screenSize.getHeight();

        actionPanel = new ActionPanel(this);
        positionPanel = new PositionPanel();
        evalPanel = new EvalPanel(this);
        graph = new Graph(this);

        add(actionPanel, BorderLayout.WEST);
        add(positionPanel, BorderLayout.NORTH);
        add(evalPanel, BorderLayout.SOUTH);
        add(graph, BorderLayout.CENTER);


        setLocationRelativeTo(null);

        actionPanel.reactToResize((int) width, (int) height);
        positionPanel.reactToResize((int) width, (int) height);
        evalPanel.reactToResize((int) width, (int) height);

        actionPanel.setAllBackgroundColor(Color.lightGray);
        positionPanel.setAllBackgroundColor(Color.lightGray);
        evalPanel.setAllBackgroundColor(Color.lightGray);


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

    void prepareFunction() throws Exception {
        try {
            Analyseur analyseur = new Analyseur(evalPanel.getExpresion());
            fonction = analyseur.analyser();
            graph.repaint();
        } catch (Exception e) {
            throw e;
        }
    }

    public ActionPanel getActionPanel() {
        return actionPanel;
    }

    public PositionPanel getPositionPanel() {
        return positionPanel;
    }

    public EvalPanel getEvalPanel() {
        return evalPanel;
    }

    public Fonction getFonction() {
        return fonction;
    }

    public Graph getGraph() {
        return graph;
    }


}

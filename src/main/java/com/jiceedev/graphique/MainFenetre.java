package com.jiceedev.graphique;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jiceedev.evalplus.arithmetics.*;
import com.jiceedev.graphique.Canvas;

public class MainFenetre extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Variables
	JLabel xmin, xmax, deltax, ymin, ymax, deltay, exp;
	JTextField txmin, txmax, tdeltax, tymin, tymax, tdeltay, texp;
	JButton button;
	Canvas mycanvas;
	Noeud noeud;
	
	double[] valeurParametres = {-1.0, +1.0, 0.2, -1.0, +1.0, 0.2 };
	
	// Constructeur
	public MainFenetre() {
		setTitle("Tracer des fonctions Mathématique");
		setSize(600,400);
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		
		// 1_Container du West
		JPanel west = new JPanel();
		west.setLayout(new BorderLayout());
			
			// 1-1_Grid layout : le tableau
		JPanel row = new JPanel();
		row.setLayout(new GridLayout(6,6));
		
		xmin = new JLabel("X min");
		row.add(xmin);
		txmin = new JTextField(10);
		row.add(txmin);
		
		xmax = new JLabel("X max");
		row.add(xmax);
		txmax = new JTextField(10);
		row.add(txmax);
		
		deltax = new JLabel("delta X");
		row.add(deltax);
		tdeltax = new JTextField(10);
		row.add(tdeltax);
		
		ymin = new JLabel("Y min");
		row.add(ymin);
		tymin = new JTextField(10);
		row.add(tymin);
	
		ymax = new JLabel("Y max");
		row.add(ymax);
		tymax = new JTextField(10);
		row.add(tymax);
		
		deltay = new JLabel("delta Y");
		row.add(deltay);
		tdeltay = new JTextField(10);
		row.add(tdeltay);
		
		JPanel but = new JPanel();
		but.setLayout(new FlowLayout());
		
		button = new JButton("Tracer");
		but.add(button);
		
		west.add(row, BorderLayout.NORTH);
		west.add(but, BorderLayout.CENTER);
		
		// 2_Container du CENTER
		mycanvas = new Canvas(this);
		
		// 3_Container du SOUTH
		JPanel sud = new JPanel();
		JPanel rowsud = new JPanel();
		rowsud.setLayout(new GridLayout(2,0));
		
		exp = new JLabel("Entrer votre fonction f(x) : ");
		rowsud.add(exp);
		texp = new JTextField(10);
		rowsud.add(texp);
		sud.add(rowsud);
		// fin
		
		container.add(west, BorderLayout.WEST);
		container.add(mycanvas, BorderLayout.CENTER);
		container.add(sud, BorderLayout.SOUTH);
		
		// Début des évenement
		button.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					preparerLaCourbe();
				}catch(Exception excep) {
					String msg ="Exception est "+excep;
					JOptionPane.showMessageDialog(null, msg, "Message d' erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		// fin event
		
		setLocationRelativeTo(this.getParent());
		setDefaultCloseOperation(3);
		}
		private void preparerLaCourbe() throws Exception{
			try {
				valeurParametres[0] = Double.parseDouble(txmin.getText());
				valeurParametres[1] = Double.parseDouble(txmax.getText());
				valeurParametres[2] = Double.parseDouble(tdeltax.getText());

				valeurParametres[3] = Double.parseDouble(tymin.getText());
				valeurParametres[4] = Double.parseDouble(tymax.getText());
				valeurParametres[5] = Double.parseDouble(tdeltay.getText());

				/* Debug
				valeurParametres[0] = 0f; //xMin
				valeurParametres[1] = 100f; //xMax
				valeurParametres[2] = 10f; //detalX
				valeurParametres[3] = 0f; //yMin
				valeurParametres[4] = 100f; // yMax
				valeurParametres[5] = 10f; // deltaY
				*/
				
				Analyseur analyseur = new Analyseur(texp.getText());
				noeud = analyseur.analyser();
				
			}catch(Exception ex) {
				throw ex;
			}
			mycanvas.repaint();
		}
		
		public double getXmin(){
			return valeurParametres[0];
		}
		
		public double getXmax(){
			return valeurParametres[1];
		}
		
		public double deltaX(){
			return valeurParametres[2];
		}
		
		public double getYmin(){
			return valeurParametres[3];
		}
		
		public double getYmax(){
			return valeurParametres[4];
		}
		
		public double deltaY(){
			return valeurParametres[5];
		}
		
		public Noeud getNoeud() {
			return noeud;
		}
		
		
}

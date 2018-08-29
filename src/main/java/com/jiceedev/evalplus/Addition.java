package com.jiceedev.evalplus;

public class Addition extends NoeudBinaire{
	
	public Addition(Noeud fg, Noeud fd) {
		super(fg, fd);
	}
	
	public String toString(){
		return "("+ fg + " + " + fd + ")";
	}
	
	public double execute() {
		return getfg().execute()+getfd().execute();
	}

}

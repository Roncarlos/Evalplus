package com.jiceedev.evalplus;

public class Mult extends NoeudBinaire{
	
	public Mult(Noeud fg, Noeud fd){
		super(fg, fd);		
	}
	
	public double execute(){
		return getfg().execute() * getfd().execute();
	}
}

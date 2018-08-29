package com.jiceedev.evalplus;

public class Division extends NoeudBinaire{
	
	public Division(Noeud fg, Noeud fd){
		super(fg, fd);
	} 
	
	public String toString(){
		return "("+ fg + " / " + fd + ")";
	}

	public double execute(){
		if(getfd().execute() != 0) {
			return getfg().execute() / getfd().execute();
		}
		else return 0;
	}
	
}

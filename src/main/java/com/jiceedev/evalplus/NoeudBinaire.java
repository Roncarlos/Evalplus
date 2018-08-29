package com.jiceedev.evalplus;

public abstract class NoeudBinaire implements Noeud {
	
	protected Noeud fg;
	protected Noeud fd;
	
	public NoeudBinaire(Noeud fg, Noeud fd) {
		this.fg = fg;
		this.fd = fd;
	}

	public Noeud getfg(){
		return this.fg;
	}
	
	public Noeud getfd(){
		return this.fd;
	}
}

package eval;

public class Soustraction extends NoeudBinaire{
	public Soustraction(Noeud fg, Noeud fd) {
		  super(fg, fd);
		}
	
	public String toString(){
		return "("+ fg + " - " + fd + ")";
	}
	
	public double execute() {
		return getfg().execute()-getfd().execute();
		
	}
}

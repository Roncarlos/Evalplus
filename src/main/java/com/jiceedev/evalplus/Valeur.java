package eval;

public class Valeur implements Noeud {
	private double Val;
	
	public Valeur(double v){
		Val=v;
	}
	
	public double getV(){
		return Val;
	}

	
	public double execute(){
		return Val;
	}

}

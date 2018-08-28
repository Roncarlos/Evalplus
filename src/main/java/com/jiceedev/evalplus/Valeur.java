package eval;

class Variable implements Noeud {
	private double Val;
	
	
	public double getV(){
		return Val;
	}
	
	public String toString() {
		return "x";
	}

	
	public double execute(){
		return Val;
	}

}

class Constante implements Noeud {
	private double val;

	public Constante(double value) {
		val = value;
	}

	@Override
	public double execute() {
		return val;
	}

	public String toString() {
		return Double.toString(val);
	}
}




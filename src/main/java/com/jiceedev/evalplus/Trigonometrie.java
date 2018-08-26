package eval;

public class Trigonometrie extends NoeudUnaire{
	Noeud node;
	
	public Trigonometrie(Noeud node){
		super(node);
	}
	
	public double execute() {
		return getNoeud().execute();
	}
	
	public String toString(){
		return "Trigo("+ node +")";
	}
	
	public double cos(double x) {
		return getValueCos(x);
	}
	
	public double sin(double x) {
		return getValueSin(x);
	}
	
	public double log(double x) {
		return getValueLog(x);
	}
	
	public double exp(double x) {
		return getValueExp(x);
	}
	
	
	
	public double getValueCos(double x) {
		return Math.cos(node.execute());	
	}
	
	public double getValueSin(double x) {
		return Math.sin(node.execute());
	}
	
	public double getValueLog(double x) {
		return Math.log(node.execute());
	}
	
	public double getValueExp(double x) {
		return Math.exp(node.execute());
	}
	
	

}

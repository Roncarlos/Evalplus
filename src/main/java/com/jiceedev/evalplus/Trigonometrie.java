package evalplus;

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
	
	public double cos() {
		return getValueCos(getNoeud().execute());
	}
	
	public double sin() {
		return getValueSin(getNoeud().execute());
	}
	
	public double log() {
		return getValueLog(getNoeud().execute());
	}
	
	public double exp() {
		return getValueExp(getNoeud().execute());
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

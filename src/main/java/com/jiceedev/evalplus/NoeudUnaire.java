package eval;

public abstract class NoeudUnaire implements Noeud{
	
	protected Noeud n;
	
	public NoeudUnaire(Noeud node){
		n = node;
	}
	
	public Noeud getNoeud(){
		return n;
	}
}

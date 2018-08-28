package evalplus;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;


public class Analyseur {

	private StreamTokenizer buffer;
	
	public Analyseur(String s){
			buffer = new StreamTokenizer(new StringReader(s));
			buffer.ordinaryChar('/');
			buffer.ordinaryChar('-');
		}
	public Noeud analyser() throws IOException,SyntaxErrorException{
		buffer.nextToken();
		Noeud result = analyserExpression();
		if(buffer.ttype != StreamTokenizer.TT_EOF)
			throw new SyntaxErrorException("Unexpected character at end of text.");
		
		return result;
	}
	
	public Noeud analyserExpression() throws IOException, SyntaxErrorException{
		Noeud result;
		
		boolean sign = true;
		if(buffer.ttype == '-') {
			sign = false;
			buffer.nextToken();
		}
		result = (sign) ? analyserTerme() : new Soustraction(new Constante(0), analyserTerme());
		
		while(buffer.ttype == '+' || buffer.ttype == '-') {
			int symbol = buffer.ttype;
			buffer.nextToken();
			Noeud term = analyserTerme();
			switch(symbol) {
				case '+':
					result = new Addition(result, term);
					break;
				case '-':
					result = new Soustraction(result, term);
					break;
				default:
					throw new SyntaxErrorException("Le buffer '" + buffer.ttype + "' dans l'expression");
			}			
			buffer.nextToken();
		}
		
		return result;
	}
	
	private Noeud analyserTerme() throws IOException, SyntaxErrorException {
		Noeud result = analyserFacteur();
		
		while(buffer.ttype == '*' || buffer.ttype == '/') {
			int symbol = buffer.ttype;
			buffer.nextToken();
			Noeud fact = analyserFacteur();
			switch(symbol)
			{
				case '*':
					result = new Mult(result, fact);
					break;
				case '/':
					result = new Division(result, fact);
					break;
				default:
					throw new SyntaxErrorException("Le buffer est inconnue '" + buffer.ttype);
			}
		}
		
		return result;
	}
	
	private Noeud analyserFacteur() throws IOException, SyntaxErrorException{
		Noeud result = null;
		switch(buffer.ttype) {
			case StreamTokenizer.TT_NUMBER:
				result = new Constante(buffer.nval);
				break;
			case StreamTokenizer.TT_WORD:
				if(buffer.sval.equalsIgnoreCase("x")) {
					result = new Variable();
				} else if (buffer.sval.equalsIgnoreCase("sin")) {
					buffer.nextToken();
					
					Trigonometrie sin = new Trigonometrie(result);
					sin.sin();
					result = sin;
				} else if (buffer.sval.equalsIgnoreCase("cos")) {
					buffer.nextToken();
					
					Trigonometrie cos = new Trigonometrie(result);
					cos.cos();
					result = cos;
				} else if (buffer.sval.equalsIgnoreCase("log")) {
					buffer.nextToken();
					
					Trigonometrie log = new Trigonometrie(result);
					log.log();
					result = log;
				} else if (buffer.sval.equalsIgnoreCase("exp")) {
					buffer.nextToken();
					
					Trigonometrie exp = new Trigonometrie(result);
					exp.exp();
					result = exp;
				} else {
					throw new SyntaxErrorException("Variable inconnue '" + buffer.sval + "'");
				}
				break;
			case '(':
				buffer.nextToken();
				result = analyserExpression();
				buffer.nextToken();
				break;
			case ')':
				throw new SyntaxErrorException("Unmatched closing parenthesis.");
			default:
				throw new SyntaxErrorException("Buffer indefinie '" + buffer.ttype + "'dans facteur");
		}
		
		buffer.nextToken();
		return result;
	}
	
	private void debug() {
		System.out.println("ttype: " + buffer.ttype + "(" + (char)buffer.ttype + ")");
		System.out.println("nval: " + buffer.nval);
		System.out.println("sval: " + buffer.sval);
	}
	
	
	class SyntaxErrorException extends Exception {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SyntaxErrorException(String message) {
			super(message);
			debug();
		}
	}
}


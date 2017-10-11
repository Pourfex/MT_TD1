package session1.td;

public class NatParInt implements Nat{
	
	private int n; // Invariant: n >= 0
	
	public NatParInt(int n) throws IllegalArgumentException { // Rôle du constructeur -> initialiser l'état (l'ensemble des attributs)
		if(n < 0) {
			throw new IllegalArgumentException("Un entier ne doit pas être inférieur à 0");
		}
		this.n = n;
	}
	
	public int getN() { // Accesseur dont le but est d'observer l'état
		return this.n;
	}
	
	public Nat somme(Nat p) { // Operation qui utilise un accesseur et un constructeur -> service
		return new NatParInt(this.getN() + p.getN());
	}
	
	public String toString() {
		return this.n+"";
	}

	public int taille() {
		return this.toString().length();
	}

	public int getChiffres(int i) {
		return Character.getNumericValue(this.toString().charAt(this.taille() - 1 - i));
	}
	
}

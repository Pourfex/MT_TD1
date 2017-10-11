package session1.td;

public class NatParInt implements Nat{
	
	public static FabriqueNaturel fab = new NatParInt(0);
	private int val;
	
	public NatParInt(int val) {
		if(val < 0) {
			throw new IllegalArgumentException("Un entier naturel ne peut pas être négatif");
		}
		this.val = val;
	}
	@Override
	public Nat creerNatAvecValeur(int i) {
		return new NatParInt(i);
	}

	@Override
	public Nat creerNatAvecRepresentation(String s) {
		return new NatParInt(Integer.parseInt(s));
	}

	@Override
	public Nat creerZero() {
		return new NatParInt(0);
	}

	@Override
	public Nat creerSuccesseur(Nat n) {
		return new NatParInt(n.val() + 1 );
	}

	@Override
	public boolean estNul() {
		return this.val() == 0;
	}

	@Override
	public Nat predecesseur(Nat n) {
		if(this.val() == 0) {
			throw new UnsupportedOperationException("Le predecesseur de  n'est pas un naturel");
		}
		return new NatParInt(this.val()-1);
	}

	@Override
	public int chiffres(int i) {
		if(i <= 0) {
			throw new IllegalArgumentException("Le chiffre ne peut être negatif ou nul");
		}
		return Integer.toString(this.val()).charAt(i);
	}

	@Override
	public int taille() {
		return Integer.toString(this.val()).length();
	}

	@Override
	public int val() {
		return this.val;
	}
	@Override
	public Nat somme(Nat x) {
		return new NatParInt(this.val + x.val());
	}
	@Override
	public Nat zero() {
		return creerZero();
	}
	@Override
	public Nat produit(Nat x) {
		return new NatParInt(this.val * x.val());
	}
	@Override
	public Nat un() {
		return new NatParInt(1);
	}
	@Override
	public Nat modulo(Nat x) {
		int val = this.val();
		while(val> x.val()) {
			val = val - x.val();
		}
		return new NatParInt(val);
	}
	@Override
	public Nat div(Nat x) {
		return new NatParInt(this.val / x.val());
	}
	
	@Override
	public String toString() {
		return Integer.toString(this.val());
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(! (obj instanceof NatParInt)) {
			return false;
		}
		
		NatParInt objNat = (NatParInt) obj;
		if(objNat.estNul()) {
			return this.estNul();
		}
		if(this.estNul()) {
			return objNat.estNul();
		}
		
		return this.val() == objNat.val();
	}
	
	
}

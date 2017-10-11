package session1.td;

public class NatDecimale implements Nat{

	public static final FabriqueNaturel FAB = new NatDecimale("");
	private static final Nat DIX = FAB.creerNatAvecRepresentation("10"); 
	
	private String chiffres;
	
	private NatDecimale(String s) {
		this.chiffres = s;
	}
	
	@Override
	public Nat creerNatAvecValeur(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Nat creerNatAvecRepresentation(String s) {
		if(s.equals("")){
			s = "0";
		}
		char min = Character.forDigit(0, 10);
		char max = Character.forDigit(9, 10);
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(c < min)	throw new IllegalArgumentException();
			if(c > max) throw new IllegalArgumentException();
		}
		return new NatDecimale(s);
	}

	@Override
	public Nat creerZero() {
		return new NatDecimale("0");
	}

	@Override
	public Nat creerSuccesseur(Nat n) {
		int t = n.taille();
		StringBuilder rep = new StringBuilder();
		int retenue = 1;
		for(int i = 0; i < t; i++){
			int chiffre = n.chiffres(i) + retenue;
			if(chiffre > 9){
				chiffre = chiffre - 10;
				retenue = 1;
			}else{
				retenue = 0;
			}
			rep.append(Integer.toString(chiffre));
		}
		rep = retenue == 0 ? rep : rep.append(1);
		return new NatDecimale(rep.reverse().toString());
	}

	@Override
	public Nat somme(Nat x) {
		int t = this.taille() < x.taille() ? x.taille() : this.taille();
		StringBuilder rep = new StringBuilder();
		int retenue = 0;
		for(int i = 0; i < t; i++){
			int chiffre = this.chiffres(i) + x.chiffres(i) + retenue;
			if(chiffre > 9){
				chiffre = chiffre - 10;
				retenue = 1;
			}else{
				retenue = 0;
			}
			rep.append(Integer.toString(chiffre));
		}
		rep = retenue == 0 ? rep : rep.append(1);
		return new NatDecimale(rep.reverse().toString());
	}

	@Override
	public Nat zero() {
		return this.creerZero();
	}

	@Override
	public Nat produit(Nat x) {
		if(x.equals(DIX)){
			return this.creerNatAvecRepresentation(this.toString() + "0");
		}
		Nat res = zero();
		Nat index = zero();
		while(!index.equals(x)){
			res = res.somme(this);
			index = this.creerSuccesseur(index);
		}
		return res;
	}

	@Override
	public Nat un() {
		return this.creerNatAvecRepresentation("1");
	}

	@Override
	public Nat modulo(Nat x) {
		if(x.equals(DIX)){
			return this.creerNatAvecValeur(this.chiffres(0));
		}
		Nat courant = zero();
		Nat q = zero();
		Nat r = zero();
		while(!courant.equals(this)){
			r = this.creerSuccesseur(r);
			if(r.equals(x)){
				r = zero();
				q = this.creerSuccesseur(q);
			}
			courant = this.creerSuccesseur(courant);
		}
		return r;
	}

	@Override
	public Nat div(Nat x) {
		if(x.equals(DIX)){
			if(this.taille() == 1)
				return this.zero();
			return this.creerNatAvecRepresentation(this.toString().substring(0, this.taille() - 1));
		}
		Nat courant = zero();
		Nat q = zero();
		Nat r = zero();
		while(!courant.equals(this)){
			r = this.creerSuccesseur(r);
			if(r.equals(x)){
				r = zero();
				q = this.creerSuccesseur(q);
			}
			courant = this.creerSuccesseur(courant);
		}
		return q;
	}

	@Override
	public boolean estNul() {
		for(int i = 0; i < this.taille(); i++){
			if(this.chiffres(i) != 0){
				return false;
			}
		}
		return true;
	}

	@Override
	public Nat predecesseur() {
		if(this.estNul()){
			throw new UnsupportedOperationException();
		}
		int t = this.taille();
		StringBuilder rep = new StringBuilder();
		int retenue = -1;
		for(int i = 0; i < t; i++){
			int chiffre = this.chiffres(i) + retenue;
			if(chiffre == -1){
				chiffre = 9;
				retenue = -1;
			}else{
				retenue = 0;
			}
			rep.append(Integer.toString(chiffre));
		}
		return this.creerNatAvecRepresentation(rep.reverse().toString());
	}

	@Override
	public int chiffres(int i) {
		if(i < this.taille())
    		return Character.getNumericValue(chiffres.charAt(chiffres.length() -1 -i));
    	return 0;
	}

	@Override
	public int taille() {
		return chiffres.length();
	}

	@Override
	public int val() {
		return Integer.parseInt(this.chiffres);
	}
	
	public boolean equals(Object obj){
		if(!(obj instanceof Nat)) return false;
		Nat n = (Nat)obj;
		return this.toString().equals(n.toString());
	}
	
	public String toString() {
    	return this.chiffres;
    }

}

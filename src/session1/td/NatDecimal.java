package session1.td;

public class NatDecimal implements Nat {

	private String chiffres;

	public NatDecimal(String chiffres) {
		this.chiffres = chiffres;
		// TODO : test / string
	}

	public int getChiffres(int i) {
		if(i >= this.taille()) {
			return 0;
		}
		return Character.getNumericValue(chiffres.charAt(chiffres.length() - 1 - i));
	}

	public void setChiffres(String chiffres) {
		this.chiffres = chiffres;
	}
	
	public int taille() {
		return this.chiffres.length();
	}
	
	public Nat somme(Nat n) {
		int t = this.taille() < n.taille() ? n.taille() : this.taille();
		int retenue = 0;
		String res = "";
		for(int i = 0; i < t; i++) {
			int c = this.getChiffres(i) + n.getChiffres(i) + retenue;
			if(c > 9) {
				c = c - 10;
				retenue = 1;
			}else {
				retenue = 0;
			}
			res = c + res;
		}
		if(retenue == 1) {
			res = "1" + res;
		}
		return new NatDecimal(res);
	}
	
	public String toString() {
		return this.chiffres.toString();
	}

	public int getN() {
		return Integer.parseInt(this.chiffres);
	}

	
}

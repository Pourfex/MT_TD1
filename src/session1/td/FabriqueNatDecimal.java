package session1.td;

public class FabriqueNatDecimal implements FabriqueNat{

	public Nat creerNatAvecChiffres(String chiffres) {
		return new NatDecimal(chiffres);
	}

	public Nat creerNatString(int i) {
		return new NatDecimal(Integer.toString(i));
	}
}
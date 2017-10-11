package session1.td;

public class FabriqueNatParInt implements FabriqueNat{

	public Nat creerNatAvecChiffres(String chiffres) {
		return new NatParInt(Integer.parseInt(chiffres));
	}

	public Nat creerNatString(int i) {
		return new NatParInt(i);
	}
}

package session1.td;

public interface FabriqueNaturel {
	
	Nat creerNatAvecValeur(int i);
	Nat creerNatAvecRepresentation(String s);
	Nat creerZero();
	Nat creerSuccesseur(Nat n);

}

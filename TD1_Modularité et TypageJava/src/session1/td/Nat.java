package session1.td;

import hierarchie.SemiAnneauUnitaireEuclidien;

public interface Nat extends FabriqueNaturel, SemiAnneauUnitaireEuclidien<Nat> {
	public boolean estNul();
	public Nat predecesseur(Nat n);
	public int chiffres(int i);
	public int taille();
	public int val();
}
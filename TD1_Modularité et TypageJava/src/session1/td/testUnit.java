package session1.td;

public class testUnit {

	public static void main(String[] args) {
		
			
				test(NatParInt.FAB);
				test(NatDecimale.FAB);
				
			}
	
	private static void test(FabriqueNaturel fab) {
		Nat zero = fab.creerNatAvecValeur(0);
		System.out.println("0 ?" +" " + zero);
		
		System.out.println("true ? " + zero.equals(zero.zero()));
		
		Nat un = fab.creerSuccesseur(zero);
		System.out.println("1 ? " + un);
		
		zero = un.predecesseur();
		System.out.println("0 ? " + zero);
		
		System.out.println("true ? " + un.equals(un.un()));
		
		Nat cinq = fab.creerNatAvecValeur(5);
		System.out.println("5 ? " + cinq);
		
		Nat six = fab.creerNatAvecValeur(6);
		System.out.println("11 ? " + cinq.somme(six));
		System.out.println("30 ? " + cinq.produit(six));
		
		Nat trentetrois = fab.creerNatAvecValeur(33);
		System.out.println("33 ? " + trentetrois);
		System.out.println("3 ? " + trentetrois.modulo(six));
		
	}

}

package session1.td;

public class testUnit {

	public static void main(String[] args) {
		
			
				test(new FabriqueNatParInt());
			}
	
	private static void test(FabriqueNat fab) {
		Nat zero = fab.creerNatString(0);
		System.out.println("0" +" " + zero);
		
		
	}

}

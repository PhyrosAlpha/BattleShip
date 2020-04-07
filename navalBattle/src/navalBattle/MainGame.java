package navalBattle;

public class MainGame {

	public static void main(String[] args) {		
		//--------Creating Players--------\\
		Player lala = new Player("Captain Laís", "Golfinhos");	
		Player fefe = new Player("Captain Felipe", "Infernal Sharks");


		
		//--------Creating Ships--------\\
		fefe.addShip(new Ship("Smart Ship", "Y", 2) {

			public void shipMsg() {
				System.out.println("Alterei essa bagaça aqui no main sou foda!!");
			}
			
		});
		
		
		fefe.addShip(new Ship("Smart Ship", "S", 2));
		lala.addShip(new Ship("Medium Ship", "M", 4));
		lala.addShip(new Ship("Medium Ship", "M", 4));
		lala.addShip(new Ship("Giant Ship", "G", 5));
		//-------------------------------\\
		fefe.addShip(new Ship("Smart Ship", "S", 2));
		fefe.addShip(new Ship("Smart Ship", "S", 2));
		fefe.addShip(new Ship("Medium Ship", "M", 4));
		fefe.addShip(new Ship("Medium Ship", "M", 4));
		fefe.addShip(new Ship("Giant Ship", "G", 5));
		
			
		lala.initShips();
		fefe.initShips();
		
		
		fefe.showHiddenZone();
		lala.showHiddenZone();
		
		
		//--------Creating Battle--------\\		
		Battle pacific = new Battle(lala, fefe);
		pacific.initBattle();
		
			

		
	}

}

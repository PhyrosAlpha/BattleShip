package navalBattle;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Player {
	
	private String captain;	
	private String teamName;	
	private boolean ready;	
	private String target;	
	//Hidden Map and discovered map   
	private Ship [][] objectsZone;
	private String [][] hiddenOwnZone;            //This array stores the informations about spawned ships, This informations must stay hidden until will be discovered.
	private String [][] discoveredOwnZone;        //When the player hits a valid target, it will become visible and is stored here.
	private ArrayList<Ship> ships;
	private int points;
	
	
	public Player(String captain, String teamName) {

		this.captain = captain;
		this.teamName = teamName;
		this.objectsZone = new Ship[8][8];
		this.hiddenOwnZone = new String[8][8];
		this.discoveredOwnZone = new String[8][8];
		this.ships = new ArrayList<Ship>();
		this.ready = false;
		this.target = "blocked";
		this.points = 0;
			
	}

	public void addShip(Ship ship) {
	//	if(this.isReady()) {
			System.out.println("The " + ship.getShip() + " was added to your naval team");
			this.ships.add(ship);
	//	}else System.out.println("This action is not possible, because the team is not ready");
		
	}
	
	public void playerInformations() {
		System.out.println("---------|" + this.getTeamName() + " informations|--------");
		System.out.println("the Captain's name is " + this.getCaptain());
		System.out.println("The Team Name's is " + this.getTeamName());
		System.out.println("-----------------------------------------------------------");
			
	}
	
	
	public void setTarget(){         //The player set its target which will be stored in target attribute

		if(this.isReady()) {
			
			String atkCoordenates;
			Scanner atkInput = new Scanner(System.in);
			boolean check = true;
			while(check) {
				System.out.println("Choose the coordenates");			
				atkCoordenates = atkInput.nextLine();
				if(atkCoordenates.length() != 2) {
					System.out.println("You must type only one letter and one number, please try again!");
				}else if(!atkCoordenates.substring(1,2).matches("[A-H]*")) {
					System.out.println("Sorry Wrong Something with the typed letter, try only letters between A and H");
				}else if(!atkCoordenates.substring(0,1).matches("[1-8]")) {
					System.out.println("Sorry Wrong Something with the typed numbers");
				}else {
					check = false;
					this.setTarget(atkCoordenates);
					System.out.println("Locked Target!");
				}				
				}
		}else System.out.println("This action is not possible, because the team is not ready");
		
		}
	
		
		public void initShips() {     //This method is responsible for loading the player game.
		if(!this.isReady()) {
			System.out.println("The " + this.getTeamName() + " is getting ready");
			this.setReady(true);     	//it will became the o object available for battles
			this.generatorField();     //it will generate the map
			this.spawnField();			//it will generate the ships spawn
			System.out.println("The " + this.getTeamName() + " are prepared");
		}else System.out.println("All ships are already prepared, Let's go battle!!");
						
	}
		
		
	private int randomNumber() {
		Random random = new Random();
		int number = random.nextInt(8);
		return number;
	}
	
	
	private void spawnField() {	 // this method creates the random spawn of the ships.
		System.out.println("The ships are prepared!!");
		int rx;
		int ry;	
			for(int x = 0; x < ships.size(); x++) {
				while(true) {
				rx = randomNumber();
				ry = randomNumber();
				if (this.hiddenOwnZone[rx][ry] == " "){
					this.hiddenOwnZone[rx][ry] = ships.get(x).getIcon();
					this.objectsZone[rx][ry] = ships.get(x);
					break;		
				}else continue;
			}
    	}		
					
	}	
	
	private void generatorField() {
		System.out.println("Bulding Map!");
		int x;
		int y;
		for (x = 0; x < 8;x++) {
			for(y = 0; y < 8; y++) {
				this.hiddenOwnZone[x][y] = " ";
				this.discoveredOwnZone[x][y] = " ";
			}
		}
		System.out.println("The map was built!");
	}	
	
	//--------Creating Ships--------\\
	public void showZone() {
		int x;
		int y;
		System.out.println(" |A|B|C|D|E|F|G|H|");
		for (x = 0; x < 8;x++) {
			System.out.print(x+1 + " ");
			for(y = 0; y < 8; y++) {
				System.out.print(this.discoveredOwnZone[x][y] + " ");
			}
			System.out.println();
		}	
		
	}
	
	
	public void showHiddenZone() {
		int x;
		int y;
		System.out.println(" |A|B|C|D|E|F|G|H|");
		for (x = 0; x < 8;x++) {
			System.out.print(x+1 + " ");
			for(y = 0; y < 8; y++) {
				System.out.print(this.hiddenOwnZone[x][y] + " ");
			}
			System.out.println();
		}	
		
	}

	
	//getters and setters
	
	public String getCaptain() {
		return captain;
	}

	
	public void setCaptain(String captain) {
		this.captain = captain;
	}


	public String getTeamName() {
		return teamName;
	}


	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	public boolean isReady() {
		return ready;
	}


	public void setReady(boolean ready) {
		this.ready = ready;
	}


	public String getTarget() {
		return target;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public void setTarget(String target) {
		this.target = target;
	}


	public String[][] getHiddenOwnZone() {
		return hiddenOwnZone;
	}


	public void setHiddenOwnZone(String[][] hiddenOwnZone) {
		this.hiddenOwnZone = hiddenOwnZone;
	}


	public String[][] getDiscoveredOwnZone() {
		return discoveredOwnZone;
	}


	public void setDiscoveredOwnZone(String mark, int x, int y) {
		this.discoveredOwnZone[x][y] = mark;
	}

	public ArrayList<Ship> getShips() {
		return ships;
	}

	public void setShips(ArrayList<Ship> ships) {
		this.ships = ships;
	}

	public Ship[][] getObjectsZone() {
		return objectsZone;
	}

	public void setObjectsZone(Ship[][] objectsZone) {
		this.objectsZone = objectsZone;
	}	
	
}

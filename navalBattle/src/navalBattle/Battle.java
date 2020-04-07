package navalBattle;

import java.util.Random;
import java.util.Scanner;

public class Battle {

	private boolean statusBattle;

//----------Player One------------\\	
	private Player playerOne;
	private int playerOnePoints;

//----------Player Two------------\\	
	private Player playerTwo;
	private int playerTwoPoints;

	private int numberTurns;

	public Battle(Player playerOne, Player playerTwo) {

		this.statusBattle = false;

		this.playerOne = playerOne;
		this.playerTwo = playerTwo;

		this.numberTurns = 0;
	}

	public void initBattle() {
		if (this.getPlayerOne().isReady() && this.getPlayerTwo().isReady()) {

			System.out.println("Loading Battle!!");

			System.out.println("------------------------|Apresentations|-------------------------");

			this.getPlayerOne().playerInformations();
			System.out.println("=================================================================");
			this.getPlayerTwo().playerInformations();

			System.out.println("-----------------------------------------------------------------");

			this.setStatusBattle(true);
			this.battle();

		} else
			System.out.println("There is a wrong, check please!");

	}

	private void battle() {
		if(this.isStatusBattle()) {
			System.out.println("Ready?");
			System.out.println("Go");
			
			Random random = new Random();
			int number = random.nextInt(1);
			int playerTurn = 0;
			int x;
			int y;
			
			while(this.isStatusBattle()) {
			
				if(playerTurn == 0) {
					while(true) {
					System.out.println("Hey " + this.getPlayerOne().getCaptain() + " is your time!! Go!");
					this.getPlayerOne().setTarget();
					y = letterConvert(this.getPlayerOne().getTarget().substring(1,2));
					x = (Integer.parseInt(this.getPlayerOne().getTarget().substring(0,1))-1);
					
					
					if(this.playerTwo.getObjectsZone()[x][y] instanceof Ship) {
						if(!this.playerTwo.getObjectsZone()[x][y].isDestroyed()) {
							this.playerTwo.getObjectsZone()[x][y].shipMsg();
							this.playerTwo.getObjectsZone()[x][y].destroyedShip();
							this.playerOne.setPoints(this.getPlayerOnePoints() + this.playerTwo.getObjectsZone()[x][y].getPoints());					
							this.playerTwo.setDiscoveredOwnZone("O", x, y);
							this.playersZone();
							break;
							
						}else {
								System.out.println("You already destroyed this ship, try again please!");
															
							}
						
					}else {
						System.out.println("You missed");
						this.playerTwo.setDiscoveredOwnZone("X", x, y);		
						this.playersZone();
						break;
					}
					}	
					
					}
			//	playerTurn = 1;
				if(this.checkWinner(this.playerTwo)) {
					System.out.println(this.getPlayerOne().getCaptain() + " are the winner!");
					this.setStatusBattle(false);
						
				}
						
				if(playerTurn == 1) {
					System.out.println("Hey " + this.getPlayerTwo().getCaptain() + " is your time!! Go!");
					this.getPlayerTwo().setTarget();
					y = letterConvert(this.getPlayerTwo().getTarget().substring(1,2));
					x = (Integer.parseInt(this.getPlayerTwo().getTarget().substring(0,1))-1);
					
					
					if(this.playerOne.getObjectsZone()[x][y] instanceof Ship) {
						this.playerOne.getObjectsZone()[x][y].shipMsg();
						this.playerOne.getObjectsZone()[x][y].destroyedShip();
						this.playerTwo.setPoints(this.getPlayerTwoPoints() + this.playerOne.getObjectsZone()[x][y].getPoints());					
						this.playerOne.setDiscoveredOwnZone("O", x, y);
						this.playersZone();
						
					}else {
						System.out.println("You missed");
						this.playerOne.setDiscoveredOwnZone("X", x, y);	
						this.playersZone();
					}
					
					
					if(this.checkWinner(this.playerOne)) {
						System.out.println(this.getPlayerTwo().getCaptain() + " are the winner!");
						this.setStatusBattle(false);
						
					}
					playerTurn = 0;
				}
			}
			}

	}
	private boolean checkWinner(Player player) {
		for (int x = 0; x < player.getShips().size(); x++) {
			if (player.getShips().get(x).isDestroyed() == false) {
				return false;
			}
		}
		return true;
	}

	private void playersZone() {
		System.out.println("------------------------------------------------");
		System.out.println(this.playerOne.getTeamName() + " zone");
		this.playerOne.showZone();
		System.out.println("------------------------------------------------");

		System.out.println("------------------------------------------------");
		System.out.println(this.playerTwo.getTeamName() + " zone");
		this.playerTwo.showZone();
		System.out.println("------------------------------------------------");
	}

	private int letterConvert(String letter) {
		switch (letter) {

		case "A":
			return 0;
		case "B":
			return 1;
		case "C":
			return 2;
		case "D":
			return 3;
		case "E":
			return 4;
		case "F":
			return 5;
		case "G":
			return 6;
		case "H":
			return 7;
		default:
			return -1;
		}
	}

	public boolean isStatusBattle() {
		return statusBattle;
	}

	public void setStatusBattle(boolean statusBattle) {
		this.statusBattle = statusBattle;
	}

	public Player getPlayerOne() {
		return playerOne;
	}

	public void setPlayerOne(Player playerOne) {
		this.playerOne = playerOne;
	}

	public Player getPlayerTwo() {
		return playerTwo;
	}

	public void setPlayerTwo(Player playerTwo) {
		this.playerTwo = playerTwo;
	}

	public int getPlayerOnePoints() {
		return playerOnePoints;
	}

	public void setPlayerOnePoints(int playerOnePoints) {
		this.playerOnePoints = playerOnePoints;
	}

	public int getPlayerTwoPoints() {
		return playerTwoPoints;
	}

	public void setPlayerTwoPoints(int playerTwoPoints) {
		this.playerTwoPoints = playerTwoPoints;
	}

}

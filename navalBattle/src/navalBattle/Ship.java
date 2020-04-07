package navalBattle;

public class Ship {
	private String ship;
	private String icon;
	private int points;
	private boolean destroyed;
	
	
	public Ship(String ship, String icon, int points) {
		this.ship = ship;
		this.icon = icon;
		this.points = points;
		this.destroyed = false;
				
	}
	
	public void shipMsg(){
		System.out.println("WOW Spot on. You you Hit a " + this.getShip() + "You gained " + this.getPoints());
		
	}
	
	public void destroyedShip() {
		if(!destroyed) {
			this.setDestroyed(true);
		}	
	}

	
	public String getShip() {
		return ship;
	}

	public void setShip(String ship) {
		this.ship = ship;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public boolean isDestroyed() {
		return destroyed;
	}

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}

}

package Player;

public class Player {
	
	private String name;
	private char p;
	private int score;
	
	public Player(String name, char p){
		this.name = name;
		this.p = p;
		this.score = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public char getP() {
		return p;
	}

	public void setP(char p) {
		this.p = p;
	}
}

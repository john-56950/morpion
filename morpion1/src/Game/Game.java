package Game;

import java.util.Scanner;

import Plateau.Grille;
import Player.Player;

public class Game {
	
	private Player p1;
	private Player p2;
	private Grille g;
	
	public Game(){
		p1 = new Player(null,'O');
		p2 = new Player(null,'X');
		g = new Grille();
	}

	public Player getP1() {
		return p1;
	}

	public void setP1(Player p1) {
		this.p1 = p1;
	}

	public Player getP2() {
		return p2;
	}

	public void setP2(Player p2) {
		this.p2 = p2;
	}

	public Grille getG() {
		return g;
	}

	public void setG(Grille g) {
		this.g = g;
	}
	
	public static int demandeLig(){
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
	public void playToGame(char p, String name){
		System.out.println("");
		System.out.println("GRILLE DE JEU !");
		g.afficheGrille();
		System.out.println(name+" n° de la case !");
		int numCase = demandeLig();
		
		if(numCase<1 || numCase>9){
			System.out.println("Erreur de saisie !");
			playToGame(p, name);
		}
		if(numCase>0 && numCase<4){
			if(g.estVide(0, numCase-1)){
				g.addTo(0, numCase-1, p);
			}
			else{
				System.out.println("Case pleine !");
				playToGame(p, name);
			}
		}
		else if(numCase>3 && numCase<7){
			if(g.estVide(1, numCase-4)){
				g.addTo(1, numCase-4, p);
			}
			else{
				System.out.println("Case pleine !");
				playToGame(p, name);
			}		
		}
		else if(numCase>6 && numCase<10){
			if(g.estVide(2, numCase-7)){
				g.addTo(2, numCase-7, p);
			}
			else{
				System.out.println("Case pleine !");
				playToGame(p, name);
			}
		}
	}
	
	public void play(Game game){
		Scanner sc = new Scanner(System.in);
		System.out.println("OPTIONS !");
		Command.allCommand();
		System.out.println();
		System.out.println("Choix ?");
		String c = sc.next();
		
		Command cmd = Command.getCommand(c);
		
		if(cmd == null){
			System.out.println("Mauvaise commande !");
			play(game);
		}
		else{
			switch(cmd){
			case JOUER:
				System.out.println("Nom du joueur 1 !");
				game.getP1().setName(sc.next());
				System.out.println("Nom du joueur 2 !");
				game.getP2().setName(sc.next());
				System.out.println(game.getP1().getName()+" à les ronds et "+game.getP2().getName()+" à les croix.");
				
				do{
					playToGame(p1.getP(),p1.getName());
					if(g.grillePleine() != true && g.Win(p1.getP()) != true){
						playToGame(p2.getP(),p2.getName());
					}
				}
				while(g.grillePleine() != true && g.Win(p1.getP()) != true && g.Win(p2.getP()) != true);
				if(g.Win(p1.getP()) == true){
					System.out.println(p1.getName()+" a gagné !");
					System.out.println(p2.getName()+" a perdu !");
				}	
				else if(g.Win(p2.getP()) == true){
					System.out.println(p2.getName()+" a gagné !");
					System.out.println(p1.getName()+" a perdu !");
				}
				else{
					System.out.println("MATCH NUL !");	
				}
				break;
			case REGLES:
				System.out.println("Chaque joueur doit aligné 3 pions de la même forme pour gagné !");
				play(game);
				break;
			case QUITTER:
				break;	
			}
		}
	}
				
	public static void main(String args[]){
		Game game = new Game();
		game.play(game);
	}
}

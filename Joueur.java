import java.util.*;
public class Joueur{
	public String nom;
	public LinkedList <Carte> cartes;
	public int score;
	public int somme;
	
	public Joueur(int num, LinkedList <Carte> c){
		score=0;
		somme=0;
		cartes= c;
	}
	public Joueur(String n){
		nom=n;
		score=0;
		somme=0;
	}
	
	public void calculScore(Joueur j1){
		score=score+j1.somme;
	}
	public void calculSomme(){
		for( Carte c : cartes){
			somme= somme+ c.valeur;
		}
	}
}
	

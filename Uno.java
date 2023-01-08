import java.util.*;
public class Uno {
	
	public static void main ( String[] args){
		
		LinkedList<Carte> pioche=new LinkedList<Carte>();
		LinkedList<Carte> defausse=new LinkedList<Carte>(); 
		

		//tableau de couleur
		String[] couleurs={"ROUGE","JAUNE","VERT","BLEU","NOIR"};
		
		//initialisation de la pioche
		for (int k=0; k<2;k++){ //2 cartes de chaque type
			for (int i=0; i<=3; i++){ //4 couleurs
				for (int j=1; j<=9;j++){ //que les chiffres
					Carte carte=new Carte(j,couleurs [i]);
					pioche.add (carte);
				}		
				//cartes spéciales: "+4"; "choixCouleur" ; "+2"; "passer"; "inverser";
				pioche.add(new Carte("+2", couleurs [i]));
				pioche.add(new Carte("passer", couleurs [i]));
				pioche.add(new Carte("inverser", couleurs [i]));
			}
			pioche.add(new Carte("+4", couleurs [4]));
			pioche.add(new Carte("+4", couleurs [4]));
			pioche.add(new Carte("choixCouleur", couleurs [4]));
			pioche.add(new Carte("choixCouleur", couleurs [4]));	
		}
	
		// initialisation des paquets de cartes des 4 joueurs:
		Joueur [] joueurs= new Joueur [4];
		for (int i=0; i<=3;i++){
			LinkedList<Carte> mainDuJoueur=new LinkedList<Carte>();
			while(mainDuJoueur.size() != 7){
				mainDuJoueur.add(piocher(pioche));
			}
			joueurs[i]=new Joueur (i, mainDuJoueur);
		}
		//Affichage de la fenetre Jeu
		FenetreMenu a=new FenetreMenu(pioche,joueurs);
		
	}
	
	//enlève et renvoie une carte de la pioche
	public static Carte piocher(LinkedList<Carte> pioche){ 
		int i= (int)(pioche.size()*Math.random());
		Carte c = pioche.get(i);
		pioche.remove(i);
		return c;
	}
}


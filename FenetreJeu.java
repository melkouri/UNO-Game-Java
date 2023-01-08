import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JButton;
import java.awt.Color;



public class FenetreJeu extends JFrame implements ActionListener {
	private LinkedList<Carte> pioche;			//paquet de cartes
	private Joueur[] joueur= new Joueur[4]; 	//tableau dejoueurs
	private LinkedList <Carte> cartesEnCours; 	//liste qui stocke les cartes à afficher
	private JButton jouer;						//pour jouer la carte
	private JButton boutonPioche;				//pour piocher
	private JButton joueurSuivant;				
	private int positionCarte;					//numéro choisi par le joueur
	private JTextField num;						//JtextField pour récupérer le numéro de carte
	private LinkedList <Carte> defausse;
	private boolean sensJeu; 					//true si sens est changé
	public int joueurEnCours;					//indice du joueur courant
	public Carte carteSupDefausse;
	public JTextField tourJoueur;	
	private LinkedList<Carte> liste2ou4;		//liste de cartes qui stocke les cartes à piocher si +2 ou +4
	public JTextField couleur;
	public JPanel choixCouleur;
	public String couleurChoisie;
	public JButton jSuivant;
	public JFrame frame;						//Fenetre entre chaque joueur
	public boolean joSuivant;					//true si on passe au joueur suivant
	
	public FenetreJeu (Joueur[] j,LinkedList<Carte> pioche){
		cartesEnCours=new LinkedList<Carte>();
		joueur=j;
		defausse=new LinkedList<Carte>();
		defausse.add(piocher(pioche));
		carteSupDefausse=new Carte();
		carteSupDefausse=defausse.get(defausse.size()-1);
		
		liste2ou4=new LinkedList<Carte> ();
		joueurEnCours=0;
		sensJeu=false;
		joSuivant=false;
		
		cartesEnCours=joueur[0].cartes;
		
		this.pioche=pioche;
		this.setTitle("UNO");
		this.setSize(1920,1080);
		this.setLocation(0,0);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Bouton Piocher
		boutonPioche= new JButton(new ImageIcon("uno_dos.jpg"));
		boutonPioche.setBounds(300,65,136,205);
		boutonPioche.addActionListener(this);
		
		//Bouton Jouer
		jouer=new JButton();
		jouer.setBounds(100,0,200,150);
		jouer.setText("Jouer");
		jouer.setBackground(new Color(255,215,0));
		jouer.setFont(new java.awt.Font("Tahoma", 1, 36)); 
		jouer.addActionListener(this);
		
		//Texte du numéro saisi
		num=new JTextField();
		num.setBounds(100,170,200,150);
		num.setFont(new java.awt.Font("Tahoma", 1, 30));
		
		//Bouton passer au Joueur Suivant
		joueurSuivant=new JButton();
		joueurSuivant.setBounds(100,340,200,150);
		joueurSuivant.setText("Joueur suivant");
		joueurSuivant.setBackground(new Color(255,215,0));
		joueurSuivant.setFont(new java.awt.Font("Tahoma", 1, 20));
		joueurSuivant.addActionListener(this);
		
		//Texte affichant le joueur en cours
		tourJoueur=new JTextField();
		tourJoueur.setBounds(20,510,400,50);
		tourJoueur.setOpaque(false);
		tourJoueur.setBorder(null);
		tourJoueur.setEditable(false);
		tourJoueur.setForeground(Color.white);
		tourJoueur.setBackground(Color.blue);
		tourJoueur.setText("Le joueur en cours est 1 "+joueur[0].nom);
		tourJoueur.setFont(new Font ("",Font.PLAIN,30));
		
		//photo fond
		JLabel photo=new JLabel(new ImageIcon("fondFenetreJeu1.png"));
        photo.setBounds(0,0,1920,1080);
		
		//Texte couleur saisie
		couleur=new JTextField();
		couleur.setBounds(50,50,200,100);
		couleur.setFont(new java.awt.Font("Tahoma", 1, 30));
		couleur.setForeground(Color.white);
		couleur.setBackground(Color.black);
		
		// JPanel choixCouleur
		choixCouleur=new JPanel();
		choixCouleur.setBounds(600,400,300,200);
		choixCouleur.setLayout(null);
		choixCouleur.setBackground(Color.white);
		couleurVisible(false);
		
		// JPanel principal
		JPanel conteneurPrincipal  = new JPanel();
		conteneurPrincipal.setBounds(0,0,1920,1080);
		conteneurPrincipal.setLayout(null);
		
		// JPanel pioche
		JPanel zonePioche = new JPanel();
		zonePioche.setLayout(null);
		zonePioche.setBounds(1000,100,500,600);
		zonePioche.setOpaque(false);
		
		choixCouleur.add(couleur);
		
		zonePioche.add(joueurSuivant);
		zonePioche.add(tourJoueur);
		zonePioche.add(jouer);
		zonePioche.add(num);
		
		conteneurPrincipal.add(choixCouleur);
		conteneurPrincipal.add(boutonPioche);
		conteneurPrincipal.add(zonePioche);
		conteneurPrincipal.add(photo);
		this.add(conteneurPrincipal);
		this.setVisible(true);
		
		
		partie();
		
		//Fenetre entre chaque joueur
		jSuivant = new JButton();
        jSuivant.setText("Passer au joueur suivant");
        jSuivant.setFont(new java.awt.Font("Tahoma", 1, 50));
        jSuivant.setBounds(760,412,350,250);
        jSuivant.addActionListener(this);
		frame = new JFrame();
		frame.setContentPane(jSuivant);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(1920,1080));
		frame.pack();
		frame.setVisible(false);
		
	}
	//méthode pour piocher des cartes
	public Carte piocher(LinkedList<Carte> pioche){ 
		//on teste si la pioche est vide si oui on remet les cartes de la defausse en gardant la dernière carte jouée
		if(pioche.isEmpty()){
			for(int i=0;i<defausse.size()-1;i++){
				pioche.add(defausse.get(i));
				defausse.remove(i);
			}
		}
		int i= (int)(pioche.size()*Math.random());
		Carte c = pioche.get(i);
		pioche.remove(i);
		return c;
	}
	
	//Méthode qui lance la partie
	public void partie(){
		cartesEnCours=joueur[0].cartes;
		Carte c= defausse.get(defausse.size()-1);
		//La partie ne commence pas si la première carte est +2/+4/ChoixCouleur
		if((c.type.equals("+2")) || (c.type.equals("+4")|| c.type.equals("choixCouleur"))){
			defausse.add(piocher(pioche));
			partie();
		}
		//Si la partie commence avec la carte inverser ou passer
		jouerPasserouInverser();
	}
	
	//permet d'ajouter des cartes dans liste2ou4 
	public void plusDeCartes ( Carte dCarte,LinkedList <Carte> pioche){ 
		if( dCarte.type == "+2" || dCarte.type == "+4"){
			liste2ou4.add(piocher(pioche));
			liste2ou4.add(piocher(pioche));
			if(dCarte.type == "+4"){
				liste2ou4.add(piocher(pioche));
				liste2ou4.add(piocher(pioche));
			}
		}
	}
	
	//actualise la carte sup et l'enlève de la main du joueur
	public void carteSuperieure(Joueur j){
		Carte p=cartesEnCours.get(positionCarte);
		defausse.add(p);
		carteSupDefausse=defausse.get(defausse.size()-1);
		j.cartes.remove(positionCarte);
		repaint();
	}

	//Méthode qui dessine la liste des cartes du joueur en cours
	public void paint(Graphics g){
		super.paint(g);
		for(int i=0; i<cartesEnCours.size();i++){
			cartesEnCours.get(i).dessine(g,i*(1920)/cartesEnCours.size(),800);
			
			//affichage numéros en dessus des cartes
			Font fonte = new Font("TimesRoman ",Font.BOLD,20);
			g.setFont(fonte);
			g.setColor(Color.white);
			g.drawString(Integer.toString(i+1) , i*(1920)/cartesEnCours.size() +10,780);
		}
		defausse.get(defausse.size()-1).dessine(g,100,100);
	}
		
	//Méthode qui met à jour cartesEnCours
	public void majCartesEnCours(int i){
		cartesEnCours=joueur[i].cartes;
		repaint();
	}
	
	//Test si une carte de pouvoir void est jouable
	public boolean jouableVoid(Carte carteSup, Carte c){
		boolean a=(c.getCouleur().equals(carteSup.getCouleur()) || c.valeur==carteSup.valeur || c.couleur=="NOIR");
		if((carteSup.type=="+2" || carteSup.type=="+4" || carteSup.type=="inverser" || carteSup.type=="passer") && carteSup.pouvoir=="void"){
			a= a || (c.type==carteSup.type);
		}
		return a;
	}
	//Méthode qui incrémente le tour du joueur
	public void avancer(){
		if(sensJeu==false){
			joueurEnCours++;
			if(joueurEnCours>=4){
				joueurEnCours=0;
			}
			
		}
		if(sensJeu){
			joueurEnCours--;
			if(joueurEnCours<0){
					joueurEnCours=joueur.length-1;
			}
		}
		tourJoueur.setText("le joueur en cours est "+ Integer.toString(joueurEnCours+1)+" "+ joueur[joueurEnCours].nom);
	}
	

		
	//Méthode pour jouer inverser et passer
	public void jouerPasserouInverser(){
		//si carte passer
		if(carteSupDefausse.pouvoir=="passer"){
			visible(false);
			JOptionPane.showMessageDialog(this,"Vous passez votre tour");
			carteSupDefausse.pouvoir="void";
		}
		//Si carte inverser
		if(carteSupDefausse.pouvoir=="inverser"){
			visible(false);
			sensJeu=!sensJeu;
			JOptionPane.showMessageDialog(this,"Changement du sens du jeu");
			carteSupDefausse.pouvoir="void";
		}
	}
	//visibilité boutons
	public void visible(boolean b){
		jouer.setVisible(b);
		boutonPioche.setVisible(b);
	}
	
	//Visibilité Panel choix couleur
	public void couleurVisible(boolean b){
		choixCouleur.setVisible(b);
	}
	
	//test si la partie est finie
	public void winOrLose(){  //Si un joueur n'a plus de cartes, il remporte la manche et gagne des points (somme des valeurs des cartes des autres)
		String s;
		if(joueur[joueurEnCours].cartes.isEmpty()){
			for(int i=0;i<joueurEnCours;i++){	
				joueur[joueurEnCours].calculScore(joueur[i]);
			}
			for(int i=joueurEnCours+1;i<joueur.length;i++){	
				joueur[joueurEnCours].calculScore(joueur[i]);
			}
			FenetreFin fin = new FenetreFin(joueur[joueurEnCours]);
		}
	}
	
	//déroulement du jeu
	public void actionPerformed(ActionEvent e){	
		if(e.getSource()==jouer){
			
			if(Integer.parseInt(num.getText())>=1){
				positionCarte=Integer.parseInt(num.getText())-1;
				//si la carte est une carte chiffre ou n'a pas de pouvoir
				if(carteSupDefausse.pouvoir.equals("void")){
					if(jouableVoid(carteSupDefausse,cartesEnCours.get(positionCarte))){
						carteSuperieure(joueur[joueurEnCours]);
						majCartesEnCours(joueurEnCours);
						visible(false);
					}
					else{
						JOptionPane.showMessageDialog(this,"Veuillez piocher");
					}
				} 
				//si la carte est un +2 
				if(carteSupDefausse.pouvoir=="+2"){
					if(joSuivant){
						if(cartesEnCours.get(positionCarte).pouvoir=="+2"){
							carteSuperieure(joueur[joueurEnCours]);
							plusDeCartes(carteSupDefausse,pioche);
						}
						else{
							plusDeCartes(carteSupDefausse,pioche);
							for(Carte c : liste2ou4){
								joueur[joueurEnCours].cartes.add(c);
								carteSupDefausse.pouvoir="void";
							}
							liste2ou4.clear();
						}
					}
					majCartesEnCours(joueurEnCours);
					joSuivant=false;
				}
				//Si la carte est un +4
				if(carteSupDefausse.pouvoir=="+4"){
					couleurVisible(true);
					if(joSuivant){
						if(cartesEnCours.get(positionCarte).pouvoir=="+4"){
							carteSuperieure(joueur[joueurEnCours]);
							plusDeCartes(carteSupDefausse,pioche);
						}
						else{
							plusDeCartes(carteSupDefausse,pioche);
							for(Carte c : liste2ou4){
								joueur[joueurEnCours].cartes.add(c);
								carteSupDefausse.pouvoir="void";
							}
							liste2ou4.clear();
						}
					}
					majCartesEnCours(joueurEnCours);
					joSuivant=false;
				}
				//si carte choix couleur
				if(carteSupDefausse.pouvoir=="choixCouleur"){
					JOptionPane.showMessageDialog(this,"Choisissez une couleur");
					couleurVisible(true);
					carteSupDefausse.pouvoir = "void";
					
				}
				//si carte passer
				if(carteSupDefausse.pouvoir=="passer" ){
					visible(false);
				}
				//Si carte inverser
				if(carteSupDefausse.pouvoir=="inverser"){
					visible(false);
					sensJeu=!sensJeu;
					JOptionPane.showMessageDialog(this,"Changement du sens du jeu");
					carteSupDefausse.pouvoir="void";
				}					
			}
			else{
				JOptionPane.showMessageDialog(this,"Entrez un numéro de carte supérieur ou égal à 1 ou piochez");
			}	
		}
		if (e.getSource()== boutonPioche){
			joueur[joueurEnCours].cartes.add(piocher(pioche));
			majCartesEnCours(joueurEnCours);
			visible(false);

		}
		if(e.getSource()==joueurSuivant){
			visible(true);
			winOrLose();
			frame.setVisible(true);
			avancer();
			majCartesEnCours(joueurEnCours);
		}
		if(e.getSource()==jSuivant){
			if(carteSupDefausse.pouvoir=="passer"){
				JOptionPane.showMessageDialog(this,"Vous passez votre tour");
				visible(false);
				carteSupDefausse.pouvoir="void";
			}
			if((carteSupDefausse.type == "choixCouleur")||(carteSupDefausse.type == "+4")){
				couleurChoisie = couleur.getText();
				couleurVisible(false);
				
				if(couleurChoisie.equals("VERT") || couleurChoisie.equals("ROUGE") || couleurChoisie.equals("BLEU") ||couleurChoisie.equals("JAUNE")){
					carteSupDefausse.couleur = couleurChoisie;
					JOptionPane.showMessageDialog(this,"Jouer une carte de couleur "+couleurChoisie);
				}else{
					JOptionPane.showMessageDialog(this,"Veuillez choisir une autre couleur");
				}
			}
			if(carteSupDefausse.pouvoir=="+2"|| carteSupDefausse.pouvoir=="+4"){
				joSuivant=true;
			}
			frame.setVisible(false);
			
		}
	}

	
}

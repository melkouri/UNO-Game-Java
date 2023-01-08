 import javax.swing.*;
 import java.awt.*;
 import java.awt.Color;
 import java.awt.event.*;
 import java.util.*;
public class FenetreMenu extends JFrame implements ActionListener {

    private JButton jButton1;//Jouer
    private JButton jButton2;//Quitter
    private JLabel jLabel1;
    private LinkedList<Carte> pioche;
    private Joueur [] joueurs;
    
    
    public FenetreMenu(LinkedList<Carte> p, Joueur [] j) {
        super("Menu");
		this.setSize(1920,1080);
		this.setLocation(0,0);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		joueurs=j;
		pioche=p;
		
		jButton1 = new JButton();
        jLabel1 = new JLabel();
        jButton2 = new JButton();

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 70)); 
        jButton1.setText("Jouer");
        jButton1.setBounds(760,412,350,250);
        jButton1.addActionListener(this);

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 70)); 
        jButton2.setText("Quitter");
        jButton2.setBounds(760,742,350,250);
        jButton2.addActionListener(this);
        
        JLabel photo=new JLabel(new ImageIcon("unobackground1.png"));
        photo.setBounds(0,0,1920,1080);
        
		//JPanel principal
		JPanel conteneurPrincipal = new JPanel();
		conteneurPrincipal.setLayout(null);
		conteneurPrincipal.setBounds(0,0,1920,1080);
		
        conteneurPrincipal.add(jButton2);
        conteneurPrincipal.add(jButton1);
        conteneurPrincipal.add(photo);
    
        this.add(conteneurPrincipal);
        setVisible(true);
    }                        

    public void actionPerformed(ActionEvent e) {                                         
		NomJoueurs fenetrejoueurs=new NomJoueurs(pioche);
		fenetrejoueurs.joueurs=joueurs;
        if(e.getSource()==jButton1){
			fenetrejoueurs.setVisible(true);
		}
		if(e.getSource()==jButton2){
			setVisible(false);
		}
    }                                        

}
               

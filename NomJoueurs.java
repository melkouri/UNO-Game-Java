 import javax.swing.*;
 import java.awt.*;
 import java.awt.Color;
 import java.awt.event.*;
 import java.util.*;
public class NomJoueurs extends JFrame implements ActionListener{

    
    public Joueur [] joueurs;
    private JButton BoutonCommencer;
    private JButton BoutonEnregistrer;
    private JTextField Nom1;
    private JTextField Nom2;
    private JTextField Nom3;
    private JTextField Nom4;
    private LinkedList<Carte> pioche;
    
    public NomJoueurs(LinkedList<Carte> p) {
		super("NomsJoueurs");
		this.setSize(1920,1080);
		this.setLocation(0,0);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 joueurs= new Joueur [4];
		 pioche=p;

        Nom1 = new JTextField();
        Nom1.setBounds(1040,215,400,145);
        
        Nom2 = new JTextField();
        Nom2.setBounds(1040,380,400,145);
        
        Nom3 = new JTextField();
        Nom3.setBounds(1040,545,400,145);
        
        Nom4 = new JTextField();
        Nom4.setBounds(1040,710,400,145);
        
        JLabel jLabel1 = new JLabel();
        JLabel NomJoueurLabel4 = new JLabel();
        JLabel NomJoueurLabel3 = new JLabel();
        JLabel NomJoueurLabel2 = new JLabel();
        JLabel NomJoueurLabel1 = new JLabel();
        BoutonCommencer = new JButton();
        BoutonEnregistrer = new JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Entrez les pseudos des joueurs");
		jLabel1.setBounds(610,40,700,145);
		jLabel1.setForeground(Color.YELLOW);

        NomJoueurLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        NomJoueurLabel4.setText("Joueur 4");
        NomJoueurLabel4.setBounds(100,710,400,145);
        NomJoueurLabel4.setForeground(Color.YELLOW);

        NomJoueurLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); 
        NomJoueurLabel3.setText("Joueur 3");
		NomJoueurLabel3.setBounds(100,545,400,145);
		NomJoueurLabel3.setForeground(Color.YELLOW);
		
        NomJoueurLabel2.setFont(new java.awt.Font("Tahoma", 1, 36));
        NomJoueurLabel2.setText("Joueur 2");
		NomJoueurLabel2.setBounds(100,380,400,145);
		NomJoueurLabel2.setForeground(Color.YELLOW);
		
        NomJoueurLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); 
        NomJoueurLabel1.setText("Joueur 1");
        NomJoueurLabel1.setBounds(100,215,400,145);
        NomJoueurLabel1.setForeground(Color.YELLOW);
        
        BoutonCommencer.setFont(new java.awt.Font("Tahoma", 1, 36)); 
        BoutonCommencer.setText("Commencer");
        BoutonCommencer.setBounds(1040,885,400,145);
        BoutonCommencer.addActionListener(this);

        BoutonEnregistrer.setFont(new java.awt.Font("Tahoma", 1, 36)); 
        BoutonEnregistrer.setText("Enregistrer");
        BoutonEnregistrer.setBounds(80,885,400,145);
        BoutonEnregistrer.addActionListener(this);
        
        JLabel photo=new JLabel(new ImageIcon("unobackground1.png"));
        photo.setBounds(0,0,1920,1080);
        
        //JPanel principal
		JPanel conteneurPrincipal = new JPanel();
		conteneurPrincipal.setLayout(null);
		conteneurPrincipal.setBounds(0,0,1920,1080);
		
        add(conteneurPrincipal);
        conteneurPrincipal.add(BoutonEnregistrer);
        conteneurPrincipal.add(BoutonCommencer);
        conteneurPrincipal.add(Nom1);
        conteneurPrincipal.add(Nom2);
        conteneurPrincipal.add(Nom3);
        conteneurPrincipal.add(Nom4);
        conteneurPrincipal.add(NomJoueurLabel4);
        conteneurPrincipal.add(NomJoueurLabel3);
        conteneurPrincipal.add(NomJoueurLabel2);
        conteneurPrincipal.add(NomJoueurLabel1);
        conteneurPrincipal.add(jLabel1);
        conteneurPrincipal.add(photo);
        
        setVisible(false);
    }                  

    public void actionPerformed(ActionEvent e) { 
		if(e.getSource() ==BoutonEnregistrer){                                       
			joueurs[0]=new Joueur( Nom1.getText());
			joueurs[1]=new Joueur( Nom2.getText());
			joueurs[2]=new Joueur( Nom3.getText());
			joueurs[3]=new Joueur( Nom4.getText());
		}
		if(e.getSource() ==BoutonCommencer){
			new FenetreJeu(joueurs,pioche).setVisible(true);
		}
			
    }                                                 
                                             
}

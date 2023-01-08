import javax.swing.*;
import java.awt.*;

public class FenetreFin extends JFrame{
	public FenetreFin(Joueur j){
		super("Game Over");
		this.setSize(1920,1080);
		this.setLocation(0,0);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel photo=new JLabel(new ImageIcon("unobackground1.png"));
        photo.setBounds(0,0,1920,1080);
        
        JLabel gagnant=new JLabel();
        gagnant.setText("Le gagnant est "+ j.nom +" avec un score de "+ j.score);
        gagnant.setBounds(400,300,1400,400);
        gagnant.setFont(new java.awt.Font("Segoe UI", 1, 50)); 
        gagnant.setForeground(Color.YELLOW);
        
		//JPanel principal
		JPanel conteneurPrincipal = new JPanel();
		conteneurPrincipal.setLayout(null);
		conteneurPrincipal.setBounds(0,0,1920,1080);
		
		conteneurPrincipal.add(gagnant);
		conteneurPrincipal.add(photo);
		this.add(conteneurPrincipal);
		this.setVisible(true);
	}
}

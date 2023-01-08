import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.*;
import java.awt.image.*;

public class Carte {
	
	public String couleur; 
	public int valeur;
	public String type;
	public String pouvoir; 
	private Image image;
	
	public Carte (int valeur, String couleur){
		this.couleur=couleur;
		this.valeur=valeur;
		this.type= "chiffre"; 
		this. pouvoir = "void";
		String fileName=valeur +" "+couleur;
		try{
			BufferedImage img= ImageIO.read(new File("./images UNO/"+fileName+".png"));
			image=img.getScaledInstance(125,185,java.awt.Image.SCALE_SMOOTH);
		}catch (IOException ex){
			System.out.println("IOException from cartes constructor"+ this.getCarte());
		}
	} 
	
	public Carte (){
	}
	
	public Carte (String type, String couleur){
		this.couleur=couleur;
		this.type=type;
		this.pouvoir=type;
		if (this.type=="+4"||this.type=="choixCouleur") valeur=50;												
		if (this.type=="+2"||this.type=="passer"||this.type=="inverser") valeur=20;
		String fileName=type +" "+couleur;
		try{
			BufferedImage img= ImageIO.read(new File( fileName+".png"));
			image=img.getScaledInstance(125,185,java.awt.Image.SCALE_SMOOTH);
		}catch (IOException ex){
			System.out.println("IOException from cartes constructor" + this.getCarte());
		}
	}
	
	public String getCarte (){
		String s =("Je suis une carte de couleur " + this.couleur+ ", de type "+ this.type+ " et de valeur " + this.valeur +" et de pouvoir " + this.pouvoir);
		return s;
	}
	public void dessine(Graphics g, int x, int y){
		g.drawImage(image,x,y,null);
	}
	public String getCouleur(){
		return this.couleur;
	}
}

package objetos.futbol.UI;
import javax.swing.*;
import java.math.*;
import java.awt.*;
import java.awt.event.*;

public class CanchaDibujo extends JPanel{
	private double x1=0 , y1=0;
	private final double Cx=0.3278;
	private final double Cy=0.3156;
	private Color b = new Color(31,238,48);	
	private Color c = new Color(36,100,42);
	private Color r = new Color(235,235,235);
	public void paintComponent(Graphics g){
		g.setColor(b);
		g.fillRect(0, 0, 600, 400);
		g.setColor(Color.BLACK);
		g.fillRect(0, 135, 600, 135);
		g.setColor(c);
		g.fillRect(150,135,300,135);
		g.setColor(Color.RED);
		double x= (x1*Cx)-15;
		double y= ((385)-(y1*Cy));
		g.fillOval((int)x,(int)y, 30, 30);
		g.setColor(r);
		g.fillRect(0, 400, 10000, 1000);
		
	}
	public double getX1(){
		return this.x1;
	}
	public double getY1(){
		return this.y1;
	}
	public void setX1(double x1){
		this.x1=x1;
		repaint();
	}
	public void setY1(double y1){
		this.y1=y1;
		repaint();
	}
}


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Windows.10
 */
public class draw extends JFrame{

    public draw(){
        setTitle("compare");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
    }
    
    public void print(Graphics g){
        super.print(g);
        g.setColor(Color.BLUE);
        g.drawString("dvdvfv", 50, 50);
    }
    
    public static void main(String[] args) {
        new draw();
    }
}

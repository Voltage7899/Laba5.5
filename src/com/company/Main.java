package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JComponent implements  KeyListener,ActionListener {

    Image grass=new ImageIcon("src/grass.jpg").getImage();
    Image apple =new ImageIcon("src/apple1.png").getImage();
    private int Rx=10,Ry=10,w=5,h=5,Applex=0,Appley=0;
    Timer t=new Timer(5,this);
    Rectangle rectangle=new Rectangle(Rx,Ry,w,h);


    public void paint(Graphics g)
    {
        Graphics2D gr =(Graphics2D)g;
        gr.drawImage(grass,0,0,null);

        gr.fill(rectangle);
        gr.drawImage(apple,Applex,Appley,w+25,h+25,null);
        t.start();
    }


    public static void main(String[] args)
    {
        Main image =new Main();
        JFrame f=new JFrame("Animation");
        f.setSize(550,550);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.addKeyListener(image);
        f.add(new Main());
        f.add(image);
        f.setVisible(true);



    }
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            rectangle.setLocation(rectangle.x+1,rectangle.y);
            Rx+=1;
            this.Applex+=1;
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN)
        {
            rectangle.setLocation(rectangle.x,rectangle.y+1);
            this.Appley+=1;
        }



    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}
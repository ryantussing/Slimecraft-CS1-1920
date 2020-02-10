/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slattcraft;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

/**
 *
 * @author 802793
 */
public class SlattCraft extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame j = new SlattCraft();
        World c = new World();
        j.add(c);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setSize(826, 649);
        j.setVisible(true);
        j.setLocationRelativeTo(null);
        j.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                c.keyPressed(e);
//            }
//            @Override
//            public void keyReleased(KeyEvent e) {
//                c.keyReleased(e);
//            }
        });
    }
    
}

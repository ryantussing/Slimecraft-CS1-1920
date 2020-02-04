/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimecraft;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author jword
 */
public class World extends JPanel {
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(30, 30, 100,150);
    }
    
}

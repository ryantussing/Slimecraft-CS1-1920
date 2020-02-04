/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimecraft;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author jword
 */
public class World extends JPanel {
    private ArrayList<Blob> blobs = new ArrayList<>();    
    private ArrayList<Glob> globs = new ArrayList<>();    
    private ArrayList<Sprite> sprites = new ArrayList<>();

    public World() {
        sprites.add(new Blob(10,10));
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(30, 30, 100,150);
    }
    
}

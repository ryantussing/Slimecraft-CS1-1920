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
    //private ArrayList<Blob> blobs = new ArrayList<>();    
    //private ArrayList<Glob> globs = new ArrayList<>();    
    private ArrayList<Sprite> sprites = new ArrayList<>();

    public World() {
        for (int i = 0; i < 200; i++) {
            int x = (int) (Math.random() * 800);
            int y = (int) (Math.random() * 600);
            sprites.add(new Blob(x,y));    
        }        
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Sprite sprite : sprites) {
            sprite.draw(g);
        }
    }
    
}

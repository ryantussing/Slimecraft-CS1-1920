/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slattcraft;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author 802793
 */
public class Baby extends Sprite {
    
    //static constants
    private static int WIDTH = 10;
    private static int HEIGHT = 10;


    public Baby(int speed, int x, int y, Color color) {
        super(speed, x, y, WIDTH, HEIGHT, color);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(super.getColor());
        g.drawOval(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    }
    
}

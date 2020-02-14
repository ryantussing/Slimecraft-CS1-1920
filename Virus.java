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
public class Virus extends Sprite {
    
    private static final Color COLOR = new Color(238, 130, 238);
    private static final int WIDTH = 5;
    private static final int HEIGHT = 5;
    private static final int SPEED = 0;
    private int damage;
    
    public Virus (int x, int y) {
        super(SPEED, x, y, WIDTH, HEIGHT, COLOR);
        damage = (int) (Math.random() * 10);
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(super.getColor());
        g.fillOval(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    
}

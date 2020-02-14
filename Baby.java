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
    private int strength;
    private int health;


    public Baby(int speed, int x, int y, Color color) {
        super(speed, x, y, WIDTH, HEIGHT, color);
        this.strength = (int) (Math.random() * 20);
        this.health = (int) (strength * .75);
    }

     public void eat(Food food) {
        if (super.collide(food)) {
            super.setHeight(super.getHeight() + 5);
            super.setWidth(super.getWidth() + 5);
            this.strength = (int) (this.strength * 1.25);
            food.die();
        }
    }
     public void eat(Virus virus) {
        if (super.collide(virus)) {
            this.health = this.health - virus.getDamage();
            virus.die();
            checkHealth();
        }
    }
    public void didWin(Baby other) {
        this.strength += this.strength - other.strength;
        super.grow(1.2);
    }
    
    public void checkHealth() {
        if (this.health <= 0) {
            this.die();
        }
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(super.getColor());
        g.drawOval(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    }

    public int getStrength() {
        return strength;
    }
    
}

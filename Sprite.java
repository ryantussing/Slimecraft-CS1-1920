/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slattcraft;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
/**
 *
 * @author 802793
 */
public abstract class Sprite {
    
    private int speed;
    private int x, y;
    private int vx, vy;
    private int width, height;
    private Color color;
    private Rectangle bounds;
    private boolean alive;

    public Sprite(int speed, int x, int y, int width, int height, Color color) {
        this.speed = speed;
        this.alive = true;
        this.x = x;
        this.y = y;
        this.vx = (int) (Math.random() * this.speed * 2 - this.speed);
        this.vy = (int) (Math.random() * this.speed * 2 - this.speed);
        this.width = width;
        this.height = height;
        this.color = color;
        this.bounds = new Rectangle(x, y, width, height);
    }
    
    // Methods
    
    public void update() {
        this.x += this.vx;
        this.y += this.vy;
        this.bounds = new Rectangle(x, y, width, height);
    }
    public abstract void draw(Graphics g);
    
    public void collide(Sprite other) {
        if (this.bounds.intersects(other.bounds)) {
            this.didCollide();
            other.didCollide();
        }
    }
    
    public void eat(Sprite food) {
        if (this.getBounds().intersects(food.getBounds()) && food.isAlive()) {
            this.setHeight(this.getHeight() + 5);
            this.setWidth(this.getWidth() + 5);
            food.die();
        }
    }
    
    public void die() {
        this.alive = false;
    }
    
    public void didCollide() {
        this.vx = -this.vx;
        this.vy = -this.vy;
    }

    // Getters And Setters
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    
}

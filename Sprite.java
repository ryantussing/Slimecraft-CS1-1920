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
    private boolean alive = true;

    public Sprite(int speed, int x, int y, int width, int height, Color color) {
        this.speed = speed;
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
    public void grow(double rate) {
        this.width *= rate;
        this.height *= rate;
    }
    
    public void update() {
        this.x += this.vx;
        this.y += this.vy;
        this.bounds = new Rectangle(x, y, width, height);
    }
    public abstract void draw(Graphics g);
    
    public boolean collide(Sprite other) {
         boolean collided = this.bounds.intersects(other.bounds);
        if (collided) {
            this.didCollide();
            other.didCollide();
        }
        return collided;
    }

    public int getSpeed() {
        return speed;
    }
    
    public void die() {
        this.alive = false;
    }
    
    public void didCollide() {
        this.vx = -this.vx;
        this.vy = -this.vy;
        this.update();
    }

    public void collideWorldBounds(int cWidth, int cHeight) {
        if (this.x < 0 || this.x + this.width > cWidth)
            this.vx = -this.vx;
        if (this.y < 0 || this.y + this.height > cHeight)
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

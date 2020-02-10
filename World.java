/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slattcraft;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

/**
 *
 * @author 802793
 */
public class World extends JPanel {
    
    private ArrayList<BabyYoda> bbyoda = new ArrayList<>();    
    private ArrayList<BabyGroot> bbgroot = new ArrayList<>();    
    private ArrayList<Food> food = new ArrayList<>();    
    private ArrayList<Sprite> sprites = new ArrayList<>();
    private Timer timer;
    
    public World() {
        
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/30);
        
        for (int i = 0; i < 200; i++) {
            int x = (int) (Math.random() * 400);
            int y = (int) (Math.random() * 600);
            sprites.add(new BabyYoda(x,y));
        }
        for (int i = 0; i < 200; i++) {
            int x = (int) ((Math.random() * 400) + 400);
            int y = (int) (Math.random() * 600);
            sprites.add(new BabyGroot(x,y));
        }
        for (int i = 0; i < 200; i++) {
            int x = (int) ((Math.random() * 800));
            int y = (int) (Math.random() * 600);
            food.add(new Food(x,y));
        }
        
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Sprite sprite: sprites) {
            if (sprite.isAlive()) {
                sprite.draw(g);
            }
            sprite.update();
            for (Sprite other: sprites) {
                if (sprite != other) {
                    sprite.collide(other);
                }
            }
            for (Sprite food: food) {
                if (sprite != food) {
                    sprite.eat(food);
                }
            }
        }
    }
    
    private class ScheduleTask extends TimerTask {
        @Override
        public void run() {
            repaint();
        }
    }
    
}

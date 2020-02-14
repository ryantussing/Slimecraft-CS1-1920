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
    
    private ArrayList<BabyYoda> bbyodas = new ArrayList<>();    
    private ArrayList<BabyGroot> bbgroots = new ArrayList<>();    
    private ArrayList<Food> foods = new ArrayList<>();    
    private ArrayList<Sprite> sprites = new ArrayList<>();
    private ArrayList<Baby> babys = new ArrayList<>();
    private ArrayList<Virus> viruses = new ArrayList<>();
    private Timer timer;
    private int frames;
    
    public World() {
        
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/12);
        
        for (int i = 0; i < 30; i++) {
            int x = (int) (Math.random() * 400);
            int y = (int) (Math.random() * 600);
            BabyYoda bbyoda = new BabyYoda(x,y);
            sprites.add(bbyoda);
            babys.add(bbyoda);
            bbyodas.add(bbyoda);
        }
        for (int i = 0; i < 30; i++) {
            int x = (int) ((Math.random() * 400) + 400);
            int y = (int) (Math.random() * 600);
            BabyGroot bbgroot = new BabyGroot(x,y);
            sprites.add(bbgroot);
            babys.add(bbgroot);
            bbgroots.add(bbgroot);
        }
        for (int i = 0; i < 120; i++) {
            int x = (int) ((Math.random() * 800));
            int y = (int) (Math.random() * 600);
            Food food = new Food(x,y);
            foods.add(food);
            sprites.add(food);
        }
        for (int i = 0; i < 30; i++) {
            int x = (int) ((Math.random() * 800));
            int y = (int) (Math.random() * 600);
            Virus virus = new Virus(x,y);
            viruses.add(virus);
            sprites.add(virus);
        }
        
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        frames++;
        System.out.println(frames);
        for (Baby baby : babys) {
            for (Food food : foods) {
                baby.eat(food);
            }            
            for (Virus virus : viruses) {
                baby.eat(virus);
            }            
        }

        ArrayList<BabyYoda> newBabyYoda = new ArrayList<>();
        ArrayList<BabyGroot> newBabyGroot = new ArrayList<>();

        for (BabyYoda bbyoda : bbyodas) {
            for (BabyGroot bbgroot : bbgroots) {
                bbyoda.fight(bbgroot);
            }
            for (BabyYoda otherBabyYoda : bbyodas) {
                if (bbyoda == otherBabyYoda) continue;
                if (bbyoda.collide(otherBabyYoda) && Math.random() < 0.03)
                    newBabyYoda.add(bbyoda.reproduce(otherBabyYoda));
            }
        }
        for (BabyGroot bbgroot : bbgroots) {
            for (BabyGroot otherGlob : bbgroots) {
                if (bbgroot == otherGlob) continue;
                if (bbgroot.collide(otherGlob) && Math.random() < 0.03)
                    newBabyGroot.add(bbgroot.reproduce(otherGlob));
            }
        }
        for (Sprite sprite : sprites) {
            sprite.draw(g);
            sprite.update();         
            sprite.collideWorldBounds(800,600);
        }        

        takeOutTheTrash();
        addNewSlimes(newBabyYoda, newBabyGroot);
    }

    private void addNewSlimes(ArrayList<BabyYoda> newBabyYoda, ArrayList<BabyGroot> newBabyGroot) {
        bbyodas.addAll(newBabyYoda);
        bbgroots.addAll(newBabyGroot);
        sprites.addAll(newBabyGroot);
        sprites.addAll(newBabyYoda);
    }
    
     private void takeOutTheTrash() {
        ArrayList<Sprite> trash = new ArrayList<>();
        for (Sprite sprite : sprites) {
            if (!sprite.isAlive())
                trash.add(sprite);
        }
        sprites.removeAll(trash);
        trash.clear();
        for (Food food : foods) {
            if (!food.isAlive())
                trash.add(food);
        }
        for (Virus virus : viruses) {
            if (!virus.isAlive())
                trash.add(virus);
        }
        foods.removeAll(trash);
        trash.clear();
        for (BabyYoda bbyoda : bbyodas) {
            if (!bbyoda.isAlive())
                trash.add(bbyoda);
        }
        bbyodas.removeAll(trash);
        trash.clear();
        for (BabyGroot bbgroot : bbgroots) {
            if (!bbgroot.isAlive())
                trash.add(bbgroot);
        }
        bbgroots.removeAll(trash);
        trash.clear();        
    }
     
    private class ScheduleTask extends TimerTask {
        @Override
        public void run() {
            repaint();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slattcraft;

import java.awt.Color;

/**
 *
 * @author 802793
 */
public class BabyYoda extends Baby {
    
    private static final int SPEED = 3;
    private static final Color COLOR = new Color(0, 250, 154);

    public BabyYoda(int x, int y) {
        super(SPEED, x, y, COLOR);
    }  
    
    public void fight(BabyGroot bbgroot) {
        if (super.collide(bbgroot)) {
            if (super.getStrength() >= bbgroot.getStrength()) {
                this.didWin(bbgroot);
                bbgroot.die();
            } else {
                bbgroot.didWin(this);
                this.die();
            }
        }
    }
   public BabyYoda reproduce(BabyYoda mate) {
        int newX = super.getX() + (int) (Math.random() * 10 - 5);
        int newY = super.getY() + (int) (Math.random() * 10 - 5);
        BabyYoda baby = new BabyYoda(newX, newY);
        return baby;
    }
    
}

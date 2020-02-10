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
public class BabyGroot extends Baby {
    
    private static final int SPEED = 5;
    private static final Color COLOR = new Color(25, 127, 80);

    public BabyGroot(int x, int y) {
        super(SPEED, x, y, COLOR);
    }  

}

package fr.supocompote.jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardEvents implements KeyListener {

    private boolean pressed;
    private Bird bird;

    public KeyboardEvents(Bird bird){
        this.bird = bird;
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 32 && !pressed){
            pressed = true;
            bird.setVelocity(-1.1);
        }
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == 32){
            pressed = false;
        }
    }
}

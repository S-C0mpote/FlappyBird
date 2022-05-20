package fr.supocompote.jeu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Bird {

    private BufferedImage bird;
    private double y;
    private double velocity = 0;
    private final double MAX_VELOCITY = 5;
    public final int x = 20;

    public Bird(){
        try {
            bird = ImageIO.read(new File("assets/images/Oiseau.png"));
        } catch (Exception ignore) {}//on ignore l'erreur

        y = GameEngine.SIZE.height / 2.0 - bird.getHeight() / 2.0;
    }

    public void update(double delta){

        if(y >= GameEngine.SIZE.height - bird.getHeight())GameEngine.RUNNING = false;
        y += velocity;
        if(y < 0) y -= velocity;
        //gravity
        if(velocity < MAX_VELOCITY) velocity += delta * 4.5;
        if(velocity > MAX_VELOCITY) velocity = MAX_VELOCITY;

    }

    public void render(Graphics2D g){
        g.drawImage(bird,20, (int) y, null);
    }

    public double getY() {
        return y;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public double getVelocity() {
        return velocity;
    }

    public int getX() { return x; }
}

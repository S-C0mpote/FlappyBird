package fr.supocompote.jeu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

public class Background {

    private BufferedImage background;
    private double x = 0;

    public Background(){
        try {
            background = ImageIO.read(new File("assets/images/bandeFondEcran.png"));
        } catch (Exception ignore) {}//on ignore l'erreur
    }

    public void update(double delta){
        x -= 250 * delta;
        if(x <= -background.getWidth()) x += background.getWidth();
    }

    public void render(Graphics2D g){
        g.drawImage(background,(int) x, 0, null);
        g.drawImage(background,(int) x + background.getWidth(), 0, null);
        g.drawImage(background,(int) x + background.getWidth() * 2, 0, null);
    }
}

package fr.supocompote.jeu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class GameOver {

    private BufferedImage gameover;
    private double x = 0;

    public GameOver(){
        try {
            gameover = ImageIO.read(new File("assets/images/gameOver.png"));
        } catch (Exception ignore) {}//on ignore l'erreur
    }

    public boolean lost(){
        return GameEngine.RUNNING;
    }

    public void render(Graphics2D g){
        if(!lost()) g.drawImage(gameover,GameEngine.SIZE.width /8, GameEngine.SIZE.height /2, null);
    }
}

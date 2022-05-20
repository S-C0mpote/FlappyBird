package fr.supocompote.jeu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

public class Tuyaux {

    private static BufferedImage tuyauHigh;
    private static BufferedImage tuyauLow;

    static {
        try {
            tuyauHigh = ImageIO.read(new File(TypeTuyaux.HIGH.getPath()));
            tuyauLow = ImageIO.read(new File(TypeTuyaux.LOW.getPath()));
        } catch (Exception e) {}
    }

    private static double x = 150;
    private final int SEPARATION = 90;

    private  int yHigh = -100;
    private  int yLow = yHigh + 420;

    public void updateHaut(double delta){
        x -= 100 * delta;

        if(x <= -tuyauHigh.getWidth() - 60){
            Random r = new Random();
            setyHigh(-r.nextInt(160)-90);
            setyLow(yHigh + 420);
            GameEngine.score ++;
            x += GameEngine.SIZE.width + 90;
        }
    }

    public void updateBas(double delta){
        x -= 60 * delta;
        if(x <= -tuyauLow.getWidth() - 60){
            GameEngine.score ++;
            x += GameEngine.SIZE.width + 90;
        }
    }
    public void setyHigh(int yHigh) { this.yHigh = yHigh;}

    public void setyLow(int yLow){this.yLow = yLow;}
    public void renderHAUT(Graphics2D g){
        g.drawImage(tuyauHigh,(int)x + tuyauHigh.getWidth(), yHigh,null);
    }

    public void renderBAS(Graphics2D g){
        g.drawImage(tuyauLow,(int)x + tuyauLow.getWidth(), yLow ,null);
    }

    public int getLargeur(){return tuyauHigh.getWidth();}
    public int getLongueur(){return tuyauHigh.getHeight();}
    public int getX() { return (int)x; }
    public int getyHigh() { return yHigh; }
    public int getyLow() { return yLow; }
}

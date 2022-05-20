package fr.supocompote.jeu;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;


//Canvas permet de creer un rectangle pour dessiner
public class GameEngine extends Canvas {

    public static boolean RUNNING = true;

    public static final Dimension SIZE = new Dimension(250,400);

    //BufferedImage = data de l'image


    private final Background background = new Background();
    private final Bird bird = new Bird();
    private final Tuyaux tuyau = new Tuyaux();

    private GameOver gameOver = new GameOver();

    private Font police = new Font("Arial", Font.PLAIN, 40);
    private Font police2 = new Font("Arial", Font.PLAIN, 15);

    public static int score = 0;

    private int frames = 0;
    private int FFRAMES;

    private final JFrame window;
    private BufferStrategy buffer;



    public GameEngine(JFrame window){
        this.window = window;
        this.setMinimumSize(SIZE);
        this.setMaximumSize(SIZE);
        this.setSize(SIZE);

        this.setFocusable(true);
    }

    //méthode d'initialisation du moteur
    //Creation du buffer de 3 de profondeur
    //Boucle principale
    public synchronized void init(){
        this.createBufferStrategy(3);
        buffer = this.getBufferStrategy();

        this.addKeyListener(new KeyboardEvents(bird));

        long before = System.currentTimeMillis(), after, delta;
        long accumulator = 0;

        render();

        while(RUNNING){

            after = System.currentTimeMillis();
            delta = after - before;
            accumulator += delta;
            before = System.currentTimeMillis();


            while(accumulator >= 1000){
                System.out.println(frames + " FPS");
                FFRAMES = frames;
                accumulator -= 1000;
                frames = 0;
            }

            update((double) delta / 1000);
            if(collision())RUNNING = false;
            render();
            frames ++;

            try {
                Thread.sleep(1);
            } catch (Exception ignore) {}
        }
    }

    private synchronized void update(double delta){
        background.update(delta);
        tuyau.updateHaut(delta);
        tuyau.updateBas(delta);

        bird.update(delta);
    }

    private synchronized void render(){
        Graphics2D g = (Graphics2D) buffer.getDrawGraphics();
        g.setColor(new Color(0x000000));
        g.fillRect(0,0, SIZE.width, SIZE.height);
        Random r = new Random();

        background.render(g);
        tuyau.renderHAUT(g);
        tuyau.renderBAS(g);
        bird.render(g);
        gameOver.render(g);

        g.setFont(police);
        g.drawString("" + score,120 ,50);
        g.setFont(police2);
        g.drawString(FFRAMES + "FPS",10,50);
        //g.dispose() indique que tu arrêtes le dessin
        //buffer.show permet d'afficher les changement
        g.dispose();
        buffer.show();
    }
    private boolean collision(){

        int endWidth = tuyau.getX() + tuyau.getLargeur();

        if(tuyau.getX() + 20 <= bird.getX() && bird.getX() <=endWidth + 40) {

            if(tuyau.getyHigh() + tuyau.getLongueur() > bird.getY()){ return true; }
            if(tuyau.getyLow() - 20 < bird.getY()){ return true; }

        }
        return false;
    }


}

package fr.supocompote.jeu;

import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {
    public static GameEngine gameEngine;

    public Fenetre(){

        gameEngine = new GameEngine(this);
        this.setTitle("FlappyBirdZebi");

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(gameEngine);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);

        gameEngine.init();
    }
}

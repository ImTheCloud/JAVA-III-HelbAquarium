///////////////////////////////////
// The Import
//////////////////////////////////

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;
// import javax.swing.*;
// import java.awt.*;

public class Board extends JPanel implements ActionListener {

    ///////////////////////////////////
    // The variables
    //////////////////////////////////
    private final static int B_WIDTH = 600;
    private final static int B_HEIGHT = 350;
    private final int Delay = 10;
    private Timer timer = new Timer(Delay, this);

    private int numberInsectMax = 5;
    private int numberInsect = (int) (Math.random() * numberInsectMax + 1);
    private static int numberObstacleMax = 2;
    private static int numberObstacle = (int) (Math.random() * numberObstacleMax + 1);
    private int numberEdiblePelletMax = 5;
    private int ediblePelletCounter = (int) (Math.random() * numberEdiblePelletMax + 1);

    private int numberFishDifferentExisting = 4;
    private int fishColourAdd;
    private int numberInsectDifferentExisting = 3;
    private int insectColourAdd;

    // private Image orange;
    // private Image purple;
    // private Image red;
    // private Image blue;

    ///////////////////////////////////
    // les array list
    ///////////////////////////////////
    private static ArrayList<Obstacle> obstacleList = new ArrayList<Obstacle>();
    private static ArrayList<EdiblePellet> ediblePelletList = new ArrayList<EdiblePellet>();
    private static ArrayList<Fish> fishList = new ArrayList<Fish>();
    private static ArrayList<Insect> insectList = new ArrayList<Insect>();

    ///////////////////////////////////
    // The Get for other class
    ///////////////////////////////////

    public static ArrayList<Fish> get_listFish() {
        return fishList;
    }

    public static ArrayList<EdiblePellet> get_ediblePellet() {
        return ediblePelletList;
    }

    public static ArrayList<Obstacle> get_listObstacle() {
        return obstacleList;
    }

    public static int get_speed_fish() {
        return numberObstacle;
    }

    public static int getB_WIDTH() {
        return B_WIDTH;
    }

    public static int getB_HEIGHT() {
        return B_HEIGHT;
    }

    // //private void loadImages() {

    // ImageIcon iio = new ImageIcon("Image/fishOrange.png");
    // orange = iio.getImage();

    // ImageIcon iip = new ImageIcon("Image/fishPurple.png");
    // purple = iip.getImage();

    // ImageIcon iir = new ImageIcon("Image/fishRed.png");
    // red = iir.getImage();

    // ImageIcon iib = new ImageIcon("Image/fishBlue.png");
    // blue = iib.getImage();

    // }

    //////////////////////////////////
    // Lancement de l'application
    ///////////////////////////////////
    public Board() {
        initBoard();

    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setBackground(Color.gray);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        initGame();
    }

    private void initGame() {
        timer.start();

        addFish();
        addInsect();
        addObstacle();
        addEdiblePellet();

    }

    ///////////////////////////////////
    // Method to add the element in the aquarium
    ///////////////////////////////////

    private void addFish() {
        fishList.add(new FishRed());
        fishList.add(new FishBlue());
        fishList.add(new FishOrange());
        fishList.add(new FishPurple());

    }

    private void addInsect() {

        for (int i = 0; i < numberInsect; i++) {
            insectColourAdd = (int) (Math.random() * numberInsectDifferentExisting);
            if (insectColourAdd == 0) {
                insectList.add(new InsectBlack());
            } else if (insectColourAdd == 1) {
                insectList.add(new InsectRed());
            } else if (insectColourAdd == 2) {
                insectList.add(new InsectBrown());
            }
        }

    }

    private void addObstacle() {
        for (int i = 0; i < numberObstacle; i++) {
            obstacleList.add(new Obstacle());
        }
    }

    private void addEdiblePellet() {
        for (int i = 0; i < ediblePelletCounter; i++) {
            ediblePelletList.add(new EdiblePellet());
        }
    }

    ///////////////////////////////////
    // Method to draw the element every moment
    ///////////////////////////////////

    private void drawFish(Graphics g) {
        for (int i = 0; i < fishList.size(); i++) {
            g.drawImage(fishList.get(i).getPathToImage(), fishList.get(i).getPos_x(), fishList.get(i).getPos_y(), this);
        }
    }

    private void drawInsect(Graphics g) {
        for (int i = 0; i < insectList.size(); i++) {
            g.drawImage(insectList.get(i).getPathToImage(), insectList.get(i).getPos_x(), insectList.get(i).getPos_y(),
                    this);
        }
    }

    private void drawObstacle(Graphics g) {
        for (int i = 0; i < obstacleList.size(); i++) {
            g.drawImage(obstacleList.get(i).PathToImage(), obstacleList.get(i).getPos_x(),
                    obstacleList.get(i).getPos_y(), this);
        }
    }

    private void drawEdiblePellet(Graphics g) {
        for (int i = 0; i < ediblePelletList.size(); i++) {
            g.drawImage(ediblePelletList.get(i).PathToImage(), ediblePelletList.get(i).getPos_x(),
                    ediblePelletList.get(i).getPos_y(), this);
        }
    }

    private void doDrawing(Graphics g) {
        drawFish(g);
        drawInsect(g);
        drawEdiblePellet(g);
        drawObstacle(g);
    }

    ///////////////////////////////////
    // Method to update the element every moment
    ///////////////////////////////////
    private void doUpdate() {

        for (int i = 0; i < fishList.size(); i++) {
            fishList.get(i).update(); // get the current value get(i)
        }

        for (int i = 0; i < insectList.size(); i++) {
            insectList.get(i).update();
        }

        for (int i = 0; i < ediblePelletList.size(); i++) {
            ediblePelletList.get(i).update();
        }

    }

    ///////////////////////////////////
    // Method called every moment
    ///////////////////////////////////
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doUpdate();
        doDrawing(g);

    }

    ///////////////////////////////////
    // keyboard key
    ///////////////////////////////////

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (key == KeyEvent.VK_0) { // empty all the arayList and start the game again
                obstacleList.removeAll(obstacleList);
                fishList.removeAll(fishList);
                ediblePelletList.removeAll(ediblePelletList);
                insectList.removeAll(insectList);
                initGame();
                setBackground(Color.CYAN);

            }
            if (key == KeyEvent.VK_1) {
                setBackground(Color.white); // cold Background
            }
            if (key == KeyEvent.VK_2) {
                setBackground(Color.cyan); // warm Background
            }
            if (key == KeyEvent.VK_3) {
                setBackground(Color.blue); // hot Background
            }
            if (key == KeyEvent.VK_4) { // add insect random
                insectColourAdd = (int) (Math.random() * numberInsectDifferentExisting);
                if (insectColourAdd == 0) {
                    insectList.add(new InsectBlack());
                } else if (insectColourAdd == 1) {
                    insectList.add(new InsectRed());
                } else {
                    insectList.add(new InsectBrown());
                }
            }
            if (key == KeyEvent.VK_5) { // add edible pellet
                ediblePelletList.add(new EdiblePellet());
            }
            if (key == KeyEvent.VK_6) {

            }
            if (key == KeyEvent.VK_7) {

            }
            if (key == KeyEvent.VK_8) {

            }
            if (key == KeyEvent.VK_9) { // add fish random
                fishColourAdd = (int) (Math.random() * numberFishDifferentExisting);
                if (fishColourAdd == 0) {
                    fishList.add(new FishBlue());
                } else if (fishColourAdd == 1) {
                    fishList.add(new FishRed());
                } else if (fishColourAdd == 3) {
                    fishList.add(new FishPurple());
                } else {
                    fishList.add(new FishOrange());
                }
            }
            if (key == KeyEvent.VK_R) {

            }
            if (key == KeyEvent.VK_B) {

            }
            if (key == KeyEvent.VK_M) {

            }
            if (key == KeyEvent.VK_O) {

            }
        }
    }
}

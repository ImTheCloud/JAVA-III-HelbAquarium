
///////////////////////////////////
// The Imports
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
import javax.swing.*;
import java.awt.*;

public class Board extends JPanel implements ActionListener {

    ///////////////////////////////////
    // The variables Image
    //////////////////////////////////
    private Image orangeImage;
    private Image purpleImage;
    private Image redImage;
    private Image blueImage;
    private Image insectBlackImage;
    private Image obstacleImage;
    private Image ediblePelletImage;
    private Image blackImage;

    ///////////////////////////////////
    // The variables
    //////////////////////////////////
    private final static int B_WIDTH = 1000; // Size screen Width
    private final static int B_HEIGHT = 500; // Size screen Height
    private final int Delay = 60; // every 60 milisecond, it's the timmer
    private final Color backGroundCold = new Color(102, 178, 255);
    private final Color backGroundDefault = new Color(0, 128, 255);
    private final Color backGroundHot = new Color(51, 51, 255);
    private Timer timer = new Timer(Delay, this);
    private int keyEvent;
    private int numberFishDifferentExisting = 4;
    private int numberInsectmaxInTheGame = 5;
    private int numberEdiblePelletMaxInTheGame = 3;
    private static int numberObstacleMaxInTheGame = 2;
    private int fishColourAddForKeyEvent = 0;
    private static String colourFishKeyEvent = "Default";
    // +1 bcs at least 1 (for all +1 in a random)
    private int numberInsect = (int) (Math.random() * numberInsectmaxInTheGame + 1);
    private static int numberObstacle = (int) (Math.random() * numberObstacleMaxInTheGame + 1);
    private int numberEdiblePellet = (int) (Math.random() * numberEdiblePelletMaxInTheGame + 1);
    private double calculDistance;
    private double closestDistance = Board.getB_WIDTH();
    // by default its the width but when the calcul start the closest
    // distance become the closest distance of the fish
    private int x;// calcul for the closest distance
    private int y;

    ///////////////////////////////////
    // The Array lists
    ///////////////////////////////////
    private static ArrayList<Obstacle> obstacleList = new ArrayList<Obstacle>();
    private static ArrayList<EdiblePellet> ediblePelletList = new ArrayList<EdiblePellet>();
    private static ArrayList<Fish> fishList = new ArrayList<Fish>();
    private static ArrayList<Insect> insectList = new ArrayList<Insect>();

    ///////////////////////////////////
    // Get Array List
    ///////////////////////////////////

    public static ArrayList<Fish> get_listFish() {
        return fishList;
    }

    public static ArrayList<EdiblePellet> get_ediblePellet_list() {
        return ediblePelletList;
    }

    public static ArrayList<Obstacle> get_listObstacle() {
        return obstacleList;
    }

    public static ArrayList<Insect> get_insectList() {
        return insectList;
    }

    ///////////////////////////////////
    // Other Get
    ///////////////////////////////////

    public static String get_colourFishKeyPressed() {
        return colourFishKeyEvent;
    }

    public static int get_numberObstacle() {
        return numberObstacle;
    }

    public static int getB_WIDTH() {
        return B_WIDTH;
    }

    public static int getB_HEIGHT() {
        return B_HEIGHT;
    }

    ///////////////////////////////////
    // Image
    ///////////////////////////////////

    private void loadImages() {

        ImageIcon iibl = new ImageIcon("Image/fishBlack.png");
        blackImage = iibl.getImage();

        ImageIcon iio = new ImageIcon("Image/fishOrange.png");
        orangeImage = iio.getImage();

        ImageIcon iip = new ImageIcon("Image/fishPurple.png");
        purpleImage = iip.getImage();

        ImageIcon iir = new ImageIcon("Image/fishRed.png");
        redImage = iir.getImage();

        ImageIcon iib = new ImageIcon("Image/fishBlue.png");
        blueImage = iib.getImage();

        ImageIcon iiiB = new ImageIcon("Image/insectBlack.png");
        insectBlackImage = iiiB.getImage();

        ImageIcon iiob = new ImageIcon("Image/obstacle.png");
        obstacleImage = iiob.getImage();

        ImageIcon iipl = new ImageIcon("Image/ediblePellet.png");
        ediblePelletImage = iipl.getImage();

    }

    //////////////////////////////////
    // Start the application
    ///////////////////////////////////
    public Board() {
        initBoard();

    }

    private void initBoard() {
        addKeyListener(new TAdapter());
        setBackground(backGroundDefault);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImages();
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
    // Method to add the element in the aquarium by default
    ///////////////////////////////////

    private void addFish() {
        fishList.add(new FishRed());

        fishList.add(new FishOrange());
        fishList.add(new FishOrange());
        fishList.add(new FishOrange());
        fishList.add(new FishOrange());

        fishList.add(new FishBlue());
        fishList.add(new FishBlue());
        fishList.add(new FishPurple());
        fishList.add(new FishPurple());

    }

    private void addInsect() {
        for (int i = 0; i < numberInsect; i++) {
            insectList.add(new Insect());
        }

    }

    private void addObstacle() {
        for (int i = 0; i < numberObstacle; i++) {
            obstacleList.add(new Obstacle());
        }
    }

    private void addEdiblePellet() {
        for (int i = 0; i < numberEdiblePellet; i++) {
            ediblePelletList.add(new EdiblePellet());
        }
    }

    ///////////////////////////////////
    // Method for the couple if 2 fish touch each other, 3 others appear
    ///////////////////////////////////
    public static void addNewFish(String newFish) {

        if (newFish == "FishOrange") {
            fishList.add(new FishOrange());
            fishList.add(new FishOrange());
            fishList.add(new FishOrange());
        } else if (newFish == "FishPurple") {
            fishList.add(new FishPurple());
            fishList.add(new FishPurple());
            fishList.add(new FishPurple());
        } else if (newFish == "FishRed") {
            fishList.add(new FishRed());
            fishList.add(new FishRed());
            fishList.add(new FishRed());
        } else {
            fishList.add(new FishBlue());
            fishList.add(new FishBlue());
            fishList.add(new FishBlue());
        }

    }

    ///////////////////////////////////
    // Draw the element every moment if a fish is oange he take the orange image,...
    // same for insect, obstacle and Pelelt but whitout condition
    // because its only 1 image
    ///////////////////////////////////

    private void drawFish(Graphics g) {
        for (int i = 0; i < fishList.size(); i++) {
            if (fishList.get(i) instanceof FishOrange) {
                g.drawImage(orangeImage, fishList.get(i).getPos_x_fish(), fishList.get(i).getPos_y_fish(), this);
            } else if (fishList.get(i) instanceof FishPurple) {
                g.drawImage(purpleImage, fishList.get(i).getPos_x_fish(), fishList.get(i).getPos_y_fish(), this);
            } else if (fishList.get(i) instanceof FishBlue) {
                g.drawImage(blueImage, fishList.get(i).getPos_x_fish(), fishList.get(i).getPos_y_fish(), this);
            } else if (fishList.get(i) instanceof FishRed) {
                g.drawImage(redImage, fishList.get(i).getPos_x_fish(), fishList.get(i).getPos_y_fish(), this);
            } else if (fishList.get(i) instanceof FishBlack) {
                g.drawImage(blackImage, fishList.get(i).getPos_x_fish(), fishList.get(i).getPos_y_fish(), this);
            }
        }

    }

    private void drawInsect(Graphics g) {
        for (int i = 0; i < insectList.size(); i++) {
            g.drawImage(insectBlackImage, insectList.get(i).getPos_x_insect(), insectList.get(i).getPos_y_insect(),
                    this);
        }
    }

    private void drawObstacle(Graphics g) {
        for (int i = 0; i < obstacleList.size(); i++) {
            g.drawImage(obstacleImage, obstacleList.get(i).getPos_x_obstacle(),
                    obstacleList.get(i).getPos_y_obstacle(), this);
        }
    }

    private void drawEdiblePellet(Graphics g) {
        for (int i = 0; i < ediblePelletList.size(); i++) {
            g.drawImage(ediblePelletImage, ediblePelletList.get(i).getPos_x_pellet(),
                    ediblePelletList.get(i).getPos_y_pellet(), this);
        }
    }

    private void doDrawing(Graphics g) {
        drawFish(g);
        drawInsect(g);
        drawEdiblePellet(g);
        drawObstacle(g);
    }

    ///////////////////////////////////
    // Method to update the element every moment from each class
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

        for (int i = 0; i < obstacleList.size(); i++) {
            obstacleList.get(i).update();
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

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();

    }

    ///////////////////////////////////
    // Method for keyboard key
    ///////////////////////////////////
    // empty all the arayList and start the game again
    public void resetAquarium() {
        obstacleList.removeAll(obstacleList);
        fishList.removeAll(fishList);
        ediblePelletList.removeAll(ediblePelletList);
        insectList.removeAll(insectList);
        EdiblePellet.set_counterToStopMoveFish(0);
        FishRed.setSpeedUpgrade(5);

        setBackground(backGroundDefault);
        initGame();

    }

    // add fish random colour but not the black
    public void addFishKeyboardKey() {
        fishColourAddForKeyEvent = (int) (Math.random() * numberFishDifferentExisting);
        if (fishColourAddForKeyEvent == 0) {
            fishList.add(new FishBlue());
        } else if (fishColourAddForKeyEvent == 1) {
            fishList.add(new FishRed());
        } else if (fishColourAddForKeyEvent == 2) {
            fishList.add(new FishPurple());
        } else {
            fishList.add(new FishOrange());
        }
    }

    // every fish go to the closest insect
    public void goToTheClosestInsect() {
        if (EdiblePellet.get_counterToStopMoveFish() != 0) {
            for (int j = 0; j < get_listFish().size(); j++) {
                for (int i = 0; i < get_insectList().size(); i++) {
                    x = get_insectList().get(i).getPos_x_insect() - get_listFish().get(i).getPos_x_fish();
                    y = get_insectList().get(i).getPos_y_insect() - get_listFish().get(i).getPos_y_fish();
                    calculDistance = Math.sqrt(x * x + y * y);

                    if (closestDistance > calculDistance) {
                        closestDistance = calculDistance;

                        // Fish.setPos_x_target(get_insectList().get(i).getPos_x_pellet());
                        // Fish.setPos_y_target(get_insectList().get(i).getPos_y_pellet());

                    }
                }
            }
            closestDistance = Board.getB_WIDTH();
        }
    }
    // every fish go to the closest pellet

    public void goToTheClosestPellet() {
        if (EdiblePellet.get_counterToStopMoveFish() != 0) {

            for (int j = 0; j < get_listFish().size(); j++) {
                for (int i = 0; i < get_ediblePellet_list().size(); i++) {
                    x = get_ediblePellet_list().get(i).getPos_x_pellet() - get_listFish().get(i).getPos_x_fish();
                    y = get_ediblePellet_list().get(i).getPos_y_pellet() - get_listFish().get(i).getPos_y_fish();
                    calculDistance = Math.sqrt(x * x + y * y);

                    if (closestDistance > calculDistance) {
                        closestDistance = calculDistance;

                        // Fish.setPos_x_target(get_ediblePellet_list().get(i).getPos_x_pellet());
                        // Fish.setPos_y_target(get_ediblePellet_list().get(i).getPos_y_pellet());

                    }
                }
            }
            closestDistance = Board.getB_WIDTH();
        }
    }

    // every fish go to the closest fish ( same colour)
    public void goToTheClosestFishSameColour() {
        if (EdiblePellet.get_counterToStopMoveFish() != 0) {
            for (int j = 0; j < get_listFish().size(); j++) {
                for (int i = 0; i < get_listFish().size(); i++) {
                    x = get_listFish().get(i).getPos_x_fish() - get_listFish().get(i).getPos_x_fish();
                    y = get_listFish().get(i).getPos_y_fish() - get_listFish().get(i).getPos_y_fish();
                    calculDistance = Math.sqrt(x * x + y * y);

                    if (closestDistance > calculDistance) {
                        closestDistance = calculDistance;

                        // Fish.setPos_x_target(get_listFish().get(i).getPos_x_fish());
                        // Fish.setPos_y_target(get_listFish().get(i).getPos_y_fish());

                    }
                }
            }
            closestDistance = Board.getB_WIDTH();
        }
    }

    ///////////////////////////////////
    // keyboard key
    ///////////////////////////////////

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            keyEvent = e.getKeyCode();

            if (keyEvent == KeyEvent.VK_0) {
                resetAquarium();
            }
            if (keyEvent == KeyEvent.VK_1) {
                setBackground(backGroundCold); // cold Background
                FishRed.setSpeedUpgrade(3);
            }
            if (keyEvent == KeyEvent.VK_2) {
                setBackground(backGroundDefault); // warm Background
                FishRed.setSpeedUpgrade(6);
            }
            if (keyEvent == KeyEvent.VK_3) {
                setBackground(backGroundHot); // hot Background
                FishRed.setSpeedUpgrade(10);
            }
            if (keyEvent == KeyEvent.VK_4) { // add insect
                insectList.add(new Insect());
            }
            if (keyEvent == KeyEvent.VK_5) { // add edible pellet
                ediblePelletList.add(new EdiblePellet());
            }
            if (keyEvent == KeyEvent.VK_6) {
                goToTheClosestInsect();
            }
            if (keyEvent == KeyEvent.VK_7) {
                goToTheClosestPellet();
            }
            if (keyEvent == KeyEvent.VK_8) {
                goToTheClosestFishSameColour();
            }
            if (keyEvent == KeyEvent.VK_9) { // add fish random
                addFishKeyboardKey();
            }
            if (keyEvent == KeyEvent.VK_R) { // stop move fish all but not red
                colourFishKeyEvent = "FishRed";
                EdiblePellet.set_counterToStopMoveFish(Integer.MAX_VALUE);
            }
            if (keyEvent == KeyEvent.VK_B) {// stop move fish all but not blue
                colourFishKeyEvent = "FishBlue";
                EdiblePellet.set_counterToStopMoveFish(Integer.MAX_VALUE);
            }
            if (keyEvent == KeyEvent.VK_M) {// stop move fish all but not purple
                EdiblePellet.set_counterToStopMoveFish(Integer.MAX_VALUE);
                colourFishKeyEvent = "FishPurple";
            }
            if (keyEvent == KeyEvent.VK_O) {// stop move fish all but not orange
                EdiblePellet.set_counterToStopMoveFish(Integer.MAX_VALUE);
                colourFishKeyEvent = "FishOrange";
            }
            if (keyEvent == KeyEvent.VK_A) {// add Fish Black and 2 fish red
                fishList.add(new FishBlack());
                fishList.add(new FishRed());

            }
        }
    }
}

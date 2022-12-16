
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

    ///////////////////////////////////
    // The variables 
    //////////////////////////////////
    private final static int B_WIDTH = 1000; // Size screen Width
    private final static int B_HEIGHT = 500; // Size screen Height
    private final int Delay = 50; // every 50 milisecond, it's the timmer
    private Timer timer = new Timer(Delay, this);

    private int numberFishDifferentExisting = 4;
    private int numberInsectmaxInTheGame = 5;
    private int numberEdiblePelletMaxInTheGame = 8;
    private static int numberObstacleMaxInTheGame = 2;
    private int fishColourAddForKeyEvent = 0;
    private static String colourFishKeyEvent = "Default";
    // +1 bcs at least 1 (for all +1 in a random)
    private int numberInsect = (int) (Math.random() * numberInsectmaxInTheGame + 1);
    private static int numberObstacle = (int) (Math.random() * numberObstacleMaxInTheGame + 1);
    private int ediblePelletCounter = (int) (Math.random() * numberEdiblePelletMaxInTheGame + 1);

    ///////////////////////////////////
    // The Array lists
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

    public static String get_colourFishKeyPressed() {
        return colourFishKeyEvent;
    }

    public static ArrayList<EdiblePellet> get_ediblePellet() {
        return ediblePelletList;
    }

    public static ArrayList<Obstacle> get_listObstacle() {
        return obstacleList;
    }

    public static ArrayList<Insect> get_insectList() {
        return insectList;
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

    ///////////////////////////////////
    // The Set for other class
    ///////////////////////////////////

    ///////////////////////////////////
    // Load Image
    ///////////////////////////////////

    private void loadImages() {

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
    // Method to add the element in the aquarium
    ///////////////////////////////////

    private void addFish() {
        fishList.add(new FishRed());

        fishList.add(new FishPurple());
        fishList.add(new FishPurple());
        fishList.add(new FishBlue());
        fishList.add(new FishBlue());

        fishList.add(new FishOrange());
        fishList.add(new FishOrange());
        fishList.add(new FishOrange());

    }

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

    private void addInsect() {
        for (int i = 0; i < numberInsect; i++) {
            insectList.add(new InsectBlack());
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
            if (fishList.get(i) instanceof FishOrange) {
                g.drawImage(orangeImage, fishList.get(i).getPos_x(), fishList.get(i).getPos_y(), this);
            } else if (fishList.get(i) instanceof FishPurple) {
                g.drawImage(purpleImage, fishList.get(i).getPos_x(), fishList.get(i).getPos_y(), this);
            } else if (fishList.get(i) instanceof FishBlue) {
                g.drawImage(blueImage, fishList.get(i).getPos_x(), fishList.get(i).getPos_y(), this);
            } else if (fishList.get(i) instanceof FishRed) {
                g.drawImage(redImage, fishList.get(i).getPos_x(), fishList.get(i).getPos_y(), this);
            }

        }

    }

    private void drawInsect(Graphics g) {
        for (int i = 0; i < insectList.size(); i++) {
            g.drawImage(insectBlackImage, insectList.get(i).getPos_x(), insectList.get(i).getPos_y(), this);
        }
    }

    private void drawObstacle(Graphics g) {
        for (int i = 0; i < obstacleList.size(); i++) {
            g.drawImage(obstacleImage, obstacleList.get(i).getPos_x(),
                    obstacleList.get(i).getPos_y(), this);
        }
    }

    private void drawEdiblePellet(Graphics g) {
        for (int i = 0; i < ediblePelletList.size(); i++) {
            g.drawImage(ediblePelletImage, ediblePelletList.get(i).getPos_x(),
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

    ///////////////////////////////////
    // Method for keyboard key
    ///////////////////////////////////

    public void resetAquarium() {
        obstacleList.removeAll(obstacleList);
        fishList.removeAll(fishList);
        ediblePelletList.removeAll(ediblePelletList);
        insectList.removeAll(insectList);
        setBackground(Color.CYAN);

        initGame();

    }

    public void addInsectKeyboardKey() {
        insectList.add(new InsectBlack());
    }

    public void addFishKeyboardKey() {
        fishColourAddForKeyEvent = (int) (Math.random() * numberFishDifferentExisting);
        if (fishColourAddForKeyEvent == 0) {
            fishList.add(new FishBlue());
        } else if (fishColourAddForKeyEvent == 1) {
            fishList.add(new FishRed());
        } else if (fishColourAddForKeyEvent == 3) {
            fishList.add(new FishPurple());
        } else {
            fishList.add(new FishOrange());
        }
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
                resetAquarium();
            }
            if (key == KeyEvent.VK_1) {
                setBackground(Color.lightGray); // cold Background
                FishRed.setSpeedUpgrade(4);
            }
            if (key == KeyEvent.VK_2) {
                setBackground(Color.gray); // warm Background
                FishRed.setSpeedUpgrade(5);
            }
            if (key == KeyEvent.VK_3) {
                setBackground(Color.darkGray); // hot Background
                FishRed.setSpeedUpgrade(6);
            }
            if (key == KeyEvent.VK_4) { // add insect random
                addInsectKeyboardKey();

            }
            if (key == KeyEvent.VK_5) { // add edible pellet
                ediblePelletList.add(new EdiblePellet());
            }
            if (key == KeyEvent.VK_6) {

                if (EdiblePellet.get_counterToStopMoveFish() == 0) {
                    for (int i = 0; i < get_insectList().size(); i++) {

                    }
                }

            }
            if (key == KeyEvent.VK_7) {

            }
            if (key == KeyEvent.VK_8) {

            }
            if (key == KeyEvent.VK_9) { // add fish random
                addFishKeyboardKey();
            }
            if (key == KeyEvent.VK_R) {
                colourFishKeyEvent = "red";
                EdiblePellet.set_counterToStopMoveFish(1000000);
            }
            if (key == KeyEvent.VK_B) {
                colourFishKeyEvent = "blue";
                EdiblePellet.set_counterToStopMoveFish(1000000);
            }
            if (key == KeyEvent.VK_M) {
                EdiblePellet.set_counterToStopMoveFish(1000000);
                colourFishKeyEvent = "purple";
            }
            if (key == KeyEvent.VK_O) {
                EdiblePellet.set_counterToStopMoveFish(1000000);
                colourFishKeyEvent = "orange";
            }
        }
    }
}

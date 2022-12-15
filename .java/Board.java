
///////////////////////////////////
// The Import
//////////////////////////////////aa
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
// delimitation ex : 10000 fish

public class Board extends JPanel implements ActionListener {

    ///////////////////////////////////
    // The variables
    //////////////////////////////////
    private final static int B_WIDTH = 1000;
    private final static int B_HEIGHT = 500;
    private final int Delay = 30;
    private Timer timer = new Timer(Delay, this);

    private int numberInsectMax = 5;
    private int numberInsect = (int) (Math.random() * numberInsectMax + 1);
    private static int numberObstacleMax = 2;
    private static int numberObstacle = (int) (Math.random() * numberObstacleMax + 1);
    private int numberEdiblePelletMax = 20;
    private int ediblePelletCounter = (int) (Math.random() * numberEdiblePelletMax + 1);

    private int numberFishDifferentExisting = 4;
    private int fishColourAdd;
    private int numberInsectDifferentExisting = 3;
    private int insectColourAdd = (int) (Math.random() * numberInsectDifferentExisting);

    private Image orangeImage;
    private Image purpleImage;
    private Image redImage;
    private Image blueImage;
    private Image insectBlackImage;
    private Image insectRedImage;
    private Image insectBrownImage;
    private Image obstacleImage;
    private Image ediblePelletImage;

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

        ImageIcon iiiR = new ImageIcon("Image/insectRed.png");
        insectRedImage = iiiR.getImage();

        ImageIcon iiiBr = new ImageIcon("Image/insectBrown.png");
        insectBrownImage = iiiBr.getImage();

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
            if (insectList.get(i) instanceof InsectBlack) {
                g.drawImage(insectBlackImage, insectList.get(i).getPos_x(), insectList.get(i).getPos_y(), this);
            } else if (insectList.get(i) instanceof InsectRed) {
                g.drawImage(insectRedImage, insectList.get(i).getPos_x(), insectList.get(i).getPos_y(), this);
            } else if (insectList.get(i) instanceof InsectBrown) {
                g.drawImage(insectBrownImage, insectList.get(i).getPos_x(), insectList.get(i).getPos_y(), this);
            }
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
        if (insectColourAdd == 0) {
            insectList.add(new InsectBlack());
        } else if (insectColourAdd == 1) {
            insectList.add(new InsectRed());
        } else {
            insectList.add(new InsectBrown());
        }
    }

    public void addFishKeyboardKey() {
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
                setBackground(Color.white); // cold Background
                FishRed.setSpeedUpgrade(2);
            }
            if (key == KeyEvent.VK_2) {
                setBackground(Color.GRAY); // warm Background
                FishRed.setSpeedUpgrade(3);
            }
            if (key == KeyEvent.VK_3) {
                setBackground(Color.blue); // hot Background
                FishRed.setSpeedUpgrade(4);
            }
            if (key == KeyEvent.VK_4) { // add insect random
                addInsectKeyboardKey();

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
                addFishKeyboardKey();
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

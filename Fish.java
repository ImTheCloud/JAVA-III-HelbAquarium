import java.util.ArrayList;

public class Fish {
    ///////////////////////////////////
    // The variables
    //////////////////////////////////
    protected final int endOfTheCounter = 0;
    private final int counterDecrement = 1;
    private final static int sizeFish = 20; // 20 beacause its the zise of the fish
    private final static int hitBoxFish = 12; // 12 bcs if the speed upgrade to 11, the hitbox need to be bigger
    final int speedUpgrade = 10; // 10 if a fish touch a insect
    protected final static int screen_W = Board.getB_WIDTH() - sizeFish;
    // protected, this variable can be used in other class extends the fish
    // - sizeFish, if not its possible to see the fish halfway
    // if is appear at the limit of the screen
    protected final static int screen_H = Board.getB_HEIGHT() - sizeFish;
    private int pos_x_Fish; // position of the fish will be random
    private int pos_y_Fish;
    private int pos_x_target; // target of every fish
    private int pos_y_target;
    private static int speedFish; // important to put the good speed for every fish

    private double calculDistance = 0;
    private double closestDistance = Board.getB_WIDTH();
    // by default its the width but when the calcul start the closest
    // distance become the closest distance of the fish
    private int x;// calcul for the closest distance
    private int y;
    private int idFish = idCount; // id fish for to know who fish need to be kill
    private static int idCount;
    private int idTargetDeathFish;
    private int chanceToCouplingFish;
    private int coupleFishOk;

    ArrayList<Fish> get_listFish = Board.get_listFish();

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    public Fish() {
        positionFish(); // put a random position for every fish
        idCount++; // for the id Fish

    }

    ///////////////////////////////////
    // get and set
    //////////////////////////////////

    // id death fish
    public int getIdTargetDeathFish() {
        return idTargetDeathFish;
    }

    public void setIdTargetDeathFish(int idTargetDeathFish) {
        this.idTargetDeathFish = idTargetDeathFish;
    }

    // id fish
    public int getIdFish() {
        return idFish;
    }

    // Hitbox
    public static int getHitBoxFish() {
        return hitBoxFish;
    }

    // speed upgrade
    public int getSpeedUpgrade() {
        return speedUpgrade;
    }

    // calcul closest distance
    public double getCalculDistance() {
        return calculDistance;
    }

    public void setCalculDistance(double calculDistance) {
        this.calculDistance = calculDistance;
    }

    public double getClosestDistance() {
        return closestDistance;
    }

    public void setClosestDistance(double closestDistance) {
        this.closestDistance = closestDistance;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // screen
    public int get_screen_W() {
        return screen_W;
    }

    public int get_screen_H() {
        return screen_H;
    }

    // speed
    public int getSpeedFish() {
        return speedFish;
    }

    public void setSpeedFish(int speedFish) {
        Fish.speedFish = speedFish;
    }

    // Fish
    public int getPos_y_fish() {
        return pos_y_Fish;
    }

    public int getPos_x_fish() {
        return pos_x_Fish;
    }

    public void setPos_x_Fish(int pos_x) {
        this.pos_x_Fish = pos_x;
    }

    public void setPos_y_Fish(int pos_y) {
        this.pos_y_Fish = pos_y;
    }
    // target Fish

    public int getPos_y_target() {
        return pos_y_target;
    }

    public int getPos_x_target() {
        return pos_x_target;
    }

    public void setPos_x_target(int pos_x_target) {
        this.pos_x_target = pos_x_target;
    }

    public void setPos_y_target(int pos_y_target) {
        this.pos_y_target = pos_y_target;
    }

    // counter
    public int getEndOfTheCounter() {
        return endOfTheCounter;
    }

    public int getCounterDecrement() {
        return counterDecrement;
    }

    ///////////////////////////////////
    // Method update called in Board for do something every x milisecond (timer)
    //////////////////////////////////

    public void update() {

        if (Board.isInsectivorMod()) {
            goToTheClosestInsect();
        } else if (Board.isPelletMod()) {
            goToTheClosestPellet();
        } else if (Board.isCoupleMod()) {
            goToTheClosestFishSameColor();
        }

        if (Board.get_colourFishKeyPressed() != "Default") {

            if (this.getClass().getName() == Board.get_colourFishKeyPressed()) {
                this.movefishToTarget();
            }

        } else {
            if (Insect.getIdFishTouchInsect() != Insect.getIdfishtouchelementbydefault()) {

                if (this.idFish == Insect.getIdFishTouchInsect()) {
                    speedFish = speedUpgrade;

                }
            }

            if (EdiblePellet.getIdFishTouchPellet() != EdiblePellet.getIdfishtouchelementbydefault()) {
                if (this.idFish == EdiblePellet.getIdFishTouchPellet()) {
                    movefishToTarget();
                }
            } else {
                movefishToTarget();
            }

        }

        couplingFish();
    }

    ///////////////////////////////////
    // Movement for the fish, same just a different target dependant
    // of the behavior of the fish
    // if the pos x its smaler than the pos x target the pos x
    // will just decrement (speed), etc..
    //////////////////////////////////

    public void movefishToTarget() {
        // first I verify if a fish touch a obstacle
        // if yes, the fish will go on the right if hes under the obstacle, etc..
        // if not he will just move normal
        int pos_xIncrement = getPos_x_fish() + speedFish;
        int pos_yIncrement = getPos_y_fish() - speedFish;
        int pos_yDecrement = getPos_y_fish() + speedFish;
        int pos_xDecrement = getPos_x_fish() - speedFish;

        if (Obstacle.getIdFishTouchInsect() == this.idFish) {
            if (getPos_y_fish() < getPos_y_target()) {
                setPos_x_Fish(pos_xIncrement);
            }
            if (getPos_x_fish() < getPos_x_target()) {
                setPos_y_Fish(pos_yIncrement);
            }
            if (getPos_x_fish() > getPos_x_target()) {
                setPos_y_Fish(pos_yIncrement);
            }
            if (getPos_y_fish() > getPos_y_target()) {
                setPos_x_Fish(pos_xIncrement);
            }
        } else {
            if (getPos_y_fish() < getPos_y_target()) {

                setPos_y_Fish(pos_yDecrement);
            }
            if (getPos_x_fish() < getPos_x_target()) {
                setPos_x_Fish(pos_xIncrement);
            }
            if (getPos_x_fish() > getPos_x_target()) {

                setPos_x_Fish(pos_xDecrement);
            }
            if (getPos_y_fish() > getPos_y_target()) {
                setPos_y_Fish(pos_yIncrement);
            }
        }

    }

    ///////////////////////////////////
    // Method for put a fish in a random position ah the beginning
    //////////////////////////////////
    public void positionFish() {
        pos_x_Fish = (int) (Math.random() * screen_W);
        pos_y_Fish = (int) (Math.random() * screen_H);
    }

    ///////////////////////////////////
    // Method for the couple of the fish
    //////////////////////////////////

    public void couplingFish() {

        int sizeListFish = get_listFish.size();
        for (int j = 0; j < sizeListFish; j++) {

            Fish fish = get_listFish.get(j);
            String nameFishCurrent = fish.getClass().getName();
            int pos_x_fish = fish.getPos_x_fish();
            int pos_y_fish = fish.getPos_y_fish();

            if (pos_x_fish != this.getPos_x_fish()
                    && pos_y_fish != this.getPos_y_fish()) {
                // if its not the same fish

                if (pos_x_fish <= this.getPos_x_fish() + hitBoxFish
                        && pos_x_fish >= this.getPos_x_fish() - hitBoxFish
                        && pos_y_fish <= this.getPos_y_fish() + hitBoxFish
                        && pos_y_fish >= this.getPos_y_fish() - hitBoxFish) {

                    // if they have the same colour
                    if (nameFishCurrent == this.getClass().getName()) {

                        chanceToCouplingFish = get_listFish.size(); // get the number of the fish in a variable
                        coupleFishOk = (int) (Math.random() * chanceToCouplingFish); // make a random from the vairable

                        if (coupleFishOk == 0) {
                            // if the random is 0, they can be a couple
                            Board.deleteFish(fish.idFish);
                            Board.deleteFish(this.idFish);
                            Board.addNewFish(this.getClass().getName());
                        }

                    }

                }

            }

        }
    }

    ///////////////////////////////////
    // go to the closest fish who has the same color, calcul the distance
    // and they go to the closest
    //////////////////////////////////

    public void goToTheClosestFishSameColor() {

        int sizeListFish = get_listFish.size();
        for (int j = 0; j < sizeListFish; j++) {

            Fish fish = get_listFish.get(j);
            String nameFishCurrent = fish.getClass().getName();
            int pos_x_fish = fish.getPos_x_fish();
            int pos_y_fish = fish.getPos_y_fish();

            if (pos_x_fish != this.getPos_x_fish()
                    && pos_y_fish != this.getPos_y_fish()) {

                if (nameFishCurrent == this.getClass().getName()) {
                    x = pos_x_fish - this.getPos_x_fish();
                    y = pos_y_fish - this.getPos_y_fish();
                    calculDistance = Math.sqrt(x * x + y * y);

                    if (closestDistance > calculDistance) {
                        closestDistance = calculDistance;

                        setPos_x_target(pos_x_fish);
                        setPos_y_target(pos_y_fish);

                    }
                }
            }

        }
        closestDistance = Board.getB_WIDTH();

    }

    ///////////////////////////////////
    // same for insectivor, just for the insect, every fish go to the closest insect
    //////////////////////////////////

    public void goToTheClosestInsect() {

        ArrayList<Insect> get_insectList = Board.get_insectList();
        for (int i = 0; i < get_insectList.size(); i++) {

            Insect insect = get_insectList.get(i);

            int pos_x_insect = insect.getPos_x_element();
            int pos_y_insect = insect.getPos_y_element();

            x = pos_x_insect - this.getPos_x_fish();
            y = pos_y_insect - this.getPos_y_fish();
            calculDistance = Math.sqrt(x * x + y * y);

            if (closestDistance > calculDistance) {
                closestDistance = calculDistance;

                setPos_x_target(pos_x_insect);
                setPos_y_target(pos_y_insect);

            }
        }
        closestDistance = Board.getB_WIDTH();

    }

    ///////////////////////////////////
    // same for pellet, like insectivorMod
    //////////////////////////////////

    public void goToTheClosestPellet() {

        ArrayList<EdiblePellet> gEdiblePellets = Board.get_ediblePellet_list();
        for (int i = 0; i < gEdiblePellets.size(); i++) {

            EdiblePellet pellet = gEdiblePellets.get(i);

            int pos_x_pellet = pellet.getPos_x_element();
            int pos_y_pellet = pellet.getPos_y_element();

            x = pos_x_pellet - this.getPos_x_fish();
            y = pos_y_pellet - this.getPos_y_fish();
            calculDistance = Math.sqrt(x * x + y * y);

            if (closestDistance > calculDistance) {
                closestDistance = calculDistance;

                setPos_x_target(pos_x_pellet);
                setPos_y_target(pos_y_pellet);

            }
        }
        closestDistance = Board.getB_WIDTH();

    }

}

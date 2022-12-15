public class Insect {
    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private int pos_x;
    private int pos_y;
    private int hitBoxInsect = 15;
    protected int screen_W = Board.getB_WIDTH();
    protected int screen_H = Board.getB_HEIGHT();

    private int randomInsectColour = (int) (Math.random() * 3);
    private String insectColourName;
    private static int timmerSpeedInsect = 0;

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    public Insect() {

        positionRandomInsect();

        randomInsectColour = (int) (Math.random() * 3);
        if (randomInsectColour == 0) {
            insectColourName = "timmerLow";
        } else if (randomInsectColour == 1) {
            insectColourName = "timmerNormal";
        } else {
            insectColourName = "timmerHigh";
        }
    }

    ///////////////////////////////////
    // The Get for other class
    //////////////////////////////////

    public int getPos_x() {
        return pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public static int get_timmerSpeedFish() {
        return timmerSpeedInsect;
    }

    public static void set_timmerSpeedFish(int setTimmerSpeedInsect) {
        timmerSpeedInsect = setTimmerSpeedInsect;
    }

    ///////////////////////////////////
    // create a random position for the Pellet
    //////////////////////////////////

    public void positionRandomInsect() {
        pos_x = (int) (Math.random() * screen_W);
        pos_y = (int) (Math.random() * screen_H);
    }

    ///////////////////////////////////
    // If a fish touch a insect he eats it and another insect appears in a random
    // and another insect appears in a random position
    ///////////////////////////////////

    public void update() {

        for (int i = 0; i < Board.get_listFish().size(); i++) {

            if ((getPos_x() - hitBoxInsect <= Board.get_listFish().get(i).getPos_x())
                    && (getPos_x() + hitBoxInsect >= Board.get_listFish().get(i).getPos_x())
                    && (getPos_y() - hitBoxInsect <= Board.get_listFish().get(i).getPos_y())
                    && (getPos_y() + hitBoxInsect >= Board.get_listFish().get(i).getPos_y())) {

                if (insectColourName == "timmerLow") {
                    timmerSpeedInsect = 100;
                } else if (insectColourName == "timmerNormal") {
                    timmerSpeedInsect = 150;
                } else {
                    timmerSpeedInsect = 200;
                }
                System.out.println(Board.get_listFish().get(i).getClass().getName() + " insect");
                positionRandomInsect();

            }

        }
    }

}
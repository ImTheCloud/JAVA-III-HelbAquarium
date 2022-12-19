public class Insect {
    ///////////////////////////////////
    // The variables
    //////////////////////////////////
    private final int hitBoxInsect = 15;
    private final int screen_W = Board.getB_WIDTH() - hitBoxInsect;
    private final int screen_H = Board.getB_HEIGHT() - hitBoxInsect;
    // - hitbox, if not its possible to see the insect halfway
    // if is appear at the limit of the screen
    private int pos_x_insect;
    private int pos_y_insect;
    private int randomInsectTimmer = (int) (Math.random() * 3);
    private String insecTimmerName;
    private static int timmerSpeedInsect = 0;
    private static String nameFishTouchInsect;

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    public Insect() {
        positionRandomInsect();
        nameTimeSpeedUpgrade();
    }

    ///////////////////////////////////
    // The Get for other class
    //////////////////////////////////
    public static String getNameFishTouchInsect() {
        return nameFishTouchInsect;
    }

    public static void setNameFishTouchInsect(String nameFishTouchInsect) {
        Insect.nameFishTouchInsect = nameFishTouchInsect;
    }

    public int getPos_x_insect() {
        return pos_x_insect;
    }

    public int getPos_y_insect() {
        return pos_y_insect;
    }

    // time of the spped
    public static int get_timmerSpeedFish() {
        return timmerSpeedInsect;
    }

    public static void set_timmerSpeedFish(int setTimmerSpeedInsect) {
        timmerSpeedInsect = setTimmerSpeedInsect;
    }
    ///////////////////////////////////
    // Method update called in Board for do something every x milisecond (timer)
    //////////////////////////////////

    public void update() {
        insectTouchedbyAInsect();
    }

    ///////////////////////////////////
    // Method for different timer
    // when a fish take a insect his speed upgrade
    // if its the timmer low, the time of the speed will be low, etc...
    //////////////////////////////////

    public void nameTimeSpeedUpgrade() {
        randomInsectTimmer = (int) (Math.random() * 3);
        if (randomInsectTimmer == 0) {
            insecTimmerName = "timmerLow";
        } else if (randomInsectTimmer == 1) {
            insecTimmerName = "timmerNormal";
        } else {
            insecTimmerName = "timmerHigh";
        }
    }

    ///////////////////////////////////
    // Method for put a insect in a random position at the beginning
    //////////////////////////////////

    public void positionRandomInsect() {
        pos_x_insect = (int) (Math.random() * screen_W);
        pos_y_insect = (int) (Math.random() * screen_H);
    }

    ///////////////////////////////////
    // If a fish touch a insect he eats it
    // and another insect appears in a random position
    // if the insect has the name "timmerHigh"
    // he will have the most time of the 3 time, etc...
    ///////////////////////////////////

    public void insectTouchedbyAInsect() {
        for (int i = 0; i < Board.get_listFish().size(); i++) {

            if ((getPos_x_insect() - hitBoxInsect <= Board.get_listFish().get(i).getPos_x_fish())
                    && (getPos_x_insect() + hitBoxInsect >= Board.get_listFish().get(i).getPos_x_fish())
                    && (getPos_y_insect() - hitBoxInsect <= Board.get_listFish().get(i).getPos_y_fish())
                    && (getPos_y_insect() + hitBoxInsect >= Board.get_listFish().get(i).getPos_y_fish())) {
                nameFishTouchInsect = Board.get_listFish().get(i).getClass().getName();

                if (insecTimmerName == "timmerLow") {
                    timmerSpeedInsect = 100;
                } else if (insecTimmerName == "timmerNormal") {
                    timmerSpeedInsect = 150;
                } else {
                    timmerSpeedInsect = 200;
                }
                positionRandomInsect();

            }

        }
    }

}
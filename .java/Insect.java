public class Insect {
    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private int pos_x_insect;
    private int pos_y_insect;
    private int hitBoxInsect = 15;
    protected int screen_W = Board.getB_WIDTH() - hitBoxInsect;
    protected int screen_H = Board.getB_HEIGHT() - hitBoxInsect;
    // - hitbox, if not its possible to see the insect halfway
    // if is appear at the limit of the screen
    private int randomInsectTimmer = (int) (Math.random() * 3);
    private String insecTimmerName;
    private static int timmerSpeedInsect = 0;

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
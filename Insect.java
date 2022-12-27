import java.util.ArrayList;

public class Insect extends GameFixeElement {
    ///////////////////////////////////
    // The variables
    //////////////////////////////////
    private final int hitBoxInsect = 15;
    private final int numberOfInsect = 3;
    private int randomInsectTimmer = (int) (Math.random() * numberOfInsect);
    private final int insectNumberOne = 0;
    private final int insectNumberTwo = 1;
    private static int timmerSpeedInsect = 0;
    private String insecTimmerName;

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    public Insect() {
        nameTimeSpeedUpgrade();
        super.positionRandomElement();
    }

    ///////////////////////////////////
    // The Get for other class
    //////////////////////////////////

    public static int getTimmerSpeedInsect() {
        return timmerSpeedInsect;
    }

    public static void setTimmerSpeedInsect(int timmerSpeedInsect) {
        Insect.timmerSpeedInsect = timmerSpeedInsect;
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
        randomInsectTimmer = (int) (Math.random() * numberOfInsect);
        if (randomInsectTimmer == insectNumberOne) {
            // its a random in 0,1,2 number of insect if the random its 0, the timmer will
            // be low, etc...
            insecTimmerName = "timmerLow";
        } else if (randomInsectTimmer == insectNumberTwo) {
            insecTimmerName = "timmerNormal";
        } else {
            insecTimmerName = "timmerHight";
        }
    }

    ///////////////////////////////////
    // If a fish touch a insect he eats it
    // and another insect appears in a random position
    // if the insect has the name "timmerHigh"
    // he will have the most time of the 3 time, etc...
    ///////////////////////////////////

    public void insectTouchedbyAInsect() {

        ArrayList<Fish> get_listFish = Board.get_listFish();

        int sizeListFish = get_listFish.size();
        for (int i = 0; i < sizeListFish; i++) {

            Fish fish = get_listFish.get(i);
            int pos_x_fish = fish.getPos_x_fish();
            int pos_y_fish = fish.getPos_y_fish();

            if ((getPos_x_element() - hitBoxInsect <= pos_x_fish)
                    && (getPos_x_element() + hitBoxInsect >= pos_x_fish)
                    && (getPos_y_element() - hitBoxInsect <= pos_y_fish)
                    && (getPos_y_element() + hitBoxInsect >= pos_y_fish)) {

                super.positionRandomElement();

                if (insecTimmerName == "timmerLow") {
                    int timeByDefaultlow = 100 * sizeListFish;
                    // important to let variable local, if not the condition will not work
                    timmerSpeedInsect = timeByDefaultlow * sizeListFish;
                } else if (insecTimmerName == "timmerNormal") {
                    int timeByDefaultNormal = 200 * sizeListFish;
                    timmerSpeedInsect = timeByDefaultNormal;
                } else {
                    int timeByDefaultHight = 300 * sizeListFish;
                    timmerSpeedInsect = timeByDefaultHight;
                }

                setIdFishTouchElement(fish.getIdFish());

            }

        }

        if (timmerSpeedInsect != getEndofthecounter()) {
            timmerSpeedInsect--;
        } else {
            setIdFishTouchElement(getIdFishTouchElement());
        }

    }

}
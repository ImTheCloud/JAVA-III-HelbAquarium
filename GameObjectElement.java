public class GameFixeElement {
    private final int hitBoxElement = 20;
    private final static int endOfTheCounter = 0;
    private final static int idFishTouchElementByDefault = -1;
    // by default is -1 because if no fish touch insect = no id Fish
    private int pos_x_element;
    private int pos_y_element;

    public GameFixeElement() {
        positionRandomElement();
    }

    ///////////////////////////////////
    // The Get for other class
    //////////////////////////////////
    public static int getIdfishtouchelementbydefault() {
        return idFishTouchElementByDefault;
    }

    public static int getEndofthecounter() {
        return endOfTheCounter;
    }

    public int getPos_y_element() {
        return pos_y_element;
    }

    public int getPos_x_element() {
        return pos_x_element;
    }
    ///////////////////////////////////
    // Method for put a insect in a random position at the beginning
    //////////////////////////////////

    public void positionRandomElement() {
        pos_x_element = (int) (Math.random() * Board.getB_WIDTH() - hitBoxElement);
        if (pos_x_element < hitBoxElement) {
            pos_x_element = hitBoxElement;
        }
        pos_y_element = (int) (Math.random() * Board.getB_HEIGHT() - hitBoxElement);
        if (pos_y_element < hitBoxElement) {
            pos_y_element = hitBoxElement;
        }
        // - hitbox, if not its possible to see the element halfway
        // if is appear at the limit of the screen
        // if the random can go until -20, if is -20 we will never see the element so I
        // put the element at 20

    }

}

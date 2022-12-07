
public class FishRed extends Fish {
    private int nvl_pos_x;
    private int nvl_pos_y;
    private int new_pos;

    public FishRed() {
        super("Image/fishRed.png");
    }

    public void random_nvl_position() {

        nvl_pos_x = getPos_x();
        nvl_pos_y = getPos_y();

    }

    @Override
    public void update() {

        if (getPos_x() < nvl_pos_x) {
            new_pos = getPos_x() + 1;
            setPos_x(new_pos);
        } else if (getPos_x() > nvl_pos_x) {
            new_pos = getPos_x() - 1;
            setPos_x(new_pos);
        } else if (getPos_y() > nvl_pos_y) {
            new_pos = getPos_y() - 1;
            setPos_y(new_pos);
        } else if (getPos_y() < nvl_pos_y) {
            new_pos = getPos_y() + 1;
            setPos_y(new_pos);
        } else if (getPos_x() == nvl_pos_x && getPos_y() == nvl_pos_y) {
            // arrete toi 1 seconde
            random_nvl_position();
        }

    }
}
public class FishPurple extends Fish {
    private int nvl_pos_x;
    private int nvl_pos_y;
    private int new_pos;

    public FishPurple() {
        super("Image/fishPurple.png");
    }

    public void random_nvl_position() {

        int r = (int) (Math.random() * 4 + 1);

        if (r == 1) {
            nvl_pos_x = 0;
            nvl_pos_y = (int) (Math.random() * screen_H);
        } else if (r == 2) {
            nvl_pos_x = screen_W;
            nvl_pos_y = (int) (Math.random() * screen_H);
        } else if (r == 3) {
            nvl_pos_y = 0;
            nvl_pos_x = (int) (Math.random() * screen_W);
        } else if (r == 4) {
            nvl_pos_y = screen_H;
            nvl_pos_x = (int) (Math.random() * screen_W);
        }

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
            random_nvl_position();
        }

    }

}
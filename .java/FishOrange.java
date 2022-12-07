public class FishOrange extends Fish {
    private static int nvl_pos_x;
    private static int nvl_pos_y;
    private int new_pos;
    private static int[] tab = new int[2];

    public FishOrange() {
        super("Image/fishOrange.png");
        random_nvl_position();
    }

    // Methode qui donne un nv endroit ou aller au poisson si il touche un bord
    public static int[] random_nvl_position() {

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

        tab[0] = nvl_pos_x;
        tab[1] = nvl_pos_y;

        return tab;

    }

    public static int[] get_randomNvlPosition() {
        return random_nvl_position();
    }

    @Override
    public void update() {

        // EdiblePellet.set_stop();

        // if (set_stop== 0) {
        // Fait avancer le poisson
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
        // } else {
        // set_stop--;
        // }

    }

}

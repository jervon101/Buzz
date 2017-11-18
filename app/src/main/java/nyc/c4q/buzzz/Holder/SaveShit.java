package nyc.c4q.buzzz.Holder;

/**
 * Created by jervon.arnoldd on 11/18/17.
 */

public class SaveShit {
    private static String counter="";

    public static String getCounter() {
        return counter;
    }

    public static void addStuff (int counter) {
        counter+=counter;
    }
}

package nyc.c4q.buzzz.data;

import android.support.annotation.DrawableRes;

/**
 * Created by jervon.arnoldd on 11/16/17.
 */

public class TopFive {
    String Question;
    int image;


    public TopFive(String question, @DrawableRes int image) {
        this.image=image;
        this.Question = question;

    }


    public String getQuestion() {
        return Question;
    }
    @DrawableRes
    public int getImage() {
        return image;
    }

}

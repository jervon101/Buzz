package nyc.c4q.buzzz.Holder;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import nyc.c4q.buzzz.R;
import nyc.c4q.buzzz.data.TopFive;


/**
 * Created by jervon.arnoldd on 11/16/17.
 */

public class TopFiveHolder extends RecyclerView.ViewHolder {

    TextView question;
    ImageView image;

    RadioButton yes;
    RadioButton no;
    int count;


    public TopFiveHolder(View itemView) {
        super(itemView);
        question = (TextView) itemView.findViewById(R.id.text_view);
        image = (ImageView) itemView.findViewById(R.id.image_view);

        yes = (RadioButton) itemView.findViewById(R.id.yes);
        no = (RadioButton) itemView.findViewById(R.id.no);
    }

    public void onBind(final TopFive topFive) {
//        slide();
//        blink();
        question.setText(topFive.getQuestion());

        image.setImageResource(topFive.getImage());

        yes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                no.setVisibility(View.GONE);
                SaveShit.addStuff(-1);
                Log.e("Count is(holder)", ""+count);
            }
        });


        no.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                yes.setVisibility(View.GONE);
                SaveShit.addStuff(1);
                Log.e("Count is(holder)", ""+count);
            }
        });
    }


    public int  getCount(){return count;}

    public void blink() {
        ImageView image = (ImageView) itemView.findViewById(R.id.image_view);
        Animation animation1 =
                AnimationUtils.loadAnimation(itemView.getContext(),
                        R.anim.blink);
        image.startAnimation(animation1);
    }

    public void slide() {
        TextView text = (TextView) itemView.findViewById(R.id.text_view);
        Animation animation2 =
                AnimationUtils.loadAnimation(itemView.getContext(), R.anim.slide);
        text.startAnimation(animation2);
    }

}

package nyc.c4q.buzzz;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.blurry.Blurry;
import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nyc.c4q.buzzz.Adpter.TopFiveAdapter;
import nyc.c4q.buzzz.Holder.SaveShit;
import nyc.c4q.buzzz.data.TopFive;

public class MainActivity extends AppCompatActivity {
    KonfettiView viewKonfetti;
    int count;
    RecyclerView recyclerView;
    Button button;
    Button button2;
    TopFiveAdapter adapter;
    LinearLayout layout;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.test);
        button2 = (Button) findViewById(R.id.test2);
        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        layout = (LinearLayout) findViewById(R.id.layout);
        viewKonfetti = (KonfettiView) findViewById(R.id.viewKonfetti);
        textView = (TextView) findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setVisibility(View.GONE);
                button2.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);


                firstGame();


            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setVisibility(View.GONE);
                button2.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);


                secondGame();


            }
        });

    }


    public void firstGame() {

        Blurry.with(getApplicationContext())
                .radius(10)
                .sampling(8)
                .color(Color.argb(66, 255, 255, 0))
                .async()
                .onto(layout);

        List<TopFive> list = new ArrayList<>();

        list.add(new TopFive("Do You Want to me a Winner", R.mipmap.ic_launcher));
        list.add(new TopFive("Are you Good at Winning", R.mipmap.ic_launcher));
        list.add(new TopFive("Have You ever Lost?", R.mipmap.ic_launcher));
        list.add(new TopFive("Have you ever ran for the train?", R.mipmap.ic_launcher));
        list.add(new TopFive("Have you ever ran for the bus", R.mipmap.ic_launcher));
        list.add(new TopFive("Does the Rain make you sleepy", R.mipmap.ic_launcher));
        list.add(new TopFive("DO you like naps", R.mipmap.ic_launcher));

        fade();

        adapter = new TopFiveAdapter(list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter.myMethod();
        Log.e("Count is(main)", "" + adapter.myMethod());


        if (SaveShit.getCounter().length() >= 7) {

            for (int i = 0; i < SaveShit.getCounter().length(); i++) {
                int sum = 0;
                sum += Integer.parseInt(SaveShit.getCounter().charAt(i) + "");


                if (sum % 2 == 0) {
                    button.setVisibility(View.GONE);
                    button2.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.GONE);

                    textView.setVisibility(View.VISIBLE);

                } else if (sum % 2 != 0) {
                    button.setVisibility(View.GONE);
                    button2.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.GONE);

                    textView.setVisibility(View.VISIBLE);

                }
            }

        }
    }

    public void secondGame() {

        Blurry.with(getApplicationContext())
                .radius(10)
                .sampling(8)
                .color(Color.argb(66, 255, 255, 0))
                .async()
                .onto(layout);

        List<TopFive> list = new ArrayList<>();

        list.add(new TopFive("Are You happy?", R.mipmap.ic_launcher));
        list.add(new TopFive("Are you Tired?", R.mipmap.ic_launcher));
        list.add(new TopFive("Are You in Good Health?", R.mipmap.ic_launcher));
        list.add(new TopFive("Are you over 5ft?", R.mipmap.ic_launcher));
        list.add(new TopFive("Does this picture make you happy?", R.mipmap.ic_launcher));


        fade();

        adapter = new TopFiveAdapter(list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter.myMethod();
        Log.e("Count is(main)", "" + adapter.myMethod());


        if (SaveShit.getCounter().length() >= 7) {

            for (int i = 0; i < SaveShit.getCounter().length(); i++) {
                int sum = 0;
                sum += Integer.parseInt(SaveShit.getCounter().charAt(i) + "");


                if (sum % 2 == 0) {

                    button.setVisibility(View.GONE);
                    button2.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.GONE);

                    textView.setVisibility(View.VISIBLE);
                } else if (sum % 2 != 0) {
                    button.setVisibility(View.GONE);
                    button2.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.GONE);

                    textView.setVisibility(View.VISIBLE);

                }
            }

        }
    }


    public void fade() {
        recyclerView = (RecyclerView) findViewById(R.id.recycle);

        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.fade);
        recyclerView.startAnimation(animation1);
    }


    @Override
    public void onBackPressed() {
        fade();


        button.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);

        recyclerView.setVisibility(View.GONE);

    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event)  {
//        if (Integer.pagrseInt(android.os.Build.VERSION.SDK) > 5
//                && keyCode == KeyEvent.KEYCODE_BACK
//                && event.getRepeatCount() == 0) {
//            Log.d("CDA", "onKeyDown Called");
//            onBackPressed();
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }


}

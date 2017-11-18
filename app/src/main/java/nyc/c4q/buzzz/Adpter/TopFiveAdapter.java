package nyc.c4q.buzzz.Adpter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


import nyc.c4q.buzzz.Holder.TopFiveHolder;
import nyc.c4q.buzzz.R;
import nyc.c4q.buzzz.data.TopFive;


/**
 * Created by jervon.arnoldd on 11/16/17.
 */

public class TopFiveAdapter extends RecyclerView.Adapter<TopFiveHolder> {

    int mycount;
    List<TopFive> list;

    public TopFiveAdapter(List<TopFive> list) {
        this.list = list;
    }

    @Override
    public TopFiveHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_layout, parent, false);


        return new TopFiveHolder(view);
    }

    @Override
    public void onBindViewHolder(TopFiveHolder holder, int position) {
        TopFive someClass = list.get(position);
        holder.onBind(someClass);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public int myMethod() {
        return mycount;
    }


}


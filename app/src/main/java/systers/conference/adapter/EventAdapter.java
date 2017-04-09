package systers.conference.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.StringTokenizer;

import systers.conference.R;

/**
 * Created by anip on 05/04/17.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    ArrayList<String> url;
    private Activity context;
    public EventAdapter(Activity context, ArrayList<String> url){
        this.url = url;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_card_view, parent, false);
//        TextView textView = (TextView) view.findViewById(R.id.)
        // set the view's size, margins, paddings and layout parameters
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        View view = holder.itemView;
        ImageView event_image = (ImageView) view.findViewById(R.id.image);
        TextView title = (TextView) view.findViewById(R.id.event_name);
        title.setText("Main Event");
        Glide.with(context).load(url.get(position)).centerCrop().into(event_image);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public int getItemCount() {
        return url.size();
    }
}

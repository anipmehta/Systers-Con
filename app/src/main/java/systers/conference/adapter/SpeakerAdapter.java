package systers.conference.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import systers.conference.R;
import systers.conference.model.Speaker;
import systers.conference.utility.CircleTransform;

/**
 * Created by anip on 07/04/17.
 */

public class SpeakerAdapter extends BaseAdapter {
    private static LayoutInflater inflater=null;
    private Context context;
    private ArrayList<Speaker> speakers;
    public SpeakerAdapter(Context context, ArrayList<Speaker> speakers){
        this.context = context;
        this.speakers = speakers;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return speakers.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public class Holder{
        TextView name;
        TextView event;
        ImageView profile;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder = new Holder();
        Speaker speaker = speakers.get(i);
        View row_view = inflater.inflate(R.layout.speaker_list_view, null);
        holder.name = (TextView) row_view.findViewById(R.id.name);
        holder.event = (TextView) row_view.findViewById(R.id.event);
        holder.profile = (ImageView) row_view.findViewById(R.id.profile);
        holder.name.setText(speaker.getName());
        holder.event.setText(speaker.getEvent_name());
        System.out.println(new CircleTransform(context));
        Glide.with(context).load(speaker.getImage_url()).transform(new CircleTransform(context)).into(holder.profile);
        return row_view;
    }
}

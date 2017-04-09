package systers.conference.adapter;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import systers.conference.R;

/**
 * Created by anip on 08/04/17.
 */

public class MyPagerAdapter extends PagerAdapter{
    private Context context;
    public MyPagerAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View layout = null;
        switch (position) {
            case 0:
                layout = inflater.inflate(R.layout.intro_slide1, container, false);
                break;
            case 1:
                layout = inflater.inflate(R.layout.intro_slide2, container, false);
                break;
            case 2:
                layout = inflater.inflate(R.layout.intro_slide_3, container, false);
                break;
            default:
                layout = inflater.inflate(R.layout.intro_slide1, container, false);
        }
        container.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}
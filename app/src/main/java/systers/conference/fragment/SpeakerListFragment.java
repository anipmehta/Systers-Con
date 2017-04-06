package systers.conference.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import systers.conference.R;

/**
 * Created by anip on 06/04/17.
 */

public class SpeakerListFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_speakers, container, false);

        return rootView;
    }

    public static SpeakerListFragment newInstance() {

        Bundle args = new Bundle();

        SpeakerListFragment fragment = new SpeakerListFragment();
        fragment.setArguments(args);
        return fragment;
    }
}

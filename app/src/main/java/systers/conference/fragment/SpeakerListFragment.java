package systers.conference.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import systers.conference.R;
import systers.conference.adapter.SpeakerAdapter;
import systers.conference.model.Speaker;

/**
 * Created by anip on 06/04/17.
 */

public class SpeakerListFragment extends Fragment {
    private ArrayList<Speaker> speakers;
    private SpeakerAdapter speakerAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_speakers, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ListView speakers_list = (ListView) view.findViewById(R.id.speaker_list);
        speakers = new ArrayList<Speaker>();
        Speaker speaker1 = new Speaker();
        speaker1.setImage_url("https://www.newschool.edu/uploadedImages/Parsons/Profiles/jamer_hunt_profile.jpg?n=4468");
        speaker1.setEvent_name("Event 1");
        speaker1.setName("Jake Wharton");
        Speaker speaker2 = new Speaker();
        speaker2.setImage_url("https://www.erdw.ethz.ch/content/specialinterest/erdw/d-erdw/en/personen/profil.person_image.jpeg?persid=206195");
        speaker2.setEvent_name("Event 2");
        speaker2.setName("Robert Stempel");
        speakers.add(speaker1);
        speakers.add(speaker2);
        speakerAdapter = new SpeakerAdapter(getActivity(), speakers);
        speakers_list.setAdapter(speakerAdapter);
        super.onViewCreated(view, savedInstanceState);
    }

    public static SpeakerListFragment newInstance() {

        Bundle args = new Bundle();

        SpeakerListFragment fragment = new SpeakerListFragment();
        fragment.setArguments(args);
        return fragment;
    }
}

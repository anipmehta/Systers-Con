package systers.conference.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by anip on 12/04/17.
 */

public class Attendee implements Serializable {
    @SerializedName("data")
    private ArrayList<Speaker> speakers;

    public ArrayList<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(ArrayList<Speaker> speakers) {
        this.speakers = speakers;
    }
}

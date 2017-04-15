package systers.conference.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by anip on 07/04/17.
 */

public class Speaker implements Serializable {
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String event_name;
    private String image_url = "https://www.newschool.edu/uploadedImages/Parsons/Profiles/jamer_hunt_profile.jpg?n=4468";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}

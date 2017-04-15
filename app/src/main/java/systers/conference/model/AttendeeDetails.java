package systers.conference.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by anip on 15/04/17.
 */

public class AttendeeDetails implements Serializable {
    @SerializedName("responses")
    private HashMap<Integer, Response> response;


    public HashMap<Integer, Response> getResponse() {
        return response;
    }

    public void setResponse(HashMap<Integer, Response> response) {
        this.response = response;
    }
}

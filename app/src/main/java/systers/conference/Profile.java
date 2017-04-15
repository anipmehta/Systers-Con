package systers.conference;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import systers.conference.model.AttendeeDetails;
import systers.conference.model.Response;

/**
 * Created by anip on 15/04/17.
 */

public class Profile extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Gson gson = new Gson();
        setContentView(R.layout.activity_profile);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("Anip Data\n\n");
        BufferedReader jsonReader2 = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.attendee_anip)));
        AttendeeDetails attendeeDetails = gson.fromJson(jsonReader2, AttendeeDetails.class);
        for(Response response : attendeeDetails.getResponse().values()){
            textView.setText(textView.getText()+response.getName()+ " : "+ response.getResponse()+"\n");
        }
        textView.setText(textView.getText()+"\n\n"+"May Data\n"+"\n");
        BufferedReader jsonReader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.attendee_may)));
        AttendeeDetails attendeeDetails2 = gson.fromJson(jsonReader, AttendeeDetails.class);
        for(Response response : attendeeDetails2.getResponse().values()){
            textView.setText(textView.getText()+response.getName()+ " : "+ response.getResponse()+"\n");
        }
    }
}

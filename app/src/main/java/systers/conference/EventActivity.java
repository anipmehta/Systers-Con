package systers.conference;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import systers.conference.fragment.DetailFragment;
import systers.conference.fragment.LocationFragment;
import systers.conference.fragment.SpeakerListFragment;

/**
 * Created by anip on 06/04/17.
 */

public class EventActivity extends AppCompatActivity{
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event);
        getSupportActionBar().setTitle("Event Name");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.getMenu();
        bottomNavigationView.setSelectedItemId(R.id.detail);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = null;
        Bundle args = new Bundle();
        args.putString("Title","");
        args.putString("Image",getIntent().getStringExtra("url"));
        fragment = DetailFragment.newInstance(args);
        fragmentTransaction.add(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.location:
                        fragment = LocationFragment.newInstance();
                        break;
                    case R.id.detail:
                        Bundle args = new Bundle();
                        args.putString("Title","");
                        args.putString("Image",getIntent().getStringExtra("url"));
                        fragment = DetailFragment.newInstance(args);
//                        fragment.setArguments(args);
                        break;
                    case R.id.speakers:
                        fragment = SpeakerListFragment.newInstance();
                        break;
                }
                if (fragment != null) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, fragment);
                    fragmentTransaction.commit();
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.event_toolbar, menu);
        MenuItem like = menu.findItem(R.id.action_like);
        MenuItem share = menu.findItem(R.id.action_share);
        share.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                String shareBody = "Here is the share content body";
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
                return true;
            }
        });
        like.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                menuItem.setIcon(R.drawable.ic_favorite_white_24dp);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

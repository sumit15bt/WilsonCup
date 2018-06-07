package Sumit.wilsoncricket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private Firebase mRef,mRef2;
    private ArrayList<String> mTeamname=new ArrayList<>();
    private ArrayList<String> mTeamPoint=new ArrayList<>();
    private ListView mListView,mListView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRef=new Firebase("https://cricket-ba5cc.firebaseio.com/Teams");
        mListView=(ListView)findViewById(R.id.TeamList);
        final ArrayAdapter<String> arrayAdapter =new ArrayAdapter<String>(this,R.layout.teamlayout,mTeamname);
        mListView.setAdapter(arrayAdapter);
        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value= dataSnapshot.getValue(String.class);
                mTeamname.add(value);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mRef2=new Firebase("https://cricket-ba5cc.firebaseio.com/Teamout");
        mListView2=(ListView)findViewById(R.id.TeamList2);
        final ArrayAdapter<String> arrayAdapter2 =new ArrayAdapter<String>(this,R.layout.teamlayout,mTeamPoint);
        mListView2.setAdapter(arrayAdapter2);
        mRef2.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value= dataSnapshot.getValue(String.class);
                mTeamPoint.add(value);
                arrayAdapter2.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.notice:
                Toast.makeText(this, "Notices ...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),Notices.class));
                break;

            case R.id.itm1:
                Toast.makeText(this, "ScoreBoard ...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),MainScore.class));
                break;
            case R.id.item2:
                Toast.makeText(this, "Teams ...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                break;

            case R.id.item4:
                Toast.makeText(this, "About wilson Cup ...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),AboutWC.class));

                break;
            case R.id.location:
                Toast.makeText(this, "location ...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),Mlocation.class));
                break;

        }
        return super.onOptionsItemSelected(item);
    }

}




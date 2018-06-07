package Sumit.wilsoncricket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class Interface extends AppCompatActivity {
    private EditText Team1,Team2,Run,Wicket,Over,result,playing_team;
    private Firebase mRef1,mRef2,mRef3,mRef4,mRef5,mRef6,mRef7;
    private Button mSendata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface);
        mSendata=(Button)findViewById(R.id.bt1);

        Team1=(EditText)findViewById(R.id.team1);
        playing_team=(EditText)findViewById(R.id.playingteam);
        Team2=(EditText)findViewById(R.id.team2);
        Run=(EditText)findViewById(R.id.run);
        Wicket=(EditText)findViewById(R.id.wicket);
        Over=(EditText)findViewById(R.id.over);
        result=(EditText)findViewById(R.id.resultdec);

        mRef1=new Firebase("https://cricket-ba5cc.firebaseio.com/CurrentMatch/Team1");
        mRef2=new Firebase("https://cricket-ba5cc.firebaseio.com/CurrentMatch/Team2");
        mRef3=new Firebase("https://cricket-ba5cc.firebaseio.com/CurrentMatch/Runs");
        mRef4=new Firebase("hhttps://cricket-ba5cc.firebaseio.com/CurrentMatch/wicket");
        mRef5=new Firebase("https://cricket-ba5cc.firebaseio.com/CurrentMatch/Overs");
        mRef6=new Firebase("https://cricket-ba5cc.firebaseio.com/CurrentMatch/Result");
        mRef7=new Firebase("https://cricket-ba5cc.firebaseio.com/CurrentMatch/PlayingTeam");


        mRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                Team1.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                Team2.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                Run.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                Wicket.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                Over.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                result.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                playing_team.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        mSendata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tm1,tm2,currenttm,run,wicket,over,resultd;
               tm1=Team1.getText().toString();
                mRef1.setValue(""+tm1+"");
                tm2=Team2.getText().toString();
                mRef2.setValue(""+tm2+"");
                currenttm=playing_team.getText().toString();
                mRef7.setValue(""+currenttm+"");
                run=Run.getText().toString();
                mRef3.setValue(""+run+"");
                wicket=Wicket.getText().toString();
                mRef4.setValue(""+wicket+"");
                over=Over.getText().toString();
                mRef5.setValue(""+over+"");
                resultd=result.getText().toString();
                mRef6.setValue(""+resultd+"");

                Toast.makeText(Interface.this, " Upadting ... wait...", Toast.LENGTH_SHORT).show();
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
                break;

            case R.id.itm1:
                Toast.makeText(this, "ScoreBoard ...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),MainScore.class));
                break;

            case R.id.item4:
                Toast.makeText(this, "About wilson Cup ...", Toast.LENGTH_SHORT).show();

                break;
            case R.id.location:
                Toast.makeText(this, "location ...", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

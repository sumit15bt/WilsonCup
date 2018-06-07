package Sumit.wilsoncricket;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Sore extends Fragment {

    private TextView Team1,Team2,Run,Wicket,Over,result,playing_team;
    private Firebase mRef1,mRef2,mRef3,mRef4,mRef5,mRef6,mRef7;
    private Firebase mRefcom;
    private ArrayList<String> mNotices=new ArrayList<>();
    private ListView mListView;
    public Sore() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_sore,container,false);

        Team1=(TextView)view.findViewById(R.id.team1);
        playing_team=(TextView)view.findViewById(R.id.playingteam);
        Team2=(TextView)view.findViewById(R.id.team2);
        Run=(TextView)view.findViewById(R.id.run);
        Wicket=(TextView)view.findViewById(R.id.wicket);
        Over=(TextView)view.findViewById(R.id.over);
        result=(TextView)view.findViewById(R.id.resultdec);
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

        mRefcom=new Firebase("https://cricket-ba5cc.firebaseio.com/Commentry");
        mListView=(ListView)view.findViewById(R.id.comentry);
        final ArrayAdapter<String> arrayAdapter =new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.lista_lyout,mNotices);
        mListView.setAdapter(arrayAdapter);
        mRefcom.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value= dataSnapshot.getValue(String.class);
                mNotices.add(value);
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

        return view;
    }

}

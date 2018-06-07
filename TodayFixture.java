package Sumit.wilsoncricket;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TodayFixture extends Fragment {

    private Firebase mRefcom;
    private ArrayList<String> mNotices=new ArrayList<>();
    private ListView mListView;
    public TodayFixture() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_today_fixture,container,false);

        mRefcom=new Firebase("https://cricket-ba5cc.firebaseio.com/TodaysFixture");
        mListView=(ListView)view.findViewById(R.id.matchfixture);
        final ArrayAdapter<String> arrayAdapter =new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.teamlayout2,mNotices);
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

        // Inflate the layout for this fragment
        return view;
    }



}

package Sumit.wilsoncricket;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Mlocation extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng shuats = new LatLng(25.4135, 81.8469);
        mMap.addMarker(new MarkerOptions().position(shuats).title("Sam Higginbottom University of Agriculture, Technology and Sciences"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(shuats));
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

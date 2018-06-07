package Sumit.wilsoncricket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class AboutWC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_wc);


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

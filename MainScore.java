package Sumit.wilsoncricket;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainScore extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tablayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainscore);

        viewPager = (ViewPager) findViewById(R.id.vpager);
        setupviewPager(viewPager);

        tablayout = (TabLayout) findViewById(R.id.tab1);
        tablayout.setupWithViewPager(viewPager);
        // setupTabIcon();

    }


    //    private void setupTabIcon() {
//        tablayout.getTabAt(0).setIcon(tabicon[0]);
//        tablayout.getTabAt(1).setIcon(tabicon[1]);
//        tablayout.getTabAt(2).setIcon(tabicon[2]);
//
//    }
    private void setupviewPager(ViewPager viewPager) {
        ViewPagerAdapter vpa = new ViewPagerAdapter(getSupportFragmentManager());
        vpa.addFragment(new Sore(),"SCORE");
        vpa.addFragment(new TodayFixture(), "TODAY FIXTURE");



        viewPager.setAdapter(vpa);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> fragmentsList = new ArrayList<>();
        private final List<String> fragmentTittle = new ArrayList<>();


        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentsList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentsList.size();
        }

        public void addFragment(Fragment fragment, String Title) {
            fragmentsList.add(fragment);
            fragmentTittle.add(Title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // return null;
            return fragmentTittle.get(position);
        }
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

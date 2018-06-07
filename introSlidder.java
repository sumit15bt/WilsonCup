package Sumit.wilsoncricket;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class introSlidder extends AppCompatActivity {
    private static ViewPager viewPager;
    private static LinearLayout dotsLayout;
    private static TextView[] dots;
    private static int[] layout;
    private Button skip,next;
    private  PrefManager prefManager;
    public   MyViewPagerAdapter myViewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Checking for First time Launch.....
        prefManager=new PrefManager(this);
        if(!prefManager.isFirstTimeLaunch()){
            launchHomeScreen();
            finish();
        }
        //making Notification Bar Transparent
        if(Build.VERSION.SDK_INT>=21)
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        setContentView(R.layout.activity_intro_slidder);
//for introslidder....
        viewPager=(ViewPager)findViewById(R.id.view_pager);
        dotsLayout=(LinearLayout)findViewById(R.id.layoutDots);
        skip=(Button)findViewById(R.id.btn_skip);
        next=(Button)findViewById(R.id.btn_next);
        layout=new int[]{R.layout.welcome_slide_one,R.layout.welcome_slide_two};
        addBootomDot(0);
        myViewPagerAdapter=new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerpageChangeListener);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchHomeScreen();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int current=getItem(+1);
                if(current<layout.length){
                    viewPager.setCurrentItem(current);
                }
                else{
                    launchHomeScreen();
                }
            }
        });
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem()+i;
    }

    private void addBootomDot(int i) {
        dots=new TextView[layout.length];
        int[] colourActive=getResources().getIntArray(R.array.array_dot_active);
        int[] colourInactive=getResources().getIntArray(R.array.array_dot_inactive);
        dotsLayout.removeAllViews();
        for(int j=0;j<dots.length;j++){
            dots[j]=new TextView(this);
            dots[j].setText(Html.fromHtml("&#8226;"));
            dots[j].setTextSize(35);
            dots[j].setTextColor(colourInactive[i]);
            dotsLayout.addView(dots[j]);
        }
        if(dots.length>0){
            dots[i].setTextColor(colourActive[i]);

        }
    }

    private void launchHomeScreen() {
        prefManager.setFirstTimelaunch(false);
        startActivity(new Intent(getApplicationContext(),MainScore.class));
        finish();

    }
    ViewPager.OnPageChangeListener viewPagerpageChangeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
    //for changing the next btn text Next to Got-It
            addBootomDot(position);
            if(position==layout.length-1){
                next.setText(getString(R.string.gotit));
                skip.setVisibility(View.GONE);
            }
            else
            {
                next.setText(getString(R.string.next));
                skip.setVisibility(View.VISIBLE);

            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public class MyViewPagerAdapter extends PagerAdapter{
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view=layoutInflater.inflate(layout[position],container,false);
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return layout.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view=(View)object;
            container.removeView(view);
        }
    }

}

package com.example.home.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class Portfolio extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    public static String[] input;
    public static Context c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        //c=getApplicationContext();
        //Toast.makeText(this, "starting", Toast.LENGTH_SHORT).show();
        Bundle b = this.getIntent().getExtras();
        input = b.getStringArray("key");
        c=getApplicationContext();
        //for(int i=0;i<7;i++)
        //Toast.makeText(this, input[i], Toast.LENGTH_SHORT).show();
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            String[][] out=null;
            View rootView = inflater.inflate(R.layout.fragment_portfolio, container, false);
            PieChart chart = (PieChart) rootView.findViewById(R.id.chart);
            //Toast.makeText(c, cs, Toast.LENGTH_SHORT).show();
            Folio_1_New f = new Folio_1_New(c);
            //Toast.makeText(c,input[0],Toast.LENGTH_SHORT).show();
                    f.initializer(input[0],input[1],input[2],input[3],input[4],input[5],input[6]);
            if(getArguments().getInt(ARG_SECTION_NUMBER)==1)
            {
                try {
                    out = f.portfolioA();
                }
                catch(Exception e)
                {

                }
            }
            else if(getArguments().getInt(ARG_SECTION_NUMBER)==2)
            {
                try {
                    out = f.portfolioB();
                }
                catch(Exception e)
                {

                }
            }
            else
            {
                try {
                    out = f.portfolioC();
                }
                catch(Exception e)
                {

                }
            }
            if(out!=null) {
                //Toast.makeText(c, "Starting", Toast.LENGTH_SHORT).show();
                if(out[0][0].equals("Sorry.You cannot receive a reasonable reccomendation based on your inputs.")==false) {
                    setupPieChart(chart, out);
                    //TextView textView = (TextView) rootView.findViewById(R.id.text);
                }
                //textView.setText("Expected rate of return is " + out[2][0]);
                //Toast.makeText(c, cs, Toast.LENGTH_SHORT).show();
            }
            return rootView;
        }

        private void setupPieChart(PieChart chart, String [][] out) {
           // Populating the data for the pie chart
            List<PieEntry> pieentries = new ArrayList<>();
            int rows=out[0].length;
            //Toast.makeText(c,Integer.toString(rows),Toast.LENGTH_SHORT).show();
            for(int i=0; i<rows; i++)
            {
                try {
                    pieentries.add(new PieEntry(Float.parseFloat(out[1][i]), out[0][i]));
                }
                catch(Exception e)
                {
                    break;
                }
            }
            String s ="Expected rate of return is " + out[2][0];
            //String s = "Hello";
            PieDataSet dataset= new PieDataSet(pieentries,s);
            dataset.setColors(ColorTemplate.COLORFUL_COLORS);
            PieData data = new PieData(dataset);
            //Drawing the chart
            chart.setData(data);
            chart.invalidate();
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Portfolio A";
                case 1:
                    return "Portfolio B";
                case 2:
                    return "Portfolio C";
            }
            return null;
        }
    }
}

package vn.edu.usth.weather;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

//Hmm this seems deprecated but it works lol
public class HomePagerAdapter extends FragmentPagerAdapter {
    private final int PAGE_COUNT = 3;
    private String titles[] = new String[] {"Hanoi, Vietnam", "London, England", "Tokyo, Japan"};
    public HomePagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int page){
        switch (page){
            case 0: return WeatherAndForecast.newInstance("","");
            case 1: return WeatherAndForecast.newInstance("","");
            case 2: return WeatherAndForecast.newInstance("","");
            default: return WeatherAndForecast.newInstance("","");
        }
    }

    @Override
    public CharSequence getPageTitle(int page){
        return titles[page];
    }

    @Override
    public int getCount(){
        return PAGE_COUNT;
    }
}
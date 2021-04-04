package ru.mora.myweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import ru.mora.myweather.fragment_tabs.FragmentCity;
import ru.mora.myweather.fragment_tabs.FragmentTask;
import ru.mora.myweather.fragment_tabs.FragmentWeather;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // получение компонента прокрутки
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        // установка адаптера и окон
        setupViewPager(viewPager);

        // получение компонента вкладки
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        // объединение с ViewPager
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentCity(), getResources().getString(R.string.text_label_1));
        adapter.addFragment(new FragmentWeather(), getResources().getString(R.string.text_label_2));
        adapter.addFragment(new FragmentTask(), getResources().getString(R.string.text_label_3));
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
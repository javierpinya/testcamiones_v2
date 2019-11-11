package com.javierpinya.testcamiones_v2;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.ToxicBakery.viewpager.transforms.CubeOutTransformer;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.javierpinya.testcamiones_v2.Adapters.MenuSliderAdapter;
import com.javierpinya.testcamiones_v2.ui.DashboardFragment;
import com.javierpinya.testcamiones_v2.ui.PerfilFragment;
import com.javierpinya.testcamiones_v2.ui.SincronizarFragment;

public class MenuActivity extends AppCompatActivity {

    FragmentPagerAdapter adapter;

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;

    private DashboardFragment dashboardFragment;
    private PerfilFragment perfilFragment;
    private SincronizarFragment sincronizarFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ViewPager vpPager = (ViewPager) findViewById(R.id.pager);
        adapter = new MenuSliderAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapter);
        vpPager.setPageTransformer(true, new CubeOutTransformer());
    }

}

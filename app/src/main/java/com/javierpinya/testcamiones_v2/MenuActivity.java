package com.javierpinya.testcamiones_v2;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.ToxicBakery.viewpager.transforms.CubeOutTransformer;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.javierpinya.testcamiones_v2.Adapters.SliderAdapter;
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
        adapter = new SliderAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapter);
        vpPager.setPageTransformer(true, new CubeOutTransformer());
    }


/*
        bottomNavigationView = findViewById(R.id.nav_view);
        //frameLayout = findViewById(R.id.contenedor_menu);

        dashboardFragment = new DashboardFragment();
        perfilFragment = new PerfilFragment();
        sincronizarFragment = new SincronizarFragment();


        firstFragment(dashboardFragment);
        bottomNavigationView.setSelectedItemId(R.id.navigation_dashboard);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.navigation_perfil:
                         setFragment(perfilFragment);
                        return true;
                    case R.id.navigation_dashboard:
                        setFragment(dashboardFragment);
                        return true;
                    case R.id.navigation_sincronizar:
                        setFragment(sincronizarFragment);
                        return true;
                }

                Toast.makeText(getApplicationContext(), "entramos en: " + menuItem.getItemId(), Toast.LENGTH_SHORT).show();

                return false;
            }
        });

    }

    /*

    private void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.contenedor_menu, fragment);
        fragmentTransaction.commit();
    }

    private void firstFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.contenedor_menu, fragment);
                fragmentTransaction.commit();
    }

     */
}

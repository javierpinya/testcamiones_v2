package com.javierpinya.testcamiones_v2;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.ToxicBakery.viewpager.transforms.CubeOutTransformer;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.javierpinya.testcamiones_v2.Adapters.SliderAdapter;
import com.javierpinya.testcamiones_v2.ui.DashboardFragment;
import com.javierpinya.testcamiones_v2.ui.PerfilFragment;
import com.javierpinya.testcamiones_v2.ui.SincronizarFragment;

import java.io.File;

public class MenuActivity extends AppCompatActivity {

    private static final int PERMISSION_READ_EXTARNAL_MEMORY = 1000;
    private static final int PERMISSION_READ_EXTERNAL_MEMORY = 100;
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


        //isExternalStorageReadable();
    }



/*
    private boolean hasPermission(String permissionToCheck){
        int permissionCheck = ContextCompat.checkSelfPermission(this, permissionToCheck);
        return (permissionCheck == PackageManager.PERMISSION_GRANTED);
    }

    private void checkForPermission(){
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);

        if(permissionCheck != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    PERMISSION_READ_EXTARNAL_MEMORY);
        }
    }

 */

    private boolean isExternalStorageReadable(){
        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || Environment.MEDIA_MOUNTED_READ_ONLY.equals(Environment.getExternalStorageState())){
            Log.i("State", "Yes, it is readable!");
            return true;
        }else{
            return false;
        }
    }

/*

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode){
            case PERMISSION_READ_EXTERNAL_MEMORY:
                if((grantResults.length>0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)){

                }
        }
    }

 */
}

package com.javierpinya.testcamiones_v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.ToxicBakery.viewpager.transforms.FlipHorizontalTransformer;
import com.javierpinya.testcamiones_v2.Adapters.ResultadoBuscarVehiculoSliderAdapter;

public class ResultadoInspeccionActivity extends AppCompatActivity {

    FragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_inspeccion);
        ViewPager vpPager = (ViewPager) findViewById(R.id.pager);
        adapter = new ResultadoBuscarVehiculoSliderAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapter);
        vpPager.setPageTransformer(true, new FlipHorizontalTransformer());
    }
}

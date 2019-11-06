package com.javierpinya.testcamiones_v2.Adapters;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.javierpinya.testcamiones_v2.ui.ResultadoBuscarVehiculo.ResultadoBuscarCisternaFragment;
import com.javierpinya.testcamiones_v2.ui.ResultadoBuscarVehiculo.ResultadoBuscarConductorFragment;
import com.javierpinya.testcamiones_v2.ui.ResultadoBuscarVehiculo.ResultadoBuscarRigidoFragment;
import com.javierpinya.testcamiones_v2.ui.ResultadoBuscarVehiculo.ResultadoBuscarTractoraFragment;

public class ResultadoBuscarVehiculoSliderAdapter extends FragmentPagerAdapter {

    public ResultadoBuscarVehiculoSliderAdapter(FragmentManager fm){ super (fm);}


    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                ResultadoBuscarTractoraFragment resultadoBuscarTractoraFragment= new ResultadoBuscarTractoraFragment();
                return resultadoBuscarTractoraFragment;
            case 1:
                ResultadoBuscarRigidoFragment resultadoBuscarRigidoFragment= new ResultadoBuscarRigidoFragment();
                return resultadoBuscarRigidoFragment;
            case 2:
                ResultadoBuscarCisternaFragment resultadoBuscarCisternaFragment = new ResultadoBuscarCisternaFragment();
                return resultadoBuscarCisternaFragment;
            case 3:
                ResultadoBuscarConductorFragment resultadoBuscarConductorFragment = new ResultadoBuscarConductorFragment();
                return resultadoBuscarConductorFragment;
        }

        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Tractora";
            case 1:
                return "Rígido";
            case 2:
                return "Cisterna";
            case 3:
                return "Conductor";
        }
        return "0";
    }
}

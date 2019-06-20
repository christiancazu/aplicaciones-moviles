package com.utp.app;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        // needed implement fragments interfaces until android api 23
        implements
                FragmentOne.OnFragmentInteractionListener,
                FragmentTwo.OnFragmentInteractionListener {

    FragmentOne fragmentOne;
    FragmentTwo fragmentTwo;
    FrameLayout flFragmentContainer;
    // FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flFragmentContainer = findViewById(R.id.fl_fragment_container);

        fragmentOne = new FragmentOne();

        setSelectedFragment(fragmentOne);

        // fragmentTransaction = getSupportFragmentManager().beginTransaction();
    }

    public void switchFragment(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                setSelectedFragment(fragmentOne);
                break;
            case R.id.btn_two:
                if (fragmentTwo == null) fragmentTwo = new FragmentTwo();
                setSelectedFragment(fragmentTwo);
                break;
        }
    }

    private void setSelectedFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(flFragmentContainer.getId(), fragment)
                .commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

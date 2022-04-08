package com.example.bse5a_lab_fragsimple;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements LeftFragment.FragmentLeftCommInterface {
    private LeftFragment leftFragment;
    private RightFragment rightFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int orientation = getResources().getConfiguration().orientation;

        if(orientation== Configuration.ORIENTATION_LANDSCAPE){
            FragmentManager fragmentManager = getSupportFragmentManager();
            leftFragment = (LeftFragment) fragmentManager.findFragmentById(R.id.fragmentContainerViewLeft);
            rightFragment = (RightFragment) fragmentManager.findFragmentById(R.id.fragmentContainerViewRight);
        }
    }

    @Override
    public void sendMessage(String message) {
        rightFragment.getMessage(message);
    }
}
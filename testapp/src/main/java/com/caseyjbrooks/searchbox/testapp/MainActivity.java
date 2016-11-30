package com.caseyjbrooks.searchbox.testapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.caseyjbrooks.androidclog.AndroidClog;
import com.caseyjbrooks.clog.Clog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Clog.setCurrentProfile("dev", AndroidClog.getDevelopmentClog());

        Fragment fragment = BlankFragment.getInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, fragment)
                .commit();
    }
}

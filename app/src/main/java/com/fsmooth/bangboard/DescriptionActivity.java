package com.fsmooth.bangboard;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import fragments.Description;

/**
 * Created by fonsi on 22/01/17.
 */

public class DescriptionActivity extends AppCompatActivity{

    Description description;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        description = (Description) getSupportFragmentManager()
                        .findFragmentById(R.id.frgDescription);
        description.showDescription(getIntent().getStringExtra("description"));
    }
}

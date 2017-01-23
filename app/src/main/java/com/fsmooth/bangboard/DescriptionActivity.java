package com.fsmooth.bangboard;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import fragments.Description;

/**
 * Created by fonsi on 22/01/17.
 */

public class DescriptionActivity extends AppCompatActivity{

    Description description;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Bundle bundle = getIntent().getExtras();

        description = (Description) getSupportFragmentManager()
                .findFragmentById(R.id.frgDescription);
        description.showDescription(bundle.getString("description"));
    }
}

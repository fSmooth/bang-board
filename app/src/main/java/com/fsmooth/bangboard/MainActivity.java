package com.fsmooth.bangboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    TabHost tabs;
    TabHost.TabSpec spec;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tabs = (TabHost) findViewById(android.R.id.tabhost);
        tabs.setup();

        spec = tabs.newTabSpec("tabCharacter");
        spec.setContent(R.id.tabCharacter);
        spec.setIndicator("",
                getResources().getDrawable(R.drawable.ic_character));
        tabs.addTab(spec);

        spec = tabs.newTabSpec("tabEquipment");
        spec.setContent(R.id.tabEquipment);
        spec.setIndicator("",
                getResources().getDrawable(R.drawable.ic_sword));
        tabs.addTab(spec);

        tabs.setCurrentTab(0);


    }
}

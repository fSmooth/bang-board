package com.fsmooth.bangboard;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.Toast;

import fragments.CharacterList;
import fragments.Description;

public class MainActivity extends AppCompatActivity
        implements CharacterList.CharacterListener {

    TabHost tabs;
    TabHost.TabSpec spec;
    CharacterList frgCharacterList;
    String description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // tabs
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


        // fragments
        frgCharacterList = (CharacterList) getSupportFragmentManager()
                .findFragmentById(R.id.frgCharacterList);

        frgCharacterList.setCharacterListener(this);


    }

    @Override
    public void onCharacterSeleccionado(Character c) {
        description = c.getDescription();

        if (hasDescription()) {
            ((Description) getSupportFragmentManager()
                    .findFragmentById(R.id.frgDescription)).showDescription(c.getDescription());

        } else {
            Intent i = new Intent(this, DescriptionActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("description", c.getDescription());
            i.putExtras(bundle);
            startActivity(i);
        }
    }

    /**
     * Método que comprueba si el layou actual contiene un fragment de descripción.
     *
     * @return boolean
     */
    private boolean hasDescription() {
        boolean has = false;

        if (getSupportFragmentManager().findFragmentById(R.id.frgDescription) != null)
            has = true;

        return has;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "v1.0", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("description", description);
        super.onSaveInstanceState(outState);


    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        description = savedInstanceState.getString("description");

        if (hasDescription()) {
            ((Description) getSupportFragmentManager()
                    .findFragmentById(R.id.frgDescription)).showDescription(savedInstanceState.getString("description"));

        }

    }
}

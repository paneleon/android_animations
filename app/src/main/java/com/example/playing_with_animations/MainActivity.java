package com.example.playing_with_animations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // list view
        ListView mainMenu = findViewById(R.id.main_menu_options);
        // get options from resources
        String[] mainMenuOptions = getResources().getStringArray(R.array.menu_options);

        //set adapter to use options
        mainMenu.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mainMenuOptions));

        // set event listener on choosing items
        mainMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onListItemClick(parent, view, position, id);
            }
        });
    }

    // event handler for clicking on one of the options in list view
    public void onListItemClick(AdapterView<?> parent, View view, int position, long id){
        Intent intent = null;
        // create respective intents
        switch (position)
        {
            case 0:
                intent = new Intent(this, FramedAnimationActivity.class);
                break;
            case 1:
                intent = new Intent(this, TweenAnimationActivity.class);
                break;
            case 2:
                intent = new Intent(this, DrawingActivity.class);
                break;
        }
        // start activity
        startActivity(intent);

    }
}
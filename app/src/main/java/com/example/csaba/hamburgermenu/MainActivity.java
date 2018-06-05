package com.example.csaba.hamburgermenu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


/**
 * (1) Build a blank SettingsActivity.
 * <p>
 * Step 1: Add Strings to strings.xml
 * Step 2: Create the SettingsActivity
 * Create java file
 * Create xml file
 * Add in Android Manifest
 * (2) Add Menu in the app bar of the EarthquakeActivity
 * <p>
 * Step 3: Setup the Menu xml file
 * Step 4: Setup the Menu item in the mainactivity
 * Add onCreateOptionsMenu to put Options Menu in app bar
 * Add onOptionsItemSelected method that specifies to open the SettingsActivity when the user selects the Options Menu
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**this sharedpreferences brings the value from the hamburger menu settings*/
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);

        // getString retrieves a String value from the preferences. The second parameter is the default value for this preference.
        String newNumber = sharedPrefs.getString(
                getString(R.string.settings_key),
                getString(R.string.settings_default));

        TextView text = (TextView) findViewById(R.id.hello);
        text.setText(newNumber);
    }

    @Override
    // This method initialize the contents of the Activity's options menu
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    // This method is called whenever an item in the options menu is selected.
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent settingsIntent = new Intent(this, SettingsActivity.class);
            startActivity(settingsIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

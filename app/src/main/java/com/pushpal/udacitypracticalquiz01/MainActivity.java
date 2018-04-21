package com.pushpal.udacitypracticalquiz01;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";
    public static final String About = "aboutKey";
    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String DESCRIPTION = "description";
    Toolbar toolbar;
    EditText name, email, about;
    AppCompatButton next;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        name = findViewById(R.id.et_username);
        email = findViewById(R.id.et_email);
        about = findViewById(R.id.et_write_about_yourself);
        next = findViewById(R.id.btn_next);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(NAME))
                name.setText(savedInstanceState.getString(NAME));
            if (savedInstanceState.containsKey(EMAIL))
                email.setText(savedInstanceState.getString(EMAIL));
            if (savedInstanceState.containsKey(DESCRIPTION))
                about.setText(savedInstanceState.getString(DESCRIPTION));
        }

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(Name, name.getText().toString());
                editor.putString(Email, email.getText().toString());
                editor.putString(About, about.getText().toString());
                editor.apply();

                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_profile:
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(Name, name.getText().toString());
                editor.putString(Email, email.getText().toString());
                editor.putString(About, about.getText().toString());
                editor.apply();

                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(NAME, name.getText().toString());
        outState.putString(EMAIL, email.getText().toString());
        outState.putString(DESCRIPTION, about.getText().toString());
    }
}
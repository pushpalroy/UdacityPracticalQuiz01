package com.pushpal.udacitypracticalquiz01;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static com.pushpal.udacitypracticalquiz01.MainActivity.About;
import static com.pushpal.udacitypracticalquiz01.MainActivity.Email;
import static com.pushpal.udacitypracticalquiz01.MainActivity.MyPREFERENCES;
import static com.pushpal.udacitypracticalquiz01.MainActivity.Name;

public class DetailsActivity extends AppCompatActivity {

    TextView name, email, about;
    de.hdodenhof.circleimageview.CircleImageView civProfilePicture;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        name = findViewById(R.id.tv_name);
        email = findViewById(R.id.tv_email);
        about = findViewById(R.id.tv_description);
        civProfilePicture = findViewById(R.id.iv_logo);
        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        Glide.with(this)
                .load(R.drawable.profile_picture)
                .into(civProfilePicture);

        name.setText(sharedPreferences.getString(Name, ""));
        email.setText(sharedPreferences.getString(Email, ""));
        about.setText(sharedPreferences.getString(About, ""));
    }
}

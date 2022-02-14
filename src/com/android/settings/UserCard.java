package com.android.settings;

import android.content.Context;
import android.content.Intent;

import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.View;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.R;

import com.android.settings.core.BasePreferenceController;
import androidx.preference.PreferenceScreen;
import com.android.settingslib.widget.LayoutPreference;


import androidx.appcompat.app.AppCompatActivity;


import com.google.android.material.card.MaterialCardView;

import java.io.FileNotFoundException;


public class UserCard extends BasePreferenceController  {

    Context context;

    public UserCard(Context context, String key) {
        super(context, key);
        this.context = context;
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }


    @Override
    public void displayPreference(PreferenceScreen screen) {
        super.displayPreference(screen);
        LayoutPreference mPreference = screen.findPreference("top_level_usercard");
        onBindItems(mPreference.findViewById(R.id.card_root));
    }


    public void onBindItems(View holder) {

        View root = holder;
        final Intent intent = new Intent(Intent.ACTION_MAIN)
                .setClassName(
                        "com.android.settings", "com.android.settings.Settings$UserCardFActivity");
        FrameLayout ln = root.findViewById(R.id.owclick);
        ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(intent);
            }


        });
        final Intent intent2 = new Intent(Intent.ACTION_MAIN)
                .setClassName(
                        "com.android.settings", "com.android.settings.Settings$OctaviLabActivity");
        MaterialCardView mc = root.findViewById(R.id.oclab);

        mc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(intent2);
            }


        });
        MaterialCardView mo = root.findViewById(R.id.ocota);
        final Intent intent3 = new Intent(Intent.ACTION_MAIN)
                .setClassName(
                        "apps.octavi.ota", "apps.octavi.ota.MainActivity");

        mo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(intent3);
            }


        });
        ImageView iv = root.findViewById(R.id.userimg);
        String path = context.getSharedPreferences("image_path", Context.MODE_PRIVATE).getString("image_path", "");

            try {
                iv.setImageBitmap(BitmapFactory.decodeStream(context.getContentResolver().openInputStream(Uri.parse(path))));
            } catch (FileNotFoundException e) {
                iv.setImageResource(R.drawable.user);
            }




    }

}

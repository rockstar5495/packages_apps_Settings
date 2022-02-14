package com.android.settings;

import android.content.Intent;
import android.os.Build;
import android.os.SystemProperties;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import com.android.settings.core.BasePreferenceController;
import androidx.preference.PreferenceScreen;
import com.android.settingslib.widget.LayoutPreference;

import android.os.Bundle;
import android.os.StatFs;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.card.MaterialCardView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Objects;


public class OosAboutPreference extends BasePreferenceController implements View.OnTouchListener {

    Context context;

    public OosAboutPreference(Context context, String key) {
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
        LayoutPreference mPreference = screen.findPreference("pref_layout_octavi_about");
        onBindItems(mPreference.findViewById(R.id.oos_about_root));
    }


    public void onBindItems(View holder) {

        View root = holder;



        TextView tw = root.findViewById(R.id.model);
        tw.setText(Build.MODEL);
        tw = root.findViewById(R.id.board);
        tw.setText(android.os.Build.DEVICE.toString());
        tw = root.findViewById(R.id.patch);
        tw.setText(getSystemProperty("ro.build.version.security_patch"));
        tw = root.findViewById(R.id.cpu);
        tw.setText(getCpuInfo());
        tw = root.findViewById(R.id.memory);
        String ram = String.valueOf(Math.round(Float.parseFloat(getTotalMemory().toLowerCase().replace("kb","").replace("memtotal:",""))/ 1000000));
        String storage = String.valueOf(Math.round(Float.parseFloat(getTotalInternalStorage())));
        tw.setText(ram+"GB | "+storage +" GB ");
        TextView tws = root.findViewById(R.id.battery);
        tws.setText(getBatteryCapacity(context)+" mAh");
        String res = "";
        tws = root.findViewById(R.id.kernel);
        tws.setText(getkernel());

        TextView bsb= root.findViewById(R.id.baseband);
        bsb.setText(Build.getRadioVersion());

        tws = root.findViewById(R.id.selinux);

        tws.setText(isSeLinuxEnforcing());

        tws = root.findViewById(R.id.version);
        tws.setText(getSystemProperty("ro.octavi.build.version"));


        TextView maintainer = root.findViewById(R.id.maintainer);
        maintainer.setText(getSystemProperty("ro.octavi.maintainer"));
        MaterialCardView mc = root.findViewById(R.id.maincard);
        mc.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(context,getSystemProperty("ro.octavi.maintainer"),Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        tws = root.findViewById(R.id.cam);
        if (Objects.equals(getSystemProperty("ro.octavi.hw.cam"),"")){
            tws.setText("Undefined");

        }else {
            tws.setText(Html.fromHtml(getSystemProperty("ro.octavi.hw.cam").split("\\|")[0].replace(":","<br>").replace(","," | ")));
        }

        tws=root.findViewById(R.id.namecpu);
        if(Objects.equals(getSystemProperty("ro.octavi.hw.cpu"),"")){
            tws.setText("Undefined");
        }else{
            tws.setText(Html.fromHtml(getSystemProperty("ro.octavi.hw.cpu").split("\\|")[1]));
        }
        if(!getSystemProperty("ro.octavi.buildtype").toLowerCase(Locale.ROOT).equals("official")){
            ImageView i = root.findViewById(R.id.vic);
            i.setImageResource(R.drawable.unverified);
        }





        try {
            // MyApplication.java is main application class
            int width= context.getResources().getDisplayMetrics().widthPixels;
            res+=String.valueOf(width)+"x";
            int height=  context.getResources().getDisplayMetrics().heightPixels;
            res+=String.valueOf(height);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            DisplayMetrics metrics =  context.getResources().getDisplayMetrics();
            int densityDpi = (int)(metrics.density * 160f);

            res+=" | \n"+String.valueOf(densityDpi)+" dpi";
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        tw = root.findViewById(R.id.res);
        tw.setText(res);

        final Intent intent = new Intent(Intent.ACTION_MAIN)
                .setClassName(
                        "android", com.android.internal.app.PlatLogoActivity.class.getName());

        MaterialCardView androidversion = root.findViewById(R.id.a12);

        androidversion.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                try {
                    context.startActivity(intent);
                    return true;
                } catch (Exception ignored) {
                }
                return false;
            }
        });

    }


    public static String getSystemProperty(String key) {
        String value = null;

        try {
            value = (String) Class.forName("android.os.SystemProperties")
                    .getMethod("get", String.class).invoke(null, key);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }
    public static String getTotalInternalStorage() {
        StatFs stat = new StatFs(Environment.getDataDirectory().getPath());
        long bytesAvailable = (long)stat.getBlockSize() *(long)stat.getBlockCount();
        double totalInt = bytesAvailable / 1048576000f;
        int total = 0;
        if (totalInt > 0 && totalInt < 17)
            total = 16;
        else if (totalInt > 16 && totalInt < 33)
            total = 32;
        else if (totalInt > 32 && totalInt < 65)
            total = 64;
        else if (totalInt > 64 && totalInt < 129)
            total = 128;
        else if (totalInt > 128 && totalInt < 257)
            total = 256;
        else if (totalInt > 256 && totalInt < 513)
            total = 512;
        return String.valueOf(total);
    }

    @SuppressWarnings("deprecation")
    public static String getTotalExternalStorage() {
        StatFs stat = new StatFs(Environment.getDataDirectory().getPath());
        long bytesAvailable = (long)stat.getBlockSize() *(long)stat.getBlockCount();
        float megAvailable = bytesAvailable / 1048576000f;

        float internal = megAvailable;

        stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
        bytesAvailable = (long)stat.getBlockSize() *(long)stat.getBlockCount();
        megAvailable = bytesAvailable / 1048576000f;

        float external = megAvailable;
        if(internal != external && Math.abs(internal - external) != 0.1 && external != 0)
            return String.format(Locale.getDefault(), "%.3f GB", megAvailable);
        return "not available";
    }

    public static String getCpuInfo() {
        try {


            Process proc = Runtime.getRuntime().exec("cat /proc/cpuinfo");
            InputStream is = proc.getInputStream();
            String[] listMemory = getStringFromInputStream(is).split("\n");

            for(int i = 0 ; i < listMemory.length ; i++) {
                if(listMemory[i].contains("Qualcomm"))
                    return listMemory[i].replace("Hardware\t: ","").replace("Qualcomm Technologies, Inc ","");
                else if (listMemory[i].contains("model name"))
                    return listMemory[i].replace("model name\t: ","");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return "unknown";
    }
    public static String getStringFromInputStream(InputStream is) {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = null;

        try {
            while((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
    public static String getTotalMemory() {
        try {
            Process proc = Runtime.getRuntime().exec("cat /proc/meminfo");
            InputStream is = proc.getInputStream();
            String[] listMemory = getStringFromInputStream(is).split("\n");
            for(int i = 0 ; i < listMemory.length ; i++) {
                if(listMemory[i].contains("MemTotal"))
                    return listMemory[i];
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return "unknown";
    }


    public static String isSeLinuxEnforcing() {
        StringBuffer output = new StringBuffer();
        Process p;
        try {
            p = Runtime.getRuntime().exec("getenforce");
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line);
            }
        } catch (Exception e) {
            // If getenforce is not available to the device, assume the device is not enforcing
            e.printStackTrace();
            return "Permissive";
        }
        String response = output.toString();
        if ("Enforcing".equals(response)) {
            return "Enforcing";
        } else if ("Permissive".equals(response)) {
            return "Permissive";
        } else {
            return "Permissive";
        }

    }
    public static int getBatteryCapacity(Context context) {
        Object mPowerProfile;
        double batteryCapacity = 0;
        final String POWER_PROFILE_CLASS = "com.android.internal.os.PowerProfile";

        try {
            mPowerProfile = Class.forName(POWER_PROFILE_CLASS)
                    .getConstructor(Context.class)
                    .newInstance(context);

            batteryCapacity = (double) Class
                    .forName(POWER_PROFILE_CLASS)
                    .getMethod("getBatteryCapacity")
                    .invoke(mPowerProfile);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return (int) batteryCapacity;

    }
    public static String getkernel(){
        try {
            Process proc =Runtime.getRuntime().exec("uname -r");
            InputStream is = proc.getInputStream();
            String size = getStringFromInputStream(is);
            return size;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Failed to get kernelinfo";
    }
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View v, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
            v.animate().scaleX(.97f).setDuration(300).start();
            v.animate().scaleY(.97f).setDuration(300).start();
            return true;
        } else if (action == MotionEvent.ACTION_UP) {
            v.animate().cancel();
            v.animate().scaleX(1f).setDuration(500).start();
            v.animate().scaleY(1f).setDuration(500).start();
            return true;
        }
        return false;
    }
}

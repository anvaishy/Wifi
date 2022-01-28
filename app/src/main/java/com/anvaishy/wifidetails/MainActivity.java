package com.anvaishy.wifidetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView rs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rs=findViewById(R.id.rssi);
        rs.setText("RSSI:-"+getWifiStrengthPercentage(MainActivity.this)+"%");
    }
    public static double getWifiStrengthPercentage(Context context)
    {
        try
        {
            WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
            int rssi = wifiManager.getConnectionInfo().getRssi();
            double level = wifiManager.calculateSignalLevel(rssi,100);
            double percentage =((level/10.0)*10);
            return percentage;
        }
        catch (Exception e)
        {
            return 0.0F;
        }
    }
    public void reset(View view) {
        rs=findViewById(R.id.rssi);
        rs.setText("RSSI:-"+getWifiStrengthPercentage(MainActivity.this)+"%");
    }
}
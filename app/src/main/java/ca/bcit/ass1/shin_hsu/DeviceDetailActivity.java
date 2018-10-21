package ca.bcit.ass1.shin_hsu;

import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DeviceDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_detail);

        //let activity display device details
        String manufacturer = android.os.Build.MANUFACTURER;
        String model = android.os.Build.MODEL;
        int version = android.os.Build.VERSION.SDK_INT;
        String versionRelease = android.os.Build.VERSION.RELEASE;
        String deviceId = Settings.System.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        String messageText = "Manufacturer: " + manufacturer
                + " \nModel: " + model
                + " \nVersion: " + version
                + " \nVersionRelease: " + versionRelease
                + " \nSerial number: " + deviceId;
        TextView details = findViewById(R.id.device_details);
        details.setText(messageText);
    }
}

package com.example.b.a23_location;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Geocoder geocoder;
    int REQUEST_PERMISSIONS = 100;
    LocationListener listener;
    LocationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);

        geocoder = new Geocoder(MainActivity.this);

        manager = (LocationManager) getSystemService(LOCATION_SERVICE);
        List<String> providers = manager.getAllProviders();
        String str = "";
        for (int i = 0; i < providers.size(); i++) {
            str += "provider : " + providers.get(i) + " state : " +
                    manager.isProviderEnabled(providers.get(i)) + "\n";
        }
        textView.setText(str);
        listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                String str = "lat : " + location.getLatitude() +
                        " lon : " + location.getLongitude() + "\n";
                textView.append(str);

                try {
                    List<Address> list = geocoder.getFromLocation(location.getLatitude(),
                            location.getLongitude(), 10);
                    Address address = list.get(0);
                    textView.append(address.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(
                        new String[]{
                                Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.READ_EXTERNAL_STORAGE
                        },
                        REQUEST_PERMISSIONS);
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }else{
                manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
                manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, listener);
            }
        }else {
            manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
            manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, listener);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_PERMISSIONS){
            for(int i=0; i<permissions.length; i++){
                if(permissions[i].equals(Manifest.permission.ACCESS_FINE_LOCATION)){
                    if(grantResults[i] != PackageManager.PERMISSION_GRANTED){
                        // deny
                        Toast.makeText(MainActivity.this, "Setting ...",Toast.LENGTH_LONG).show();
                    }else{
                        // allow
                        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
                        manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, listener);
                    }
                }else if(permissions[i].equals(Manifest.permission.READ_EXTERNAL_STORAGE)){
                    if(grantResults[i] != PackageManager.PERMISSION_GRANTED){
                        // deny
                    }else{
                        // allow
                    }
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}

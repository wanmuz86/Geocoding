package com.itrainasia.geocoding;

import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText addressLocation, lat, lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void searchAddress(View view) throws IOException {
        addressLocation = (EditText) findViewById(R.id.editText1);
        String locationName = addressLocation.getText().toString();
		/*
		 * Instantiate our Geocoder class and pass in the context
		 */
        Geocoder geocoder = new Geocoder(this);
        List<Address> addresses = geocoder.getFromLocationName(locationName, 1);
        Address addNew = addresses.get(0);

        double lat = addNew.getLatitude();
        double lon = addNew.getLongitude();

        String locality = addNew.getLocality();

        Toast.makeText(this,
                locality + " Latitude:" + lat + " Longitude:" + lon,
                Toast.LENGTH_SHORT).show();
    }

    public void searchCoordinate(View v) throws IOException {
        lat = (EditText) findViewById(R.id.editText2);
        lon = (EditText) findViewById(R.id.editText3);
        String latitude = lat.getText().toString();
        String longitude = lon.getText().toString();

        Geocoder gc = new Geocoder(this);

        List<Address> list = gc.getFromLocation(Double.valueOf(latitude),
                Double.valueOf(longitude), 1);

        Address address = list.get(0);

        StringBuffer str = new StringBuffer();
        str.append("Name: " + address.getLocality() + "\n");
        str.append("State: " + address.getAdminArea() + "\n");
        str.append("Country: " + address.getCountryName() + "\n");
        str.append("Country Code: " + address.getCountryCode() + "\n");

        String strAddress = str.toString();

        Toast.makeText(this, strAddress, Toast.LENGTH_SHORT).show();
    }
}

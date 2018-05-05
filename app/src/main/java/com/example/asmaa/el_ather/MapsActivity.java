package com.example.asmaa.el_ather;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu., menu);
//        return true;


//
// FragmentActivity implements OnMapReadyCallback {
//
//    private GoogleMap mMap;
//    private MarkerOptions options = new MarkerOptions();
//    private static final int MAP_ZOOM = 14;
//    public final static int MAP_PERMISSION_REQUEST = 1;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.activity_maps);
//        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
//    }
//
//
//    /**
//     * Manipulates the map once available.
//     * This callback is triggered when the map is ready to be used.
//     * This is where we can add markers or lines, add listeners or move the camera. In this case,
//     * we just add a marker near Sydney, Australia.
//     * If Google Play services is not installed on the device, the user will be prompted to install
//     * it inside the SupportMapFragment. This method will only be triggered once the user has
//     * installed Google Play services and returned to the app.
//     */
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//
////        // Add a marker in Sydney and move the camera
////        LatLng comp = new LatLng(26.9060999, 30.8768375);
////        mMap.addMarker(new MarkerOptions().position(comp).title("Marker in comp"));
////        mMap.moveCamera(CameraUpdateFactory.newLatLng(comp));
////        mMap.setMapType(googleMap.MAP_TYPE_SATELLITE);
////        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(comp,12));
//
//
//
//
//        LatLng latLng = new LatLng(26.9060999, 30.8768375);
//        options.position(latLng);
//        options.title("Hassen Hassen Amer El Kamash\n" +
//                "Shabin Al-Kum, Al Minufiyah, Egypt");
//        mMap.addMarker(options);
//
//        CameraPosition cameraPosition = new CameraPosition.Builder()
//                .target(latLng)
//                .zoom(MAP_ZOOM)
//                .bearing(0)
//                .tilt(0)
//                .build();
//        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
//
//    }
    }}


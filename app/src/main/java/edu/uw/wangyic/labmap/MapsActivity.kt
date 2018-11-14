package edu.uw.wangyic.labmap

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.GoogleMapOptions
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.PolylineOptions
import com.google.android.gms.maps.model.Polyline








class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val options = GoogleMapOptions()

        // Add a marker in Sydney and move the camera
        val uwFountain = LatLng(47.653846, -122.307835)

        val marker = mMap.addMarker(
            MarkerOptions()
                .position(uwFountain)
                .title("UW Fountain")
                .snippet("duck!!!!")
                .icon(BitmapDescriptorFactory.defaultMarker(260.toFloat()))
        )

        mMap.moveCamera(CameraUpdateFactory.newLatLng(uwFountain))

        val rectOptions = PolylineOptions()
            .add(LatLng(47.653846, -122.307835))
            .add(LatLng(47.653746, -122.307735))  // North of the previous point, but at the same longitude
            .add(LatLng(47.653846, -122.307635))  // Same latitude, and 30km to the west
            .add(LatLng(47.653746, -122.307535))  // Same longitude, and 16km to the south
            .add(LatLng(47.653846, -122.307435)) // Closes the polyline.
            .color(Color.parseColor("#4b2e83"))
        val polyline = mMap.addPolyline(rectOptions)
    }


}

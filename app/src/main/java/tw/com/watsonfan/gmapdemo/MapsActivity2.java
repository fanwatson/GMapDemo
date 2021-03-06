package tw.com.watsonfan.gmapdemo;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import tw.com.watsonfan.gmapdemo.databinding.ActivityMaps2Binding;

public class MapsActivity2 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMaps2Binding binding;

    private LatLng area1 = new LatLng(24.134469,120.6825714); //台中肉員
    private LatLng area2 = new LatLng(24.1378257,120.6835178); //醉月樓
    private LatLng area3 = new LatLng(24.1320321,120.6858532); //陳明統爌肉飯
    private LatLng area4 = new LatLng(24.1466117,120.6540152); //饕之鄉





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMaps2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //顯示地圖樣式
        //MAP_TYPE_NORMAL   基本地圖
        // MAP_TYPE_SATELLITE  衛星地圖
        //  MAP_TYPE_HYBRID  道路及標籤的衛星地圖

        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);



        //標示物件
        MarkerOptions markerOptions = new MarkerOptions();
        //標示圖片物件
        BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.mipmap.food);

        markerOptions.position(area1).title("台中肉員").snippet("超級好吃，湯Good").icon(bitmapDescriptor);

        mMap.addMarker(markerOptions);


        mMap.addMarker(new MarkerOptions().position(area2).title("醉月樓").snippet("宮原眼科二樓").icon(BitmapDescriptorFactory.fromResource(R.mipmap.food)));

        mMap.addMarker(new MarkerOptions().position(area3).title("陳明統"));

        mMap.addMarker(new MarkerOptions().position(area4).title("饕之鄉").snippet("平價鼎泰豐").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));


        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(area1,16);
        mMap.moveCamera(cameraUpdate);


    }
}
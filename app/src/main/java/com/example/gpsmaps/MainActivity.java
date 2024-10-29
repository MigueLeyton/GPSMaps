package com.example.gpsmaps;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final int PERMISSION_REQUEST_CODE = 100;
    private GoogleMap mapView;
    private FusedLocationProviderClient locationProvider;

    // Simulación de un token de autenticación
    private String authToken = "Bearer some_jwt_token"; // Debe ser obtenido de un servidor en un caso real

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicialización del fragmento del mapa
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // Inicialización del proveedor de ubicación
        locationProvider = LocationServices.getFusedLocationProviderClient(this);
        requestLocationPermission();

        // Ejemplo de uso de cifrado para datos sensibles
        encryptExampleData();

        // Realizar una solicitud de red (ejemplo)
        makeNetworkRequest();
    }

    // Método para encriptar datos sensibles
    private void encryptExampleData() {
        try {
            // Texto de ejemplo para cifrar
            String textToEncrypt = "Datos confidenciales";

            // Encriptar el texto
            byte[] encryptedData = EncryptionUtil.encryptData(textToEncrypt);

            // Convertir los datos encriptados a una cadena Base64 para visualizar (opcional)
            String encryptedDataString = Base64.encodeToString(encryptedData, Base64.DEFAULT);
            Log.d("EncryptedData", "Datos encriptados: " + encryptedDataString);

        } catch (Exception e) {
            Log.e("EncryptionError", "Error en la encriptación", e);
        }
    }

    private void requestLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSION_REQUEST_CODE);
        } else {
            getCurrentUserLocation();
        }
    }

    private void getCurrentUserLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            return; // Si no se tienen los permisos, no continuar
        }

        // Obtención de la última ubicación conocida
        locationProvider.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    LatLng userLocation = new LatLng(location.getLatitude(), location.getLongitude());
                    mapView.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation, 15));
                    mapView.addMarker(new MarkerOptions().position(userLocation).title("Ubicación actual"));
                }
            }
        });
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mapView = googleMap;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mapView.setMyLocationEnabled(true);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getCurrentUserLocation();
            } else {
                Toast.makeText(this, "Permiso de ubicación denegado", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Método para realizar una solicitud de red usando HTTPS
    private void makeNetworkRequest() {
        // Aquí utilizarías una biblioteca como Retrofit o Volley para hacer la solicitud HTTPS
        String url = "https://example.com/api/data"; // Asegúrate de usar HTTPS

        // Ejemplo de cómo incluir el token de autorización en un encabezado
        // Código para hacer la solicitud debería ir aquí
        Log.d("NetworkRequest", "Haciendo solicitud a: " + url);
        Log.d("NetworkRequest", "Token de autorización: " + authToken);
    }
}

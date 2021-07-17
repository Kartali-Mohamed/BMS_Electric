package com.example.appclub;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity2 extends AppCompatActivity {

    private EditText edNomID , edPrenomID , edEmail2ID , edPass2ID ;
    private TextView txtLoc , txtRetour;
    private Button buLoc , buSave;
    private FusedLocationProviderClient fusedLocationProviderClient ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Find All
        {
            edNomID = findViewById(R.id.edNomID);
            edPrenomID = findViewById(R.id.edPrenomID);
            edEmail2ID = findViewById(R.id.edEmail2ID);
            edPass2ID = findViewById(R.id.edPass2ID);
            txtLoc = findViewById(R.id.txtLocID);
            buLoc = findViewById(R.id.buLocID);
            buSave = findViewById(R.id.buSaveID);
            txtRetour = findViewById(R.id.txtRetourID);
        }

        // Listener de Button Location
        {
            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

            buLoc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (PackageManager.PERMISSION_GRANTED == getApplicationContext().checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)) {

                            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                                @Override
                                public void onSuccess(Location location) {
                                    if (location != null) {
                                        txtLoc.setText(location.getLatitude() + " , " + location.getLongitude());
                                        Toast.makeText(MainActivity2.this, "Success", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                        } else {
                            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
                        }

                    }
                }
            });
        }

        // Listener de button Enregistrer
        {
            buSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    startActivity(intent);
                }
            });
        }
        // Listener de Text Retour
        {
           txtRetour.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent intent = new Intent(MainActivity2.this , MainActivity.class);
                   startActivity(intent);
               }
           });
        }
    }
}
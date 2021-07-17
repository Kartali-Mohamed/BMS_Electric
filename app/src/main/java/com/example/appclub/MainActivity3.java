package com.example.appclub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.appclub.Adepter.AdepterProduit;
import com.example.appclub.Model.ModelProduit;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    private List<ModelProduit> produitList ;
    private RecyclerView recyclerView ;
    private AdepterProduit adepterProduit;
    private ImageView imgExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        imgExit = findViewById(R.id.imgExitID);

        imgExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity3.this);
                builder.setTitle("Confirm Exit");
                builder.setMessage("Are you sure, you want to exit !!");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });

        recyclerView = findViewById(R.id.recyclerID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        produitList = new ArrayList<>();

        produitList.add(new ModelProduit("Simple prise" , "1000" , R.drawable.prise_simple));
        produitList.add(new ModelProduit("Simple prise" , "1000" , R.drawable.prise_simple));
        produitList.add(new ModelProduit("Simple prise" , "1000" , R.drawable.prise_simple));
        produitList.add(new ModelProduit("Simple prise" , "1000" , R.drawable.prise_simple));
        produitList.add(new ModelProduit("Simple prise" , "1000" , R.drawable.prise_simple));
        produitList.add(new ModelProduit("Simple prise" , "1000" , R.drawable.prise_simple));

        adepterProduit = new AdepterProduit(this, produitList);
        recyclerView.setAdapter(adepterProduit);
        adepterProduit.notifyDataSetChanged();

    }
}
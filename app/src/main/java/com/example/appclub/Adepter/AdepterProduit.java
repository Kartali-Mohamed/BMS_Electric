package com.example.appclub.Adepter;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appclub.MainActivity;
import com.example.appclub.Model.ModelProduit;
import com.example.appclub.R;



import java.util.List;

import static com.example.appclub.R.layout.click_layout;

public class AdepterProduit extends RecyclerView.Adapter<AdepterProduit.MyViewHolder> {

    private List<ModelProduit> listProd;
    private Context context;

    public AdepterProduit(Context context ,List<ModelProduit> listProd) {
        this.listProd = listProd;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View prodView = LayoutInflater.from(parent.getContext()).inflate(R.layout.liste_produit_layout ,parent, false);
        return new MyViewHolder(prodView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ModelProduit modelProduit = listProd.get(position);
        holder.txtNom1.setText(modelProduit.getNomProd());
        holder.txtNbr1.setText(modelProduit.getNbrProd());
        holder.imgProd1.setImageResource(modelProduit.getImgProd());
    }

    @Override
    public int getItemCount() {
        return listProd.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView txtNom1 , txtNbr1 ;
        private ImageView imgProd1 ,imgEdit;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNom1 = itemView.findViewById(R.id.txtNomProdID);
            txtNbr1 = itemView.findViewById(R.id.txtNbrProdID);
            imgProd1 = itemView.findViewById(R.id.imgProdID);
            imgEdit = itemView.findViewById(R.id.imgEditID);
            
            imgEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    ModelProduit item = listProd.get(position);

                    View v = LayoutInflater.from(context).inflate(R.layout.click_layout,null , false);
                    final AlertDialog dialog ;
                    AlertDialog.Builder builder ;
                    builder = new AlertDialog.Builder(context);
                    builder.setView(v);
                    dialog =builder.create();

                    Button buAnnuler , buPlus , buMoins ;
                    final EditText edNbrMod ;

                    edNbrMod = v.findViewById(R.id.edNbrModID);
                    buAnnuler = v.findViewById(R.id.buAnnulerID);
                    buPlus = v.findViewById(R.id.buPlusID);
                    buMoins = v.findViewById(R.id.buMoinsID);

                    buPlus.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int x = Integer.parseInt(txtNbr1.getText().toString()) + Integer.parseInt(edNbrMod.getText().toString());
                            txtNbr1.setText(String.valueOf(x));
                            dialog.dismiss();
                        }
                    });

                    buMoins.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int x = Integer.parseInt(txtNbr1.getText().toString()) - Integer.parseInt(edNbrMod.getText().toString());
                            txtNbr1.setText(String.valueOf(x));
                            dialog.dismiss();
                        }
                    });

                    buAnnuler.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });


                    dialog.show();

                }

            });
        }


    }




}

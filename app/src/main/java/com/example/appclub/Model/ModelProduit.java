package com.example.appclub.Model;

import android.widget.TextView;

public class ModelProduit {
    private String nomProd , nbrProd;
    private int imgProd;

    public ModelProduit(String nomProd, String nbrProd, int imgProd) {
        this.nomProd = nomProd;
        this.nbrProd = nbrProd;
        this.imgProd = imgProd;
    }


    public String getNomProd() {
        return nomProd;
    }

    public void setNomProd(String nomProd) {
        this.nomProd = nomProd;
    }

    public String getNbrProd() {
        return nbrProd;
    }

    public void setNbrProd(String nbrProd) {
        this.nbrProd = nbrProd;
    }

    public int getImgProd() {
        return imgProd;
    }

    public void setImgProd(int imgProd) {
        this.imgProd = imgProd;
    }
}

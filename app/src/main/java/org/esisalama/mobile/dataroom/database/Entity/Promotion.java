package org.esisalama.mobile.dataroom.database.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

//creation de la table promotion
@Entity
public class Promotion {
    @PrimaryKey public int id;
    public String nom;

    public Promotion(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Promotion() {
    }

}

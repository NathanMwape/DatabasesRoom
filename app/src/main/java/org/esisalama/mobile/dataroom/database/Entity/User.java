package org.esisalama.mobile.dataroom.database.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

//creation de  table user qui aura les champs suivants(create Entity)
//(tableName = "user_tab") personnaliser le nom de la table,
//primaryKeys = {"id","matricule"}// Deux Cles etrangeres
//(autoGenerate = true) champs auto Increment
//DAO Contient toutes les requetes de labase de donnees
//@ColumnInfo(name = "Nom_User")  instruction premettant de pesonnaliser la colonne

@Entity
public class User {
    @PrimaryKey(autoGenerate = true) public int id;
    public String nom;
    public String postNom;
    public String email;
    public String matricule;

    //constructeur de la classe user avec les champs suivants : id, nom, postNom, email, matricule
    public User() {
    }

    public User(int id,String nom, String postNom, String email, String matricule) {
        this.id = id;
        this.nom = nom;
        this.postNom = postNom;
        this.email = email;
        this.matricule = matricule;
    }
}

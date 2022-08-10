package org.esisalama.mobile.dataroom.database.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

//create table etudiant_promotion (id integer primary key autoincrement, idEtudiant integer, idPromotion integer);
@Entity
public class Etudiant {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String nom;
    public String matricule;
    public int idPromotion;

    public Etudiant() {}

    public Etudiant(int id, String nom, String matricule, int idprom) {
        this.id = id;
        this.nom = nom;
        this.matricule = matricule;
        this.idPromotion = idprom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
}

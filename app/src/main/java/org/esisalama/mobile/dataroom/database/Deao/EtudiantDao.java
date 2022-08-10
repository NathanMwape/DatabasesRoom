package org.esisalama.mobile.dataroom.database.Deao;

import androidx.room.Dao;
import androidx.room.Insert;

import org.esisalama.mobile.database.database.Entity.Etudiant;

@Dao
public interface EtudiantDao {
    @Insert
    void insertEtudiant(Etudiant etudiant);
}

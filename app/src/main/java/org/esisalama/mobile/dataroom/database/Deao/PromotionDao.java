package org.esisalama.mobile.dataroom.database.Deao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import org.esisalama.mobile.database.database.Entity.EtudiantPromotion;
import org.esisalama.mobile.database.database.Entity.Promotion;

import java.util.List;

@Dao
public interface PromotionDao {
    @Insert
    void insert(Promotion promotion);

    @Query("SELECT * FROM Promotion")
    List<Promotion> findAll();

    @Transaction
    @Query("SELECT * FROM Promotion")
    List<EtudiantPromotion> findPromotionEtudiant();
}

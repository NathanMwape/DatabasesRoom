package org.esisalama.mobile.dataroom.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import org.esisalama.mobile.dataroom.database.Deao.UserDeo;
import org.esisalama.mobile.dataroom.database.Entity.Etudiant;
import org.esisalama.mobile.dataroom.database.Entity.Promotion;
import org.esisalama.mobile.dataroom.database.Entity.User;
import org.esisalama.mobile.dataroom.database.Deao.EtudiantDao;
import org.esisalama.mobile.dataroom.database.Deao.PromotionDao;

@Database(
        entities = {User.class, Etudiant.class, Promotion.class},
        version = 1
)
//
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDeo userDeo();
    public abstract EtudiantDao etudiantDao();
    public abstract PromotionDao promotionDao();


}

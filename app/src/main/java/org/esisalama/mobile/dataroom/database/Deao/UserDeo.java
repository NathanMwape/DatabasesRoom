package org.esisalama.mobile.dataroom.database.Deao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import org.esisalama.mobile.dataroom.database.Entity.User;

import java.util.List;

//creation de DOA permert de faire des requetes dans la base
//création de la classe UserDeo qui hérite de la classe DAO
@Dao
public interface UserDeo {
    //requete pour recuperer tous les users
    @Insert
    void inserAll(List<User> user);
    //requete pour recuperer un user par son id


    //requete pour recuperer tous les users
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);
    //insert into User values(id,nom,postnom,)

    //requete pour mettre a jour un user
    @Update
    void update(User user);
    //update User set nom = nom, postnom = postnom, matricule = matricule where id = id
    //requete pour supprimer un user
    @Delete
    void delete(User user);
    //delete from User where id = id

    //requete pour recuperer tous les users
    @Query("SELECT * FROM User WHERE id = :id")
    User findOne(int id);
    //select * from User where id = id

    //@Query("select * from User order by id ASC LIMIT 10")
    @Query("SELECT * FROM User")
    List<User> findAll();
}

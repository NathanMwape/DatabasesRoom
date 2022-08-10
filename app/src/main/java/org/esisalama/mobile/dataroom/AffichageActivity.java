package org.esisalama.mobile.dataroom;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import org.esisalama.mobile.dataroom.database.AppDatabase;
import org.esisalama.mobile.dataroom.database.Deao.UserDeo;
import org.esisalama.mobile.dataroom.database.Entity.User;

import java.util.List;

public class AffichageActivity extends AppCompatActivity {


    private TextView textViewList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage);
        affichageEtudiant();
        getSupportActionBar().hide();

    }

    //affichage des etudiants
    private void affichageEtudiant(){
        textViewList = findViewById(R.id.TextViewList);
        AppDatabase db = Room
                .databaseBuilder(this,
                        AppDatabase.class, "database-name")
                .allowMainThreadQueries()
                .build();
        UserDeo userDeo = db.userDeo();
        List<User> users;
        users = userDeo.findAll();
        StringBuilder stringBuilder = new StringBuilder();
        for (User s : users){
            stringBuilder.append(s.id);
            stringBuilder.append( ". " +s.nom );
            stringBuilder.append( " "+s.postNom );
            stringBuilder.append( " " +s.matricule );
            stringBuilder.append("\n");
        }
        textViewList.setText(stringBuilder);
    }


}
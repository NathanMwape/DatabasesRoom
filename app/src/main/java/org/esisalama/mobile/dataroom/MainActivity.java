package org.esisalama.mobile.dataroom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;



//        Promotion g2SI = new Promotion(2,"G2SI");
//        promotionDao.insert(g2SI);
//
//        Etudiant etudiant1 = new Etudiant(2,"Nome","1234",2);
//        etudiantDao.insertEtudiant(etudiant1);
//fIN
//        List<EtudiantPromotion> data = promotionDao.findPromotionEtudiant();
//        for (EtudiantPromotion etud: data){
//            Log.e("esis", etud.etudiant.nom + " " + etud.promotion.nom);
//        }


//requete d'insertion
import org.esisalama.mobile.dataroom.database.AppDatabase;
import org.esisalama.mobile.dataroom.database.Deao.EtudiantDao;
import org.esisalama.mobile.dataroom.database.Deao.PromotionDao;
import org.esisalama.mobile.dataroom.database.Deao.UserDeo;
import org.esisalama.mobile.dataroom.database.Entity.User;
import org.esisalama.mobile.dataroom.database.Entity.Etudiant;
import org.esisalama.mobile.dataroom.database.Entity.EtudiantPromotion;
import org.esisalama.mobile.dataroom.database.Entity.Promotion;
import org.esisalama.mobile.dataroom.database.Entity.User;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNom;
    private EditText editTextPostnom;
    private EditText editTextEmail;
    private EditText editTextMatricule;
    private Button buttonInsertion;
    private Button buttonAfficher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialisation();
        validationForm();
        affichage();
    }

    //initialisation des composants
    private void  initialisation(){
        editTextNom = findViewById(R.id.EdiTextNom);
        editTextPostnom = findViewById(R.id.EdiTextPostNom);
        editTextEmail = findViewById(R.id.EdiTextEmail);
        editTextMatricule = findViewById(R.id.EdiTextMatricule);
        buttonInsertion = findViewById(R.id.btnInsertion);
        buttonAfficher = findViewById(R.id.btnAfficher);
    }
    //validation du formulaire
    private void  validationForm(){
        buttonInsertion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = editTextNom.getText().toString();
                String postnom = editTextPostnom.getText().toString();
                String email = editTextEmail.getText().toString();
                String matricule = editTextMatricule.getText().toString();
                if (nom.isEmpty() && postnom.isEmpty() && email.isEmpty() && matricule.isEmpty()){
                    Toast.makeText(MainActivity.this,"Veiller renseigner tous le champ",Toast.LENGTH_LONG).show();
                }else if (nom.isEmpty()){
                    Toast.makeText(MainActivity.this,"le champs nom doit etre remplis",Toast.LENGTH_LONG).show();
                }else if (postnom.isEmpty()){
                    Toast.makeText(MainActivity.this,"le champs Postnom doit etre remplis",Toast.LENGTH_LONG).show();
                }else if (email.isEmpty()){
                    Toast.makeText(MainActivity.this,"le champs Email doit etre remplis",Toast.LENGTH_LONG).show();
                }else if (matricule.isEmpty()){
                    Toast.makeText(MainActivity.this,"le champs Matricule doit etre remplis",Toast.LENGTH_LONG).show();
                }else {
                    insertion(nom,postnom,email,matricule);
                }
            }
        });

    }


    //affichage des etudiants
    private void affichage(){
        AppDatabase db = Room
                .databaseBuilder(this,
                        AppDatabase.class, "database-name")
                .allowMainThreadQueries()
                .build();

        buttonAfficher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AffichageActivity.class);
                startActivity(intent);
            }
        });
    }
    //insertion dans la base de données
    private void insertion(String nom,String postnom,String email,String matricule){
        User user = new User(0,nom,postnom,email,matricule);

        AppDatabase db = Room
                .databaseBuilder(this,
                AppDatabase.class, "database-name")
                .allowMainThreadQueries()
                .build();
        UserDeo userDeo = db.userDeo();

        //recuperation de dao
        PromotionDao promotionDao = db.promotionDao();
        EtudiantDao etudiantDao = db.etudiantDao();

//        Promotion g2SI = new Promotion(1,"G2SI");
//        promotionDao.insert(g2SI);
//
//        Etudiant etudiant1 = new Etudiant(1,"Nome","1234",1);
//        etudiantDao.insertEtudiant(etudiant1);
        userDeo.insert(user);
        //requette d'insertion
        User bdUser = userDeo.findOne(1);

        Toast.makeText(MainActivity.this,user.nom,Toast.LENGTH_LONG).show();
        Toast.makeText(MainActivity.this,user.matricule,Toast.LENGTH_LONG).show();

        StringBuilder string = new StringBuilder();
        string.append("bonjour\n");
        string.append("salut !");

        String chaine = string.toString();

    }
}
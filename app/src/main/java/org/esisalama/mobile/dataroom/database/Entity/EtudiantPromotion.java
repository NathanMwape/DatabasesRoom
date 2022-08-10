package org.esisalama.mobile.dataroom.database.Entity;

import androidx.room.Embedded;
import androidx.room.Relation;

//
public class EtudiantPromotion {
    @Embedded
    public Promotion promotion;
    //
    @Relation(
            parentColumn = "id",
            entityColumn = "idPromotion"
    )
    public Etudiant etudiant;
    
}

package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;

@DatabaseTable(tableName = "avion")
public class Avion {

    @DatabaseField(columnName = "id", canBeNull = false, generatedId = true)
   private int id;
    @DatabaseField(columnName = POLJE_OZNAKA, canBeNull = false)
   private String oznaka;
    @DatabaseField(columnName = POLJE_RASPONKRILA, canBeNull = false)
   private int rasponKrila;
    @ForeignCollectionField
    ArrayList<Roba> roba;

   static final String POLJE_OZNAKA ="oznaka";
   static final String POLJE_RASPONKRILA ="raspon krila";

    public Avion() {
    }

    public Avion(String oznaka, int rasponKrila) {
        this.oznaka = oznaka;
        this.rasponKrila = rasponKrila;
    }

    @Override
    public String toString() {
        System.out.println("ID: " + id + "Oznaka: " + oznaka + "Raspon Krila: " + rasponKrila);
        return super.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public int getRasponKrila() {
        return rasponKrila;
    }

    public void setRasponKrila(int rasponKrila) {
        this.rasponKrila = rasponKrila;
    }

    public ArrayList<Roba> getRoba() {
        return roba;
    }

    public void setRoba(ArrayList<Roba> roba) {
        this.roba = roba;
    }
}

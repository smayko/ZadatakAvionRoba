package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "roba")
public class Roba {

    @DatabaseField(canBeNull = false, generatedId = true)
   private int id;
    @DatabaseField (columnName = POLJE_NAZIV, canBeNull = false)
   private String naziv;
    @DatabaseField(columnName = POLJE_OPIS, canBeNull = false)
   private String opis;
    @DatabaseField(columnName = POLJE_TEZINA, canBeNull = false)
   private double tezina;
    @DatabaseField(foreign = true)
    private Avion avion;

   static final String POLJE_NAZIV = "";
   static final String POLJE_OPIS = "";
   static final String POLJE_TEZINA = "";

    public Roba() {
    }

    public Roba(String naziv, String opis, double tezina) {
        this.naziv = naziv;
        this.opis = opis;
        this.tezina = tezina;
    }

    @Override
    public String toString() {
        System.out.println("ID: " + id + "Naziv:"+naziv+ "Opis " +opis+"Tezina: " + tezina);
        return super.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public double getTezina() {
        return tezina;
    }

    public void setTezina(double tezina) {
        this.tezina = tezina;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }
}

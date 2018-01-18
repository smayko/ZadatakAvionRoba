package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Avion;
import model.Roba;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Zadatak2DodavanjeVrednosti {
    public static void main(String[] args) {
        try {
            ConnectionSource connectionSource = new JdbcConnectionSource(Konstante.DATABASE);

            Avion avion1 = new Avion("Avion1", 34);
            Avion avion2 = new Avion("Avion2", 21);

            Dao<Avion, Integer> avionDao = DaoManager.createDao(connectionSource, Avion.class);

            avionDao.create(avion1);
            avionDao.create(avion2);


            Roba patike = new Roba("patike", "Duboke patike", 1);
            Roba kosulja = new Roba("kosulja", "Na duge rukave", 0.4);
            Roba voda = new Roba("voda", "voda za pice", 1.4);
            Roba ploce = new Roba("ploce", "Drvene ploce", 3.4);
            Roba stolica = new Roba("stolica", "plasticna stolica", 2.4);

            Dao<Roba, Integer> robaDao = DaoManager.createDao(connectionSource, Roba.class);
            robaDao.create(patike);
            robaDao.create(kosulja);
            robaDao.create(voda);
            robaDao.create(ploce);
            robaDao.create(stolica);


           List<Avion> avioni = avionDao.queryForAll();
           for(Avion a : avioni){
               System.out.println(a.getId()+" " +a.getOznaka() + " " + a.getRasponKrila());
           }

            List<Roba> roba = robaDao.queryForAll();
            for(Roba r : roba){
                System.out.println(r.getId()+" " +r.getNaziv() +"  "+r.getOpis() );
            }


            try {
                connectionSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

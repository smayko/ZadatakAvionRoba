package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Roba;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Zadatak3IzmenaVrednosti {
    public static void main(String[] args) {
        try {
            ConnectionSource connectionSource = new JdbcConnectionSource(Konstante.DATABASE);

            Dao<Roba, Integer> robaDao = DaoManager.createDao(connectionSource, Roba.class);

          List<Roba> roba = robaDao.queryForAll();
          for(Roba r : roba){
              System.out.println("ID: " + r.getId() + "Opis: " + r.getOpis()+ " naziv: " +r.getNaziv());
              if(r.getOpis().equals("plasticna stolica")) {
                  r.setOpis("Drvena Stolica");
                  robaDao.update(r);
              }
          }


            List<Roba> robaizmenjena = robaDao.queryForAll();
            for(Roba r : robaizmenjena){
                System.out.println("ID: " + r.getId() + "Opis: " + r.getOpis()+ " naziv: " +r.getNaziv());

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

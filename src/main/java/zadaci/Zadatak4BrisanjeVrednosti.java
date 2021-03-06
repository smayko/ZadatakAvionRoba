package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Roba;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Zadatak4BrisanjeVrednosti {
    public static void main(String[] args) {

        try {
            ConnectionSource connectionSource = new JdbcConnectionSource(Konstante.DATABASE);


            Dao<Roba, Integer> robaDao = DaoManager.createDao(connectionSource, Roba.class);

            List<Roba> roba = robaDao.queryForAll();
            for(Roba r : roba){
                if(r.getNaziv().equals("voda")){
                    robaDao.delete(r);
                }
            }

            List<Roba> robaIzmenjena = robaDao.queryForAll();
            for(Roba r : robaIzmenjena){
                System.out.println("ID: " + r.getId() +"naziv" + r.getNaziv()+"opsi: "+ r.getOpis());
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

package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Avion;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AvionNit extends Thread {

    static boolean dozvoljenoSletanje;
    Avion avion;
    Object o = new Object();

    public AvionNit(Avion a) {
        avion = a;
    }

    @Override
    public void run() {
        System.out.println("Pocinju pripreme za avion: " + avion.getId());
        synchronized (o) {
            try {
                sleep((int) Math.random() * 2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (dozvoljenoSletanje) {
                System.out.println(avion.getId() + " se sprema za poletanje!");
            }

            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Avion je poleteo " + avion.getId());
        }
    }

    public static void main(String[] args) {

        List<Avion> avioni = null;
        try {
            ConnectionSource con = new JdbcConnectionSource(Konstante.DATABASE);

            Dao<Avion, Integer> avionDao = DaoManager.createDao(con, Avion.class);

            avioni = avionDao.queryForAll();

            try {
                con.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        for (Avion a : avioni) {
            AvionNit nit = new AvionNit(a);
            nit.start();
        }

    }
}

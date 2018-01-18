package zadaci;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Avion;
import model.Roba;

import java.io.IOException;
import java.sql.SQLException;

public class Zadatak1KreiranjeTabela {
    public static void main(String[] args) {

        try {
            ConnectionSource connectionSource = new JdbcConnectionSource(Konstante.DATABASE);

            TableUtils.dropTable(connectionSource, Avion.class, true);
            TableUtils.dropTable(connectionSource, Roba.class, true);


            TableUtils.createTable(connectionSource, Roba.class);
            TableUtils.createTable(connectionSource, Avion.class);


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

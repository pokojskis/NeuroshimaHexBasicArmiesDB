package NeuroshimaHexDB.HeuroshimaHexDb;

import NeuroshimaHexDB.dao.JdbcCatalogFactory;
import NeuroshimaHexDB.dao.RepositoryCatalog;
import NeuroshimaHexDB.domain.Moloch;

public class App {

    public static void main(String[] args) {

        Moloch moloch1 = new Moloch();
        RepositoryCatalog workdb = new JdbcCatalogFactory().HsqlDbWorkDb();
        workdb.molochs().add(moloch1);
    }
}

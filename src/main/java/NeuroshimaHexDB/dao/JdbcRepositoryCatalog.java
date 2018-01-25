package NeuroshimaHexDB.dao;

import NeuroshimaHexDB.dao.mappers.BorgoResultMapper;
import NeuroshimaHexDB.dao.mappers.HegemoniaResultMapper;
import NeuroshimaHexDB.dao.mappers.MolochResultMapper;
import NeuroshimaHexDB.dao.mappers.PosterunekResultMapper;
import NeuroshimaHexDB.dao.uow.UnitOfWork;
import NeuroshimaHexDB.domain.Borgo;
import NeuroshimaHexDB.domain.Hegemonia;
import NeuroshimaHexDB.domain.Moloch;
import NeuroshimaHexDB.domain.Posterunek;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcRepositoryCatalog implements RepositoryCatalog {

    Connection connection;
    UnitOfWork uow;

    public JdbcRepositoryCatalog(Connection connection, UnitOfWork uow) {
        this.connection = connection;
        this.uow = uow;
    }

    public Repository<Moloch> molochs() {
        try {
            return new MolochRepository(connection, new MolochResultMapper(), uow);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Repository<Borgo> borgos() {
        try {
            return new BorgoRepository(connection, new BorgoResultMapper(),uow);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Repository<Hegemonia> hegemonie() {
        try {
            return new HegemoniaRepository(connection, new HegemoniaResultMapper(), uow);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Repository<Posterunek> posterunki() {
        try {
            return new PosterunekRepository(connection, new PosterunekResultMapper(), uow);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void saveChanges() {
        uow.saveChanges();
    }
}

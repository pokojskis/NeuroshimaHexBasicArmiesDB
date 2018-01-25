package NeuroshimaHexDB.dao;

import NeuroshimaHexDB.dao.mappers.ResultSetMapper;
import NeuroshimaHexDB.dao.uow.UnitOfWork;
import NeuroshimaHexDB.domain.Posterunek;

import java.sql.Connection;
import java.sql.SQLException;

public class PosterunekRepository extends SuperiorRepository<Posterunek> {

    public PosterunekRepository(Connection connection, ResultSetMapper<Posterunek> mapper, UnitOfWork uow) throws SQLException {
        super(connection, mapper, uow);
    }

    @Override
    protected String insertSql() {
        return "INSERT INTO posterunek (unit_name, initiative, primary_main_damage, attributes) VALUES (?, ?, ?, ?)";
    }

    @Override
    protected String updateSql() {
        return "UPDATE posterunek SET (unit_name, initiative, primary_main_damage, attributes) = (?, ?, ?, ?) WHERE id = ?";
    }

    @Override
    protected String deleteSql() {
        return "DELETE FROM posterunek WHERE id = ?";
    }

    @Override
    protected String selectAllSql() {
        return "SELECT * FROM posterunek";
    }

    @Override
    protected String tableName() {
        return "posterunek";
    }

    @Override
    protected String createTableSql() {
        return "CREATE TABLE posterunek("
                + "id INT GENERATED BY DEFAULT AS IDENTITY,"
                + "unit_name VARCHAR(30),"
                + "initiative INT(1),"
                + "primary_main_damage INT(1),"
                + "attributes VARCHAR(50)"
                + ")";
    }

    @Override
    protected void setupInsert(Posterunek posterunek) throws SQLException {
        insert.setString(1, posterunek.getUnit_name());
        insert.setInt(2, posterunek.getInitiative());
        insert.setInt(3, posterunek.getPrimary_main_damage());
        insert.setString(4, posterunek.getAttributes());
    }

    @Override
    protected void setUpdate(Posterunek posterunek) throws SQLException {
        update.setString(1, posterunek.getUnit_name());
        update.setInt(2, posterunek.getInitiative());
        update.setInt(3, posterunek.getPrimary_main_damage());
        update.setString(4, posterunek.getAttributes());
        update.setInt(5, posterunek.getId());
    }
}
package NeuroshimaHexDB.dao;

import NeuroshimaHexDB.dao.mappers.ResultSetMapper;
import NeuroshimaHexDB.dao.uow.Entity;
import NeuroshimaHexDB.dao.uow.UnitOfWork;
import NeuroshimaHexDB.dao.uow.UnitOfWorkRepository;
import NeuroshimaHexDB.domain.IHaveId;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class SuperiorRepository<TEntity extends IHaveId> implements Repository<TEntity>, UnitOfWorkRepository {

    protected Connection connection;
    protected Statement createTable;
    protected PreparedStatement insert;
    protected PreparedStatement selectAll;
    protected PreparedStatement update;
    protected PreparedStatement delete;
    ResultSetMapper<TEntity> mapper;
    UnitOfWork uow;

    protected SuperiorRepository(Connection connection, ResultSetMapper<TEntity> mapper, UnitOfWork uow) throws SQLException {
        this.mapper = mapper;
        this.connection = connection;
        this.uow = uow;
        createTable = connection.createStatement();
        createTable();
        insert = connection.prepareStatement(insertSql());
        update = connection.prepareStatement(updateSql());
        delete = connection.prepareStatement(deleteSql());
        selectAll = connection.prepareStatement(selectAllSql());
    }

    public void createTable() {
        try {
            ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
            boolean tableExists = false;
            while (rs.next()) {
                if (rs.getString("TABLE_NAME").equalsIgnoreCase(tableName())) {
                    tableExists = true;
                    break;
                }
            }
            if (!tableExists) {
                createTable.executeUpdate(createTableSql());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<TEntity> getAll() {
        List<TEntity> result = new ArrayList<TEntity>();
        try {
            ResultSet rs = selectAll.executeQuery();
            while (rs.next()) {
                result.add(mapper.map(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public void persistAdd(Entity entity) {
        try {
            setupInsert((TEntity)entity.getEntity());
            insert.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void persistUpdate(Entity entity) {
        try {
            setUpdate((TEntity)entity.getEntity());
            update.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void persistDelete(Entity entity) {
        try {
            delete.setInt(1, entity.getEntity().getId());
            delete.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void add(TEntity entity) {
        Entity ent = new Entity();
        ent.setEntity(entity);
        ent.setRepository(this);
        uow.markAsNew(ent);
    }

    public void update(TEntity entity) {
        Entity ent = new Entity();
        ent.setEntity(entity);
        uow.markAsChanged(ent);
    }

    public void delete(TEntity entity) {
        Entity ent = new Entity();
        ent.setEntity(entity);
        uow.markAsDeleted(ent);
    }

    protected abstract String insertSql();
    protected abstract String updateSql();
    protected abstract String deleteSql();
    protected abstract String selectAllSql();
    protected abstract String tableName();
    protected abstract String createTableSql();
    protected abstract void setupInsert(TEntity entity) throws SQLException;
    protected abstract void setUpdate(TEntity entity) throws SQLException;
}

package NeuroshimaHexDB.dao;

import NeuroshimaHexDB.domain.IHaveId;

import java.util.List;

public interface Repository<TEntity extends IHaveId> {

    public void delete(TEntity entity);
    public List<TEntity> getAll();
    public void add(TEntity entity);
    public void update(TEntity entity);
    public void createTable();

    // co z metodami add i update dla pozostalych tabel??
}

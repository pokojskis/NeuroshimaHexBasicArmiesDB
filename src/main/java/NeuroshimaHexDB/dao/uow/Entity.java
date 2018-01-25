package NeuroshimaHexDB.dao.uow;

import NeuroshimaHexDB.domain.IHaveId;

public class Entity {

    private IHaveId entity;
    private UnitOfWorkRepository repository;
    private EntityState state;

    public IHaveId getEntity() {
        return entity;
    }

    public void setEntity(IHaveId entity) {
        this.entity = entity;
    }

    public UnitOfWorkRepository getRepository() {
        return repository;
    }

    public void setRepository(UnitOfWorkRepository repository) {
        this.repository = repository;
    }

    public EntityState getState() {
        return state;
    }

    public void setState(EntityState state) {
        this.state = state;
    }

    public void persistChange() {
        switch (state) {
            case NEW:
                repository.persistAdd(this);
                break;
            case CHANGED:
                repository.persistUpdate(this);
                break;
            case DELETED:
                repository.persistDelete(this);
                break;
            default:
                break;
        }
    }
}

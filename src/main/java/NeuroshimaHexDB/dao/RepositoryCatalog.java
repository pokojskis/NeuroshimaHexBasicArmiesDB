package NeuroshimaHexDB.dao;

import NeuroshimaHexDB.domain.Borgo;
import NeuroshimaHexDB.domain.Hegemonia;
import NeuroshimaHexDB.domain.Moloch;
import NeuroshimaHexDB.domain.Posterunek;

public interface RepositoryCatalog {
    Repository<Moloch> molochs();

    Repository<Borgo> borgos();

    Repository<Hegemonia> hegemonie();

    Repository<Posterunek> posterunki();

    void saveChanges();
}

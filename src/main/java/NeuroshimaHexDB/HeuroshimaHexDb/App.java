package NeuroshimaHexDB.HeuroshimaHexDb;

import NeuroshimaHexDB.dao.JdbcCatalogFactory;
import NeuroshimaHexDB.dao.RepositoryCatalog;
import NeuroshimaHexDB.domain.Borgo;
import NeuroshimaHexDB.domain.Hegemonia;
import NeuroshimaHexDB.domain.Moloch;
import NeuroshimaHexDB.domain.Posterunek;

import java.util.List;

public class App {

    public static void main(String[] args) {

        Moloch moloch1 = new Moloch();
        moloch1.setUnit_name("Sztab");
        moloch1.setInitiative(0);
        moloch1.setAttributes("atak melee we wszystkich kierunkach");

//        Borgo borgo1 = new Borgo();
//        borgo1.setUnit_name("Mutek");
//        borgo1.setInitiative(2);
//        borgo1.setAttributes("atak melee w 3 kierunkach");

        Hegemonia hegemonia1 = new Hegemonia();
        hegemonia1.setUnit_name("Bydlak");
        hegemonia1.setInitiative(1);
        hegemonia1.setAttributes("atak meleee w 3 kierunkach, w tym jeden z sila 2");

        Posterunek posterunek1 = new Posterunek();
        posterunek1.setUnit_name("Pancerz wspomagany");
        posterunek1.setInitiative(3);
        posterunek1.setAttributes("Atak melee z sila 2, dodatkowa inicjatywa");

        RepositoryCatalog workdb = new JdbcCatalogFactory().HsqlDbWorkDb();

        workdb.molochs().add(moloch1);
//        workdb.borgos().add(borgo1);
        workdb.hegemonie().add(hegemonia1);
        workdb.posterunki().add(posterunek1);

        workdb.saveChanges();

        List<Moloch> molochz = workdb.molochs().getAll();
        for (Moloch m : molochz) {
            System.out.println(m.getId() + "\t" + m.getUnit_name() + "\t" + m.getInitiative() + "\t" + m.getAttributes());
        }

//        List<Borgo> borgoz = workdb.borgos().getAll();
//        for (Borgo b : borgoz) {
//            System.out.println(b.getId() + "\t" + b.getUnit_name() + "\t" + b.getInitiative() + "\t" + b.getAttributes());
//        }

        List<Hegemonia> hegemoniaz = workdb.hegemonie().getAll();
        for (Hegemonia h : hegemoniaz) {
            System.out.println(h.getId() + "\t" + h.getUnit_name() + "\t" + h.getInitiative() + "\t" + h.getAttributes());
        }

        List<Posterunek> posterunekz = workdb.posterunki().getAll();
        for (Posterunek p : posterunekz) {
            System.out.println(p.getId() + "\t" + p.getUnit_name() + "\t" + p.getInitiative() + "\t" + p.getAttributes());
        }
    }
}

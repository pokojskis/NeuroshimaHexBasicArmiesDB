package NeuroshimaHexDB.dao.mappers;

import NeuroshimaHexDB.domain.Posterunek;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PosterunekResultMapper implements ResultSetMapper<Posterunek> {

    public Posterunek map(ResultSet rs) throws SQLException {
        Posterunek posterunek = new Posterunek();
        posterunek.setId(rs.getInt("id"));
        posterunek.setUnit_name(rs.getString("unit_name"));
        posterunek.setInitiative(rs.getInt("initiative"));
        posterunek.setPrimary_main_damage(rs.getInt("primary_main_damage"));
        posterunek.setAttributes(rs.getString("attributes"));
        return posterunek;
    }
}

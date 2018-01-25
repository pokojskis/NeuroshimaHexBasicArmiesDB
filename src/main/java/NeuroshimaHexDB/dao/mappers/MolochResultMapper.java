package NeuroshimaHexDB.dao.mappers;

import NeuroshimaHexDB.domain.Moloch;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MolochResultMapper implements ResultSetMapper<Moloch> {

    public Moloch map(ResultSet rs) throws SQLException {
        Moloch moloch = new Moloch();
        moloch.setId(rs.getInt("id"));
        moloch.setUnit_name(rs.getString("unit_name"));
        moloch.setInitiative(rs.getInt("initiative"));
        moloch.setPrimary_main_damage(rs.getInt("primary_main_damage"));
        moloch.setAttributes(rs.getString("attributes"));
        return moloch;
    }
}

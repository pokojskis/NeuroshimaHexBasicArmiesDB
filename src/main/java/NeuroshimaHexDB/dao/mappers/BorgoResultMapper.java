package NeuroshimaHexDB.dao.mappers;

import NeuroshimaHexDB.domain.Borgo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BorgoResultMapper implements ResultSetMapper<Borgo> {

    public Borgo map(ResultSet rs) throws SQLException {
        Borgo borgo = new Borgo();
        borgo.setId(rs.getInt("id"));
        borgo.setUnit_name(rs.getString("unit_name"));
        borgo.setInitiative(rs.getInt("initiative"));
        borgo.setPrimary_main_damage(rs.getInt("primary_main_damage"));
        borgo.setAttributes(rs.getString("attributes"));
        return borgo;
    }
}

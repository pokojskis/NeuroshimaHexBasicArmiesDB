package NeuroshimaHexDB.dao.mappers;

import NeuroshimaHexDB.domain.Hegemonia;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HegemoniaResultMapper implements ResultSetMapper<Hegemonia> {

    public Hegemonia map(ResultSet rs) throws SQLException {
        Hegemonia hegemonia = new Hegemonia();
        hegemonia.setId(rs.getInt("id"));
        hegemonia.setUnit_name(rs.getString("unit_name"));
        hegemonia.setInitiative(rs.getInt("initiative"));
        hegemonia.setAttributes(rs.getString("attributes"));
        return hegemonia;
    }
}

package NeuroshimaHexDB.domain;

public class Posterunek implements IHaveId {

    private int id;
    private String unit_name;
    private int initiative;
    private int primary_main_damage;
    private String attributes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getPrimary_main_damage() {
        return primary_main_damage;
    }

    public void setPrimary_main_damage(int primary_main_damage) {
        this.primary_main_damage = primary_main_damage;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }
}

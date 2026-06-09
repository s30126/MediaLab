public abstract class Equipment implements Displayable {

    private String id;
    private String equipmentType;
    private String name;
    private double baseDailyPrice;
    private boolean available;

    public Equipment(String id, String equipmentType, String name, double baseDailyPrice) {
        this.id = id;
        this.equipmentType = equipmentType;
        this.name = name;
        this.baseDailyPrice = baseDailyPrice;
        this.available = true;
    }

    public String getId() {
        return id;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public String getName() {
        return name;
    }

    public double getBaseDailyPrice() {
        return baseDailyPrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public abstract double calculateDailyPrice();

    @Override
    public String getDisplayText() {
        return "Sprzęt " + getId() +
                " {nazwa: " + getName() +
                ", typ sprzętu: " + getEquipmentType() +
                ", cena za dzień: " + calculateDailyPrice() +
                ", dostępność: " + isAvailable() + "}";
    }

}

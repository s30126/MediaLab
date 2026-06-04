public class LaptopSet extends Equipment {

    private int ramGb;
    private boolean hasDockingStation;

    public LaptopSet(String id, String equipmentType, String name, double baseDailyPrice, int ramGb, boolean hasDockingStation) {
        super(id, equipmentType, name, baseDailyPrice);
        this.ramGb = ramGb;
        this.hasDockingStation = hasDockingStation;
    }

    @Override
    public double calculateDailyPrice() {
        double dailyPrice = getBaseDailyPrice();
        if (hasDockingStation) {
            dailyPrice += 15;
        }
        if (ramGb >= 32) {
            dailyPrice += 25;
        }
        return dailyPrice;
    }

}

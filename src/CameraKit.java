public class CameraKit extends Equipment {

    private int lensCount;
    private boolean hasTripod;

    public CameraKit(String id, String equipmentType, String name, double baseDailyPrice, int lensCount, boolean hasTripod) {
        super(id, equipmentType, name, baseDailyPrice);
        this.lensCount = lensCount;
        this.hasTripod = hasTripod;
    }

    @Override
    public double calculateDailyPrice() {
        double dailyPrice = getBaseDailyPrice() + 10 * lensCount;
        if (hasTripod) {
            dailyPrice += 15;
        }
        return dailyPrice;
    }

}

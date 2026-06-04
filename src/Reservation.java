public class Reservation implements Displayable {

    public String id;
    public Student student;
    public Equipment equipment;
    public int days;
    public ReservationStatus status;

    public double calculateTotalCost(DiscountPolicy discountPolicy) {
        double priceBeforeDiscount = equipment.calculateDailyPrice() * days;
        return discountPolicy.applyDiscount(student, priceBeforeDiscount);
    }

}
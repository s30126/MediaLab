public class Reservation implements Displayable {

    private int id;
    private Student student;
    private Equipment equipment;
    private int days;
    private ReservationStatus status;

    public Reservation(int id, Student student, Equipment equipment, int days, ReservationStatus status) {
        this.id = id;
        this.student = student;
        this.equipment = equipment;
        this.days = days;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public double calculateTotalCost(DiscountPolicy discountPolicy) {
        double priceBeforeDiscount = equipment.calculateDailyPrice() * days;
        return discountPolicy.applyDiscount(student, priceBeforeDiscount);
    }

    @Override
    public String getDisplayText() {
        return "Rezerwacja nr " + id +
                " {student: " + student.getFullName() +
                ", sprzęt: " + equipment.getName() +
                ", status: " + status + "}";
    }

}
import java.util.ArrayList;

public class ReservationService {
    private ArrayList<Equipment> equipment;
    private ArrayList<Student> students;
    private final DiscountPolicy discountPolicy;

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ReservationService(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public Reservation createReservation(String studentId, String equipmentId, int days) {
        // walidacja, znalezienie studenta, znalezienie sprzętu, utworzenie rezerwacji
        throw new UnsupportedOperationException("do zaimplementowania");
    }

    public void returnEquipment(String reservationId) {
        // zmiana statusu rezerwacji, odblokowanie sprzętu, dodanie punktów
    }
}
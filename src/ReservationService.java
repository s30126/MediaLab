import java.util.ArrayList;

public class ReservationService {
    private ArrayList<Equipment> equipment;
    private ArrayList<Student> students;
    private ArrayList<Reservation> reservations;
    private final DiscountPolicy discountPolicy;

    public ArrayList<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(ArrayList<Equipment> equipment) {
        this.equipment = equipment;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ReservationService(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;

        equipment = new ArrayList<>();
        students = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    private Student findStudent(String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    private Equipment findEquipment(String id) {
        for (Equipment e : equipment) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

    private Reservation findReservation(int id) {
        for (Reservation r : reservations) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    public Reservation createReservation(String studentId, String equipmentId, int days) {

        Student s = findStudent(studentId);
        if (s == null) {
            throw new IllegalArgumentException("Do utworzenia rezerwacji konieczne jest podanie prawidłowego id studenta.");
        }

        Equipment e = findEquipment(equipmentId);
        if (e == null) {
            throw new IllegalArgumentException("Do utworzenia rezerwacji konieczne jest podanie prawidłowego id sprzętu.");
        }
        if (e.isAvailable() == false) {
            throw new IllegalArgumentException("Wybrany sprzęt nie jest dostępny.");
        }

        if (days < 1 || days > 14) {
            throw new IllegalArgumentException("Liczba dni musi być z zakresu od 1 do 14");
        }

        int reservationId = reservations.size() + 1;

        Reservation r = new Reservation(reservationId, s, e, days, ReservationStatus.ACTIVE);

        e.setAvailable(false);

        reservations.add(r);

        double cost = r.calculateTotalCost(discountPolicy);

        System.out.println("Rezerwacja została utworzona. Numer rezerwacji: " + reservationId +
                ", koszt rezerwacji: " + cost + " zł.");

        return r;

    }

    public void returnEquipment(int reservationId) {

        Reservation r = findReservation(reservationId);
        if (r == null) {
            throw new IllegalArgumentException("Rezerwacja nie istnieje.");
        }
        if (r.getStatus() != ReservationStatus.ACTIVE) {
            throw new IllegalArgumentException("Wybrana rezerwacja nie jest aktywna.");
        }

        r.setStatus(ReservationStatus.RETURNED);

        r.getEquipment().setAvailable(true);

        int points = (int) (r.calculateTotalCost(discountPolicy) / 10);
        Student s = r.getStudent();
        s.setLoyaltyPoints(s.getLoyaltyPoints() + points);

        System.out.println("Zwrócono sprzęt. Student otrzymuje " + points + " pkt lojalnościowych.");

    }

    public void showActiveReservations() {
        System.out.println("Aktywne rezerwacje: ");
        for (Reservation r : reservations) {
            if (r.getStatus() == ReservationStatus.ACTIVE) {
                System.out.println(r.getDisplayText());
            }
        }
    }

    public void showReturnedReservations() {
        System.out.println("Zakończone rezerwacje: ");
        for (Reservation r : reservations) {
            if (r.getStatus() == ReservationStatus.RETURNED) {
                System.out.println(r.getDisplayText());
            }
        }
    }

    public void showRevenue() {

        double revenue = 0;

        for (Reservation r : reservations) {
            if (r.getStatus() == ReservationStatus.RETURNED) {
                revenue += r.calculateTotalCost(discountPolicy);
            }
        }

        System.out.println("Łączny przychód z zakończonych rezerwacji: " + revenue + " zł.");

    }

    public void showStudentWithMostPoints() {

        Student mostPoints = students.getFirst();

        for (Student s : students) {
            if (s.getLoyaltyPoints() > mostPoints.getLoyaltyPoints()) {
                mostPoints = s;
            }
        }

        System.out.println("Student z największą liczbą punktów lojalnościowych: " +
                mostPoints.getFullName() + " (" + mostPoints.getLoyaltyPoints() +
                " pkt).");

    }

    public void printReport() {
        System.out.println("RAPORT");
        showActiveReservations();
        showReturnedReservations();
        showRevenue();
        showStudentWithMostPoints();
    }



}
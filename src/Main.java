import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student("S001", "Anna Kowalska", "12c", 120);
        Student s2 = new Student("S002", "Marek Nowak", "12c", 40);
        Student s3 = new Student("S003", "Julia Zielińska", "13a", 0);

        Equipment e1 = new LaptopSet("E001", "LaptopSet", "Lenovo ThinkPad Lab", 80, 32, true);
        Equipment e2 = new LaptopSet("E002", "LaptopSet", "Dell XPS Demo", 100, 16, false);
        Equipment e3 = new CameraKit("E003", "CameraKit", "Sony Content Kit", 90, 3, true);
        Equipment e4 = new CameraKit("E004", "CameraKit", "Canon Interview Kit", 70, 1, true);

        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Equipment> equipment = new ArrayList<>();

        students.add(s1);
        students.add(s2);
        students.add(s3);

        equipment.add(e1);
        equipment.add(e2);
        equipment.add(e3);
        equipment.add(e4);

        ReservationService myService = new ReservationService(new LoyaltyDiscountPolicy());

        myService.setStudents(students);
        myService.setEquipment(equipment);

        Scanner scanner = new Scanner (System.in);

        int number;

        do {

            System.out.println("1. Wyświetl  sprzęt.");
            System.out.println("2. Utwórz rezerwację.");
            System.out.println("3. Zwróć sprzęt.");
            System.out.println("4. Pokaż aktywne rezerwacje.");
            System.out.println("5. Pokaż raport.");
            System.out.println("0. Zakończ.");

            System.out.println("Wybór: ");
            number = scanner.nextInt();
            scanner.nextLine();

            switch (number) {

                case 1:

                    for (Equipment e : myService.getEquipment()) {
                        System.out.println(e.getDisplayText());
                    }
                    break;

                case 2:

                    System.out.println("Podaj id studenta: ");
                    String studentId = scanner.nextLine();

                    System.out.println("Podaj id sprzętu: ");
                    String equipmentId = scanner.nextLine();

                    System.out.println("Podaj liczbę dni: ");
                    int days = scanner.nextInt();
                    scanner.nextLine();

                    Reservation r = myService.createReservation(studentId, equipmentId, days);

                    break;

                case 3:

                    System.out.println("Podaj id rezerwacji: ");
                    int reservationId = scanner.nextInt();
                    scanner.nextLine();

                    myService.returnEquipment(reservationId);

                case 4:

                    for (Reservation reservation : myService.getReservations()) {
                        if (reservation.getStatus() == ReservationStatus.ACTIVE) {
                            System.out.println(reservation.getDisplayText());
                        }
                    }
                    break;

                case 5:

                    myService.printReport();
                    break;

                case 0:

                    System.out.println("Dziękujemy za skorzystanie z serwisu!");
                    break;

                default:

                    System.out.println("Proszę wybrać jedną z dostępnych opcji.");

            }

        } while (number != 0);

    }
}

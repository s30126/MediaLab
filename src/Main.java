import java.util.ArrayList;

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

        e1.getDisplayText();


    }
}

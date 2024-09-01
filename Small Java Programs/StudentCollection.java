import java.util.ArrayList;
import java.util.Scanner;

public class StudentCollection {

    private static
    Scanner readInput = new Scanner(System.in);
    private static 
    ArrayList<Student> students = new ArrayList<Student>();

    public static 
    void main(String[] args) {
        for(int x = 0; x < 3; x++) {
            boolean status = students.add(solicitStudent());
            System.out.println("Added: " +status);
        }
        printStudents();

        while(true) {
            listener();
            printStudents();
        }
    }

    private static 
    Student solicitStudent() {

        System.out.print("Student Name: ");
        String name = readInput.next();
        name += readInput.nextLine();

        System.out.print("Student Age: ");
        int age = readInput.nextInt();

        return new Student(name, age);
    }

    private static
    void printStudents() {
        if(students.isEmpty()) {
            System.out.println("No Students To Display!");
        } else {
            setId();
            System.out.println("ID\tName\tAge");
            for(Student rep : students) {
                int id = rep.getId();
                String name = rep.name;
                int age = rep.age;
    
                System.out.printf(
                    "%d\t%s\t%s\n", id, name, age
                    );
    
            }
        }
    }

    private static 
    void setId() {
        int length = students.size();

        for(int x = 0; x < length; x++) {
            students
            .get(x)
            .setId((x + 1));
        }
    }

    // remove
    private static 
    void remove() {
        System.out.print("Id Of Student To Be Removed: ");
        int id = readInput.nextInt();

        Student removedStudent = students.remove((id -1));

        if(removedStudent != null) {
            String name = removedStudent.name;
            System.out.println("The student with name " +name +" is removed!");
        } else {
            System.out.println("Something went wrong!");
        }

        setId();
    }

    //update 
    private static
    void update() {
        System.out.println("Enter The Id Of Student To Be updated!");
        System.out.print("Student Id: ");
        int id = readInput.nextInt();

        System.out.println("Please Enter New Info For the student!");
        Student newstudent = solicitStudent();

        Student oldStudent = students.set((id - 1), newstudent);

        System.out.println("The student with name " +oldStudent.name +" is changed.");
    }

    //create
    private static
    void create() {
        System.out.println("Enter The Infos of the student!");
        Student newstudent = solicitStudent();
        boolean added = students.add(newstudent);

        if(added) {
            System.out.println("Successfully Added A new Student!");
        } else {
            System.out.println("Something Went Wrong!");
        }
    }

    private static 
    void listener() {
        System.out.println("\nDelete: 1, Update: 2, Create: 3");
        System.out.print("Enter Your Choise: ");
        int choise = readInput.nextInt();

        switch(choise) {
            case 1:
                remove();
                break;
            case 2: 
                update();
                break;
            case 3:
                create();
                break;
            default: 
                System.out.println("Option Out Of Range!");

        }
    }


}

class Student {
    private int id;
    public String name;
    public int age;

    public Student(String name, int age)  {
        this.name = name; 
        this.age = age;
    }

    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }
}
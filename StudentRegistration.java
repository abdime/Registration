import java.util.Scanner;

// The Person class is an abstract class that defines the basic attributes of a person
abstract class Person {
    private String firstName;
    private String lastName;
    private String ID;
    private int age;

    // The Person constructor initializes the attributes of a person
    public Person(String firstName, String lastName, String ID, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.age = age;
    }

    // The displayInfo method displays the information of a person
    public void displayInfo() {
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("ID: " + ID);
        System.out.println("Age: " + age);
    }
}

// The Student class extends the Person class and adds additional attributes and methods specific to a student
class Student extends Person {
    private String fieldOfStudy;
    private int year;
    private double currentCGPA;
    private int semester;

    // The Student constructor initializes the attributes of a student using the super constructor of the Person class
    public Student(String firstName, String lastName, String ID, int age, String fieldOfStudy, int year, double currentCGPA, int semester) {
        super(firstName, lastName, ID, age);
        this.fieldOfStudy = fieldOfStudy;
        this.year = year;
        this.currentCGPA = currentCGPA;
        this.semester = semester;
    }

    // The registerStudent method checks if a student is eligible to register for a specific year and semester
    public void registerStudent() {
        try {
            if (currentCGPA < 1.5) {
                throw new IllegalArgumentException("Your GPA should be greater than 1.5 to be registered");
            }
            if (year < 1 || year > 5 || semester < 1 || semester > 2) {
                throw new IllegalArgumentException("Invalid year or semester");
            }

            System.out.println("You are registered successfully for Year = " + year + " and semester = " + semester);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // The overridden displayInfo method displays the information of a student, in addition to the information of a person
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Field of Study: " + fieldOfStudy);
        System.out.println("Year: " + year);
        System.out.println("Current CGPA: " + currentCGPA);
        System.out.println("Semester: " + semester);
    }
}

// The Main class is the entry point of the program
class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get the basic information of a person
        System.out.println("Enter First Name: ");
        String firstName = input.nextLine();

        System.out.println("Enter Last Name: ");
        String lastName = input.nextLine();

        System.out.println("Enter ID: ");
        String ID = input.nextLine();

        System.out.println("Enter Age: ");
        int age = input.nextInt();

        input.nextLine(); // Consume the newline character

        // Get the additional information of a student
        System.out.println("Enter Field of Study: ");
        String fieldOfStudy = input.nextLine();

        System.out.println("Enter Year: ");
        int year;
        while (true) {
            try {
                year = input.nextInt();
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid year.");
                input.nextLine(); // Clear the invalid input
            }
        }

        System.out.println("Enter Current CGPA: ");
        double currentCGPA = input.nextDouble();

        System.out.println("Enter Semester: ");
        int semester;
        while (true) {
            try {
                semester = input.nextInt();
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid semester.");
                input.nextLine(); // Clear the invalid input
            }
        }

        // Create a Student object using the information provided by the user
        Person student = new Student(firstName, lastName, ID, age, fieldOfStudy, year, currentCGPA, semester);

        // Display the information of the student
        student.displayInfo();

        // Check if the person is actually a student and call the registerStudent method
        if (student instanceof Student) {
            ((Student) student).registerStudent();
        }
    }
}

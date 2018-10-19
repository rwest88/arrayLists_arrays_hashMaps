package functions;

import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class ConsoleIO {

  static HashMap<String, String> createStudent() {
    return new HashMap<String, String>();
  }

  static void promptUserAndSave(Scanner input, String attr, HashMap<String, String> student) {
    System.out.print(String.format("Please enter the student's %s. ", attr));
    if (attr.equals("address")) {
      input.nextLine();
      if (input.hasNextLine()) student.put(attr, input.nextLine());
    } else if (input.hasNext()) student.put(attr, input.next());
  }

  static void printStudent(HashMap<String, String> student) {
    System.out.println("");
    student.forEach((attr, value) -> {
      System.out.println(String.format("The student's %s is %s.", attr, value));
    });
    System.out.println("");
  }

  static void printStudents(ArrayList<HashMap<String, String>> students) {
    for (HashMap<String, String> _student : students) {
      System.out.println("");
      printStudent(_student);
    }
  }

  static Boolean confirm(Scanner input, String message) {
    String confirmation = "";
    System.out.print(String.format("%s (Y/N): ", message));
    if (input.hasNext()) confirmation = input.next();
    if (confirmation.equalsIgnoreCase("Y")) return true;
    return false;
  }

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    ArrayList<HashMap<String, String>> students = new ArrayList<>();

    while (true) {

      HashMap<String, String> student = createStudent();
      String[] attributes = {"first name", "middle initial", "last name", "address", "email", "phone number"};
      
      System.out.println("");

      for (String attr : attributes) promptUserAndSave(input, attr, student);
      
      printStudent(student);

      if (!confirm(input, "Does this look correct?")) {
        System.out.println("Try reentering the student's information.");
        continue;
      } else {
        students.add(student);
        if (confirm(input, "Would you like to add another student?")) {
          continue;
        } else {
          printStudents(students);
          break;
        }
      }
    }
  }
}

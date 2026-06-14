import java.util.Scanner;
import java.util.ArrayList;

public class GWACalculator {

    public static void enterCourses(Scanner sc, ArrayList<String> subjectNames, ArrayList<Integer> units, ArrayList<Double> grades){
        String coursesTaken;
        int courses = 0;
        System.out.println("Courses taken: ");
        
        coursesTaken = sc.nextLine().trim();
        courses = Integer.parseInt(coursesTaken);

        for (int i = 0; i < courses; i++){
            System.out.printf("Enter Course %d (COURSE:Grade:Units): ", i+1);
            String input = sc.nextLine().trim();
            String[] parts = input.split(":");
            if (parts.length == 3) {
                try {
                    double gradeVal = Double.parseDouble(parts[1]);
                    int unitsVal = Integer.parseInt(parts[2]);

                    subjectNames.add(parts[0].trim().toUpperCase());
                    units.add(unitsVal);
                    grades.add(gradeVal);

                    System.out.println("Successfully added!");
                } catch (NumberFormatException e) {
                    System.out.println("Error: Grade and Units must be valid numbers.");
                }
            } else{
                System.out.println("Invalid format. Please try again.");
            }
        }
    }

    public static void checkSubjects(ArrayList<String> subjectNames, ArrayList<Integer> units, ArrayList<Double> grades){
        if (subjectNames.isEmpty()) {
            System.out.println("You haven't taken any courses!");
            return;
        }

        System.out.println("\nSubject Name | Units | Grade");
        System.out.println("----------------------------");

        for (int i = 0; i < subjectNames.size(); i++){
            System.out.printf("%-15s | %5d | %.2f\n", subjectNames.get(i),units.get(i), grades.get(i));
        }
    }

    public static void calculateGWA(ArrayList<String> subjectNames, ArrayList<Integer> units, ArrayList<Double> grades){
        double totalWeightedGrade = 0.0;
        int totalUnits = 0;

        if (subjectNames.isEmpty()) {
            System.out.println("You haven't taken any courses!");
            return;
        }

        for (int i = 0; i < subjectNames.size(); i++) {
            double currentGrade = grades.get(i);
            int currentUnits = units.get(i);
            double weightedGrade = currentGrade * currentUnits;

            totalWeightedGrade += weightedGrade;
            totalUnits += currentUnits;
        }

        double gwa = totalWeightedGrade / totalUnits;
        System.out.printf("Your current GWA is %.2f.\n", gwa);

        if (gwa <= 1.25){
            System.out.println("You are on track for Summa Cum Laude!");
        } else if (gwa > 1.25 && gwa <= 1.45) {
            System.out.println("You are on track for Magna Cum Laude!");
        } else if (gwa > 1.45 && gwa <= 1.75) {
            System.out.println("You are on track for Cum Laude!");
        } else if (gwa > 1.75 && gwa <= 2.00) {
            System.out.println("You are on track for Honor Roll!");
        } else {
            System.out.println("You still have time to improve. You got this!");
        }
        
    }

    public static void editCourse(ArrayList<String> subjectNames, ArrayList<Integer> units, ArrayList<Double> grades, Scanner sc){
        String choiceStr;

        if (subjectNames.isEmpty()) {
            System.out.println("You have not taken any courses!");
            return;
        }

        checkSubjects(subjectNames, units, grades);

        System.out.println("Enter the number of the course to update: ");

        choiceStr = sc.nextLine().trim();
        int choice = Integer.parseInt(choiceStr);

        if (choice >= 1 && choice <= subjectNames.size()) {
            System.out.printf("Enter the new grade for %s", subjectNames.get(choice - 1));

            String newGradeStr = sc.nextLine().trim();
            double newGrade = Double.parseDouble(newGradeStr);

            grades.set(choice - 1, newGrade);
            System.out.println("Successfully updated!");
        } else {
            System.out.println("Invalid course number.");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choiceStr;
        int choice = 0;

        ArrayList<String> subjectNames = new ArrayList<>();
        ArrayList<Integer> units = new ArrayList<>();
        ArrayList<Double> grades = new ArrayList<>();

        do{
            System.out.println("\n========== GWA Calculator ==========");
            System.out.println("What would you like to do?");
            System.out.println("[1] Enter Courses");
            System.out.println("[2] Check Subjects Taken");
            System.out.println("[3] Calculate GWA");
            System.out.println("[4] Edit Course");
            System.out.println("[5] Exit");
            System.out.print("Enter choice: ");

            choiceStr = sc.nextLine().trim();

            try {
                choice = Integer.parseInt(choiceStr);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please choose a valid option.");
                choice = 0;
                continue;
            }

            switch (choice) {
                case 1: {
                    enterCourses(sc, subjectNames, units, grades);
                    break;
                }
                case 2: {
                    checkSubjects(subjectNames, units, grades);
                    break;
                }
                case 3: {
                    calculateGWA(subjectNames, units, grades);
                    break;
                }
                case 4: {
                    editCourse(subjectNames, units, grades, sc);
                    break;
                }
                case 5: {
                    System.out.println("Exiting.");
                    break;
                }
                default:
                    System.out.println("Please choose from one of the options.");
                    break;
            }
        } while (choice != 5);
    }
}
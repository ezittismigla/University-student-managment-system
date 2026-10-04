import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int maxarrays = 100; //Declares how many arrays array can store
        int option;
        String[] sname = new String[maxarrays]; //Array for student names
        String[] sid = new String[maxarrays]; //Array for student IDs

        int count = 0;
        int idcount = 0;

        while (true) { //Info for the student management system choices
            printMainMenu();

            if (isNotInt(scanner)) { //Makes sure that client does not use characters as input method
                continue;
            }

            option = scanner.nextInt();
            scanner.nextLine();
            Thread.sleep(500);

            switch (option) {
                case 1:
                    count = runModifierPanel(scanner, sname, sid, count, idcount);
                    break;

                case 2:
                    viewStudents(scanner, sname, sid, count);
                    break;

                case 0:
                    exitSystem();
                    return;

                default:
                    printChoiceNotExist();
                    break;
            }
        }
    }

    //Prints out divider lines for UI
    private static void printDivider() {
        System.out.println("---------------------------------");
    }

    //Prints error message when choice does not exist
    private static void printChoiceNotExist() {
        printDivider();
        System.out.println("     CHOICE DOES NOT EXIST!");
        printDivider();
    }

    //Outputs main menu choices
    public static void printMainMenu() {
        printDivider();
        System.out.println("    STUDENT MANAGEMENT SYSTEM");
        printDivider();
        System.out.println("    1.Add/modify student info");
        System.out.println("    2.View student info");
        System.out.println("    0.Exit");
        printDivider();
        System.out.print("Choice: ");
    }

    //Outputs modifier panel choices
    public static void printModifierMenu() {
        printDivider();
        System.out.println("   Student modifier panel");
        printDivider();
        System.out.println("      1.Add student name");
        System.out.println("      2.Add student course");
        System.out.println("      3.Delete student name");
        System.out.println("      4.Delete student course");
        System.out.println("      0.Exit");
        printDivider();
        System.out.print("Choice: ");
    }

    //Makes sure that client does not use characters as input method
    private static boolean isNotInt(Scanner scanner) throws InterruptedException {
        if (!scanner.hasNextInt()) { //Makes sure that client does not use characters as input method
            printDivider();
            System.out.println("        PLEASE USE NUMBER");
            printDivider();
            scanner.nextLine();
            Thread.sleep(500); //Waits 500ms until the next line executes, makes so the output is smoother
            return true;
        }
        return false;
    }

    //Handles student modifier panel choices
    private static int runModifierPanel(Scanner scanner, String[] sname, String[] sid, int count, int idcount) throws InterruptedException {
        while (true) {
            printModifierMenu();

            if (isNotInt(scanner)) { //Makes sure that client does not use characters as input method
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();
            Thread.sleep(500); //Waits 500ms until the next line executes, makes so the output is smoother

            if (choice == 0) { //Makes so you exit the loop
                break;
            }

            switch (choice) {
                case 1:
                    count = addStudentName(scanner, sname, count);
                    break;

                case 2:
                    idcount = addStudentCourse(scanner, sname, sid, count, idcount);
                    break;

                case 3: //Block to delete student name from array
                    count = deleteStudentName(scanner, sname, sid, count, idcount);
                    break;

                case 4: //Block to delete course from student
                    idcount = deleteStudentCourse(scanner, sname, sid, count, idcount);
                    break;

                default:
                    printChoiceNotExist();
                    break;
            }
        }
        return count;
    }

    //Block to add student name to array
    private static int addStudentName(Scanner scanner, String[] sname, int count) throws InterruptedException {
        printDivider();
        System.out.println("        1.Add student name");
        System.out.println("        0.Exit");
        printDivider();
        System.out.print("Choice: ");

        if (isNotInt(scanner)) { //Makes sure that client does not use characters as input method
            return count;
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 0) { //Makes so you exit
            return count;
        } else if (choice == 1) {
            printDivider();
            System.out.print("Student name: ");
            sname[count] = scanner.nextLine(); //Asks for student name array input
            count++; //Adds input to student array

            printDivider(); //Approves that the student has been added
            System.out.println("Student name has been registered!");
            printDivider();
            Thread.sleep(500); //Waits 500ms until the next line executes, makes so the output is smoother
        } else {
            printChoiceNotExist();
        }

        return count;
    }

    //Block to assign course to student
    private static int addStudentCourse(Scanner scanner, String[] sname, String[] sid, int count, int idcount) throws InterruptedException {
        if (count == 0) { //Checks if there is any registered students
            printDivider();
            System.out.println("   No registered students yet!");
            printDivider();
            Thread.sleep(500);
            return idcount;
        }

        boolean sisassign = true; //Makes available that the client can exit from course assignment tab to student adder tab

        while (sisassign) {
            printDivider();
            System.out.println("All registered students:");

            for (int i = 0; i < count; i++) { //Pulls out of the student name array stored string arrays
                String cstatus = (sid[i] != null) ? sid[i] : "[No assigned course]"; //Checks if student have any assigned any course
                System.out.println((i + 1) + ". " + sname[i] + " -> assigned course: " + cstatus); //Outputs student names with assigned courses
            }

            printDivider();
            System.out.println("        1.Assign course");
            System.out.println("        0.Exit");
            printDivider();
            System.out.print("Choice: ");

            if (isNotInt(scanner)) { //Makes sure that client does not use characters as input method
                continue;
            }

            int schoice = scanner.nextInt();
            scanner.nextLine();

            switch (schoice) {
                case 1:
                    printDivider();
                    System.out.println("Select student number to assign course (0 to Exit)");
                    printDivider();
                    System.out.print("Student number: ");

                    if (isNotInt(scanner)) { //Makes sure that client does not use characters as input method
                        continue;
                    }

                    int snum = scanner.nextInt();
                    scanner.nextLine();

                    if (snum == 0) { //Makes so you exit from course assignment tab
                        sisassign = false; //Exits the loop
                        break;
                    }

                    int sindex = snum - 1; //Converts so input is meant for arrays

                    if (sindex >= 0 && sindex < count) {
                        if (sid[sindex] != null) {
                            printDivider();
                            System.out.println(sname[sindex] + " already has assigned course!");
                            printDivider();
                        } else {
                            printDivider();
                            System.out.println("  Select course to add for " + sname[sindex]);
                            printDivider();
                            System.out.println("    Available courses to add:");
                            System.out.println("        IT | BV | RA | KI");
                            System.out.println("");
                            System.out.print("Course: ");
                            String incourse = scanner.nextLine(); //Asks for student name array input

                            if (incourse.equalsIgnoreCase("IT") || incourse.equalsIgnoreCase("BV") || incourse.equalsIgnoreCase("RA") || incourse.equalsIgnoreCase("KI")) { //Makes so if you type in lower case it counts it too and checks if you type right course
                                sid[sindex] = incourse.toUpperCase();
                                printDivider();
                                System.out.println("Student course has been registered!");
                                printDivider();
                                Thread.sleep(500); //Waits 500ms until the next line executes, makes so the output is smoother
                                idcount++; //Adds input to student array
                            } else {
                                printDivider();
                                System.out.println("  THIS COURSE DOES NOT EXIST!");
                                printDivider();
                                Thread.sleep(500); //Waits 500ms until the next line executes, makes so the output is smoother
                            }
                        }
                    } else {
                        printDivider();
                        System.out.println("   STUDENT DOES NOT EXIST!");
                        printDivider();
                        Thread.sleep(500); //Waits 500ms until the next line executes, makes so the output is smoother
                    }
                    break;

                case 0:
                    sisassign = false; //Exits the loop
                    break;

                default:
                    printChoiceNotExist();
                    break;
            }
        }
        return idcount;
    }

    //Block to delete student name from array
    private static int deleteStudentName(Scanner scanner, String[] sname, String[] sid, int count, int idcount) throws InterruptedException {
        if (count == 0) { //Checks if there is any registered students
            printDivider();
            System.out.println("   No registered students yet!");
            printDivider();
            Thread.sleep(500);
            return count;
        }

        boolean sdeletename = true; //Makes available that the client can exit from student deletion tab

        while (sdeletename) {
            printDivider();
            System.out.println("All registered students:");

            for (int i = 0; i < count; i++) { //Pulls out of the student name array stored string arrays
                String cstatus = (sid[i] != null) ? sid[i] : "[No assigned course]"; //Checks if student have any assigned any course
                System.out.println((i + 1) + ". " + sname[i] + " -> assigned course: " + cstatus); //Outputs student names with assigned courses
            }

            printDivider();
            System.out.println("        1.Delete student");
            System.out.println("        0.Exit");
            printDivider();
            System.out.print("Choice: ");

            if (isNotInt(scanner)) { //Makes sure that client does not use characters as input method
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    printDivider();
                    System.out.println("Select student number to delete (0 to Exit)");
                    printDivider();
                    System.out.print("Student number: ");

                    if (isNotInt(scanner)) { //Makes sure that client does not use characters as input method
                        continue;
                    }

                    int delNum = scanner.nextInt();
                    scanner.nextLine();

                    if (delNum == 0) { //Makes so you exit from student deletion tab
                        sdeletename = false; //Exits the loop
                        break;
                    }

                    int delIndex = delNum - 1; //Converts so input is meant for arrays

                    if (delIndex >= 0 && delIndex < count) {
                        String removedName = sname[delIndex];
                        if (sid[delIndex] != null) {
                            idcount--; //Removes count from course array if student had assigned course
                        }

                        for (int i = delIndex; i < count - 1; i++) { //Shifts student names and courses left in array after deletion
                            sname[i] = sname[i + 1];
                            sid[i] = sid[i + 1];
                        }
                        sname[count - 1] = null; //Clears last element in array
                        sid[count - 1] = null; //Clears last element in array
                        count--; //Removes count from student array

                        printDivider(); //Approves that the student has been deleted
                        System.out.println(removedName + " has been deleted!");
                        printDivider();
                        Thread.sleep(500); //Waits 500ms until the next line executes, makes so the output is smoother
                        sdeletename = false; //Exits the loop
                    } else {
                        printDivider();
                        System.out.println("   STUDENT DOES NOT EXIST!");
                        printDivider();
                        Thread.sleep(500); //Waits 500ms until the next line executes, makes so the output is smoother
                    }
                    break;

                case 0:
                    sdeletename = false; //Exits the loop
                    break;

                default:
                    printChoiceNotExist();
                    break;
            }
        }
        return count;
    }

    //Block to delete course from student
    private static int deleteStudentCourse(Scanner scanner, String[] sname, String[] sid, int count, int idcount) throws InterruptedException {
        if (count == 0) { //Checks if there is any registered students
            printDivider();
            System.out.println("   No registered students yet!");
            printDivider();
            Thread.sleep(500);
            return idcount;
        }

        boolean sdeletecourse = true; //Makes available that the client can exit from course deletion tab

        while (sdeletecourse) {
            printDivider();
            System.out.println("Registered students:");

            for (int i = 0; i < count; i++) { //Pulls out of the student name array stored string arrays
                String cstatus = (sid[i] != null) ? sid[i] : "[No assigned course]"; //Checks if student have any assigned any course
                System.out.println((i + 1) + ". " + sname[i] + " -> assigned course: " + cstatus); //Outputs student names with assigned courses
            }

            printDivider();
            System.out.println("        1.Remove course");
            System.out.println("        0.Exit");
            printDivider();
            System.out.print("Choice: ");

            if (isNotInt(scanner)) { //Makes sure that client does not use characters as input method
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    printDivider();
                    System.out.println("Select student number to remove course (0 to Exit)");
                    printDivider();
                    System.out.print("Student number: ");

                    if (isNotInt(scanner)) { //Makes sure that client does not use characters as input method
                        continue;
                    }

                    int cDelNum = scanner.nextInt();
                    scanner.nextLine();

                    if (cDelNum == 0) { //Makes so you exit from course deletion tab
                        sdeletecourse = false; //Exits the loop
                        break;
                    }

                    int cDelIndex = cDelNum - 1; //Converts so input is meant for arrays

                    if (cDelIndex >= 0 && cDelIndex < count) {
                        if (sid[cDelIndex] != null) {
                            sid[cDelIndex] = null; //Removes course from array
                            idcount--; //Removes count from course array
                            printDivider(); //Approves that the course has been removed
                            System.out.println("Course removed for " + sname[cDelIndex] + "!");
                            printDivider();
                            Thread.sleep(500); //Waits 500ms until the next line executes, makes so the output is smoother
                            sdeletecourse = false; //Exits the loop
                        } else {
                            printDivider();
                            System.out.println(sname[cDelIndex] + " has no course assigned!");
                            printDivider();
                            Thread.sleep(500); //Waits 500ms until the next line executes, makes so the output is smoother
                        }
                    } else {
                        printDivider();
                        System.out.println("   STUDENT DOES NOT EXIST!");
                        printDivider();
                        Thread.sleep(500); //Waits 500ms until the next line executes, makes so the output is smoother
                    }
                    break;

                case 0:
                    sdeletecourse = false; //Exits the loop
                    break;

                default:
                    printChoiceNotExist();
                    break;
            }
        }
        return idcount;
    }

    //Block to view registered students
    private static void viewStudents(Scanner scanner, String[] sname, String[] sid, int count) {
        System.out.println("-----------------------------");
        System.out.println("REGISTERED STUDENTS");
        System.out.println("-----------------------------");

        if (count == 0) { //Checks if there is any registered students
            System.out.println("No registered students yet!");
        } else {
            for (int i = 0; i < count; i++) { //Pulls out of the student name array stored string arrays
                String course = (sid[i] != null) ? sid[i] : "N/A"; //Checks if student have any assigned any course
                System.out.println((i + 1) + ". Name: " + sname[i] + " | Course: " + course); //Outputs student names with assigned courses
            }
        }
        System.out.println("-----------------------------");
        System.out.println("Press ENTER to return to main menu...");
        scanner.nextLine();
    }

    //Exits the program
    private static void exitSystem() throws InterruptedException {
        printDivider();
        System.out.println("Exiting student management system....");
        printDivider();
        Thread.sleep(1000); //Waits 1000ms until the next line executes
    }
}

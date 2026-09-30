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
            System.out.println("---------------------------------");
            System.out.println("    STUDENT MANAGEMENT SYSTEM");
            System.out.println("---------------------------------");
            System.out.println("    1.Add student info");
            System.out.println("    2.View student info");
            System.out.println("    3.Delete student info");
            System.out.println("    4.AExit");

            if(!scanner.hasNextInt()) { //Makes sure that client does not use characters as input method
                System.out.println("---------------------------------");
                System.out.println("        PLEASE USE NUMBER");
                System.out.println("---------------------------------");
                scanner.nextLine();
                Thread.sleep(500); //Waits 500ms until the nect line executes, makes so the output is smoother
                continue;
            }
            option = scanner.nextInt();
            scanner.nextLine();
            Thread.sleep(500);

            switch (option) {
                case 1:
                    while (true) {
                        System.out.println("---------------------------------");
                        System.out.println("   Student adder/remover panel");
                        System.out.println("---------------------------------");
                        System.out.println("      1.Add student name");
                        System.out.println("      2.Add student course");
                        System.out.println("      3.Delete student name");
                        System.out.println("      4.Delete student course");
                        System.out.println("      5.Exit");
                        System.out.println("---------------------------------");

                        if (!scanner.hasNextInt()) { //Makes sure that client does not use characters as input method
                            System.out.println("---------------------------------");
                            System.out.println("        PLEASE USE NUMBER");
                            System.out.println("---------------------------------");
                            scanner.nextLine();
                            Thread.sleep(500); //Waits 500ms until the nect line executes, makes so the output is smoother
                            continue;
                        }

                        int choice = scanner.nextInt();
                        scanner.nextLine();
                        Thread.sleep(500); //Waits 500ms until the nect line executes, makes so the output is smoother

                        switch (choice) {
                            case 1:
                                System.out.println("---------------------------------");
                                System.out.print("Student name: ");
                                sname[count] = scanner.nextLine(); //Asks for student name array input
                                count++; //Adds inout to student array

                                System.out.println("---------------------------------"); //Aproves taht the student has been added
                                System.out.println("Student name has been registered!");
                                System.out.println("---------------------------------");
                                Thread.sleep(500); //Waits 500ms until the nect line executes, makes so the output is smoother
                                break;
                            case 2:

                                if (count == 0) { //Checks if there is any registered students
                                    System.out.println("---------------------------------");
                                    System.out.println("   No registered students yet!");
                                    System.out.println("---------------------------------");
                                    Thread.sleep(500);
                                    break;
                                }

                                boolean sisassign = true; //Makes available that  the client can exit from course assignment tab to student adder tab

                                while (sisassign) {
                                    System.out.println("---------------------------------");
                                    System.out.println("All registered students:");

                                    for (int i = 0; i < count; i++){ // pulls out of the student name array stored string arrays
                                        String cstatus = (sid[i] !=null) ? sid[i] : "[No assigned course]";//Checks if student have any assigned any course
                                        System.out.println((i + 1) + ". " + sname[i] + " -> assigned course: " + cstatus); //Outputs student names with assigned courses
                                    }

                                    System.out.println("---------------------------------");
                                    System.out.println("        1.Assign course");
                                    System.out.println("        2.Exit");
                                    System.out.println("---------------------------------");

                                    if (!scanner.hasNextInt()) { //Makes sure that client does not use characters as input method
                                        System.out.println("---------------------------------");
                                        System.out.println("        PLEASE USE NUMBER");
                                        System.out.println("---------------------------------");
                                        scanner.nextLine();
                                        Thread.sleep(500); //Waits 500ms until the nect line executes, makes so the output is smoother
                                        continue;

                                    }

                                    int schoice = scanner.nextInt();
                                    scanner.nextLine();

                                    switch (schoice){
                                        case 1:
                                            System.out.println("---------------------------------");
                                            for (int i = 0; i < count; i++){ // pulls out of the student name array stored string arrays
                                                String cstatus = (sid[i] !=null) ? sid[i] : "[No assigned course]";//Checks if student have any assigned any course
                                                System.out.println((i + 1) + ". " + sname[i] + " -> assigned course: " + cstatus); //Outputs student names with assigned courses
                                            }

                                            System.out.println("---------------------------------");
                                            System.out.println("Select student number to assign course");
                                            System.out.println("---------------------------------");
                                            System.out.print("Student number:");

                                            if (!scanner.hasNextInt()) { //Makes sure that client does not use characters as input method
                                                System.out.println("---------------------------------");
                                                System.out.println("        PLEASE USE NUMBER");
                                                System.out.println("---------------------------------");
                                                scanner.nextLine();
                                                Thread.sleep(500); //Waits 500ms until the nect line executes, makes so the output is smoother
                                                continue;
                                            }

                                            for (int i = 0; i < count; i++){ // pulls out of the student name array stored string arrays
                                                String cstatus = (sid[i] !=null) ? sid[i] : "[No assigned course]";//Checks if student have any assigned any course
                                                System.out.println((i + 1) + ". " + sname[i] + " -> assigned course: " + cstatus); //Outputs student names with assigned courses
                                            }

                                            int snum = scanner.nextInt();
                                            scanner.nextLine();
                                            int sindex = snum -1; //Converts so input is meant for arrays

                                            if (sindex >= 0 && sindex < count) {
                                                if (sid[sindex] != null) {
                                                    System.out.println("---------------------------------");
                                                    System.out.println(sname[sindex] + " already has assigned course!");
                                                    System.out.println("---------------------------------");
                                                }else {
                                                    System.out.println("---------------------------------");
                                                    System.out.println("  Select course to add for " + sname[sindex]);
                                                    System.out.println("---------------------------------");
                                                    System.out.println("    Available courses to add:");
                                                    System.out.println("        IT | BV | RA | KI");
                                                    System.out.println("");
                                                    System.out.print("Course: ");
                                                    String incourse = scanner.nextLine(); //Asks for student name array input

                                                    if (incourse.equalsIgnoreCase("IT") || incourse.equalsIgnoreCase("BV") || incourse.equalsIgnoreCase("RA") || incourse.equalsIgnoreCase("KI")){ // makes so if you type in lower case it counts it too and checks of you type right course
                                                        sid[sindex] = incourse.toUpperCase();
                                                        System.out.println("---------------------------------");
                                                        System.out.println("Student course has been registered!");
                                                        System.out.println("---------------------------------");
                                                        Thread.sleep(500); //Waits 500ms until the next line executes, makes so the output is smoother
                                                        idcount++; //Adds inout to student array
                                                    }else {
                                                        System.out.println("---------------------------------");
                                                        System.out.println("  THIS COURSE DOES NOT EXIST!");
                                                        System.out.println("---------------------------------");
                                                        Thread.sleep(500); //Waits 500ms until the nect line executes, makes so the output is smoother
                                                    }
                                                }
                                            }
                                            break;
                                        case 2:
                                            sisassign = false; //Exits the loop
                                            break;
                                        default:
                                            System.out.println("---------------------------------");
                                            System.out.println("     CHOICE DOES NOT EXIST!");
                                            System.out.println("---------------------------------");
                                            break;
                                    }
                                }
                                break;

                            case 3:
                                System.out.println("        PLEASE USE NUMBER 3");
                                break;
                            case 4:
                                System.out.println("        PLEASE USE NUMBER 4");
                                break;
                            case 5:
                                break;
                        }
                    }
                case 2:
                    System.out.println("This is case 2");
                    break;
                case 3:
                    System.out.println("This is case 3");
                    break;
                case 4:
                    System.out.println("---------------------------------"); //Exits the program
                    System.out.println("Exiting student management system....");
                    System.out.println("---------------------------------");
                    Thread.sleep(1000);
                    return;
            }

        }
    }
}
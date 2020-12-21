import java.util.Scanner;

public class eParkMenu {
    public static void main(String[] args) {
        eParkSystem eps = new eParkSystem();

        //main loop
        while (true){
            System.out.println("Welcome to our magical park!");
            System.out.println("choose one of the following Commands:");

            System.out.println("\t- register");
            System.out.println("\t- manageTicket <child name>");
            System.out.println("\t- exitPark");
            System.out.println("\t- exit");

            Scanner scanner = new Scanner(System.in);  // Create a Scanner object
            String userInput = scanner.nextLine();  // Read user input

            if (userInput.equals("register")) {
                System.out.println("please enter child's ID:");
                String childId = scanner.nextLine();

                System.out.println("please enter child's name:");
                String childName = scanner.nextLine();

                System.out.println("please enter child's age");
                String childAge = scanner.nextLine();

                try{
                    eps.enterDetails();
                }
                catch (Exception e){

                }

            }

            else if (userInput.startsWith("manageTicket")){
                String childID = userInput.substring(13);
                Child child = eps.getChildById(childID);

                eTicket eTicket = child.geteTicket();

                //displaying eTicket details
                System.out.println(eTicket);

                System.out.println("Choose an action:");
                System.out.println("\t- add <ride name>");
                System.out.println("\t- remove <ride name>");

                String choice = scanner.nextLine();

                if (choice.startsWith("add")){

                }
                else if (choice.startsWith("remove")){

                }
                else{
                    System.out.println("Invalid input");
                }

            }

            else if (userInput.equals("exitPark")){

            }

            else if (userInput.equals("exit")){
                System.out.println("Goodbye");
                break;
            }

            else{
                System.out.println("not a valid command!");
            }

        }


    }
}

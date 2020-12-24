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
                    eps.enterDetails(childId, childName, childAge);
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                    continue;
                }


                System.out.println("please enter your credit number:");
                String creditNumber = scanner.nextLine();

                System.out.println("please enter credit's expiration month:");
                String expirationMonth = scanner.nextLine();

                System.out.println("please enter credit's expiration year:");
                String expirationYear = scanner.nextLine();

                System.out.println("please enter your limit:");
                String limit = scanner.nextLine();

                boolean isValid = false;
                try{
                    isValid = eps.enterCreditDetails(creditNumber, expirationMonth, expirationYear, limit);
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                    continue;
                }

                if (!isValid){
                   continue;
                }

                // All creations
                eps.registerNewChild(childId, childName, childAge, creditNumber, expirationMonth, expirationYear, limit);

                System.out.println("please enter your child's weight:");
                String childWeight = scanner.nextLine();

                System.out.println("please enter your child's height:");
                String childHeight = scanner.nextLine();

                try{
                    eps.registerMeasurement(childName, childHeight, childWeight);
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }

            }

//            else if (userInput.startsWith("manageTicket")){
//                String childID = userInput.substring(13);
//                Child child = eps.getChildById(childID);
//
//                eTicket eTicket = child.geteTicket();
//
//                //displaying eTicket details
//                System.out.println(eTicket);
//
//                System.out.println("Choose an action:");
//                System.out.println("\t- add <ride name>");
//                System.out.println("\t- remove <ride name>");
//
//                String choice = scanner.nextLine();
//
//                if (choice.startsWith("add")){
//
//                }
//                else if (choice.startsWith("remove")){
//
//                }
//                else{
//                    System.out.println("Invalid input");
//                }
//
//            }

            else if (userInput.equals("exitPark")){
                System.out.println("Enter child name:");
                String name = scanner.nextLine();
                eps.ExitPark(name);
            }

            else if (userInput.equals("exit")){
                eps.Exit();
                System.out.println("Goodbye");
                break;
            }

            else{
                System.out.println("not a valid command!");
            }

        }


    }
}

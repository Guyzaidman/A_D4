import java.util.ArrayList;
import java.util.HashMap;
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
                if (choice.toLowerCase().startsWith("add")){
                    ArrayList<Device> devices = eps.getSuitableDevices(child);
                    HashMap<Device,Integer> entries = new HashMap<>();
                    while (true){
                        int num = 0;
                        for (Device device: devices){
                            System.out.println(num+ ". " + device.toString());
                            num++;
                        }
                        System.out.println("\nChoose device number to add from the above\nTap any other to end.");
                        choice = scanner.nextLine();
                        try{
                            int deviceNum = Integer.valueOf(choice);
                            if (deviceNum >= num || deviceNum < 0) break;
                            System.out.println("Type amount of Entries to add:");
                            choice = scanner.nextLine();
                            int numOfEntries = Integer.valueOf(choice);
                            if (entries.containsKey(devices.get(deviceNum))){
                                numOfEntries += entries.get(devices.get(deviceNum));
                                entries.replace(devices.get(deviceNum), numOfEntries);
                            }
                            else{
                                entries.put(devices.get(deviceNum), numOfEntries);
                            }
                        }
                        catch(Exception e){
                            if (entries.size() == 0) break;
                            for (Device device: entries.keySet()){
                                if (device instanceof ExtremeDevice){
                                    System.out.println("The device " + device.getName() + " is Extreme.\nType 'yes' to Approve or other to cancel");
                                    choice = scanner.nextLine();
                                    if (choice.toLowerCase() != "yes"){
                                        entries.remove(device);
                                    }
                                }
                            }
                            boolean allSuccess = true;
                            for (Device device: entries.keySet()){
                                for (int i = 0; i < entries.get(device); i++){
                                    boolean ifSuccess = eps.AddRide(device, ticket);
                                    if (!ifSuccess) {
                                        System.out.println("Out of balance.\nThe action of add entrance number" + i + "of device " + device.getName() + " not completed!");
                                        allSuccess = false;
                                    }
                                }
                            }
                            if (allSuccess){
                                System.out.println("All Entrance created successfully.");
                            }
                            break;
                        }
                    }
                }
                else if (choice.toLowerCase().startsWith("remove")){
                    int num = 0;
                    int lenArray;
                    ArrayList<Device> devicesList = new ArrayList<>();
                    for (Device device: ticket.getEntranceTable().keySet()){
                        lenArray = ticket.getEntranceTable().get(device).size();
                        System.out.println(num+ ". " + device.toString() + ", amount of entrance: " + lenArray);
                        num++;
                        devicesList.add(device);
                    }
                    System.out.println("\nChoose device number to remove from the above\nTap any other to end.");
                    choice = scanner.nextLine();
                    try{
                        int deviceNum = Integer.valueOf(choice);
                        if (deviceNum >= num || deviceNum < 0) throw new Exception("Invalid device number.\nDidn't remove anything");
                        lenArray = ticket.getEntranceTable().get(devicesList.get(deviceNum)).size();
                        System.out.println("Type amount of Entries to remove:");
                        choice = scanner.nextLine();
                        int numOfEntries = Integer.valueOf(choice);
                        if (numOfEntries > lenArray){
                            throw new Exception("Invalid amount to remove.\nDidn't remove anything");
                        }
                        for (int i=0; i<numOfEntries; i++){
                            eps.RemoveRide(devicesList.get(deviceNum), ticket);
                        }

                    }
                    catch (NumberFormatException e){

                    }
                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }
//                else{
//                    System.out.println("Invalid input");
//                }
//
//            }

            else if (userInput.equals("exitPark")){
                System.out.println("Enter child name:");
                String name = scanner.nextLine();
                // prints the confirmation message.
                System.out.println(eps.ExitPark(name));
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

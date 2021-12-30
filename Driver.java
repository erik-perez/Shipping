import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        int x=10;
        String name;
        String origin;
        String destination;
        double weight;
        int track;
        Truck t=null;
        Scanner keyIn;
        do {
            keyIn = new Scanner(System.in);
            try {
                System.out.println("\nWhat would you like to do?");
                System.out.println("1. Start a cargo");
                System.out.println("2. Load the truck with packages");
                System.out.println("3. Unload a package");
                System.out.println("4. The number of loaded packages");
                System.out.println("5. The gross income earned by shipping the cargo");
                System.out.println("6. Weight of the loaded truck");
                System.out.println("7. Drive the truck to its destination");
                System.out.println("0. Quit");
                System.out.println("Please enter your choice and press <Enter>: ");

                x=keyIn.nextInt();


                while(x>7 || x<0) {
                    System.out.println("Please enter a valid choice and press <Enter>: ");
                    x=keyIn.nextInt();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input!");
            }
            switch(x) {
                case 1:
                    try {
                        System.out.println("a. Driver name: ");
                        name = keyIn.nextLine();
                        name = keyIn.nextLine();
                        System.out.println("b. Unloaded weight(kg): ");
                        weight= keyIn.nextDouble();
                        System.out.println("c. Origin City:");
                        origin = keyIn.nextLine();
                        origin = keyIn.nextLine();
                        System.out.println("d. Destination City:");
                        destination = keyIn.nextLine();
                        t= new Truck(name,origin,destination,weight);
                    }catch (InputMismatchException e) {
                        System.out.println("Invalid Input!");
                    }
                    break;

                case 2:
                    if(t==null) System.out.println("No truck exists.");
                    if(t!=null) {
                        try {
                            System.out.println("a. Package Tracking number: ");
                            track=keyIn.nextInt();
                            System.out.println("b. Package weight(oz;lb): ");
                            weight=keyIn.nextDouble();
                            try {
                                switch(track%10) {
                                    case 0: t.load(new Letter(track,weight)); break;
                                    case 1: t.load(new Box(track,weight)); break;
                                    case 2: t.load(new WoodCrate(track,weight)); break;
                                    case 3: t.load(new MetalCrate(track,weight)); break;
                                    default: throw new PackageException();
                                }
                            } catch(PackageException e) {
                            }

                        }catch(InputMismatchException e) {
                            System.out.println("Invalid Input!");
                        }
                    }break;
                case 3:
                    try {
                        System.out.println("Which package index would you like to unload: ");
                        t.unload(keyIn.nextInt());
                    } catch (NullPointerException e) {
                        System.out.println("No truck exists.");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input!");
                    }
                    break;
                case 4:
                    try {
                        System.out.println(t.getLoaded()+" Packages loaded.");
                    } catch (NullPointerException e) {
                        System.out.println("No truck exists.");
                    }
                    break;

                case 5:
                    try {
                        System.out.println("The gross income is $"+t.getIncome());
                    } catch (NullPointerException e) {
                        System.out.println("No truck exists.");
                    }
                    break;

                case 6:
                    try {
                        System.out.println("The weight of the loaded truck is "+t.toKilograms(t.getWeight())+"kg ("+t.getWeight()+"lbs).");
                    } catch (NullPointerException e) {
                        System.out.println("No truck exists.");
                    }
                    break;

                case 7:
                    try {
                        System.out.println(t.getName()+" picked up the cargo in "+ t.getOrigin()
                                +" and successfully deivered it to "+t.getDestination()+
                                ", earning $"+t.getIncome()+".");
                        t=null;
                    } catch (NullPointerException e) {
                        System.out.println("No truck exists.");
                    }
                    break;
            }

        } while (x!=0);
        System.out.println("Thank you for using the shipping program.");
        keyIn.close();
    }
}



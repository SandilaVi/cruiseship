import java.io.FileWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] X = new String[10];
        String choiceM;

        do {
            System.out.println();
            System.out.println("#################################################");
            System.out.println("### Welcome to the Cruise Ship Boarding Menu! ###");
            System.out.println("## V - View all cabins                         ##");
            System.out.println("## B - Display booked cabins                   ##");
            System.out.println("## E - Display empty cabins                    ##");
            System.out.println("## A - Add a customer to a cabin               ##");
            System.out.println("## D - Delete customer from cabin              ##");
            System.out.println("## F - Find cabin from customer name           ##");
            System.out.println("## S - Store program data into a file          ##");
            System.out.println("## O - View passengers names by alphabetically ##");
            System.out.println("#################################################");
            System.out.println();
            System.out.print("Which method do you want to execute : ");

            Scanner scn = new Scanner(System.in);
            String input = scn.nextLine();

            switch (input) {
                //View all cabins
                case "V":
                case "v":
                    System.out.println("### Cabins ###");
                    for (int v = 0; v < X.length; v++) {
                        if (X[v] != null) {
                            System.out.println("Cabin no " + v + " - " + X[v]);
                        } else {
                            System.out.println("Cabin no " + v + " - " + "empty");
                        }
                    }
                    System.out.println();
                    break;


                //Display booked cabins
                case "B":
                case "b":
                    System.out.println("### Booked Cabins ###");
                    boolean viewCabins=false;

                    for (int b = 0; b < X.length; b++) {
                        if (X[b] != null) {
                            viewCabins=true;
                            System.out.println("Cabin no " + b + " - " + X[b]);
                        }
                    }
                    if (!viewCabins) {
                        System.out.println("No booked cabins so far!");
                    }
                    System.out.println();
                    break;


                //Display empty cabins
                case "E":
                case "e":
                    System.out.println("### Empty Cabins ###");
                    boolean emptyCabins=false;

                    for (int e = 0; e < X.length; e++) {
                        if (X[e] == null) {
                            emptyCabins=true;
                            System.out.println("Cabin no " + e);
                        }
                    }
                    if (!emptyCabins) {
                        System.out.println("All cabins have been booked!");
                    }
                    System.out.println();
                    break;


                //Add a customer to a cabin
                case "A":
                case "a":
                    System.out.println("### Add a Customer To a Cabin ###");
                    String choiceA;

                    do {
                        System.out.print("Empty cabins so far : ");
                        for (int a = 0; a < X.length; a++) {
                            if (X[a] == null) {
                                System.out.print(a + " ");
                            }
                        }
                        System.out.println();
                        try {
                            System.out.print("Which cabin do you want to book : ");
                            String cabinnoA = scn.nextLine();
                            if (X[Integer.parseInt(cabinnoA)] == null) {
                                System.out.print("Enter customer name : ");
                                String cusnameA = scn.nextLine();

                                X[Integer.parseInt(cabinnoA)] = cusnameA;
                                System.out.println("Cabin no " + cabinnoA + " - " + cusnameA);
                                System.out.print("Do you need to add another customer? : ");
                            } else {
                                System.out.println("This cabin is already booked. Try another cabin!");
                                System.out.print("Do you want to try another cabin? : ");
                            }
                        } catch (Exception A) {
                            System.out.println("You entered a wrong cabin number. Please try again!");
                            System.out.print("Do you want to try again? : ");
                        }
                        choiceA = scn.nextLine();
                        System.out.println();

                    } while (choiceA.equals("Y") | choiceA.equals("y"));
                    break;


                //Delete customer from cabin
                case "D":
                case "d":
                    System.out.println("### Delete Customer From Cabin ###");
                    boolean deleteCustomer = false;
                    int countD=0;

                    for (String d : X) {
                        if (d != null) {
                            countD++;
                        }
                    }

                    if (countD == 0) {
                        System.out.println("No customers are booked so far!");
                        System.out.println();
                    }

                    else {
                        System.out.println("--Booked customers so far--");
                        for (String D : X) {
                            if (D != null) {
                                System.out.println(D);
                                System.out.println();
                            }
                        }

                        System.out.print("Which customer do you want to remove? : ");
                        String cusnameD= scn.nextLine();
                        for (int D = 0; D < X.length; D++) {
                            if (Objects.equals(cusnameD, X[D])) {
                                deleteCustomer = true;
                                X[D] = null;
                                System.out.println("Customer successfully deleted from cabin!");
                            }
                        }
                        if (!deleteCustomer) {
                            System.out.println("Check the customer name and try again!");
                        }
                        System.out.println();
                    }
                    break;


                //Find cabin from customer name
                case "F":
                case "f":
                    System.out.println("### Find Cabin From Customer Name ###");
                    boolean findCustomer = false;

                    System.out.print("Enter customer name : ");
                    String cusnameF = scn.nextLine();
                    for (int f = 0; f < X.length; f++) {
                        if (cusnameF.equals(X[f])) {
                            findCustomer = true;
                            //When cusnameF equals to X[f], boolean value change as true means a match has been found.
                            //Above condition will check till the for loop ends.
                            System.out.println("This customer booked cabin is : "+ f);
                        }
                    }
                    if (!findCustomer) {
                        //After the loop code checks the boolean value, if it is false means no match has been found.
                        //These lines will execute only after executing for loop and boolean value is false.
                        System.out.println("Check the customer name and try again!");
                    }
                    System.out.println();
                    break;


                //Store program data into a file
                case "S":
                case "s":
                    System.out.println("### Store Program Data ###");
                    try {
                        FileWriter writer = new FileWriter("stored_data.txt");
                        for (int s = 0; s < X.length; s++) {
                            if (X[s] != null) {
                                writer.write("Cabin no " + s + " - " + X[s]);
                            } else {
                                writer.write("Cabin no " + s + " - " + "empty");
                            }
                            writer.write("\n");
                        }
                        writer.close();
                        System.out.println("Data successfully saved to a text file as stored_data.txt!");
                    } catch (Exception s) {
                        System.out.println("An error occurred. Data saved unsuccessfully!");
                    }
                    System.out.println();
                    break;


                //View passengers names by alphabetically
                case "O":
                case "o":
                    System.out.println("### Passengers Names by Alphabetically ###");
                    //Count how many not null elements are in the X array.
                    int countO=0;
                    for (String o : X) {
                        if (o != null) {
                            countO++;
                        }
                    }

                    if (countO == 0) {
                        System.out.println("We couldn't found any record for the booked customers!");
                        System.out.println();
                    }

                    else {
                        //Create a new array called Y and copy all the not null elements from X array to Y array.
                        String[] Y=new String[countO];
                        int elements=0;
                        for (String name : X) {
                            if (name != null) {
                                Y[elements]=name;
                                elements++;
                            }
                        }

                        //Sort all elements in the Y array alphabetically.
                        Arrays.sort(Y,String.CASE_INSENSITIVE_ORDER);
                        for (String namesO : Y) {
                            System.out.println(namesO);
                        }
                        System.out.println();
                    }
                    break;


            }

            System.out.print("Do you want to go to the menu? : ");
            choiceM = scn.nextLine();

        } while (choiceM.equals("Y") | choiceM.equals("y"));

    }
}


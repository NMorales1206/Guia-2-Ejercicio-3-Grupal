import java.util.*;
import java.lang.Math;

public class Main {

    static Scanner input = new Scanner(System.in);
    // -- Main Method --
    public static void main(String[] args) throws InterruptedException {

        System.out.println();
        System.out.println("############################");
        System.out.println("Welcome to the EAN EX.3 App");
        System.out.println("############################");
        System.out.println();
        // -- Start of the menu loop --
        int exercise;
        do {
            System.out.println();
            exercise = menu();
            if (exercise == 1) {
                listResolution(getIntArrayList());
            } else if (exercise == 2) {
                System.out.println("how many numbers will you add? ");
                double[] myArray = secondExArray(input.nextInt());
                System.out.println("The standard deviation is: " + secondExResult(myArray));
            } else if (exercise == 3) {
                System.out.println("For the first group: ");
                ArrayList<String> list1 = getStrArrayList();
                System.out.println("For the second group: ");
                ArrayList<String> list2 = getStrArrayList();
                System.out.println("The unique elements of those lists are: " + listResolution(list1, list2));
            } else if(exercise == 0){
                break;  // -- The only option that breaks the loop --
            } else {
                System.out.println("ERROR: Invalid Internal Handler.");
                System.out.println();
                System.out.println();
            }
            sleep();
        } while(true);
        System.out.println("Good Bye!");
        sleep();
    }

    // -- Methods --
    // -- Method to create the List of Int --
    public static ArrayList<Integer> getIntArrayList() {
        ArrayList<Integer> array = new ArrayList<>();
        System.out.println("How many numbers do you want to add?");
        int userChoice = input.nextInt();
        for (int i = 1; i <= userChoice; i++) {
            System.out.println("Enter the " + i + " value.");
            array.add(input.nextInt());
        }
        do {
            System.out.println("Do you want to add another number? N/Y");
            String choice = input.next();
            choice = choice.toLowerCase();
            if (choice.equals("y")) {
                System.out.println("Please enter a number");
                int number = input.nextInt();
                array.add(number);
            } else if (choice.equals("n")) {
                break;
            } else {
                System.out.println("ERROR: Incorrect choice. Only N/Y are allowed");
            }
        } while (true);

        return array;
    }

    // -- Method to create the List of Strings --
    public static ArrayList<String> getStrArrayList() {
        ArrayList<String> array = new ArrayList<>();
        System.out.println("How many items do you want to add?");
        int userChoice = input.nextInt();
        for (int i = 1; i <= userChoice; i++) {
            System.out.println("Enter the item number " + i + ".");
            array.add(input.next());
        }
        do {
            System.out.println("Do you want to add another item? N/Y");
            String choice = input.next();
            choice = choice.toLowerCase();
            if (choice.equals("y")) {
                System.out.println("Please enter the item");
                String item = input.next();
                array.add(item);
            } else if (choice.equals("n")) {
                break;
            } else {
                System.out.println("ERROR: Incorrect choice. Only N/Y are allowed");
            }
        } while (true);
        return array;
    }

    // -- Method to work on one list --
    public static void listResolution(ArrayList<Integer> array) {
        double totalSum = 0;
        for (int item : array) {
            totalSum += item;
        }
        Collections.sort(array);
        System.out.println("The smallest number is: " + array.get(0));
        System.out.println("The highest number is: " + array.get(array.size() - 1));
        System.out.println("The average is: " + totalSum / array.size());
        System.out.println("The list of numbers you added is: "+ array);
    }

    // -- Method override to work on 2 lists --
    public static List<String> listResolution(ArrayList<String> list1, ArrayList<String> list2) {
        Collections.sort(list1);
        Collections.sort(list2);
        List<String> tempList = new ArrayList<>(list1);
        tempList.removeAll(list2);
        list2.removeAll(list1);
        tempList.addAll(list2);
        Collections.sort(tempList);
        return (tempList);
    }

    // -- Creates the Array for the second ex. --
    public static double[] secondExArray(int number) {
        double [] array = new double[number];

        System.out.println("Enter " + number + " values");
        for(int i = 0; i < array.length; i++) {
            array[i] = input.nextDouble();
        }
        return array;
    }

    // -- Solved the Array of the second ex. --
    public static double secondExResult(double [] array) {
        int n = array.length;
        int average = 0;
        double internalSum = 0;
        for (double item : array) {
            average += item;
        }
        average /= n;
        for (double item : array) {
            internalSum += Math.pow((item - average), 2);
        }
        return (Math.sqrt(internalSum/(array.length - 1)));
        }

    // -- Improved Menu --
    public static int menu() throws InterruptedException {

        int option;
        do {
            System.out.println("Here is the list of exercises");
            System.out.println();
            System.out.println("1. Average, Highest, Lowest");
            System.out.println("2. Standard Deviation");
            System.out.println("3. Differences Between 2 Lists");
            System.out.println("0. To exit the app");
            System.out.println();
            System.out.println("Please enter the number of what you want to execute: ");
            boolean intChecker = input.hasNextInt();
            if(intChecker) {
                option = input.nextInt();
                if (option < 0 || option > 3) {
                    System.out.println("ERROR: Please enter a number between 0 and 3");
                    System.out.println();
                    System.out.println();
                    sleep();
                } else {
                    break;
                }
            } else {
                System.out.println("ERROR: Only numbers are allowed");
                sleep();
            }
            input.nextLine();
        } while(true);
        return option;
    }


    public static void sleep() throws InterruptedException {
        Thread.sleep(3500);
    }
}
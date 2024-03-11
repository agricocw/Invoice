import java.util.Scanner;
import java.util.regex.*;
public class SafeInput {
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = ""; // Set this to zero length. Loop runs until it isn’t
        do
        {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        }while(retString.length() == 0);
        return retString;
    }
    public static double CtoF(double celsius) {
        // Convert Celsius to Fahrenheit
        return (celsius * 9.0 / 5.0) + 32.0;
    }
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retDouble;

        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            while (!pipe.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid double value.");
                System.out.print(prompt + " [" + low + " - " + high + "]: ");
                pipe.next(); // Clear the input buffer.
            }
            retDouble = pipe.nextDouble();
            pipe.nextLine(); // Consume the newline character

            if (retDouble < low || retDouble > high) {
                System.out.println("Input out of range. Please enter a value between " + low + " and " + high + ".");
            }
        } while (retDouble < low || retDouble > high);

        return retDouble;
    }
    public static int getInt(Scanner pipe, String prompt)
    {
        int retInt;
        while(true)
        {
            try
            {
                System.out.print("\n" +prompt + ": "); // show prompt add space
                retInt = Integer.parseInt(pipe.nextLine());
                break;
            }
            catch (Exception e) {

            }
        }
        return retInt;
    }
    public static void prettyHeader(String msg) {
        int totalWidth = 60; // Width of the header

        // Calculate the padding needed to center the message
        int msgWidth = msg.length();
        int padding = (totalWidth - msgWidth - 4) / 2;

        // Print the top line of asterisks
        for (int i = 0; i < totalWidth; i++) {
            System.out.print("*");
        }
        System.out.println();

        // Print the second line with centered message and stars on both sides
        System.out.print("***");
        for (int i = 0; i < padding; i++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < padding; i++) {
            System.out.print(" ");
        }
        System.out.println("***");

        // Print the bottom line of asterisks
        for (int i = 0; i < totalWidth; i++) {
            System.out.print("*");
        }
        System.out.println();
    }



    public static double getDouble(Scanner pipe, String prompt)
    {
        double retDouble;
        while(true)
        {
            try
            {
                System.out.print("\n" +prompt + ": "); // show prompt add space
                retDouble = Double.parseDouble(pipe.nextLine());
                break;
            }
            catch (Exception e) {

            }
        }
        return retDouble;
    }



    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retInt;
        do
        {
            retInt=getInt(pipe, prompt);
        }while(retInt<low || retInt>high);
        return retInt;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean validInput = false;
        char inputChar;
        do {
            System.out.print("\n" + prompt + " (Y/N): ");
            inputChar = pipe.next().charAt(0);
            inputChar = Character.toUpperCase(inputChar);
            if (inputChar == 'Y' || inputChar == 'N') {
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter 'Y' for Yes or 'N' for No.");
            }
        } while (!validInput);
        return inputChar == 'Y';
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String str="";
        // Compile the ReGex
        Pattern p = Pattern.compile(regEx);
        Matcher m;
        do
        {
            str=getNonZeroLenString(pipe, prompt);
            m= p.matcher(str);
        }while(!m.matches());
        return str;
    }
}
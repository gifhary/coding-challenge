import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.concurrent.RejectedExecutionException;

public class CodingChallenge {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Set how many digits number after comma
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(5);

        //Base number to be rooted, accept more than 17 digits
        System.out.print("Enter the base number : ");
        double baseNum = scan.nextDouble();

        //nth root number (only 1-10)
        System.out.print("Enter nth root number : ");
        int rootNum = scan.nextInt();

        scan.close();

        String sequence;
        switch (rootNum) {
            case 1: sequence = "st"; break;
            case 2: sequence = "nd"; break;
            case 3: sequence = "rd"; break;
            default: sequence = "th";
        }

        
        double result = nthRoot(baseNum, rootNum);
        System.out.print(rootNum + sequence + " root of " + baseNum + " is : " + df.format(result));

    }

    /*
     * This method is used to find the nth root of any number with requirement :
     * Takes in two parameters: a number and a root.
     * Accept up to 17 digits number
     * Able to calculate nth root between 1 and 10
     * Not using any math library to compute
     * Not using any special operator
     * 
     * This method work using nth root number input as aguide to select which code to process
     * Most code is using similar method to compute the nth root of a number except for 1st and 2nd root
     * The method used here is manually increasing index number iteratively, compute "index" to the "nth root"
     * power and then assign the value as reference. As long the reference value still less than the base
     * number, the loop keep increasing the index value until "reference" is equal to "base"
     * The method will retun final index value as the nth root of base number
    */
    public static double nthRoot(double base, int root) {
        double i = 1; //index
        double reference = 1;
        double addition = 0.000001; // smaller number is better but take more time to process large base number

        switch (root) {
        case 1:
        //If the user input for nth root is 1 (one), it return the base number itself
            i = base;
            break;

        case 2:
            //different approach for square root, it take too long if using other method
            double t;
            double squareRoot = base / 2;

            do {
                t = squareRoot;
                squareRoot = (t + (base / t)) / 2;
            } while ((t - squareRoot) != 0);

            i = squareRoot;
            break;

        case 3:
            while (reference < base) {
                i = i + addition;
                reference = i * i * i;
            }
            break;

        case 4:
            while (reference < base) {
                i = i + addition;
                reference = i * i * i * i;
            }
            break;

        case 5:
            while (reference < base) {
                i = i + addition;
                reference = i * i * i * i * i;
            }
            break;

        case 6:
            while (reference < base) {
                i = i + addition;
                reference = i * i * i * i * i * i;
            }
            break;

        case 7:
            while (reference < base) {
                i = i + addition;
                reference = i * i * i * i * i * i * i;
            }
            break;

        case 8:
            while (reference < base) {
                i = i + addition;
                reference = i * i * i * i * i * i * i * i;
            }
            break;

        case 9:
            while (reference < base) {
                i = i + addition;
                reference = i * i * i * i * i * i * i * i * i;
            }
            break;

        case 10:
            while (reference < base) {
                i = i + addition;
                reference = i * i * i * i * i * i * i * i * i * i;
            }
            break;

        default:
        //nth root number other than 1-10, it throws an exception error
            throw new RejectedExecutionException("Allowed root number 1-10 only");
        }
        return i - addition;
    }
}
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.concurrent.RejectedExecutionException;

public class CodingChallenge {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(5);

        System.out.print("Enter the base number : ");
        double baseNum = scan.nextDouble(); // Base number to be rooted, accept more than 17 digits

        System.out.print("Enter nth root number : ");
        int rootNum = scan.nextInt(); // nth root number (only 1-10)

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

    public static double nthRoot(double base, int root) {
        double i = 1, result = 1;
        double addition = 0.000001; // smaller number is better but take more time to process large base number

        switch (root) {
        case 1:
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
            while (result < base) {
                i = i + addition;
                result = i * i * i;
            }
            break;

        case 4:
            while (result < base) {
                i = i + addition;
                result = i * i * i * i;
            }
            break;

        case 5:
            while (result < base) {
                i = i + addition;
                result = i * i * i * i * i;
            }
            break;

        case 6:
            while (result < base) {
                i = i + addition;
                result = i * i * i * i * i * i;
            }
            break;

        case 7:
            while (result < base) {
                i = i + addition;
                result = i * i * i * i * i * i * i;
            }
            break;

        case 8:
            while (result < base) {
                i = i + addition;
                result = i * i * i * i * i * i * i * i;
            }
            break;

        case 9:
            while (result < base) {
                i = i + addition;
                result = i * i * i * i * i * i * i * i * i;
            }
            break;

        case 10:
            while (result < base) {
                i = i + addition;
                result = i * i * i * i * i * i * i * i * i * i;
            }
            break;

        default:
            throw new RejectedExecutionException("Allowed root number 1-10 only");
        }
        return i - addition;
    }
}
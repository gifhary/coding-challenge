import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.concurrent.RejectedExecutionException;

public class CodingChallenge2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Set how many digits number after comma
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(9);

        // Base number to be rooted, accept more than 17 digits
        System.out.print("Enter the base number : ");
        double baseNum = scan.nextDouble();

        // nth root number (only 1-10)
        System.out.print("Enter nth root number : ");
        int rootNum = scan.nextInt();

        scan.close();

        String sequence;
        switch (rootNum) {
        case 1:
            sequence = "st";
            break;
        case 2:
            sequence = "nd";
            break;
        case 3:
            sequence = "rd";
            break;
        default:
            sequence = "th";
        }

        double result = nthRoot(rootNum, baseNum);
        System.out.print(rootNum + sequence + " root of " + baseNum + " is : " + df.format(result));
    }

    public static double nthRoot(int rootNum, double base) {
        if(rootNum < 1 || rootNum > 10){
            //nth root number other than 1-10, it throws an exception error
            throw new RejectedExecutionException("Allowed root number 1-10 only");
        }
        if(rootNum == 1){
            return base;
        }

        double x0 = 1;
        boolean accurate = false;
        while (!accurate) {
            double x1 = (1 / (double)rootNum) * ((rootNum - 1) * x0 + base / power(x0, rootNum - 1));
            accurate = accurate(x0, x1);
            x0 = x1;
        }
        return x0;
    }
 
 
    private static boolean accurate(double x0, double x1) {
        return absolute(x1-x0) < 0.000001;
    }

    private static double absolute(double a){
        return (a <= 0) ? 0 - a : a;
    }

    static double power(double x, int n) {
        if(n == 0) {
            return 1;
        }
        return x * power(x, n-1);
    }
}
import java.util.Scanner;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;

public class Calc_Function_Rational {    
    
    public void rationalFunc() {
        double x;
        double y;
        String operation;
        
        Scanner readRational = new Scanner(System.in);

        System.out.println("Input first number: ");
        x = readRational.nextDouble();

        System.out.println("Input second number: ");
        y = readRational.nextDouble();

        System.out.println("Input operation (+, -, *, /): ");
        operation = readRational.next();
        
        readRational.close();

        double result = rationalResult(x, y, operation);

        File logFile = new File("Log.txt");

        try {
            if (!logFile.exists()) {
                logFile.createNewFile();
            }

            ((Appendable) logFile).append(String.format("%s %s %s = %s + \n",
                                                        x, operation, y, result));

            ((Flushable) logFile).flush();
            
            ((Closeable) logFile).close();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }
    double rationalResult(double x, double y, String operation) { 
        double res = 0;
        switch (operation) {
            case ("+"):
                 res = x + y;
                 break;
            case ("-"):
                 res = x - y;
                 break;
            case ("*"):
                res = x * y;
                    break;
            case("/"):
                res = x / y;
                break;
        }            
            
            
            return res;
    }

    
    
    
        
}
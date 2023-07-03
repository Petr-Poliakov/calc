import java.util.Scanner;
import java.io.File;
import java.io.Closeable;
import java.io.Flushable;

public class Calc_Function_Complex {

    public void complexFunc() {
        int realPart1;
        int imgPart1;
        int realPart2;
        int imgPart2;
        String operation;

        Scanner readComplex = new Scanner(System.in);

        System.out.println("FIRST number is REAL part: ");
        realPart1 = readComplex.nextInt();

        System.out.println("FIRST number is IMAGINARY part: ");
        imgPart1 = readComplex.nextInt();

        System.out.println("SECOND number is REAL part: ");
        realPart2 = readComplex.nextInt();

        System.out.println("SECOND number is IMAGINARY part: ");
        imgPart2 = readComplex.nextInt();

        System.out.println("Input operation (+, -, *, /): ");
        operation = readComplex.next();

        readComplex.close();

        String result = complexResult(realPart1, imgPart1, realPart2,
                                      imgPart2, operation);
        
        File logFile = new File("Log.txt");

        try {
            if (!logFile.exists()) {
                logFile.createNewFile();
            }

            ((Appendable) logFile).append(String.format("%s+%s %s %s+$s = %s+$s + \n",
                                                        realPart1, imgPart1, operation,
                                                        realPart2, imgPart2, result));

            ((Flushable) logFile).flush();
            
            ((Closeable) logFile).close();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    String complexResult(int realPart1, int imgPart1,
                      int realPart2, int imgPart2,
                      String operation) {
        
        String res = "";
        int resReal = 0;
        int resImg = 0;

        switch (operation) {
            case ("+"):
                resReal = realPart1 + realPart2;
                resImg = imgPart1 + imgPart2;
                res = resReal + " + " + resImg + "i";
                break;
            case ("-"):
                resReal = realPart1 - realPart2;
                resImg = imgPart1 - imgPart2;
                res = resReal + " + " + resImg + "i";
                break;
            case ("*"):
                resReal = realPart1 * realPart2 - imgPart1 * imgPart2;
                resImg = realPart1 * imgPart2 + realPart2 * imgPart1;
                res = resReal + " + " + resImg + "i";
                break;
            case ("/"):
                resReal = (realPart1 * realPart2 + imgPart1 * imgPart2)
                           / (realPart1 * realPart1) + (imgPart2 * imgPart2);
                resImg = (realPart2 * imgPart1 - realPart1 * imgPart2)
                          / (realPart1 * realPart1) + (imgPart2 * imgPart2);
                res = resReal + " + " + resImg + "i";
                break;
        }

        return res;
                        
    }

}
    

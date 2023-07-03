import java.util.Scanner;

public class Calc_Main {
    public static void main(String[] args) {

        Scanner scanMain = new Scanner(System.in);

        Calc_Function_Rational rational = new Calc_Function_Rational();
        Calc_Function_Complex complex = new Calc_Function_Complex();

        System.out.println("click 1 to select rational numbers");
        System.out.println(" or");
        System.out.println("click 2 to select complex numbers");

        int select = scanMain.nextInt();

        switch (select) {
            case (1):
                rational.rationalFunc();
                break;
            case (2):
                complex.complexFunc();
                break;
        
            default:
                System.out.println("Please select 1 or 2");
        }


        scanMain.close();
    } 

    
}
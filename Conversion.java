package conversion;

import java.util.Scanner;

public class Conversion {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = scan.nextInt();

        Compute m = new Compute();

        System.out.println("Binary: " + m.toBinary(num));
        System.out.println("Octal: " + m.toOctal(num));
        System.out.println("Hexadecimal: " + m.toHexadecimal(num));

    }
}


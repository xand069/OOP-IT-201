
package conversion;

public class Compute {

    public String toBinary(int num) {
        String Binary = "";
        do {
            int x = num % 2;
            Binary = x + Binary;
            num = num / 2;
        } while (num != 0);
        return Binary;
    }

    public String toOctal(int num) {
        String Octal = "";
        do {
            int x = num % 8;
            Octal = x + Octal;
            num = num / 8;
        } while (num != 0);
        return Octal;
    }

    public String toHexadecimal(int num) {
        String Hexadecimal = "";
        do {
            int x = num % 16;
            if (x < 10) {
                Hexadecimal = x + Hexadecimal;
            } else {
                char hexChar = (char) ('A' + (x - 10));
                Hexadecimal = hexChar + Hexadecimal;
            }
            num = num / 16;
        } while (num != 0);
        return Hexadecimal;
    }
}
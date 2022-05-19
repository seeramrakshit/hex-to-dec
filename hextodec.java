import java.util.*;

class HexFormatException extends IllegalArgumentException{
    public HexFormatException(String exe){
        super(exe);
    }
}

public class hexTodec {

    public static int hex2Dec(String givenHex) throws HexFormatException {
        givenHex = givenHex.toUpperCase();
        int dValue = 0;
        for (int i = 0; i < givenHex.length(); i++) {
            if ((givenHex.charAt(i) >= '0' && givenHex.charAt(i) <= '9') || (givenHex.charAt(i) >= 'A' && givenHex.charAt(i) <= 'F')){
                char hexChar = givenHex.charAt(i);
                dValue = dValue * 16 + hexCharToDecimal(hexChar);
            }
            else {
                throw new HexFormatException("Given Value is not a hexadecimal !");
            }
        }
        return dValue;
    }

    public static int hexCharToDecimal(char num) {
        if (num >= 'A' && num <= 'F')
            return 10 + num - 'A';
        else {
            return num - '0';
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a hexadecimal number: \n");
        String hex = input.nextLine();

        try {
            System.out.println("The decimal value for hexadecimal number "
                    + hex + " is " + hex2Dec(hex));
        }

        catch (HexFormatException ex) {
            System.out.println(ex.getMessage());
        }
    }
}


//Test.java
import java.util.*;

public class Test{   
    public static void main(String args) {
        int size, hammingCodeSize, errorPosition;
        int array[];
        int hammingCode[];
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the bits size for the data.");
        size =  sc.nextInt();
        array = new Int [size];

        for(int j = 0 ; j < size ; j ++){
            System.out.println("Enter " + (size - j) + "-bit ot the data:");

            array[size - j - 1] = sc.nextInt();
        }

        System.out.println("The data which you enter is: ");
        for(int k = 0 ; k < size ; k ++ ){
            System.out.print(array[size - k - 1]);
        }
        System.out.println();
        hammingCode = getHammingCode(array);
        hammingCodeSize = hammingCode.length;

        System.out.println("The hamming code generated for your data is: ");
        for ( int i = 0 ; i < hammingCodeSize; i++) {
            System.out.print(hammingCode [ (hammingCodeSize - i - 1 ) ] );
        }
        System.out.println();
        System.out.println("For detecting error at the receiver end, enter osition of a bit alter original data" + "(0 for no error):");
        errorPosition = sc.nextInt();
        sc.close();

        if(errorPosition != 0 ){
            hammingCode[errorPosition - 1] = (hammingCode[errorPosition - 1] + 1 ) % 2;
        }
        System.out.println("Sent Data is:");

        for(int k = 0 ; k < hammingCodeSize; k++){
            System.out.println(hammingCode[hammingCodeSize - k - 1]);
        }
        System.out.println();
        receiveData(hammingCode, hammingCodeSize - array.length);

    }

    
}
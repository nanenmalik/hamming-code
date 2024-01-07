//Test.java
import java.util.*;

public class Test {
    //main method
    public static void main(String [] args) {
        int size, hammingCodeSize, errorPosition;
        int array[];
        int hammingCode[];
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the bits size for the data.");
        size =  sc.nextInt();
        array = new int [size];

        for(int j = 0 ; j < size ; j ++){
            System.out.println("Enter " + (size - j) + "-bit ot the data:");

            array[size - j - 1] = sc.nextInt();
        }

        System.out.println("The data which you enter is: ");
        for(int k = 0 ; k < size ; k ++ ){
            System.out.print(array[size - k - 1]);
        }
        System.out.println();
        hammingCode = GetHammingCode(array);
        hammingCodeSize = hammingCode.length;

        System.out.println("The hamming code generated for your data is: ");
        for ( int i = 0 ; i < hammingCodeSize; i++) {
            System.out.print(hammingCode [ (hammingCodeSize - i - 1 ) ] );
        }
        System.out.println();
        System.out.println("For detecting error at the receiver end, enter position of a bit alter original data" + "(0 for no error):");
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

    public static int[]  GetHammingCode (int data[] )

    {
    int returnData [];
    int size;
    int i = 0, parityBits = 0 , j = 0, k = 0;
    size = data. length;
    while (i < size) {
    
       if (Math.pow (2, parityBits) == (1 + parityBits + 1)) {
          parityBits++;
       }
       else {
          i++;
       }
    }
    
    returnData = new int [size + parityBits];
    for (i = 1; i <= returnData.length; i++) {
       if (Math.pow (2, j) == i) {
          returnData[i-1] = 2;
          j++;
       }
       else {
          returnData[k+j] = data[k++];
       }
    }
    
    for (i = 0; i < parityBits; i++) {
       returnData[((int) Math.pow (2, i)) - 1] = getParityBit (returnData, i);
    }
    
    return returnData;
    
    }
    public static int getParityBit(int returnData[], int power) {
        int parityBit = 0;
        int size = returnData.length;

        for (int i = 0; i < size; i++) {
            if (returnData[i] != 2) {

                int k = i + 1;
                String str = Integer.toBinaryString(k);
                int x = ((Integer.parseInt(str)) / ((int) Math.pow(10, power))) % 10;

                if (x == 1) {
                    if (returnData[i] == 1) {
                        parityBit = (parityBit + 1) % 2;
                    }
                }
            }
        }
        return parityBit;
    }


public static void receiveData(int data[], int parityBits) {

        int pow;
        int size = data.length;

        int parityArray[] = new int[parityBits];

        String errorLoc = new String();

        for(pow = 0; pow < parityBits; pow++) {
            for(int i = 0; i < size; i++) {
                int k = i + 1;
                String str = Integer.toBinaryString(k);
                int bit = ((Integer.parseInt(str)) / ((int) Math.pow(10, pow))) % 10;
                if(bit == 1) {
                    if(data[i] == 1) {
                        parityArray[pow] = (parityArray[pow] + 1) % 2;
                    }
                }
            }
            errorLoc = parityArray[pow] + errorLoc;
        }

        int finalLoc = Integer.parseInt(errorLoc, 2);

        if(finalLoc != 0) {
            System.out.println("Error is at location " + finalLoc + ".");
            data[finalLoc - 1] = (data[finalLoc - 1] + 1) % 2;
            System.out.println("Corrected code is:");
            for(int i = 0; i < size; i++) {
                System.out.print(data[size - i - 1] );
            }
            System.out.println();
        }
        else {
            System.out.println("There is no error in the received data.");
        }

        System.out.println("The data sent from the sender: ");
        pow = parityBits - 1;
        for(int j = size; j > 0; j--) {
            if(Math.pow(2, pow) != j) {
                System.out.print(data[j - 1]);
            }
            else {
                pow--;
            }
        }

        System.out.println();



    }
    }



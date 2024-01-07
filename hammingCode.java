//hammingCode.java

public class hammingCode{
   
    //Method 3
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
}
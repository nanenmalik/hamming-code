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
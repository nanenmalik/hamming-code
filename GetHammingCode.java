
public static int()  GetHammingCode (int data[] )

{
int returnData [];
int size:
int 1 = 0, parityBits = 0 , j = 0, k = 0;
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

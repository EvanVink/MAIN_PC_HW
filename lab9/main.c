#include <stdio.h>
#include <stdlib.h>


long logicalAdder(long num1, long  num2) {
    return num1 ^ num2;
}


int main(int argc, char *argv[]) {

    int bitWidth = atoi(argv[1]);
    int number1 = atoi(argv[2]);
    int number2 = atoi(argv[3]);
    int shiftNumber = atoi(argv[4]);


    if(bitWidth != 8 && bitWidth != 16 && bitWidth != 32 && bitWidth != 64) {
        printf("Invalid BitWidth Value!");
        return 1;
    }

    printf("%d", logicalAdder(number1, number2));
    return 0;
}







// long detectOverflow() {
//
// }

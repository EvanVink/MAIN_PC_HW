#include <stdio.h>


int multipyValues(int x, int y) {
    return x * y;
}

int addValues(int x, int y) {
    return x + y;
}

void calculate(int operation, int x, int y) {
    switch(operation) {
        case 0:
            printf("%d", multipyValues(x,y));
            break;
        case 1:
            printf("%d", addValues(x,y));
            break;
        default:
            printf("invalid operation");
    }
}


int getOperation(int index) {
    if(index == 0) {
        return 0;
    }
    if (index == 1){
        return 1;
    }
    return -1;
}

int main(void) {
    printf("enter index\n");
    int operation = scanf(" enter:");

    int x = 5, y = 6;

    if(getOperation(operation) == -1) {
        printf("invalid operation");
    }


    calculate(operation, x, y);


    return 0;
}

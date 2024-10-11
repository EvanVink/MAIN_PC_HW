#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

#define ARRAY_SIZE 10 // Adjusted to match the problem constraints

void rotateArray(int arr[10][10], int n, int rows, int cols) {


    int temp[10][10];


    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            temp[i][j] = arr[i][j];
        }
    }


    if (n == 90) {
        for(int column = 0; column < cols; column++) {
            int decColumn = cols - 1;
            for(int row = 0; row < rows; row++) {
                temp[column][decColumn] = arr[row][column];
                decColumn--;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = temp[i][j];
            }
        }
    } else if (n == 180) {
        rotateArray(arr, 90, rows, cols);
        rotateArray(arr, 90, rows, cols);
    } else if (n == 270) {
        rotateArray(arr, 90, rows, cols);
        rotateArray(arr, 90, rows, cols);
        rotateArray(arr, 90, rows, cols);
    }




}

/*********************************/
// Do NOT touch anything below this line
int main(int argc, char **argv){
    int i, j, n;
    int arr[10][10] = {0}; // Initialize the array to zero

    // Sample 5x5 input array
    int sample[5][5] = {
        {1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1},
        {2, 2, 2, 2, 2},
        {2, 2, 2, 2, 2},
        {3, 3, 3, 3, 3}
    };

    // Copy sample input to arr
    for (i = 0; i < 5; i++) {
        for (j = 0; j < 5; j++) {
            arr[i][j] = sample[i][j];
        }
    }

    // Set the rotation angle
    n = 90; // Change this to test different angles

    printf("========INPUT=======\n");
    for (i = 0; i < 5; i++) {
        for (j = 0; j < 5; j++) {
            printf("%d", arr[i][j]);
        }
        printf("\n");
    }

    rotateArray(arr, 270, 5, 5);



    return 0;
}

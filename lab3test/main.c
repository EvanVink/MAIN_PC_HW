#include <stdio.h>


void rotateArray(int arr[10][10], int n, int rows, int cols) {


    int temp[10][10];


    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            temp[i][j] = arr[i][j];
        }
    }

    for(int column = 0; column < cols; column++) {
        int decColumn = cols - 1;
        for(int row = 0; row < rows; row++) {

            temp[column][decColumn] = arr[row][column];
            decColumn--;


        }

    }

    if (n == 90) {


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = temp[i][j];
            }
        }

    } else if (n == 180) {
        rotateArray(temp, 90, rows, cols);

        // for(int column = 0; column < cols; column++) {
        //     int decColumn = cols - 1;
        //     for(int row = 0; row < rows; row++) {
        //
        //         temp[column][decColumn] = arr[row][column];
        //         decColumn--;
        //
        //
        //     }
        //
        // }
        //
        // for (int i = 0; i < rows; i++) {
        //     for (int j = 0; j < cols; j++) {
        //         temp2[i][j] = temp[i][j];
        //     }
        // }
        //
        // for(int column = 0; column < cols; column++) {
        //     int decColumn = cols - 1;
        //     for(int row = 0; row < rows; row++) {
        //
        //         temp2[column][decColumn] = temp[row][column];
        //         decColumn--;
        //
        //
        //     }
        //
        // }
        // for (int i = 0; i < rows; i++) {
        //     for (int j = 0; j < cols; j++) {
        //         printf("%d", temp2[i][j]);
        //     }
        //     printf("\n");
        // }
    } else if (n == 270) {


        for(int column = cols - 1; column <= 0; column--) {
            int decColumn = cols - 1;
            for(int row = rows - 1; row <= 0; row--) {

                temp[column][decColumn] = arr[row][column];
                decColumn++;


            }

        }

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                printf("%d", temp[i][j]);
            }
            printf("\n");
        }




    }




}



int main(void)
{

    int arr[10][10] = {0};

    int sample[6][6] = {
        {1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1},
        {2, 2, 2, 2, 2, 2},
        {2, 2, 2, 2, 2, 2},
        {3, 3, 3, 3, 3, 3},
        {3, 3, 3, 3, 3, 3}
    };


    for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 6; j++) {
            arr[i][j] = sample[i][j];
        }
    }

    rotateArray(arr, 180, 6, 6);

    printf("=======OUTPUT=======\n");
    for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 6; j++) {
            printf("%d", arr[i][j]);
        }
        printf("\n");
    }
    return 0;
}

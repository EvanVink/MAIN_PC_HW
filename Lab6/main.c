//
// Created by socce on 10/17/2024.
//
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "Student.h"



int main(int argc, char *argv[]) {

    domesticStudent *domesticStudents = NULL;
    int domesticCount = 0;
    internationalStudent *internationalStudents = NULL;
    int internationalCount = 0;


    char *input = argv[1];
    char *output = argv[2];
    char option = atoi(argv[3]);
    char sort = atoi(argv[4]);


    //Call the rFile function
    rFile(input, output, &domesticStudents, &domesticCount, &internationalStudents, &internationalCount);

    //Print the students
    printStudents(output, option, domesticStudents, domesticCount, internationalStudents, internationalCount, sort);

    //Free allocated memory
    free(domesticStudents);
    free(internationalStudents);


    //nest the current for loop into a while loop to fgets until its not null to parse through it

    // while(fgets(firstName, 100, file) != nullptr) {
for (int k = 0; k < 6; k++) {
    fgets(firstName, 100, file);

    char *studentItem = strtok(firstName, " ");

    while(studentItem != NULL) {
        printf("%s\n", studentItem);

        studentItem = strtok(NULL, " ");
    }
    // for(int i = 0; i <5; i++) {
    //     if (studentItem == nullptr) break;
    //     //add a counter for the for loop and change the for loop to while NOT NULL and if the count is 5
    //     //then add it to a international student
    //     //if its 4 then add it to domestic student
    //     printf("%s\n", studentItem);
    //
    //     studentItem = strtok(nullptr, " ");
    // }
}
    // }

    // printf("%s\n", fgets(firstName, 100, file));
    //
    // printf("%s\n", fgets(firstName, 100, file));
    // printf("%s\n", fgets(firstName, 100, file));
    // printf("%s\n", fgets(firstName, 100, file));
    // printf("%s\n", fgets(firstName, 100, file));
    // printf("%s\n", fgets(firstName, 100, file));
    //


    // strcpy(studentD.firstName, "Evan");
    // strcpy(studentD.lastName, "Vink");
    // studentD.GPA = 3.920;

    // array[amountOfStudents] = studentD;

    return 0;

}

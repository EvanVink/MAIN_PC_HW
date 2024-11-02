//
// Created by socce on 10/17/2024.
//
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "Student.h"



int main(int argc, char *argv[]) {

    // char *input = argv[1];
    // domesticStudent *domesticStudents = NULL;
    // internationalStudent *internationalStudents = NULL;
    // int domesticCount = 0;
    // int internationalCount = 0;
    //
    // rFile(input, &domesticStudents, &domesticCount, &internationalStudents, &internationalCount);
    //
    // // printStudents(domesticStudents, domesticCount, internationalStudents, internationalCount);
    domesticStudent *domesticStudents = NULL;
    int domesticCount = 0;
    internationalStudent *internationalStudents = NULL;
    int internationalCount = 0;

    // Call the rFile function
    rFile("input.txt", &domesticStudents, &domesticCount, &internationalStudents, &internationalCount);

    // Print the students
    printStudents(domesticStudents, domesticCount, internationalStudents, internationalCount);

    // Free allocated memory
    free(domesticStudents);
    free(internationalStudents);

    return 0;

}

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


    //Call the rFile function
    rFile(input, output, &domesticStudents, &domesticCount, &internationalStudents, &internationalCount);

    //Print the students
    printStudents(output, option, domesticStudents, domesticCount, internationalStudents, internationalCount);

    //Free allocated memory
    free(domesticStudents);
    free(internationalStudents);

    return 0;

}

//
// Created by socce on 11/1/2024.
//
#include <stdio.h>
#include <string.h>
#include "Student.h"

#include <stdlib.h>


// void wFile() {
//
// }

void addInternationalStudent(internationalStudent **students, int *count, const char *firstName, const char *lastName, float GPA, int TOEFL) {

    *students = realloc(*students, (*count + 1) * sizeof(internationalStudent));
    if(*students == NULL) {
        printf("Memory allocation failed for international students\n");
        exit(1);
    }

    strcpy((*students)[*count].firstName, firstName);
    strcpy((*students)[*count].lastName, lastName);
    (*students)[*count].GPA = GPA;
    (*students)[*count].studentType = 'I';
    (*students)[*count].TOEFL = TOEFL;
    (*count)++;

}

void addDomesticStudent(domesticStudent **students, int *count, const char *firstName, const char *lastName, float GPA) {
    *students = realloc(*students, (*count + 1) * sizeof(domesticStudent));
    if (*students == NULL) {
        printf("Memory allocation failed for domestic students\n");
        exit(1);
    }


    strcpy((*students)[*count].firstName, firstName);
    strcpy((*students)[*count].lastName, lastName);
    (*students)[*count].GPA = GPA;
    (*students)[*count].studentType = 'D';
    (*count)++;
}


void rFile(const char *inputFile, domesticStudent **domesticStudents, int *domesticCount, internationalStudent **internationalStudents, int *internationalCount) {

    FILE *file;
    char line[100];

    file = fopen("input.txt", "r");

    while(fgets(line, 100, file)) {
        domesticStudent studentD;
        internationalStudent studentI;
        char firstName[100];
        char lastName[100];
        double GPA;
        char studentType = '\0';
        int TOEFL = 0;


        char *studentItem = strtok(line, " ");
        int count = 0;


        while(studentItem != NULL) {

            switch (count) {
                case 0:
                    strcpy(firstName, studentItem);
                    break;
                case 1:
                    strcpy(lastName, studentItem);
                    break;
                case 2:
                    GPA = atof(studentItem);
                    break;
                case 3:
                    studentType = studentItem[0];
                    break;
                case 4:
                    if (studentType == 'I') {
                        TOEFL = atoi(studentItem);
                    }
                    break;
                default:
                    //write error method
            }

            count++;
            studentItem = strtok(NULL, " ");
        }

        // if(count < 4 || count > 5) {
        //     //write error method
        // }

        if(studentType == 'D') {
            addDomesticStudent(domesticStudents, domesticCount, firstName, lastName, GPA);

        } else if(studentType == 'I') {
            addInternationalStudent(internationalStudents, internationalCount, firstName, lastName, GPA, TOEFL);

        }

    }

}


void printStudents(domesticStudent *domesticStudents, int domesticCount, internationalStudent *internationalStudents, int internationalCount) {
    printf("\nDomestic Students:\n");
    for (int i = 0; i < domesticCount; i++) {
        printf("Name: %s %s, GPA: %.2f, Type: %c\n", domesticStudents[i].firstName, domesticStudents[i].lastName, domesticStudents[i].GPA, domesticStudents[i].studentType);
    }

    printf("\nInternational Students:\n");
    for (int i = 0; i < internationalCount; i++) {
        printf("Name: %s %s, GPA: %.2f, Type: %c, TOEFL: %d\n", internationalStudents[i].firstName, internationalStudents[i].lastName, internationalStudents[i].GPA, internationalStudents[i].studentType, internationalStudents[i].TOEFL);
    }
}


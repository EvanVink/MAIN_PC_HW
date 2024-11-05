
#include <stdio.h>
#include <string.h>
#include "Student.h"
#include <stdlib.h>



/**
 * Adds an international student to the students array.
 * Allocates memory for a new international student and assigns their attributes.
 *
 * @param students Pointer to the array of internationalStudent structures.
 * @param count Pointer to the number of students in the array.
 * @param firstName The first name of the student.
 * @param lastName The last name of the student.
 * @param GPA The GPA of the student.
 * @param TOEFL The TOEFL score of the student.
 * @param month
 * @param day
 * @param year
 */
void addInternationalStudent(internationalStudent **students, int *count, const char *firstName, const char *lastName,
    float GPA, int TOEFL, const char *month, int day, int year) {

    *students = realloc(*students, (*count + 1) * sizeof(internationalStudent));
    if(*students == NULL) {
        printf("Memory allocation failed for international students\n");
        exit(1);
    }

    strcpy((*students)[*count].firstName, firstName);
    strcpy((*students)[*count].lastName, lastName);
    (*students)[*count].GPA = GPA;
    (*students)[*count].day = day;
    strcpy((*students)[*count].month, month);
    (*students)[*count].year = year;
    (*students)[*count].studentType = 'I';
    (*students)[*count].TOEFL = TOEFL;
    (*count)++;

}

/**
 * Adds a domestic student to the students array.
 * Allocates memory for a new domestic student and assigns their attributes.
 *
 * @param students Pointer to the array of domesticStudent structures.
 * @param count Pointer to the number of students in the array.
 * @param firstName The first name of the student.
 * @param lastName The last name of the student.
 * @param GPA The GPA of the student.
 * @param month
 * @param day
 * @param year
 */
void addDomesticStudent(domesticStudent **students, int *count, const char *firstName, const char *lastName,
    float GPA, const char *month, int day, int year) {
    *students = realloc(*students, (*count + 1) * sizeof(domesticStudent));
    if (*students == NULL) {
        printf("Memory allocation failed for domestic students\n");
        exit(1);
    }


    strcpy((*students)[*count].firstName, firstName);
    strcpy((*students)[*count].lastName, lastName);
    (*students)[*count].GPA = GPA;
    (*students)[*count].day = day;
    strcpy((*students)[*count].month, month);
    (*students)[*count].year = year;
    (*students)[*count].studentType = 'D';
    (*count)++;
}

/**
 * Reads student data from an input file and populates domestic and international student arrays.
 * Writes errors related to invalid file format to a specified output file.
 *
 * @param inputFile The path to the input file containing student data.
 * @param output The path to the output file for error messages.
 * @param domesticStudents Pointer to the array of domesticStudent structures.
 * @param domesticCount Pointer to the number of domestic students in the array.
 * @param internationalStudents Pointer to the array of internationalStudent structures.
 * @param internationalCount Pointer to the number of international students in the array.
 */
void rFile(const char *inputFile, char *output, domesticStudent **domesticStudents, int *domesticCount, internationalStudent **internationalStudents, int *internationalCount) {
    FILE *file;
    FILE *outputFILE = fopen(output, "w");;
    char line[100];

    file = fopen(inputFile, "r");

    while(fgets(line, 100, file)) {
        char firstName[100];
        char lastName[100];
        float GPA = 0;
        char studentType = '\0';
        int TOEFL = 0;
        int day = 0;
        char month[11];
        int year = 0;


        int lineScaned = sscanf(line, "%s %s %s %f %c %d", firstName, lastName, month, &GPA, &studentType, &TOEFL);


        printf("%s %s %s %.2f %c %d\n", firstName, lastName, month, GPA, studentType, TOEFL);










        if(studentType == 'D') {
            addDomesticStudent(domesticStudents, domesticCount, firstName, lastName, GPA, month, day, year);

        } else if(studentType == 'I') {
            addInternationalStudent(internationalStudents, internationalCount, firstName, lastName, GPA, TOEFL, month, day, year);

        } else {
            fprintf(outputFILE, "Error: invalid student Type %c", studentType);
            exit(1);
        }


        // char *studentItem = strtok(line, " ");
        //
        // int count = 0;
        //
        // for(int i = 0; i < 2; i++) {
        //     switch (count) {
        //         case 0:
        //             strcpy(firstName, studentItem);
        //             break;
        //         case 1:
        //             strcpy(lastName, studentItem);
        //             break;
        //     }
        //     count++;
        //     studentItem = strtok(NULL, " ");
        // }
        //
        // char *studentDate = strtok(studentItem, "-");
        // for(int i = 0; i < 3; i++) {
        //     switch (count) {
        //         case 2:
        //             strcpy(month, studentDate);
        //             break;
        //         case 3:
        //             day = atoi(studentDate);
        //             break;
        //         case 4:
        //             year = atoi(studentDate);
        //             break;
        //         default:
        //             break;
        //     }
        //     count++;
        //     studentDate = strtok(NULL, "-");
        //
        //
        // }
        //
        // while(studentItem != NULL) {
        //     switch (count) {
        //         case 5:
        //             printf("%s", studentItem);
        //             studentType = studentItem[0];
        //             break;
        //         case 6:
        //             if (studentType == 'I') {
        //                 TOEFL = atoi(studentItem);
        //             }
        //             break;
        //         default:
        //             break;
        //     }
        //     count++;
        //     studentItem = strtok(NULL, " ");
        // }

    }
}


        // while(studentItem != NULL) {
        //
        //     switch (count) {
        //         case 0:
        //             strcpy(firstName, studentItem);
        //             break;
        //         case 1:
        //             strcpy(lastName, studentItem);
        //             break;
        //         case 2:
        //             GPA = atof(studentItem);
        //             break;
        //         case 3:
        //             studentType = studentItem[0];
        //             break;
        //         case 4:
        //             if (studentType == 'I') {
        //                 TOEFL = atoi(studentItem);
        //             }
        //             break;
        //         default:
        //             fprintf(outputFILE, "Error: invalid format");
        //             exit(1);
        //     }


        // if(count < 4 || count > 5) {
        //     fprintf(outputFILE, "Error: invalid format");
        //     exit(1);
        // }





/**
 * Prints filtered student information to a specified output file.
 * Outputs students based on the specified option, such as high GPA or high GPA and TOEFL.
 *
 * @param output The path to the output file for writing student information.
 * @param option The filtering option (1, 2, or 3) for selecting students to print.
 * @param domesticStudents Array of domestic students.
 * @param domesticCount Number of domestic students in the array.
 * @param internationalStudents Array of international students.
 * @param internationalCount Number of international students in the array.
 * @param sort
 */
void printStudents(char *output, int option, domesticStudent *domesticStudents, int domesticCount, internationalStudent *internationalStudents, int internationalCount, int sort) {

    FILE *outFile = fopen(output, "w");

    switch(option) {
        case 1:
            for(int i = 0; i < domesticCount; i++) {
                if(domesticStudents[i].GPA > 3.9) {

                    fprintf(outFile, "Domestic Students with a GPA of above 3.9:\n%s %s %.3f %c\n", domesticStudents[i].firstName, domesticStudents[i].lastName,
                        domesticStudents[i].GPA, domesticStudents[i].studentType);

                }
            }
            break;
        case 2:
            for(int i = 0; i < internationalCount; i++) {

                if(internationalStudents[i].GPA > 3.9 && internationalStudents[i].TOEFL >= 70) {
                    fprintf(outFile, "International Students with a GPA of above 3.9 and TOEFL above 70:\n%s %s %.3f %c %d\n",
                        internationalStudents[i].firstName, internationalStudents[i].lastName,
                        internationalStudents[i].GPA, internationalStudents[i].studentType, internationalStudents[i].TOEFL);

                }
            }
            break;
        case 3:
            for(int i = 0; i < domesticCount; i++) {
                if(domesticStudents[i].GPA > 3.9) {

                    fprintf(outFile, "Domestic Students with a GPA of above 3.9:\n%s %s %.3f %c\n", domesticStudents[i].firstName, domesticStudents[i].lastName,
                        domesticStudents[i].GPA, domesticStudents[i].studentType);

                }
            }
            for(int i = 0; i < internationalCount; i++) {
                if(internationalStudents[i].GPA > 3.9 && internationalStudents[i].TOEFL >= 70) {

                    fprintf(outFile, "International Students with a GPA of above 3.9 and TOEFL above 70:\n%s %s %.3f %c %d\n",
                        internationalStudents[i].firstName, internationalStudents[i].lastName,
                        internationalStudents[i].GPA, internationalStudents[i].studentType, internationalStudents[i].TOEFL);

                }
            }
            break;
        case 4:

        if(sort == 1) {
            int y;
            domesticStudent dKey;

            //insertion sort for the domestic students
            for(int x = 1; x < domesticCount; x++) {
                dKey = domesticStudents[x];
                y = x - 1;

                while(y >= 0 && domesticStudents[y].GPA > dKey.GPA) {
                    domesticStudents[y + 1] = domesticStudents[y];
                    y = y - 1;
                }

                domesticStudents[y + 1] = dKey;
            }

            int p;
            internationalStudent iKey;

            //insertion sort for the international students
            for(int x = 1; x < internationalCount; x++) {
                iKey = internationalStudents[x];
                p = x - 1;

                while(p >= 0 && internationalStudents[p].GPA > iKey.GPA) {
                    internationalStudents[p + 1] = internationalStudents[p];
                    p = p - 1;
                }

                internationalStudents[p + 1] = iKey;
            }

            fprintf(outFile, "Domestic Students GPA in descending order:\n");

            for(int i = domesticCount - 1; i >= 0; i--) {

                fprintf(outFile, "%s %s %.3f %c\n", domesticStudents[i].firstName, domesticStudents[i].lastName,
                    domesticStudents[i].GPA, domesticStudents[i].studentType);

            }

            fprintf(outFile, "International Students GPA in descending order:\n");

            for(int i = internationalCount - 1; i >= 0; i--) {

                fprintf(outFile, "%s %s %.3f %c %d\n", internationalStudents[i].firstName, internationalStudents[i].lastName,
                    internationalStudents[i].GPA, internationalStudents[i].studentType, internationalStudents[i].TOEFL);

            }

        } else if (sort == 0) {

            fprintf(outFile, "Domestic Students GPA:\n");

            for(int i = 0; i < domesticCount; i++) {

                fprintf(outFile, "%s %s %.3f %c %s %d %d\n", domesticStudents[i].firstName, domesticStudents[i].lastName,
                    domesticStudents[i].GPA, domesticStudents[i].studentType, domesticStudents[i].month,
                    domesticStudents[i].day, domesticStudents[i].year);
            }

            fprintf(outFile, "International Students GPA:\n");

            for(int i = 0; i < domesticCount; i++) {

                fprintf(outFile, "%s %s %.3f %c %d %s %d %d\n", internationalStudents[i].firstName, internationalStudents[i].lastName,
                    internationalStudents[i].GPA, internationalStudents[i].studentType, internationalStudents[i].TOEFL,
                    internationalStudents[i].month, internationalStudents[i].day, internationalStudents[i].year);

            }
        } else {
            fprintf(outFile, "Error: invalid sort choice");
            exit(1);
        }
        break;

        default:
            fprintf(outFile, "Error: invalid choice");
            exit(1);
    }

}




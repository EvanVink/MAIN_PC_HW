//
// Created by socce on 11/1/2024.
//

#ifndef STUDENT_H
#define STUDENT_H
#define MAX_NAME 100

//Struct for the domestic students
typedef struct {
    char firstName[MAX_NAME];
    char lastName[MAX_NAME];
    float GPA;
    char studentType;
}domesticStudent;

//Struct for the international students
typedef struct {
    char firstName[MAX_NAME];
    char lastName[MAX_NAME];
    float GPA;
    char studentType;
    int TOEFL;
}internationalStudent;

void rFile(const char *inputFile, char *output, domesticStudent **domesticStudents, int *domesticCount, internationalStudent **internationalStudents, int *internationalCount);
void addDomesticStudent(domesticStudent **students, int *count, const char *firstName, const char *lastName, float GPA);
void addInternationalStudent(internationalStudent **students, int *count, const char *firstName, const char *lastName, float GPA, int TOEFL);
void printStudents(char *output, int option, domesticStudent *domesticStudents, int domesticCount, internationalStudent *internationalStudents, int internationalCount);


#endif //STUDENT_H

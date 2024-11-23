
#ifndef STUDENT_H
#define STUDENT_H

#define MAX_NAME 100

//Struct for the domestic students
typedef struct {
    char firstName[MAX_NAME];
    char lastName[MAX_NAME];
    float GPA;
    int day;
    char month[4];
    int year;
    char studentType;
}domesticStudent;

//Struct for the international students
typedef struct {
    char firstName[MAX_NAME];
    char lastName[MAX_NAME];
    float GPA;
    int day;
    char month[4];
    int year;
    char studentType;
    int TOEFL;
}internationalStudent;


union students {
    domesticStudent dom;
    internationalStudent inter;
};



void rFile(const char *inputFile, char *output, domesticStudent **domesticStudents, int *domesticCount, internationalStudent **internationalStudents, int *internationalCount);
void addDomesticStudent(domesticStudent **students, int *count, const char *firstName, const char *lastName, float GPA, const char *month, int day, int year);
void addInternationalStudent(internationalStudent **students, int *count, const char *firstName, const char *lastName, float GPA, int TOEFL, const char *month, int day, int year);
void printStudents(char *output, int option, domesticStudent *domesticStudents, int domesticCount, internationalStudent *internationalStudents, int internationalCount);
void merge_sort_international(internationalStudent iStudents[], int left, int right);
void merge_sort_domestic(domesticStudent dStudents[], int left, int right);

#endif //STUDENT_H





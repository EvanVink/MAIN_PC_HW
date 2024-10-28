//
// Created by socce on 10/17/2024.
//
#include <stdio.h>
#include <stdlib.h>
#include <string.h>



typedef struct {
    char firstName[100];
    char lastName[100];
    float GPA;
}domesticStudent;

typedef struct {
    char firstName[100];
    char lastName[100];
    float GPA;
    int TOEFL;
}internationalStudent;

domesticStudent array[50];


void newStudent(int amountOfStudents) {

    FILE *file;
    domesticStudent studentD;
    internationalStudent studentI;
    char firstName[100];
    char lastName[100];
    int GPA;
    char *fNaddress;
    int diff;


    file = fopen("C:\\Users\\socce\\Desktop\\MAINPCHW\\MAIN_PC_HW\\Lab6\\input.txt", "r");
    fgets(firstName, 100, file);

    char *studentItem = strtok(firstName, " ");

    //nest the current for loop into a while loop to fgets until its not null to parse through it

    for(int i = 0; i < 5; i++) {

//add a counter for the for loop and change the for loop to while NOT NULL and if the count is 5
        //then add it to a international student
        //if its 4 then add it to domestic student
        printf("%s\n", studentItem);

        studentItem = strtok(NULL, " ");
    }




    fgets(firstName, 100, file);

    // char *student = strtok();

    printf("%s", firstName);

    // strcpy(studentD.firstName, "Evan");
    // strcpy(studentD.lastName, "Vink");
    // studentD.GPA = 3.920;

    // array[amountOfStudents] = studentD;

}

int main() {

    newStudent(0);
    printf("%s, %s, %f", array[0].firstName, array[0].lastName, array[0].GPA);



}
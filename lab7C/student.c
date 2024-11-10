//
// Created by socce on 11/7/2024.
//
#include "student.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>




int compare_students(const Student *a, const Student *b) {

    int cmp = strcmp(a->last_name, b->last_name);
    if(cmp != 0) {
        return cmp;
    }

    cmp = strcmp(a->first_name, b->first_name);
    if(cmp != 0) {
        return cmp;
    }

    cmp = strcmp(a->student_number, b->student_number);
    if(cmp != 0) {
        return cmp;
    }

    if(a->midterm_grade != b->midterm_grade) {
        return a->midterm_grade - b->midterm_grade;
    }

    return a->final_grade - b->final_grade;
}

void merge(Student students[], int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    Student *L = (Student *)malloc(n1 * sizeof(Student));
    Student *R = (Student *)malloc(n2 * sizeof(Student));

    for(int i = 0; i <n1; i++) {
        L[i] = students[left + i];
    }
    for(int j = 0; j < n2; j++) {
        R[j] = students[mid + 1 + j];
    }

    int i = 0, j = 0, k = left;
    while(i < n1 && j < n2) {
        if(compare_students(&L[i], &R[j]) <= 0) {
            students[k++] = L[i++];
        } else {
            students[k++] = R[j++];
        }
    }

    while(i < n1) {
        students[k++] = L[i++];
    }

    while(j < n2) {
        students[k++] = R[j++];
    }

    free(L);
    free(R);

}


void merge_sort(Student students[], int left, int right) {
    if(left < right) {
        int mid = left + (right - left) / 2;
        merge_sort(students, left, mid);
        merge_sort(students, mid + 1, right);
        merge(students, left, mid, right);
    }
}


int partition(Student students[], int left, int right) {
    Student pivot = students[right];
    int i = left - 1;

    for(int j = left; j < right; j++) {
        if(compare_students(&students[j], &pivot) <= 0) {
            i++;

            Student temp = students[i];
            students[i] = students[j];
            students[j] = temp;
        }
    }


    Student temp = students[i + 1];
    students[i + 1] = students[right];
    students[right] = temp;

    return i + 1;
}

void quick_sort(Student students[], int left, int right) {
    if(left < right) {
        int pi = partition(students, left, right);
        quick_sort(students, left, pi - 1);
        quick_sort(students, pi + 1, right);
    }
}




float calculate_average(const Student *student) {
    return (student->midterm_grade + student->final_grade) / 2;
}


int read_students(const char *filename, Student students[], int max_students) {
    FILE *file = fopen(filename, "r");
    if(!file) {
        printf("Error: Could not open file %s\n", filename);
        return 0;
    }

    int count = 0;

    while(count < max_students && fscanf(file, "%s %s %s %d %d",
        students[count].last_name,
        students[count].first_name,
        students[count].student_number,
        &students[count].midterm_grade,
        &students[count].final_grade) == 5) {
        count++;
    }

    fclose(file);
    return count;
}


void write_to_file(const char *filename, const Student students[], int count, int option) {
    FILE *file = fopen(filename, "w");
    if(!file) {
        printf("Error: could not open file %s\n", filename);
        return;
    }

    for(int i = 0; i < count; i++) {
        float avg = calculate_average(&students[i]);
        int write = 0;

        switch(option) {
            case 1: if(avg > 90) write = 1; break;
            case 2: if(avg >= 80 && avg <= 90) write = 1; break;
            case 3: if(avg >= 70 && avg < 80) write = 1; break;
            case 4: if(avg >= 60 && avg < 70) write = 1; break;
            case 5: if(avg < 60) write = 1; break;
        }

        if(write) {
            fprintf(file, "%s %s %s %d %d %.2f\n",
                students[i].last_name, students[i].first_name,
                students[i].student_number,
                students[i].midterm_grade, students[i].final_grade, avg);
        }
    }
    fclose(file);
}


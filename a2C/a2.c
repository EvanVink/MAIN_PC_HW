#include <stdio.h>
#include <string.h>
#include <stdlib.h>








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

    if(inputFile == NULL) {
        fprintf(outputFILE, "Error: error opening file");
        exit(1);
    }

    while(fgets(line, 100, file)) {
        char firstName[100];
        char lastName[100];
        float GPA = 0;
        char studentType = '\0';
        int TOEFL = 0;
        int day = 0;
        char date[11];
        char month[4];
        int year = 0;


        int lineScanned = sscanf(line, "%s %s %s %f %c %d", firstName, lastName, date, &GPA, &studentType, &TOEFL);
        int secLineScanned = sscanf(date, "%3s-%d-%d", month, &day, &year);

        if(lineScanned > 6 || secLineScanned > 3) {
            fprintf(outputFILE, "Error: error parsing the file");
            exit(1);
        }

        if(GPA > 4.3 || GPA < 0) {
            fprintf(outputFILE, "Error: Invalid GPA");
            exit(1);
        }

        if(year > 2010 || year < 1950) {
            fprintf(outputFILE, "Error: Invalid Year");
            exit(1);
        }


        if(studentType == 'D') {
            addDomesticStudent(domesticStudents, domesticCount, firstName, lastName, GPA, month, day, year);

        } else if(studentType == 'I') {
            addInternationalStudent(internationalStudents, internationalCount, firstName, lastName, GPA, TOEFL, month, day, year);

        } else {
            fprintf(outputFILE, "Error: invalid student Type %c", studentType);
            exit(1);
        }


    }
}

int compareMix(const internationalStudent *a, const domesticStudent *b) {
    int cmp;

    if(a->year != b->year) {
        return a->year - b->year;
    }


    int aMonth;
    if (strcmp(a->month, "Jan") == 0) aMonth = 1;
    if (strcmp(a->month, "Feb") == 0) aMonth = 2;
    if (strcmp(a->month, "Mar") == 0) aMonth = 3;
    if (strcmp(a->month, "Apr") == 0) aMonth = 4;
    if (strcmp(a->month, "May") == 0) aMonth = 5;
    if (strcmp(a->month, "Jun") == 0) aMonth = 6;
    if (strcmp(a->month, "Jul") == 0) aMonth = 7;
    if (strcmp(a->month, "Aug") == 0) aMonth = 8;
    if (strcmp(a->month, "Sep") == 0) aMonth = 9;
    if (strcmp(a->month, "Oct") == 0) aMonth = 10;
    if (strcmp(a->month, "Nov") == 0) aMonth = 11;
    if (strcmp(a->month, "Dec") == 0) aMonth = 12;

    int bMonth;
    if (strcmp(b->month, "Jan") == 0) bMonth = 1;
    if (strcmp(b->month, "Feb") == 0) bMonth = 2;
    if (strcmp(b->month, "Mar") == 0) bMonth = 3;
    if (strcmp(b->month, "Apr") == 0) bMonth = 4;
    if (strcmp(b->month, "May") == 0) bMonth = 5;
    if (strcmp(b->month, "Jun") == 0) bMonth = 6;
    if (strcmp(b->month, "Jul") == 0) bMonth = 7;
    if (strcmp(b->month, "Aug") == 0) bMonth = 8;
    if (strcmp(b->month, "Sep") == 0) bMonth = 9;
    if (strcmp(b->month, "Oct") == 0) bMonth = 10;
    if (strcmp(b->month, "Nov") == 0) bMonth = 11;
    if (strcmp(b->month, "Dec") == 0) bMonth = 12;




    if(aMonth != bMonth) {
        return aMonth - bMonth;
    }


    if(a->day != b->day) {
        return a->day - b->day;
    }

    cmp = strcmp(a->lastName, b->lastName);
    if(cmp != 0) {
        return cmp;
    }

    cmp = strcmp(a->firstName, b->firstName);
    if(cmp != 0) {
        return cmp;
    }

    if(a->GPA > b->GPA) {
        return 1;
    }
    if(a->GPA < b->GPA) {
        return -1;
    }
    return 0;
}




int compareDomestic(const domesticStudent *a, const domesticStudent *b) {

    int cmp;

    if(a->year != b->year) {
        return a->year - b->year;
    }


    int aMonth;
    if (strcmp(a->month, "Jan") == 0) aMonth = 1;
    if (strcmp(a->month, "Feb") == 0) aMonth = 2;
    if (strcmp(a->month, "Mar") == 0) aMonth = 3;
    if (strcmp(a->month, "Apr") == 0) aMonth = 4;
    if (strcmp(a->month, "May") == 0) aMonth = 5;
    if (strcmp(a->month, "Jun") == 0) aMonth = 6;
    if (strcmp(a->month, "Jul") == 0) aMonth = 7;
    if (strcmp(a->month, "Aug") == 0) aMonth = 8;
    if (strcmp(a->month, "Sep") == 0) aMonth = 9;
    if (strcmp(a->month, "Oct") == 0) aMonth = 10;
    if (strcmp(a->month, "Nov") == 0) aMonth = 11;
    if (strcmp(a->month, "Dec") == 0) aMonth = 12;

    int bMonth;
    if (strcmp(b->month, "Jan") == 0) bMonth = 1;
    if (strcmp(b->month, "Feb") == 0) bMonth = 2;
    if (strcmp(b->month, "Mar") == 0) bMonth = 3;
    if (strcmp(b->month, "Apr") == 0) bMonth = 4;
    if (strcmp(b->month, "May") == 0) bMonth = 5;
    if (strcmp(b->month, "Jun") == 0) bMonth = 6;
    if (strcmp(b->month, "Jul") == 0) bMonth = 7;
    if (strcmp(b->month, "Aug") == 0) bMonth = 8;
    if (strcmp(b->month, "Sep") == 0) bMonth = 9;
    if (strcmp(b->month, "Oct") == 0) bMonth = 10;
    if (strcmp(b->month, "Nov") == 0) bMonth = 11;
    if (strcmp(b->month, "Dec") == 0) bMonth = 12;




    if(aMonth != bMonth) {
        return aMonth - bMonth;
    }


    if(a->day != b->day) {
        return a->day - b->day;
    }

    cmp = strcmp(a->lastName, b->lastName);
    if(cmp != 0) {
        return cmp;
    }

    cmp = strcmp(a->firstName, b->firstName);
    if(cmp != 0) {
        return cmp;
    }

    if(a->GPA > b->GPA) {
        return 1;
    }
    if(a->GPA < b->GPA) {
        return -1;
    }
    return 0;
}


int compareInternational(const internationalStudent *a, const internationalStudent *b) {

    int cmp;

    if(a->year != b->year) {
        return a->year - b->year;
    }


    int aMonth;
    if (strcmp(a->month, "Jan") == 0) aMonth = 1;
    if (strcmp(a->month, "Feb") == 0) aMonth = 2;
    if (strcmp(a->month, "Mar") == 0) aMonth = 3;
    if (strcmp(a->month, "Apr") == 0) aMonth = 4;
    if (strcmp(a->month, "May") == 0) aMonth = 5;
    if (strcmp(a->month, "Jun") == 0) aMonth = 6;
    if (strcmp(a->month, "Jul") == 0) aMonth = 7;
    if (strcmp(a->month, "Aug") == 0) aMonth = 8;
    if (strcmp(a->month, "Sep") == 0) aMonth = 9;
    if (strcmp(a->month, "Oct") == 0) aMonth = 10;
    if (strcmp(a->month, "Nov") == 0) aMonth = 11;
    if (strcmp(a->month, "Dec") == 0) aMonth = 12;

    int bMonth;
    if (strcmp(b->month, "Jan") == 0) bMonth = 1;
    if (strcmp(b->month, "Feb") == 0) bMonth = 2;
    if (strcmp(b->month, "Mar") == 0) bMonth = 3;
    if (strcmp(b->month, "Apr") == 0) bMonth = 4;
    if (strcmp(b->month, "May") == 0) bMonth = 5;
    if (strcmp(b->month, "Jun") == 0) bMonth = 6;
    if (strcmp(b->month, "Jul") == 0) bMonth = 7;
    if (strcmp(b->month, "Aug") == 0) bMonth = 8;
    if (strcmp(b->month, "Sep") == 0) bMonth = 9;
    if (strcmp(b->month, "Oct") == 0) bMonth = 10;
    if (strcmp(b->month, "Nov") == 0) bMonth = 11;
    if (strcmp(b->month, "Dec") == 0) bMonth = 12;




    if(aMonth != bMonth) {
        return aMonth - bMonth;
    }


    if(a->day != b->day) {
        return a->day - b->day;
    }

    cmp = strcmp(a->lastName, b->lastName);
    if(cmp != 0) {
        return cmp;
    }

    cmp = strcmp(a->firstName, b->firstName);
    if(cmp != 0) {
        return cmp;
    }

    if(a->GPA > b->GPA) {
        return 1;
    }
    if(a->GPA < b->GPA) {
        return -1;
    }

    return a->TOEFL - b->TOEFL;

}

void merge_domestic(domesticStudent dStudents[], int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;
    domesticStudent *L = (domesticStudent *)malloc(n1 * sizeof(domesticStudent));
    domesticStudent *R = (domesticStudent *)malloc(n2 * sizeof(domesticStudent));

    for(int i = 0; i < n1; i++) {
        L[i] = dStudents[left + i];
    }

    for(int j = 0; j < n2; j++) {
        R[j] = dStudents[mid + 1 + j];
    }

    int i = 0, j = 0, k = left;
    while(i < n1 && j < n2) {
        if(compareDomestic(&L[i], &R[j]) <= 0) {
            dStudents[k++] = L[i++];
        } else {
            dStudents[k++] = R[j++];
        }
    }

    while(i < n1) {
        dStudents[k++] = L[i++];
    }

    while(j < n2) {
        dStudents[k++] = R[j++];
    }

    free(L);
    free(R);



}
void merge_international(internationalStudent iStudents[], int left, int mid, int right){
    int n1 = mid - left + 1;
    int n2 = right - mid;

        internationalStudent *L = (internationalStudent *)malloc(n1 * sizeof(internationalStudent));
        internationalStudent *R = (internationalStudent *)malloc(n2 * sizeof(internationalStudent));

        for(int i = 0; i < n1; i++) {
            L[i] = iStudents[left + i];
        }

        for(int j = 0; j < n2; j++) {
            R[j] = iStudents[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while(i < n1 && j < n2) {
            if(compareInternational(&L[i], &R[j]) <= 0) {
                iStudents[k++] = L[i++];
            } else {
                iStudents[k++] = R[j++];
            }
        }

        while(i < n1) {
            iStudents[k++] = L[i++];
        }

        while(j < n2) {
            iStudents[k++] = R[j++];
        }

        free(L);
        free(R);


}

void merge_sort_international(internationalStudent iStudents[], int left, int right) {
        if(left < right) {
            int mid = left + (right - left) / 2;
            merge_sort_international(iStudents, left, mid);
            merge_sort_international(iStudents, mid + 1, right);
            merge_international(iStudents, left, mid, right);
        }
}

void merge_sort_domestic(domesticStudent dStudents[], int left, int right) {
    if(left < right) {
        int mid = left + (right - left) / 2;
        merge_sort_domestic(dStudents, left, mid);
        merge_sort_domestic(dStudents, mid + 1, right);
        merge_domestic(dStudents, left, mid, right);
    }
}


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
void printStudents(char *output, int option, domesticStudent *domesticStudents, int domesticCount, internationalStudent *internationalStudents, int internationalCount) {

    FILE *outFile = fopen(output, "w");

    switch(option) {
        case 1:
            for(int i = 0; i < domesticCount; i++) {
                fprintf(outFile, "%s %s %s-%d-%d %.3f %c\n", domesticStudents[i].firstName, domesticStudents[i].lastName, domesticStudents[i].month, domesticStudents[i].day,
                    domesticStudents[i].year, domesticStudents[i].GPA, domesticStudents[i].studentType);
            }
            break;
        case 2:
            for(int i = 0; i < internationalCount; i++) {
                    fprintf(outFile, "%s %s %s-%d-%d %.3f %c %d\n", internationalStudents[i].firstName, internationalStudents[i].lastName,
                        internationalStudents[i].month, internationalStudents[i].day,
                    internationalStudents[i].year, internationalStudents[i].GPA, internationalStudents[i].studentType, internationalStudents[i].TOEFL);
            }
            break;
        case 3:
            int i = 0;
        int j = 0;
        for(i = 0; i < domesticCount; i++) {
            while(j < internationalCount && compareMix(&internationalStudents[j], &domesticStudents[i]) < 0) {
                fprintf(outFile, "%s %s %s-%d-%d %.3f %c %d\n",
                                internationalStudents[j].firstName, internationalStudents[j].lastName,
                                internationalStudents[j].month, internationalStudents[j].day,
                                internationalStudents[j].year, internationalStudents[j].GPA,
                                internationalStudents[j].studentType, internationalStudents[j].TOEFL);
                j++;
            }


            fprintf(outFile, "%s %s %s-%d-%d %.3f %c\n",
                        domesticStudents[i].firstName, domesticStudents[i].lastName,
                        domesticStudents[i].month, domesticStudents[i].day,
                        domesticStudents[i].year, domesticStudents[i].GPA,
                        domesticStudents[i].studentType);

        }

        while(j < internationalCount) {
            fprintf(outFile, "%s %s %s-%d-%d %.3f %c %d\n", internationalStudents[j].firstName, internationalStudents[j].lastName,
                    internationalStudents[j].month, internationalStudents[j].day,
                internationalStudents[j].year, internationalStudents[j].GPA, internationalStudents[j].studentType, internationalStudents[j].TOEFL);
            j++;
        }
            break;
        default:
            fprintf(outFile, "Error: invalid choice");
            exit(1);
    }

}






int main(int argc, char *argv[])
{

    domesticStudent *domesticStudents = NULL;
    int domesticCount = 0;
    internationalStudent *internationalStudents = NULL;
    int internationalCount = 0;


    char *input = argv[1];
    char *output = argv[2];
    char option = atoi(argv[3]);



    //Call the rFile function
    rFile(input, output, &domesticStudents, &domesticCount, &internationalStudents, &internationalCount);

    //merge sort the students
    merge_sort_domestic(domesticStudents, 0, domesticCount - 1);
    merge_sort_international(internationalStudents, 0, internationalCount - 1);

    //Print the students
    printStudents(output, option, domesticStudents, domesticCount, internationalStudents, internationalCount);

    //Free allocated memory
    free(domesticStudents);
    free(internationalStudents);

    return 0;

}

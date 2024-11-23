#include <stdio.h>
#include <stdlib.h>
#include <string.h>


struct Node {
    char name[100];
    struct Node* next;
};


struct Node* createNode(const char* name) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    strcpy(newNode->name, name);
    newNode->next = newNode;
    return newNode;
}

// void insertAtEnd(struct Node** head, const char* name) {
//
//     struct Node* newNode = createNode(name);
//     if(*head == NULL) {
//         *head = newNode;
//         return;
//     }
//
//     // struct Node* temp = *head;
//
//     newNode->next = *head;
// }

void insertAtBegining(struct Node** head, const char* name) {
    struct Node* newNode = createNode(name);
    if(*head == NULL) {
        *head = newNode;
        return;
    }

    struct Node* temp = *head;
    temp->next = newNode;

    newNode->next = *head;
}
//
//
// void insertAtPointN(struct Node** head, const char* name, const int position) {
//
// }
//
//
// void deleteNode(struct Node** head, const char* name) {
//
//
// }


void displayList(struct Node* head) {
    if(head == NULL) {
        return;
    }

    struct Node* temp = head;

    do {
    printf("Patient's name is: %s\n", temp->name);
    temp = temp->next;
    } while (temp != head);

    printf("%s (head)\n", head->name);
}





int main(void)
{

    struct Node* head = NULL;

    insertAtBegining(&head, "hello");

    displayList(head);

    insertAtBegining(&head, "bye");

    displayList(head);







    return 0;
}

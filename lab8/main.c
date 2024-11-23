#include <stdio.h>
#include "circular_node.h"

int main(void) {

    struct Node* head = NULL;

    insertAtEnd(&head, "Red", 30);
    insertAtEnd(&head, "Green", 45);
    insertAtEnd(&head, "Yellow", 10);
    insertAtEnd(&head, "Blue", 60);

    printf("Circular linked list (traffic signals):\n");
    displayList(head);

    deleteNode(&head, "Green");

    printf("Circular linked list after deletion:\n");
    displayList(head);


    return 0;
}

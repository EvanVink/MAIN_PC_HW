#include <stdio.h>
#include "circular_node.h"

int main(void) {

    struct Node* head = NULL;

    insertAtEnd(&head, "Red", 5);
    insertAtEnd(&head, "Green", 15);
    insertAtEnd(&head, "Yellow", 6);
    insertAtEnd(&head, "Blue", 5);

    printf("Circular linked list (traffic signals):\n");
    displayList(head);

    deleteNode(&head, "Green");

    printf("Circular linked list after deletion:\n");
    displayList(head);

    printf("Circular linked list after modifying signal Blue:\n");
    modifySignalDuration(head, "Blue", 7);
    displayList(head);

    printf("Circular linked list cycle:\n");
    cycleLights(head);


    return 0;
}

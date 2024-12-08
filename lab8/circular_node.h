//
// Created by socce on 11/21/2024.
//

#ifndef CIRCULAR_NODE_H
#define CIRCULAR_NODE_H

struct Node {
    char signal[10];
    int duration;
    struct Node* next;
};


struct Node* createNode(const char* signal, int duration);
void insertAtEnd(struct Node** head, const char* signal, int duration);
void deleteNode(struct Node** head, const char* signal);
void displayList(struct Node* head);
void modifySignalDuration(struct Node* head, const char* signal, int duration);
void cycleLights(struct Node* head);




#endif //CIRCULAR_NODE_H

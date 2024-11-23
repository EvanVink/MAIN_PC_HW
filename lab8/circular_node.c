//
// Created by socce on 11/21/2024.
//
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "circular_node.h"


struct Node* createNode(const char* signal, int duration) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    strcpy(newNode->signal, signal);
    newNode->duration = duration;
    newNode->next = newNode;
    return newNode;
}

void insertAtEnd(struct Node** head, const char* signal, int duration) {
    struct Node* newNode = createNode(signal, duration);
    if(*head == NULL) {
        *head = newNode;
        return;
    }

    struct Node* temp = *head;
    while(temp->next != *head) {
        temp = temp->next;
    }
    temp->next = newNode;
    newNode->next = *head;

}


void deleteNode(struct Node** head, const char* signal) {
    if(*head == NULL) {
        return;
    }

    struct Node *temp = *head, *prev = NULL;

    if(strcmp(temp->signal, signal) == 0 && temp->next == *head) {
        *head = NULL;
        free(temp);
        return;
    }

    if(strcmp(temp->signal, signal) == 0) {
        while(temp->next != *head) {
            temp = temp->next;
        }
        temp->next = (*head)->next;
        free(*head);
        *head = temp->next;
        return;
    }


    while(temp->next != *head && strcmp(temp->signal, signal) != 0) {
        prev = temp;
        temp = temp->next;
    }

    if(strcmp(temp->signal, signal) != 0) {
        return;
    }

    prev->next = temp->next;

    free(temp);

}


void modifySignalDuration(struct Node* head, const char* signal) {




}


void displayList(struct Node* head) {
    if(head == NULL) {
        return;
    }

    struct Node* temp = head;

    do {
        printf("%s (%d seconds) ->", temp->signal, temp->duration);
        temp = temp->next;
    } while(temp != head);

    printf("%s (head)\n", head->signal);
}









#include <stdio.h>


typedef struct Node {
    int data;
    struct Node *link;
} Node;


void printDuplicate(Node *head) {

    Node* data = head;

    while(data != NULL) {
        //setting a temp to check through the LL
        Node* temp = data->link;
        while(temp != NULL) {
            //if true means there is a duplicate and prints it
            if(temp->data == data->data) {
                printf("%d\n", data->data);
                break;
            }
            //going to the next node
            temp->link;
        }
        //going to the next node
        data->link;
    }

}




int main(void)
{



}

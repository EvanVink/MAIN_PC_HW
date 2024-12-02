#include <stdio.h>

struct TreeNode {
    int data;
    struct Node* left;
    struct Node* right;
};

int findHeight(struct TreeNode* node, int counter) {

    if(node == NULL) {
        return -1;
    }

    struct TreeNode* temp = node;

    if(temp->right != NULL) {
        temp->right;
        counter = counter + 1;
        return findHeight(temp, counter);
    }


    if(node->left != NULL) {
        node->left;
        counter = counter + 1;
        return findHeight(node, counter);
    }


    return counter;
}




int main(void) {



    return 0;
}

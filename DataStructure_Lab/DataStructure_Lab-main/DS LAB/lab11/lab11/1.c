#include <stdio.h>
#include <stdlib.h>

// Structure for a node in the binary search tree
struct Node {
    int data;
    struct Node* left;
    struct Node* right;
};

// Function to create a new node
struct Node* createNode(int value) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = value;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

// Function to insert a new element into the binary search tree
struct Node* insert(struct Node* root, int value) {
    // If the tree is empty, create a new node and make it the root
    if (root == NULL) {
        return createNode(value);
    }

    // If the value is less than the root's data, insert it into the left subtree
    if (value < root->data) {
        root->left = insert(root->left, value);
    }
    // If the value is greater than the root's data, insert it into the right subtree
    else if (value > root->data) {
        root->right = insert(root->right, value);
    }

    return root;
}

// Function to print the binary search tree in inorder traversal
void inorderTraversal(struct Node* root) {
    if (root != NULL) {
        inorderTraversal(root->left);
        printf("%d ", root->data);
        inorderTraversal(root->right);
    }
}

int main() {
    struct Node* root = NULL;

    // Inserting elements into the binary search tree
    root = insert(root, 50);
    insert(root, 30);
    insert(root, 20);
    insert(root, 40);
    insert(root, 70);
    insert(root, 60);
    insert(root, 80);

    // Printing the binary search tree
    printf("Inorder traversal of the binary search tree: ");
    inorderTraversal(root);

    // Inserting a new element (e.g., 45) into the binary search tree
    int elementToInsert = 45;
    root = insert(root, elementToInsert);

    // Printing the binary search tree after insertion
    printf("\nInorder traversal after inserting %d: ", elementToInsert);
    inorderTraversal(root);

    return 0;
}

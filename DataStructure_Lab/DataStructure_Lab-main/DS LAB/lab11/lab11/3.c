#include <stdio.h>
#include <stdlib.h>

// Structure for a node in the binary search tree
struct Node {
    int data;
    struct Node* left;
    struct Node* right;
};

// Function to create a new node
struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

// Function to insert a node in the binary search tree
struct Node* insertNode(struct Node* root, int data) {
    if (root == NULL) {
        return createNode(data);
    } else if (data < root->data) {
        root->left = insertNode(root->left, data);
    } else if (data > root->data) {
        root->right = insertNode(root->right, data);
    }
    return root;
}

// Function to search for an element in the binary search tree
struct Node* searchElement(struct Node* root, int key) {
    if (root == NULL || root->data == key) {
        return root;
    } else if (key < root->data) {
        return searchElement(root->left, key);
    } else {
        return searchElement(root->right, key);
    }
}

// Main function
int main() {
    struct Node* root = NULL;
    int key;

    // Insert nodes into the binary search tree
    root = insertNode(root, 50);
    root = insertNode(root, 30);
    root = insertNode(root, 20);
    root = insertNode(root, 40);
    root = insertNode(root, 70);
    root = insertNode(root, 60);
    root = insertNode(root, 80);

    // Search for an element in the binary search tree
    printf("Enter the element to search: ");
    scanf("%d", &key);
    struct Node* result = searchElement(root, key);
    if (result == NULL) {
        printf("Element not found in the binary search tree.\n");
    } else {
        printf("Element found in the binary search tree.\n");
    }

    return 0;
}

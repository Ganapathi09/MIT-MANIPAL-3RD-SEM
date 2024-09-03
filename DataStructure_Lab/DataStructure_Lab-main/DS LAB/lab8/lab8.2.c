#include <stdio.h>
#include <stdlib.h>

// Node structure for singly linked list
struct Node {
    int data;
    struct Node* next;
};

// Function to create a new node
struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

// Function to print the singly linked list
void printList(struct Node* head) {
    struct Node* temp = head;
    while (temp != NULL) {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("\n");
}

// User-defined function to split the singly linked list into two lists
struct Node* splitList(struct Node* head) {
    // Find the middle node of the list
    struct Node* slow = head;
    struct Node* fast = head;
    while (fast != NULL && fast->next != NULL && fast->next->next != NULL) {
        slow = slow->next;
        fast = fast->next->next;
    }

    // Set the head of the second list to the node after the middle node
    struct Node* head2 = slow->next->next;

    // Break the list in two at the middle node
    slow->next->next = NULL;

    return head2;
}

int main() {
    // Creating the singly linked list
    struct Node* head = createNode(1);
    head->next = createNode(2);
    head->next->next = createNode(3);
    head->next->next->next = createNode(4);
    head->next->next->next->next = createNode(5);
    head->next->next->next->next->next = createNode(6);

    // Splitting the list into two lists
    struct Node* list2 = splitList(head);

    // Printing the two lists
    printf("List 1: ");
    printList(head);

    printf("List 2: ");
    printList(list2);

    return 0;
}

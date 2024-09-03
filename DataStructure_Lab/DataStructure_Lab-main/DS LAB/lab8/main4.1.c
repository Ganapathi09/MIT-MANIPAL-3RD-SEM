#include <stdio.h>
#include <stdlib.h>

// Structure for a node in the linked list
struct Node {
    int data;
    struct Node* next;
};

// Function to split a singly linked list into two lists
void splitLinkedList(struct Node* head, struct Node** list1, struct Node** list2) {
    // Initialize two pointers for the two lists
    struct Node* current = head;
    struct Node* odd = NULL;
    struct Node* even = NULL;

    // Traverse the original list and rearrange the nodes
    while (current != NULL) {
        // Check if the data is odd or even
        if (current->data % 2 == 0) {
            // Add the node to the even list
            if (even == NULL) {
                even = current;
                *list2 = even;
            } else {
                even->next = current;
                even = even->next;
            }
        } else {
            // Add the node to the odd list
            if (odd == NULL) {
                odd = current;
                *list1 = odd;
            } else {
                odd->next = current;
                odd = odd->next;
            }
        }

        // Move to the next node
        current = current->next;
    }

    // Set the next pointers of the last nodes to NULL
    if (odd != NULL) {
        odd->next = NULL;
    }
    if (even != NULL) {
        even->next = NULL;
    }
}

// Function to print a linked list
void printLinkedList(struct Node* head) {
    struct Node* current = head;
    while (current != NULL) {
        printf("%d ", current->data);
        current = current->next;
    }
    printf("\n");s
}

// Function to create a new node in the linked list
struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

int main() {
    // Create the original linked list
    struct Node* head = createNode(1);
    head->next = createNode(2);
    head->next->next = createNode(3);
    head->next->next->next = createNode(4);
    head->next->next->next->next = createNode(5);
    head->next->next->next->next->next = createNode(6);

    // Initialize the two lists
    struct Node* list1 = NULL;
    struct Node* list2 = NULL;

    // Split the linked list
    splitLinkedList(head, &list1, &list2);

    // Print the two lists
    printf("List1: ");
    printLinkedList(list1);
    printf("List2: ");
    printLinkedList(list2);

    return 0;
}

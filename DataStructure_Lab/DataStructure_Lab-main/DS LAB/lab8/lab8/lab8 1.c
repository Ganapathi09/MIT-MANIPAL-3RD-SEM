#include <stdio.h>
#include <stdlib.h>

// Structure for a node in the doubly linked list
struct Node {
    int data;
    struct Node* prev;
    struct Node* next;
};

// Function to create a new node
struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->prev = NULL;
    newNode->next = NULL;
    return newNode;
}

// Function to insert an element at the rear end of the list
void insertRear(struct Node** head, int data) {
    struct Node* newNode = createNode(data);
    if (*head == NULL) {
        *head = newNode;
    } else {
        struct Node* temp = *head;
        while (temp->next != NULL) {
            temp = temp->next;
        }
        temp->next = newNode;
        newNode->prev = temp;
    }
    printf("Element %d inserted at the rear end of the list.\n", data);
}

// Function to delete an element from the rear end of the list
void deleteRear(struct Node** head) {
    if (*head == NULL) {
        printf("List is empty. Cannot delete from the rear end.\n");
    } else {
        struct Node* temp = *head;
        while (temp->next != NULL) {
            temp = temp->next;
        }
        if (temp->prev != NULL) {
            temp->prev->next = NULL;
        } else {
            *head = NULL;
        }
        free(temp);
        printf("Element deleted from the rear end of the list.\n");
    }
}

// Function to insert an element at a given position of the list
void insertAtPosition(struct Node** head, int data, int position) {
    if (position < 1) {
        printf("Invalid position. Cannot insert element.\n");
    } else if (position == 1) {
        struct Node* newNode = createNode(data);
        newNode->next = *head;
        if (*head != NULL) {
            (*head)->prev = newNode;
        }
        *head = newNode;
        printf("Element %d inserted at position %d of the list.\n", data, position);
    } else {
        struct Node* temp = *head;
        int count = 1;
        while (count < position - 1 && temp != NULL) {
            temp = temp->next;
            count++;
        }
        if (temp == NULL) {
            printf("Invalid position. Cannot insert element.\n");
        } else {
            struct Node* newNode = createNode(data);
            newNode->prev = temp;
            newNode->next = temp->next;
            if (temp->next != NULL) {
                temp->next->prev = newNode;
            }
            temp->next = newNode;
            printf("Element %d inserted at position %d of the list.\n", data, position);
        }
    }
}

// Function to delete an element from a given position of the list
void deleteAtPosition(struct Node** head, int position) {
    if (*head == NULL) {
        printf("List is empty. Cannot delete element.\n");
    } else if (position < 1) {
        printf("Invalid position. Cannot delete element.\n");
    } else if (position == 1) {
        struct Node* temp = *head;
        *head = (*head)->next;
        if (*head != NULL) {
            (*head)->prev = NULL;
        }
        free(temp);
        printf("Element deleted from position %d of the list.\n", position);
    } else {
        struct Node* temp = *head;
        int count = 1;
        while (count < position && temp != NULL) {
            temp = temp->next;
            count++;
        }
        if (temp == NULL) {
            printf("Invalid position. Cannot delete element.\n");
        } else {
            temp->prev->next = temp->next;
            if (temp->next != NULL) {
                temp->next->prev = temp->prev;
            }
            free(temp);
            printf("Element deleted from position %d of the list.\n", position);
        }
    }
}

// Function to insert an element after another element
void insertAfterElement(struct Node** head, int data, int element) {
    struct Node* temp = *head;
    while (temp != NULL && temp->data != element) {
        temp = temp->next;
    }
    if (temp == NULL) {
        printf("Element %d not found in the list. Cannot insert element.\n", element);
    } else {
        struct Node* newNode = createNode(data);
        newNode->prev = temp;
        newNode->next = temp->next;
        if (temp->next != NULL) {
            temp->next->prev = newNode;
        }
        temp->next = newNode;
        printf("Element %d inserted after element %d.\n", data, element);
    }
}

// Function to insert an element before another element
void insertBeforeElement(struct Node** head, int data, int element) {
    if (*head == NULL) {
        printf("List is empty. Cannot insert element.\n");
    } else if ((*head)->data == element) {
        struct Node* newNode = createNode(data);
        newNode->next = *head;
        (*head)->prev = newNode;
        *head = newNode;
        printf("Element %d inserted before element %d.\n", data, element);
    } else {
        struct Node* temp = *head;
        while (temp != NULL && temp->data != element) {
            temp = temp->next;
        }
        if (temp == NULL) {
            printf("Element %d not found in the list. Cannot insert element.\n", element);
        } else {
            struct Node* newNode = createNode(data);
            newNode->prev = temp->prev;
            newNode->next = temp;
            temp->prev->next = newNode;
            temp->prev = newNode;
            printf("Element %d inserted before element %d.\n", data, element);
        }
    }
}

// Function to traverse the list
void traverseList(struct Node* head) {
    if (head == NULL) {
        printf("List is empty.\n");
    } else {
        printf("Elements in the list: ");
        struct Node* temp = head;
        while (temp != NULL) {
            printf("%d ", temp->data);
            temp = temp->next;
        }
        printf("\n");
    }
}

// Function to reverse the list
void reverseList(struct Node** head) {
    struct Node* current = *head;
    struct Node* temp = NULL;
    while (current != NULL) {
        temp = current->prev;
        current->prev = current->next;
        current->next = temp;
        current = current->prev;
    }
    if (temp != NULL) {
        *head = temp->prev;
    }
    printf("List reversed successfully.\n");
}

// Function to display the inserted elements
void displayElements(struct Node* head) {
    if (head == NULL) {
        printf("No elements inserted in the list.\n");
    } else {
        printf("Inserted elements: ");
        struct Node* temp = head;
        while (temp != NULL) {
            printf("%d ", temp->data);
            temp = temp->next;
        }
        printf("\n");
    }
}

int main() {
    struct Node* head = NULL;
    int choice, data, position, element;

    do {
        printf("\nMenu:\n");
        printf("1. Insert an element at the rear end of the list\n");
        printf("2. Delete an element from the rear end of the list\n");
        printf("3. Insert an element at a given position of the list\n");
        printf("4. Delete an element from a given position of the list\n");
        printf("5. Insert an element after another element\n");
        printf("6. Insert an element before another element\n");
        printf("7. Traverse the list\n");
        printf("8. Reverse the list\n");
        printf("9. Display the inserted elements\n");
        printf("0. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter the element to insert: ");
                scanf("%d", &data);
                insertRear(&head, data);
                break;
            case 2:
                deleteRear(&head);
                break;
            case 3:
                printf("Enter the element to insert: ");
                scanf("%d", &data);
                printf("Enter the position to insert at: ");
                scanf("%d", &position);
                insertAtPosition(&head, data, position);
                break;
            case 4:
                printf("Enter the position to delete from: ");
                scanf("%d", &position);
                deleteAtPosition(&head, position);
                break;
            case 5:
                printf("Enter the element to insert: ");
                scanf("%d", &data);
                printf("Enter the element to insert after: ");
                scanf("%d", &element);
                insertAfterElement(&head, data, element);
                break;
            case 6:
                printf("Enter the element to insert: ");
                scanf("%d", &data);
                printf("Enter the element to insert before: ");
                scanf("%d", &element);
                insertBeforeElement(&head, data, element);
                break;
            case 7:
                traverseList(head);
                break;
            case 8:
                reverseList(&head);
                break;
            case 9:
                displayElements(head);
                break;
            case 0:
                printf("Exiting the program.\n");
                break;
            default:
                printf("Invalid choice. Please try again.\n");
        }
    } while (choice != 0);

    return 0;
}


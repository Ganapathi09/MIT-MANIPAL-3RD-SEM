#include <stdio.h>
#include <stdlib.h>

// Structure for a node
struct Node {
    int data;
    struct Node* next;
};

// Function to insert a new node before a given element
void insertBefore(struct Node** head, int key, int newData) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = newData;

    if (*head == NULL) {
        printf("Error: List is empty.\n");
        return;
    }

    struct Node* temp = *head;
    struct Node* prev = NULL;

    while (temp != NULL && temp->data != key) {
        prev = temp;
        temp = temp->next;
    }

    if (temp == NULL) {
        printf("Error: Element not found in the list.\n");
        return;
    }

    if (prev == NULL) {
        newNode->next = *head;
        *head = newNode;
    } else {
        newNode->next = temp;
        prev->next = newNode;
    }

    printf("Element %d inserted before %d.\n", newData, key);
}

// Function to insert a new node after a given element
void insertAfter(struct Node** head, int key, int newData) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = newData;

    if (*head == NULL) {
        printf("Error: List is empty.\n");
        return;
    }

    struct Node* temp = *head;

    while (temp != NULL && temp->data != key) {
        temp = temp->next;
    }

    if (temp == NULL) {
        printf("Error: Element not found in the list.\n");
        return;
    }

    newNode->next = temp->next;
    temp->next = newNode;

    printf("Element %d inserted after %d.\n", newData, key);
}

// Function to delete a given element from the list
void deleteElement(struct Node** head, int key) {
    if (*head == NULL) {
        printf("Error: List is empty.\n");
        return;
    }

    struct Node* temp = *head;
    struct Node* prev = NULL;

    while (temp != NULL && temp->data != key) {
        prev = temp;
        temp = temp->next;
    }

    if (temp == NULL) {
        printf("Error: Element not found in the list.\n");
        return;
    }

    if (prev == NULL) {
        *head = temp->next;
    } else {
        prev->next = temp->next;
    }

    free(temp);

    printf("Element %d deleted from the list.\n", key);
}

// Function to traverse and display the list
void traverseList(struct Node* head) {
    if (head == NULL) {
        printf("List is empty.\n");
        return;
    }

    struct Node* temp = head;

    printf("List elements: ");
    while (temp != NULL) {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("\n");
}

// Function to reverse the list
void reverseList(struct Node** head) {
    struct Node* prev = NULL;
    struct Node* current = *head;
    struct Node* next = NULL;

    while (current != NULL) {
        next = current->next;
        current->next = prev;
        prev = current;
        current = next;
    }

    *head = prev;

    printf("List reversed.\n");
}

// Function to sort the list in ascending order
void sortList(struct Node** head) {
    struct Node* current = *head;
    struct Node* index = NULL;
    int temp;

    if (*head == NULL) {
        printf("List is empty.\n");
        return;
    }

    while (current != NULL) {
        index = current->next;

        while (index != NULL) {
            if (current->data > index->data) {
                temp = current->data;
                current->data = index->data;
                index->data = temp;
            }
            index = index->next;
        }
        current = current->next;
    }

    printf("List sorted in ascending order.\n");
}

// Function to delete every alternate node in the list
void deleteAlternate(struct Node** head) {
    if (*head == NULL) {
        printf("Error: List is empty.\n");
        return;
    }

    struct Node* temp = *head;
    struct Node* prev = NULL;
    int count = 0;

    while (temp != NULL) {
        if (count % 2 != 0) {
            prev->next = temp->next;
            free(temp);
            temp = prev->next;
        } else {
            prev = temp;
            temp = temp->next;
        }
        count++;
    }

    printf("Every alternate node deleted from the list.\n");
}

// Function to insert an element in a sorted list
void insertInSorted(struct Node** head, int newData) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = newData;

    if (*head == NULL || newData < (*head)->data) {
        newNode->next = *head;
        *head = newNode;
    } else {
        struct Node* temp = *head;

        while (temp->next != NULL && temp->next->data < newData) {
            temp = temp->next;
        }

        newNode->next = temp->next;
        temp->next = newNode;
    }

    printf("Element %d inserted in the sorted list.\n", newData);
}

// Function to display the inserted elements
void displayInsertedElements(struct Node* head) {
    if (head == NULL) {
        printf("No elements inserted.\n");
        return;
    }

    struct Node* temp = head;

    printf("Inserted elements: ");
    while (temp != NULL) {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("\n");
}

int main() {
    struct Node* head = NULL;
    int choice, key, newData;

    do {
        printf("\nMenu:\n");
        printf("1. Insert an element before another element\n");
        printf("2. Insert an element after another element\n");
        printf("3. Delete a given element\n");
        printf("4. Traverse the list\n");
        printf("5. Reverse the list\n");
        printf("6. Sort the list\n");
        printf("7. Delete every alternate node\n");
        printf("8. Insert an element in a sorted list\n");
        printf("9. Display the inserted elements\n");
        printf("0. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter the element before which you want to insert: ");
                scanf("%d", &key);
                printf("Enter the new element: ");
                scanf("%d", &newData);
                insertBefore(&head, key, newData);
                break;
            case 2:
                printf("Enter the element after which you want to insert: ");
                scanf("%d", &key);
                printf("Enter the new element: ");
                scanf("%d", &newData);
                insertAfter(&head, key, newData);
                break;
            case 3:
                printf("Enter the element to delete: ");
                scanf("%d", &key);
                deleteElement(&head, key);
                break;
            case 4:
                traverseList(head);
                break;
            case 5:
                reverseList(&head);
                break;
            case 6:
                sortList(&head);
                break;
            case 7:
                deleteAlternate(&head);
                break;
            case 8:
                printf("Enter the new element: ");
                scanf("%d", &newData);
                insertInSorted(&head, newData);
                break;
            case 9:
                displayInsertedElements(head);
                break;
            case 0:
                printf("Exiting...\n");
                break;
            default:
                printf("Invalid choice. Please try again.\n");
        }
    } while (choice != 0);

    return 0;
}

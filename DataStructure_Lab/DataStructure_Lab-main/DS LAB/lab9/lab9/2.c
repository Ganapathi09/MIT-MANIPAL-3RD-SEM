#include <stdio.h>
#include <stdlib.h>

struct Node {
    int coefficient;
    int exponent;
    struct Node* next;
};

struct Node* addPolynomials(struct Node* poly1, struct Node* poly2) {
    struct Node* result = NULL;
    struct Node* ptr1 = poly1;
    struct Node* ptr2 = poly2;
    struct Node* resultPtr = NULL;

    while (ptr1 != NULL && ptr2 != NULL) {
        struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));

        if (ptr1->exponent > ptr2->exponent) {
            newNode->coefficient = ptr1->coefficient;
            newNode->exponent = ptr1->exponent;
            ptr1 = ptr1->next;
        } else if (ptr2->exponent > ptr1->exponent) {
            newNode->coefficient = ptr2->coefficient;
            newNode->exponent = ptr2->exponent;
            ptr2 = ptr2->next;
        } else {
            newNode->coefficient = ptr1->coefficient + ptr2->coefficient;
            newNode->exponent = ptr1->exponent;
            ptr1 = ptr1->next;
            ptr2 = ptr2->next;
        }

        newNode->next = NULL;

        if (result == NULL) {
            result = newNode;
            resultPtr = newNode;
        } else {
            resultPtr->next = newNode;
            resultPtr = resultPtr->next;
        }
    }

    while (ptr1 != NULL) {
        struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
        newNode->coefficient = ptr1->coefficient;
        newNode->exponent = ptr1->exponent;
        newNode->next = NULL;

        resultPtr->next = newNode;
        resultPtr = resultPtr->next;

        ptr1 = ptr1->next;
    }

    while (ptr2 != NULL) {
        struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
        newNode->coefficient = ptr2->coefficient;
        newNode->exponent = ptr2->exponent;
        newNode->next = NULL;

        resultPtr->next = newNode;
        resultPtr = resultPtr->next;

        ptr2 = ptr2->next;
    }

    return result;
}

void displayPolynomial(struct Node* poly) {
    struct Node* ptr = poly;

    while (ptr != NULL) {
        printf("%dx^%d ", ptr->coefficient, ptr->exponent);
        ptr = ptr->next;
    }

    printf("\n");
}

int main() {
    // Create the first polynomial: 3x^2 + 2x + 1
    struct Node* poly1 = (struct Node*)malloc(sizeof(struct Node));
    poly1->coefficient = 3;
    poly1->exponent = 2;

    struct Node* term1 = (struct Node*)malloc(sizeof(struct Node));
    term1->coefficient = 2;
    term1->exponent = 1;

    struct Node* term2 = (struct Node*)malloc(sizeof(struct Node));
    term2->coefficient = 1;
    term2->exponent = 0;

    poly1->next = term1;
    term1->next = term2;
    term2->next = NULL;

    // Create the second polynomial: 2x^3 + 4x^2 + 1
    struct Node* poly2 = (struct Node*)malloc(sizeof(struct Node));
    poly2->coefficient = 2;
    poly2->exponent = 3;

    struct Node* term3 = (struct Node*)malloc(sizeof(struct Node));
    term3->coefficient = 4;
    term3->exponent = 2;

    struct Node* term4 = (struct Node*)malloc(sizeof(struct Node));
    term4->coefficient = 1;
    term4->exponent = 0;

    poly2->next = term3;
    term3->next = term4;
    term4->next = NULL;

    // Add the polynomials
    struct Node* result = addPolynomials(poly1, poly2);

    // Display the result
    printf("Result: ");
    displayPolynomial(result);

    return 0;
}


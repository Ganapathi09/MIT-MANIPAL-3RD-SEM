#include <stdio.h>
#include <stdlib.h>

// Structure to represent a node in the adjacency list
struct Node {
    int vertex;
    struct Node* next;
};

// Structure to represent the adjacency list
struct AdjList {
    struct Node* head;
};

// Structure to represent the graph
struct Graph {
    int numVertices;
    struct AdjList* array;
};

// Function to create a new node
struct Node* createNode(int vertex) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->vertex = vertex;
    newNode->next = NULL;
    return newNode;
}

// Function to create a graph with a given number of vertices
struct Graph* createGraph(int numVertices) {
    struct Graph* graph = (struct Graph*)malloc(sizeof(struct Graph));
    graph->numVertices = numVertices;

    // Create an array of adjacency lists
    graph->array = (struct AdjList*)malloc(numVertices * sizeof(struct AdjList));

    // Initialize each adjacency list as empty by making head as NULL
    for (int i = 0; i < numVertices; i++) {
        graph->array[i].head = NULL;
    }

    return graph;
}

// Function to add an edge to an undirected graph
void addEdgeUndirected(struct Graph* graph, int src, int dest) {
    // Add an edge from src to dest
    struct Node* newNode = createNode(dest);
    newNode->next = graph->array[src].head;
    graph->array[src].head = newNode;

    // Add an edge from dest to src
    newNode = createNode(src);
    newNode->next = graph->array[dest].head;
    graph->array[dest].head = newNode;
}

// Function to add an edge to a directed graph
void addEdgeDirected(struct Graph* graph, int src, int dest) {
    // Add an edge from src to dest
    struct Node* newNode = createNode(dest);
    newNode->next = graph->array[src].head;
    graph->array[src].head = newNode;
}

// Function to print the adjacency list representation of the graph
void printGraph(struct Graph* graph) {
    for (int i = 0; i < graph->numVertices; i++) {
        struct Node* temp = graph->array[i].head;
        printf("Adjacency list of vertex %d\n", i);
        while (temp) {
            printf("%d -> ", temp->vertex);
            temp = temp->next;
        }
        printf("NULL\n");
    }
}

int main() {
    int numVertices = 5;
    struct Graph* graph = createGraph(numVertices);

    addEdgeUndirected(graph, 0, 1);
    addEdgeUndirected(graph, 0, 4);
    addEdgeUndirected(graph, 1, 2);
    addEdgeUndirected(graph, 1, 3);
    addEdgeUndirected(graph, 1, 4);
    addEdgeUndirected(graph, 2, 3);
    addEdgeUndirected(graph, 3, 4);

    printf("Undirected Graph:\n");
    printGraph(graph);

    struct Graph* directedGraph = createGraph(numVertices);

    addEdgeDirected(directedGraph, 0, 1);
    addEdgeDirected(directedGraph, 0, 4);
    addEdgeDirected(directedGraph, 1, 2);
    addEdgeDirected(directedGraph, 1, 3);
    addEdgeDirected(directedGraph, 1, 4);
    addEdgeDirected(directedGraph, 2, 3);
    addEdgeDirected(directedGraph, 3, 4);

    printf("\nDirected Graph:\n");
    printGraph(directedGraph);

    return 0;
}


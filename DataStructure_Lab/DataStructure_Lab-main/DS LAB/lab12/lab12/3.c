#include <stdio.h>
#include <stdlib.h>

// Structure to represent a node in the graph
struct Node {
    int data;
    struct Node* next;
};

// Structure to represent a graph
struct Graph {
    int numVertices;
    struct Node** adjLists;
    int* visited;
};

// Function to create a new node
struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

// Function to create a graph with a given number of vertices
struct Graph* createGraph(int vertices) {
    struct Graph* graph = (struct Graph*)malloc(sizeof(struct Graph));
    graph->numVertices = vertices;

    graph->adjLists = (struct Node**)malloc(vertices * sizeof(struct Node*));
    graph->visited = (int*)malloc(vertices * sizeof(int));

    int i;
    for (i = 0; i < vertices; i++) {
        graph->adjLists[i] = NULL;
        graph->visited[i] = 0;
    }

    return graph;
}

// Function to add an edge to an undirected graph
void addEdge(struct Graph* graph, int src, int dest) {
    // Add edge from source to destination
    struct Node* newNode = createNode(dest);
    newNode->next = graph->adjLists[src];
    graph->adjLists[src] = newNode;

    // Add edge from destination to source
    newNode = createNode(src);
    newNode->next = graph->adjLists[dest];
    graph->adjLists[dest] = newNode;
}

// Function to print the BFS traversal of a graph
void BFS(struct Graph* graph, int startVertex) {
    struct Node* queue[graph->numVertices];
    int front = 0, rear = 0;

    // Mark the start vertex as visited and enqueue it
    graph->visited[startVertex] = 1;
    queue[rear++] = graph->adjLists[startVertex];

    while (front < rear) {
        // Dequeue a vertex from the queue and print it
        struct Node* currentVertex = queue[front++];
        printf("%d ", currentVertex->data);

        // Get all adjacent vertices of the dequeued vertex
        struct Node* temp = graph->adjLists[currentVertex->data];

        // If an adjacent vertex has not been visited, mark it as visited and enqueue it
        while (temp) {
            int adjVertex = temp->data;

            if (graph->visited[adjVertex] == 0) {
                graph->visited[adjVertex] = 1;
                queue[rear++] = graph->adjLists[adjVertex];
            }

            temp = temp->next;
        }
    }
}

int main() {
    // Create a graph with 6 vertices
    struct Graph* graph = createGraph(6);

    // Add edges
    addEdge(graph, 0, 1);
    addEdge(graph, 0, 2);
    addEdge(graph, 1, 3);
    addEdge(graph, 2, 3);
    addEdge(graph, 2, 4);
    addEdge(graph, 3, 4);
    addEdge(graph, 3, 5);

    // Perform BFS starting from vertex 0
    printf("BFS traversal starting from vertex 0: ");
    BFS(graph, 0);

    return 0;
}


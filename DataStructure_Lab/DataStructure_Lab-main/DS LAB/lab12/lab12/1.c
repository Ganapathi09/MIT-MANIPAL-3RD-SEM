#include <stdio.h>

#define V 5 // Number of vertices

// Function to initialize the adjacency matrix
void initMatrix(int adjMatrix[][V]) {
  for (int i = 0; i < V; i++) {
    for (int j = 0; j < V; j++) {
      adjMatrix[i][j] = 0;
    }
  }
}

// Function to add an edge to the adjacency matrix (directed graph)
void addDirectedEdge(int adjMatrix[][V], int src, int dest) {
  adjMatrix[src][dest] = 1;
}

// Function to add an edge to the adjacency matrix (undirected graph)
void addUndirectedEdge(int adjMatrix[][V], int src, int dest) {
  adjMatrix[src][dest] = 1;
  adjMatrix[dest][src] = 1; // Add edge in both directions for undirected graph
}

// Function to print the adjacency matrix
void printMatrix(int adjMatrix[][V]) {
  for (int i = 0; i < V; i++) {
    for (int j = 0; j < V; j++) {
      printf("%d ", adjMatrix[i][j]);
    }
    printf("\n");
  }
}

int main() {
  int adjMatrix[V][V]; // Adjacency matrix

  // Initialize the adjacency matrix
  initMatrix(adjMatrix);

  // Add edges to the adjacency matrix for directed graph
  addDirectedEdge(adjMatrix, 0, 1);
  addDirectedEdge(adjMatrix, 0, 2);
  addDirectedEdge(adjMatrix, 1, 2);
  addDirectedEdge(adjMatrix, 2, 3);

  printf("Adjacency Matrix for Directed Graph:\n");
  printMatrix(adjMatrix);

  // Initialize the adjacency matrix again
  initMatrix(adjMatrix);

  // Add edges to the adjacency matrix for undirected graph
  addUndirectedEdge(adjMatrix, 0, 1);
  addUndirectedEdge(adjMatrix, 0, 2);
  addUndirectedEdge(adjMatrix, 0, 3);
  addUndirectedEdge(adjMatrix, 1, 2);

  printf("\nAdjacency Matrix for Undirected Graph:\n");
  printMatrix(adjMatrix);

  return 0;
}

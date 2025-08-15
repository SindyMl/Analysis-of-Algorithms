

import java.util.LinkedList;

public class Vertex {
    private int vertexNumber;
    private int colour; // Unused in this lab, but included as per spec
    private LinkedList<Vertex> adjacencies;

    // Constructor: Initializes vertex with a number and empty adjacency list
    public Vertex(int vertexNumber) {
        this.vertexNumber = vertexNumber;
        this.colour = 0; // Default colour
        this.adjacencies = new LinkedList<>();
    }

    // Adds a vertex to the adjacency list
    public void addAdjacency(Vertex vertex) {
        if (vertex != null && !adjacencies.contains(vertex)) {
            adjacencies.add(vertex);
        }
    }

    // Checks if a vertex is adjacent
    public boolean isAdjacent(Vertex vertex) {
        return vertex != null && adjacencies.contains(vertex);
    }

    // Returns the degree (number of adjacent vertices)
    public int getDegree() {
        return adjacencies.size();
    }

    // Getter for vertexNumber (for printing)
    public int getVertexNumber() {
        return vertexNumber;
    }
}
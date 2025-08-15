

import java.util.ArrayList;
import java.util.Scanner;

public class Graph {
    private ArrayList<Vertex> vertices;

    // Constructor: Reads input and builds the graph
    public Graph() {
        vertices = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Read number of vertices
        if (!scanner.hasNextLine()) {
            System.err.println("Error: No input provided");
            scanner.close();
            return;
        }
        int numVertices;
        try {
            numVertices = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid number of vertices");
            scanner.close();
            return;
        }

        // Create vertices
        for (int i = 0; i < numVertices; i++) {
            addVertex();
        }

        // Read edges until -1
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.equals("-1")) {
                break;
            }
            String[] edge = line.split(",");
            if (edge.length != 2) {
                System.err.println("Warning: Invalid edge format: " + line);
                continue;
            }
            try {
                int v1 = Integer.parseInt(edge[0].trim());
                int v2 = Integer.parseInt(edge[1].trim());
                addEdge(v1, v2);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.err.println("Warning: Invalid edge: " + line);
            }
        }

        // Print degree of each vertex
        for (Vertex v : vertices) {
            System.out.println(v.getVertexNumber() + ":" + v.getDegree());
        }

        scanner.close();
    }

    // Adds a new vertex with vertexNumber equal to current vertices size
    public void addVertex() {
        vertices.add(new Vertex(vertices.size()));
    }

    // Returns the vertex with the given number
    public Vertex getVertex(int vertexNumber) {
        if (vertexNumber >= 0 && vertexNumber < vertices.size()) {
            return vertices.get(vertexNumber);
        }
        return null;
    }

    // Adds an undirected edge between two vertices
    public void addEdge(int v1, int v2) {
        Vertex vertex1 = getVertex(v1);
        Vertex vertex2 = getVertex(v2);
        if (vertex1 != null && vertex2 != null && v1 != v2) {
            vertex1.addAdjacency(vertex2);
            vertex2.addAdjacency(vertex1); // Undirected edge
        }
    }
}
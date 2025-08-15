import java.util.Scanner;

public class Program {
    public static void drawSnake(String snakePoints, int snakeNumber, int[][] matrix) {
        // Split the input string into points (e.g., "1,1 2,1 2,12" -> ["1,1", "2,1",
        // "2,12"])
        String[] points = snakePoints.split(" ");

        // Process each pair of consecutive points
        for (int i = 0; i < points.length - 1; i++) {
            drawLine(matrix, points[i], points[i + 1], snakeNumber);
        }
    }

    public static void drawLine(int[][] matrix, String point1, String point2, int snakeNumber) {
        // Split points into x,y coordinates
        String[] coords1 = point1.split(",");
        String[] coords2 = point2.split(",");

        // Parse coordinates
        int x1 = Integer.parseInt(coords1[0].trim());
        int y1 = Integer.parseInt(coords1[1].trim());
        int x2 = Integer.parseInt(coords2[0].trim());
        int y2 = Integer.parseInt(coords2[1].trim());

        // Find min and max for x and y
        int minX = Math.min(x1, x2);
        int maxX = Math.max(x1, x2);
        int minY = Math.min(y1, y2);
        int maxY = Math.max(y1, y2);

        // Draw the line by setting all positions in the rectangle to snakeNumber
        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                matrix[x][y] = snakeNumber;
            }
        }
    }

    public static void printBoard(int[][] matrix) {
        // Print each row
        for (int y = 0; y < matrix[0].length; y++) {
            for (int x = 0; x < matrix.length; x++) {
                System.out.print(matrix[x][y]);
                // Add space after each number, except the last in the row
                if (x < matrix.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println(); // Newline after each row
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read first line: numSnakes, width, height, 1
        String[] firstLine = scanner.nextLine().split(" ");
        int numSnakes = Integer.parseInt(firstLine[0]);
        int width = Integer.parseInt(firstLine[1]);
        int height = Integer.parseInt(firstLine[2]);

        // Initialize matrix with zeros
        int[][] matrix = new int[width][height];

        // Read each snake's points and draw it
        for (int i = 0; i < numSnakes; i++) {
            String snakePoints = scanner.nextLine();
            drawSnake(snakePoints, i + 1, matrix); // Snake numbers start at 1
        }

        // Print the resulting matrix
        printBoard(matrix);

        scanner.close();
    }
}
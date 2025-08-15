import java.util.Scanner;

public class Program {
    public static int getMove(int headX, int headY, int appleX, int appleY) {
        if (appleX == headX) {
            if (appleY < headY) {
                return 0; // Up
            } else if (appleY > headY) {
                return 1; // Down
            }
        } else if (appleY == headY) {
            if (appleX < headX) {
                return 2; // Left
            } else if (appleX > headX) {
                return 3; // Right
            }
        }
        return -1; // Fallback (shouldn't occur per lab guarantee)
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read first line: numSnakes, width, height, 1
        String[] firstLine = scanner.nextLine().split(" ");
        int numSnakes = Integer.parseInt(firstLine[0]);

        // Read apple coordinates
        String[] appleCoords = scanner.nextLine().split(",");
        int appleX = Integer.parseInt(appleCoords[0].trim());
        int appleY = Integer.parseInt(appleCoords[1].trim());

        // Read snake number (0-based)
        int snakeNumber = Integer.parseInt(scanner.nextLine().trim());

        // Validate snakeNumber
        if (snakeNumber < 0 || snakeNumber >= numSnakes) {
            System.err.println(
                    "Error: Invalid snake number " + snakeNumber + ". Must be between 0 and " + (numSnakes - 1));
            scanner.close();
            return;
        }

        // Create a matrix to store head coordinates of all snakes (numSnakes rows, 2
        // columns: x, y)
        int[][] heads = new int[numSnakes][2];

        // Read each snake's line and store only the head coordinates
        for (int i = 0; i < numSnakes; i++) {
            if (!scanner.hasNextLine()) {
                System.err
                        .println("Error: Not enough snake lines provided. Expected " + numSnakes + " but found fewer.");
                scanner.close();
                return;
            }
            String snakePoints = scanner.nextLine();
            // Get head coordinates (first point)
            String[] headPoint = snakePoints.split(" ")[0].split(",");
            heads[i][0] = Integer.parseInt(headPoint[0].trim()); // x
            heads[i][1] = Integer.parseInt(headPoint[1].trim()); // y
        }

        // Get the specified snake's head from the matrix
        int headX = heads[snakeNumber][0];
        int headY = heads[snakeNumber][1];

        // Determine and print the move
        int move = getMove(headX, headY, appleX, appleY);
        System.out.println(move);

        scanner.close();
    }
}
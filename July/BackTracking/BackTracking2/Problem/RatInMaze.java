// public class Q1 {

//     public static void main(String[] args) {

//         int maze[][] = {
//             {1, 0, 0, 0},
//             {1, 1, 0, 1},
//             {0, 1, 0, 0},
//             {1, 1, 1, 1}
//         };

//         int N = maze.length;

//         for (int i = 0; i < N; i++) {
//             for (int j = 0; j < N; j++) {
//                 System.out.print(maze[i][j] + " ");
//             }
//             System.out.println();
//         }
//     }
// }
public class RatInMaze {

    public static void printSolution(int sol[][]) {
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol.length; j++) {
                System.out.print(" " + sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int maze[][], int x, int y) {
        return (x >= 0 && x < maze.length &&
                y >= 0 && y < maze.length &&
                maze[x][y] == 1);
    }

    public static boolean solveMaze(int maze[][]) {
        int N = maze.length;
        int sol[][] = new int[N][N];

        if (solveMazeUtil(maze, 0, 0, sol) == false) {
            System.out.println("Solution doesn't exist");
            return false;
        }

        printSolution(sol);
        return true;
    }

    public static boolean solveMazeUtil(int maze[][], int x, int y, int sol[][]) {

        // Destination reached
        if (x == maze.length - 1 &&
            y == maze.length - 1 &&
            maze[x][y] == 1) {

            sol[x][y] = 1;
            return true;
        }

        // Check if current cell is safe
        if (isSafe(maze, x, y)) {

            // Avoid revisiting
            if (sol[x][y] == 1)
                return false;

            sol[x][y] = 1;

            // Move Down
            if (solveMazeUtil(maze, x + 1, y, sol))
                return true;

            // Move Right
            if (solveMazeUtil(maze, x, y + 1, sol))
                return true;

            // Backtrack
            sol[x][y] = 0;
            return false;
        }

        return false;
    }

    public static void main(String args[]) {

        int maze[][] = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };

        solveMaze(maze);
    }
}
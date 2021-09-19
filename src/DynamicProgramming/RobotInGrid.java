package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;

public class RobotInGrid {

    private class Point{
        public int row;
        public int column;

        public Point(int row, int column){
            this.row = row;
            this.column = column;
        }
    }

    // if we have a obstacle in [row][column] it will be true
    boolean[][] grid;

    public RobotInGrid(){
        initGrid();
        ArrayList<Point> path = new ArrayList<>();
        //ArrayList<Point> res = findPathBottomUp(grid);

        if(findPathMemoization(grid, grid.length - 1, grid[0].length - 1, new HashSet<>(), path)) {
            System.out.println("Path Found");
            for (Point point : path) {
                System.out.println("y = " + point.row + " x = " + point.column);
            }
        }
        else
            System.out.println("not found path");
    }

    private boolean findPathMemoization(boolean[][] grid, int row, int col, HashSet<Point> memo, ArrayList<Point> path){

        if(col < 0 || row < 0 || grid[row][col])
            return false;


        Point point = new Point(row, col);
        if (memo.contains(point))
            return false;

        boolean isOrigin = (row == 0 && col == 0);

        if(isOrigin || findPathMemoization(grid, row - 1, col, memo, path) || findPathMemoization(grid, row, col - 1, memo, path)) {
            path.add(point);
            return true;
        }

        memo.add(point);
        return false;
    }

    private ArrayList<Point> findPathBottomUp(boolean[][] grid){

        ArrayList<Point> result = new ArrayList<>();
        if(grid[0][0] == true)//if starting point has an obstacle we directly return
            return result;

        ArrayList<Point> base = new ArrayList();
        base.add(new Point(0, 0));

        //Fill the first row
        ArrayList<Point>[][] dp = new ArrayList[grid.length][grid[0].length];



        for (int row = 0; row < grid.length;row++)
            for (int column = 0; column < grid[0].length;column++) {
                dp[row][column] = new ArrayList<>();
            }
        dp[0][0] = base;

        for (int column = 1; column < grid[0].length;column++){
            if (grid[0][column] == true)
                break;
            ArrayList<Point> leftPath = dp[0][column - 1];
            ArrayList<Point> currentPath = new ArrayList<>(leftPath);
            currentPath.add(new Point(0, column));
            dp[0][column] = currentPath;
        }

        //Fill the first column
        for (int row = 1; row < grid.length;row++){
            if (grid[row][0])
                break;
            ArrayList<Point> upPath = dp[row - 1][0];
            ArrayList<Point> currentPath = new ArrayList<>(upPath);
            currentPath.add(new Point(row, 0));
            dp[row][0] = currentPath;
        }

        for (int row = 1; row < grid.length;row++){
            for (int column = 1; column < grid[0].length; column++){
                if(grid[row][column])
                    continue;

                ArrayList<Point> leftPath = dp[row][column - 1];
                ArrayList<Point> upPath = dp[row - 1][column];

                if(!leftPath.isEmpty()){
                    ArrayList<Point> path = new ArrayList<>(leftPath);
                    path.add(new Point(row, column));
                    dp[row][column] = path;
                    continue;
                }

                if(!upPath.isEmpty()){
                    ArrayList<Point> path = new ArrayList<>(upPath);
                    path.add(new Point(row, column));
                    dp[row][column] = path;
                }
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }

    private void initGrid(){
        grid = new boolean[3][6];
    }

}

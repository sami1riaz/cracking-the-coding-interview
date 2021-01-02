package recursivedp;

import java.awt.*;
import java.util.*;
import java.util.List;


/**
 * Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
 * The robot can only move in two directions, right and down, but certain cells are "off limits"
 * such that the robot cannot step on them. Design an algorithm to find a path for the robot
 * from the top left to the bottom right.
 */
class _08_02_RobotInAGrid {

//    class Point {
//        int row;
//        int col;
//        public Point(int row, int col) {
//            this.row = row;
//            this.col = col;
//        }
//    }

    List<Point> findPath(boolean[][] grid) {

        if (grid == null || grid.length == 0) {
            return null;
        }
        // to store the path
        List<Point> path = new ArrayList<>();

        // memo
        HashSet<Point> failedPoints = new HashSet<>();
        if (hasPath(grid, grid.length - 1, grid[0].length - 1, path, failedPoints)) {
            return path;
        }
        return null;
    }

    boolean hasPath(boolean[][] grid, int row, int col, List<Point> path, HashSet<Point> failedPoints) {

        // If out of bounds, or can't access cell, return false
        if (row < 0 || col < 0 || grid[row][col] == false) {
            return false;
        }
        // if we have already found that there is no valid path from this point, return false
        Point curr = new Point(row, col);
        if (failedPoints.contains(curr) ) {
            return false;
        }

        boolean isAtStart = row == 0 && col == 0;

        // return true if
        /// we are at start,
        /// if its possible to go up one step
        /// if its possible to go left one step
        if (isAtStart || hasPath(grid, row - 1, col, path, failedPoints)
                        || hasPath(grid, row, col - 1, path, failedPoints)) {
            path.add(curr);
            return true;
        }

        // if there was no possible path, add point to failed Points and return false
        failedPoints.add(curr);
        return false;
    }
}

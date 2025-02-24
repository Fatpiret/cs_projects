package maze;

import java.util.Stack;

public class MazeSolver {
	  public static Position[] solve(Maze maze) {
		  Stack<Position> path = new Stack<>();
		  path.push(maze.getStart());
		    maze.setAt(maze.getStart(), 'V');

   
 while (!path.isEmpty()) {
    	
        Position current = path.peek();
        if (current.equals(maze.getEnd())) {
            Position[] data = new Position[path.size()];
            for (int i = 0; i < data.length; i++) {
                data[i] = path.get(i);
            }
            return data;
        }
        
       boolean moved = false;
        for (Position neighbor : getNeighbors(maze, current)) {
            if (maze.getAt(neighbor) == ' ') {
                path.push(neighbor);
                maze.setAt(neighbor, 'V');
                moved = true;
                break;
            }
        }
        
        if (!moved) {
            path.pop();
        }
    }
    
    return new Position[0]; 
}
	  
private static Stack<Position> getNeighbors(Maze maze, Position pos) {
    int row = pos.getRow();
    int col = pos.getColumn();
    Stack<Position> neighbors = new Stack<Position>(); //Stack declared and initialized 
    
    if (maze.validPosition(row - 1, col)) {            //Move Down
        neighbors.add(new Position(row - 1, col));
    }
    
    if (maze.validPosition(row + 1, col)) {
        neighbors.add(new Position(row + 1, col));     //Move Up
    }
    
    if (maze.validPosition(row, col - 1)) {            //Move Left
        neighbors.add(new Position(row, col - 1));
    }
    
    if (maze.validPosition(row, col + 1)) {
        neighbors.add(new Position(row, col + 1));     //Move Right
    }
    
    return neighbors;
  }
}

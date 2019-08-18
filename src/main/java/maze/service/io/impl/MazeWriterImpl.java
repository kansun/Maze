package maze.service.io.impl;

import maze.model.Location;
import maze.model.Maze;
import maze.model.Square;
import maze.service.io.MazeWriter;

import java.util.Map;

public class MazeWriterImpl implements MazeWriter {

    @Override
    public void write(Maze maze) {
        Map<Location, Square> map = maze.getSquares();
        StringBuilder sb = new StringBuilder();
        char[][] chars = new char[maze.getHeight()][maze.getWidth()];
        map.entrySet().stream().forEach(e -> {
            Location loc = e.getKey();
            int row = loc.getRow();
            int col = loc.getCol();
            chars[row][col] = e.getValue().getLabel();
        });
        for (int row = 0; row < chars.length; row++) {
            sb.append(String.valueOf(chars[row])).append('\n');
        }
        System.out.print(sb);
    }
}

package treasure.map.carbon;

import java.util.Arrays;

public class TreasureMap {
    private final String[][] map;

    public TreasureMap(int x, int y) {
        this.map = createMap(x, y);
    }

    public String[][] createMap(int x, int y) {
        String[][] map = new String[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                map[i][j] = ".";
            }
        }
        return map;
    }

    public static void printMap(String[][] treasureMap) {
        // print the map to the console
        for (int i = 0; i < treasureMap.length; i++) {
            for( int j = 0; j < treasureMap[i].length; j++) {
                System.out.print(treasureMap[i][j] + " ");
            }
            System.out.println();
        }
    }

    public String[][] getMap() {
        return map;
    }
}


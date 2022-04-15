package treasure.map.carbon;

import java.util.Arrays;

public class TreasureMap {
    public String[][] map;
    public int width;
    public int height;

    public TreasureMap(int x, int y) {
        this.map = createMap(x, y);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String[][] createMap(int x, int y) {
        String[][] map = new String[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                map[i][j] = ".";
            }
        }
        this.width = x;
        this.height = y;
        return map;
    }

    public void setMap(String[][] map) {
        this.map = map;
    }

    public static void printMap(String[][] treasureMap) {
        // print the map to the console
        for (int i = 0; i < treasureMap.length; i++) {
            for( int j = 0; j < treasureMap[i].length; j++) {
                if (treasureMap[i][j].startsWith("T")) {
                    System.out.print(treasureMap[i][j]+"    ");
                    continue;
                }
                if(treasureMap[i][j].startsWith("A")) {
                    System.out.print(treasureMap[i][j]);
                }
                else {
                    System.out.print(treasureMap[i][j]+ "       ");
                }
            }
            System.out.println();
        }
    }

    public void addTreasure(String [][] treasureInfo) {
        for(int i = 0; i < treasureInfo.length; i++){
            this.map[Integer.parseInt(treasureInfo[i][2])]
                    [Integer.parseInt(treasureInfo[i][1])] = "T("+ treasureInfo[i][3] + ")";
        }
    }

    public void addMountain(String [][] mountainInfo) {
        for(int i = 0; i < mountainInfo.length; i++){
            this.map[Integer.parseInt(mountainInfo[i][2])]
                    [Integer.parseInt(mountainInfo[i][1])] = "M";
        }
    }

    public String[][] getMap() {
        return map;
    }

    public void addAdventurer(String[][] adventurerInfo) {
        for(int i = 0; i < adventurerInfo.length; i++){
            this.map[Integer.parseInt(adventurerInfo[i][3])]
                    [Integer.parseInt(adventurerInfo[i][2])] = "A("+ adventurerInfo[i][1] + ") ";
        }
    }
}


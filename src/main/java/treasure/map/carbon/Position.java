package treasure.map.carbon;

import java.util.Objects;

import static java.lang.Integer.parseInt;

public class Position {
    final int x;
    final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position goNorth(TreasureMap map, Adventurer adventurer) {
        if (this.isvalid(map, this.x - 1, this.y, adventurer)) {
            return new Position(this.x - 1, this.y);
        } else {
            return this;
        }
    }

    public Position goSouth(TreasureMap map, Adventurer adventurer) {
        if (this.isvalid(map, this.x + 1, this.y, adventurer)) {
            return new Position(this.x + 1, this.y);
        } else {
            return this;
        }
    }

    public Position goWest(TreasureMap map, Adventurer adventurer) {
        if (this.isvalid(map, this.x, this.y - 1, adventurer)) {
            return new Position(this.x, this.y - 1);
        } else {
            return this;
        }
    }

    public Position goEast(TreasureMap map, Adventurer adventurer) {
        if (this.isvalid(map, this.x, this.y + 1, adventurer)) {
            return new Position(this.x, this.y + 1);
        } else {
            return this;
        }
    }

    @Override
    public String toString() {
        return  this.x + " - " + this.y;
    }

    private boolean isvalid(TreasureMap map, int x, int y, Adventurer adventurer) {
        if(x < 0 || y < 0 || x >= map.getWidth() || y >= map.getHeight()) {
            return false;
        }
        if (map.map[x][y].startsWith("M")) {
            return false;
        }
        if (map.map[x][y].startsWith("T")) {
            adventurer.numberOfTreasures++;
            String stNbTreasureLeft = map.map[x][y].substring(2,3);
            int nbTreasureLeft = parseInt(stNbTreasureLeft);
            if (nbTreasureLeft > 1) {
                nbTreasureLeft--;
                map.map[x][y] = map.map[x][y].replace(stNbTreasureLeft, String.valueOf(nbTreasureLeft));
            } else {
                map.map[x][y] = ".";
            }
            return true;
        }else {
            return true;
        }
    }
}

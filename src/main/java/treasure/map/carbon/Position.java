package treasure.map.carbon;

public class Position {
    final int x;
    final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Position goNorth(){
        return new Position(this.x, this.y+1);
    }

    public Position goSouth(){
        return new Position(this.x, this.y-1);
    }

    public Position goWest(){
        return new Position(this.x-1, this.y);
    }

    public Position goEast(){
        return new Position(this.x+1, this.y);
    }
}

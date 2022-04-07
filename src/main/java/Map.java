public class Map {
    private Number x_size;
    private Number y_size;

    public Map(Number x_size, Number y_size){
        this.x_size = x_size;
        this.y_size = y_size;
    }

    public String[] createMap(Number x_size, Number y_size){
        String[] map = new String[x_size];
        for (int i = 0; i < x_size; i++) {
            map[i] = new String[y_size];
            for (int j = 0; j < y_size; j++) {
                map[i][j] = ".";
            }
        }
        return map;
    }
    public void printMap(String[] map){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length(); j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public Number getX_size() {
        return x_size;
    }

    public void setX_size(Number x_size) {
        this.x_size = x_size;
    }

    public Number getY_size() {
        return y_size;
    }

    public void setY_size(Number y_size) {
        this.y_size = y_size;
    }
}

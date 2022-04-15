package treasure.map.carbon;

public class Adventurer {
    private String name;
    public int numberOfTreasures;
    private Orientation orientation;
    private Position position;
    private String mouvements;


    public Adventurer(String name, int numberOfTreasures, Orientation orientation, Position position, String mouvements) {
        this.name = name;
        this.numberOfTreasures = numberOfTreasures;
        this.orientation = orientation;
        this.position = position;
        this.mouvements = mouvements;
    }

    @Override
    public String toString() {
        return "A - " + name + " - " + numberOfTreasures + " - " + orientation + " - " + position + " - " + mouvements;
    }

    public String getMouvements() {
        return mouvements;
    }

    public void setMouvements(String mouvements) {
        this.mouvements = mouvements;
    }

    public void move_foward(TreasureMap map) {
        switch (this.orientation){
            case North:
                this.position = this.position.goNorth(map, Adventurer.this);
                break;
            case South:
                this.position = this.position.goSouth(map, Adventurer.this);
                break;
            case West:
                this.position = this.position.goWest(map, Adventurer.this);
                break;
            case East:
                this.position = this.position.goEast(map, Adventurer.this);
                break;
        }
    }

    public void rotate_left() {
        switch (this.orientation){
            case North:
                this.orientation = Orientation.West;
                break;
            case West:
                this.orientation = Orientation.South;
                break;
            case South:
                this.orientation = Orientation.East;
                break;
            case East:
                this.orientation = Orientation.North;
                break;
        }
    }

    public void rotate_right() {
        switch (this.orientation){
            case North:
                this.orientation = Orientation.East;
                break;
            case South:
                this.orientation = Orientation.West;
                break;
            case East:
                this.orientation = Orientation.South;
                break;
            case West:
                this.orientation = Orientation.North;
                break;
        }
    }

    public void analyseMouvements(String mouvements, TreasureMap map, Position position) {
        for (int i = 0 ; i < mouvements.length() ; i++){
            switch (mouvements.charAt(i)){
                case 'A':

                    this.move_foward(map);
                    break;
                case 'G':
                    this.rotate_left();
                    this.move_foward(map);
                    break;
                case 'D':
                    this.rotate_right();
                    this.move_foward(map);
                    break;
            }
        }
    }

    public void updatePosition(Position newPosition) {
        this.position = newPosition;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfTreasures() {
        return numberOfTreasures;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfTreasures(int numberOfTreasures) {
        this.numberOfTreasures = numberOfTreasures;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public Orientation getOrientation() {
        return orientation;
    }
}




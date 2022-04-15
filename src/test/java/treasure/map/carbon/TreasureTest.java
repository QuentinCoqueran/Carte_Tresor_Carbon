package treasure.map.carbon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TreasureTest {
    TreasureMap mapTest = new TreasureMap(10,10);

    @Test
    public void testMapSize() {
        TreasureMap map = new TreasureMap(5, 5);
        Assertions.assertEquals(5, map.getHeight());
        Assertions.assertEquals(5, map.getWidth());
    }

    @Test
    public void testAdventurerCreation() {
        Adventurer adventurer = new Adventurer("Lara", 0, Orientation.S, new Position(1, 1), "AADGAADG");
        Assertions.assertEquals(new Position(1, 1).getX(), adventurer.getPosition().getX());
        Assertions.assertEquals(new Position(1, 1).getY(), adventurer.getPosition().getY());
        Assertions.assertEquals(Orientation.S, adventurer.getOrientation());
        Assertions.assertEquals("Lara", adventurer.getName());
        Assertions.assertEquals("AADGAADG", adventurer.getMouvements());
    }

    @Test
    public void testAnalyseRotate() {
        Adventurer adventurer = new Adventurer("Lara", 0, Orientation.S, new Position(1, 1), "D");
        adventurer.analyseMouvements(adventurer.getMouvements(), mapTest, adventurer.getPosition());
        Assertions.assertEquals(new Position(1, 0).getX(), adventurer.getPosition().getX());
        Assertions.assertEquals(new Position(1, 0).getY(), adventurer.getPosition().getY());
        Assertions.assertEquals(Orientation.W, adventurer.getOrientation());
    }

    @Test
    public void testInvalidMove() {
        Adventurer adventurer = new Adventurer("Lara", 0, Orientation.N, new Position(0, 0), "A");
        adventurer.analyseMouvements(adventurer.getMouvements(), mapTest, adventurer.getPosition());
        Assertions.assertEquals(new Position(0, 0).getX(), adventurer.getPosition().getX());
        Assertions.assertEquals(new Position(0, 0).getY(), adventurer.getPosition().getY());
        Assertions.assertEquals(Orientation.N, adventurer.getOrientation());
    }

    @Test
    public void testAnalyseMoveForward() {
        Adventurer adventurer = new Adventurer("Lara", 0, Orientation.S, new Position(1, 1), "A");
        adventurer.analyseMouvements(adventurer.getMouvements(), mapTest, adventurer.getPosition());
        Assertions.assertEquals(new Position(2, 1).getX(), adventurer.getPosition().getX());
        Assertions.assertEquals(new Position(2, 1).getY(), adventurer.getPosition().getY());
    }

}

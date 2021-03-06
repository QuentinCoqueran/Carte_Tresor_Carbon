package treasure.map.carbon;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
                String[] inputdata = FileUtils.readFile("C:/Users/quent/IdeaProjects/Carte_Tresor_Carbon/src/main/java/ressources/input.txt");
                String[] parsedData = FileUtils.parseInputData(inputdata);
                TreasureMap map1 = createMap(parsedData);
                TreasureMap.printMap(map1.getMap());
                Adventurer[] adventurers = createAdventurer(parsedData, map1);
                Adventurer[] updatedAdventurers = updateAdventurers(parsedData, map1, adventurers);
                System.out.println("--------------------------");
                TreasureMap.printMap(map1.getMap());
                FileUtils.printOutputFile(map1, updatedAdventurers, parsedData);
        }

        private static Adventurer[] updateAdventurers(String[] parsedData, TreasureMap map1, Adventurer[] adventurers) {
                String [] adventurerData = FileUtils.extractAdventurerData(parsedData);
                String[][] adventurerInfo = FileUtils.parseAdventurerData(adventurerData);
                for(int i = 0; i < adventurers.length; i++) {
                        map1.map[adventurers[i].getPosition().getX()][adventurers[i].getPosition().getY()] = ".";
                        adventurers[i].analyseMouvements(adventurers[i].getMouvements(),map1, adventurers[i].getPosition());
                        adventurers[i].updatePosition(adventurers[i].getPosition());
                        adventurerInfo[i][3] = Integer.toString(adventurers[i].getPosition().getX());
                        adventurerInfo[i][2] = Integer.toString(adventurers[i].getPosition().getY());
                }
                map1.addAdventurer(adventurerInfo);
                return adventurers;
        }


        private static Adventurer[] createAdventurer(String[] parsedData, TreasureMap map1) {
                String [] adventurerData = FileUtils.extractAdventurerData(parsedData);
                String[][] adventurerInfo = FileUtils.parseAdventurerData(adventurerData);
                Adventurer[] adventurers = new Adventurer[adventurerInfo.length];
                // for multiple adventurers
                for(int i = 0; i < adventurerInfo.length; i++) {
                        Position position = new Position(Integer.parseInt(adventurerInfo[i][3]), Integer.parseInt(adventurerInfo[i][2]));
                        adventurers[i] = switch (adventurerInfo[i][4]) {
                                case "S" -> new Adventurer(adventurerInfo[i][1], 0, Orientation.S, position, adventurerInfo[i][5]);
                                case "N" -> new Adventurer(adventurerInfo[i][1], 0, Orientation.N, position, adventurerInfo[i][5]);
                                case "E" -> new Adventurer(adventurerInfo[i][1], 0, Orientation.E, position, adventurerInfo[i][5]);
                                case "W" -> new Adventurer(adventurerInfo[i][1], 0, Orientation.W, position, adventurerInfo[i][5]);
                                default -> throw new IllegalArgumentException("Invalid orientation");
                        };
                }
                return adventurers;
        }


        private static TreasureMap createMap(String[] parsedData) {

                System.out.println("Input Data :");
                for(int i = 0; i < parsedData.length; i++){
                        System.out.println(parsedData[i]);
                }
                String mapData = FileUtils.extractMapData(parsedData);
                String[] mapInfo = FileUtils.parseMapData(mapData);

                String [] mountainData = FileUtils.extractMountainData(parsedData);
                String[][] mountainInfo = FileUtils.parseMoutainData(mountainData);

                String [] treasureData = FileUtils.extractTreasureData(parsedData);
                String[][] treasureInfo = FileUtils.parseTreasureData(treasureData);

                String [] adventurerData = FileUtils.extractAdventurerData(parsedData);
                String[][] adventurerInfo = FileUtils.parseAdventurerData(adventurerData);
                System.out.println("--------------------------");
                TreasureMap map1 = new TreasureMap(Integer.parseInt(mapInfo[2]), Integer.parseInt(mapInfo[1]));
                map1.addTreasure(treasureInfo);
                map1.addMountain(mountainInfo);
                map1.addAdventurer(adventurerInfo);
                return map1;
        }
}

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
                Adventurer[] adventurers = createAdventurer(parsedData);
        }

        private static Adventurer[] createAdventurer(String[] parsedData) {
                String [] adventurerData = FileUtils.extractAdventurerData(parsedData);
                String[][] adventurerInfo = FileUtils.parseAdventurerData(adventurerData);
                Adventurer[] adventurers = new Adventurer[adventurerInfo.length];
                // for multiple adventurers
                for(int i = 0; i < adventurerInfo.length; i++) {
                        Position position = new Position(Integer.parseInt(adventurerInfo[i][3]), Integer.parseInt(adventurerInfo[i][2]));
                        adventurers[i] = switch (adventurerInfo[i][4]) {
                                case "S" -> new Adventurer(adventurerInfo[i][1], 0, Orientation.South, position, adventurerInfo[i][5]);
                                case "N" -> new Adventurer(adventurerInfo[i][1], 0, Orientation.North, position, adventurerInfo[i][5]);
                                case "E" -> new Adventurer(adventurerInfo[i][1], 0, Orientation.East, position, adventurerInfo[i][5]);
                                case "W" -> new Adventurer(adventurerInfo[i][1], 0, Orientation.West, position, adventurerInfo[i][5]);
                                default -> throw new IllegalArgumentException("Invalid orientation");
                        };
                }
                return adventurers;
        }


        private static TreasureMap createMap(String[] parsedData) {

                System.out.println("Parsed Data :");
                for(int i = 0; i < parsedData.length; i++){
                        System.out.println(parsedData[i]);
                }

                String mapData = FileUtils.extractMapData(parsedData);
                String[] mapInfo = FileUtils.parseMapData(mapData); // checked

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

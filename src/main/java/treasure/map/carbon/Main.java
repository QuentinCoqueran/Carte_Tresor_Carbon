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
                Adventurer adventurer = createAdventurer(parsedData);
        }

        private static Adventurer createAdventurer(String[] parsedData) {
                String [] adventurerData = FileUtils.extractAdventurerData(parsedData);
                String[][] adventurerInfo = FileUtils.parseAdventurerData(adventurerData);
                if (adventurerInfo[0][4].equals("S")){
                        adventurerInfo[0][4] = "South";

                }
                if (adventurerInfo[0][4].equals("N")){
                        adventurerInfo[0][4] = "North";
                }
                if (adventurerInfo[0][4].equals("E")){
                        adventurerInfo[0][4] = "East";
                }
                if (adventurerInfo[0][4].equals("0")){
                        adventurerInfo[0][4] = "West";
                }

                Adventurer adventurer = new Adventurer(
                                adventurerInfo[0][0],
                                0,

                );

                return adventurer;
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

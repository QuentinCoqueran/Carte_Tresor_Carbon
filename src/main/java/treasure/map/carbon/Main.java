package treasure.map.carbon;
import java.io.File;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) {

                String[] inputdata = FileUtils.readFile("C:/Users/quent/IdeaProjects/Carte_Tresor_Carbon/src/main/java/ressources/input.txt");
                String[] parsedData = FileUtils.parseInputData(inputdata);
                System.out.println("Parsed Data :");
                for(int i = 0; i < parsedData.length; i++){
                        System.out.println(parsedData[i]);
                }
                String mapData = FileUtils.extractMapData(parsedData);
                String [] mountainData = FileUtils.extractMountainData(parsedData);
                String [] treasureData = FileUtils.extractTreasureData(parsedData);
                String [] adventurerData = FileUtils.extractAdventurerData(parsedData);
                System.out.println("MapData :");
                System.out.println(mapData);
                System.out.println("MountainData :");
                for(int i = 0; i < mountainData.length; i++){
                        System.out.println(mountainData[i]);
                }
                System.out.println("TreasureData :");
                for(int i = 0; i < treasureData.length; i++){
                        System.out.println(treasureData[i]);
                }
                System.out.println("AdventurerData :");
                for(int i = 0; i < adventurerData.length; i++){
                        System.out.println(adventurerData[i]);
                }
                String[] mapInf = mapData.split("-");
                for(int i = 0; i < mapInf.length; i++){
                        System.out.println(mapInf[i]);
                }
                System.out.println("--------------------------");

                TreasureMap map1 = new TreasureMap(Integer.parseInt(mapInf[2]), Integer.parseInt(mapInf[1]));

                //TreasureMap map2 = new TreasureMap(10,10);
                TreasureMap.printMap(map1.getMap());
                //TreasureMap.printMap(map2.getMap());
        }
}

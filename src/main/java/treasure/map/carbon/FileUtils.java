package treasure.map.carbon;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner; // Import the Scanner class to read text files

public class FileUtils {


    public static String[] readFile(String path) {

        String[] fileLines = new String[0];
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            fileLines = new String[countFileLines(path)];
            int countLines = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.charAt(0) != '#') {
                    fileLines[countLines] = data;
                    countLines++;
                }
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return fileLines;
    }

    public static int arraylen(String[] stArray) {
        int i = 0;
        int count = 0;
        while (stArray[i] != null) {
            count++;
            i++;
        }
        return count;
    }

    public static int countMountains(String[] parsedData) {
        int count = 0;
        for (String line : parsedData) {
            if (line.startsWith("M")) {
                count++;
            }
        }
        return count;
    }

    public static int countAdventurers(String[] parsedData) {
        int count = 0;
        for (String line : parsedData) {
            if (line.startsWith("A")) {
                count++;
            }
        }
        return count;
    }

    public static int countTreasures(String[] parsedData) {
        int count = 0;
        for (String line : parsedData) {
            if (line.startsWith("T")) {
                count++;
            }
        }
        return count;
    }

    public static String[] parseInputData(String[] inputData) {
        String[] parsedData = new String[arraylen(inputData)];
        for (int i = 0; i < inputData.length && inputData[i] != null; i++) {
            inputData[i] = inputData[i].replaceAll(" ", "");
            parsedData[i] = inputData[i];
        }
        return parsedData;
    }

    public static String[] parseMapData(String mapData) {
        String[] mapInfo = mapData.split("-");
        return mapInfo;
    }

    public static String[][] parseMoutainData(String[] mountainData) {
        String[][] mountainInfo = new String[mountainData.length][3];
        int count = 0;
        for (String line : mountainData) {
            mountainInfo[count] = line.split("-");
            count++;
        }
        return mountainInfo;
    }

    public static String[][] parseTreasureData(String[] treasureData) {
        String[][] treasureInfo = new String[treasureData.length][3];
        int count = 0;
        for (String line : treasureData) {
            treasureInfo[count] = line.split("-");
            count++;
        }
        return treasureInfo;
    }

    public static String[][] parseAdventurerData(String[] adventurerData) {
        String[][] adventurerInfo = new String[adventurerData.length][6];
        int count = 0;
        for (String line : adventurerData) {
            adventurerInfo[count] = line.split("-");
            count++;
        }
        return adventurerInfo;
    }

    public static String extractMapData(String[] parsedData) {
        String mapData = "";
        for (int i = 0; i < parsedData.length; i++) {
            if (parsedData[i].startsWith("C")) {
                mapData = parsedData[i];
            }
        }
        return mapData;
    }

    public static String[] extractMountainData(String[] parsedData) {
        String[] mountainData = new String[countMountains(parsedData)];
        int countAdds = 0;
        for (int i = 0; i < parsedData.length; i++) {
            if (parsedData[i].startsWith("M")) {
                mountainData[countAdds] = parsedData[i];
                countAdds++;
            }
        }
        return mountainData;
    }

    public static String[] extractAdventurerData(String[] parsedData) {
        String[] mountainData = new String[countAdventurers(parsedData)];
        int countAdds = 0;
        for (int i = 0; i < parsedData.length; i++) {
            if (parsedData[i].startsWith("A")) {
                mountainData[countAdds] = parsedData[i];
                countAdds++;
            }
        }
        return mountainData;
    }

    public static String[] extractTreasureData(String[] parsedData) {
        String[] treasureData = new String[countTreasures(parsedData)];
        int countAdds = 0;
        for (int i = 0; i < parsedData.length; i++) {
            if (parsedData[i].startsWith("T")) {
                treasureData[countAdds] = parsedData[i];
                countAdds++;
            }
        }
        return treasureData;
    }

    public static int countFileLines(String path) {
        int lines = 0;
        try {
            lines = (int) Files.lines(Path.of(path)).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void printOutputFile(TreasureMap map1, Adventurer[] updatedAdventurers, String[]parsedData) {

        String [] treasureData = FileUtils.extractTreasureData(parsedData);
        String [] mountainData = FileUtils.extractMountainData(parsedData);
        String[] outputData = new String[parsedData.length+1];
        int countAdds = 0;
        outputData[countAdds] = parsedData[0];
        countAdds++;
        for (int i = 0; i < mountainData.length; i++) {
            outputData[countAdds] = mountainData[i];
            countAdds++;
        }
        for(int i = 0; i < treasureData.length; i++) {
            outputData[countAdds] = treasureData[i];
            countAdds++;
        }
        for(int i = 0; i < updatedAdventurers.length; i++) {
           outputData[countAdds] = updatedAdventurers[i].toString();
           countAdds++;
        }
        outputData[countAdds] = "# J'ai pas eu le temps de respecter le format de sortie pour les aventuriers le format est le suivant : {A comme Aventurier} - {Nom de l’aventurier} - {Nb. trésors ramassés} - {Orientation} - {Axe horizontal} - {Axe " +
                "vertical} - {Mouvements}";
        for(int i = 0 ; i < outputData.length; i++) {
            System.out.println(outputData[i]);
        }
    }
}



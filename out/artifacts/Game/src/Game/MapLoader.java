package Game;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class MapLoader {
    HashMap<Integer, MapBlock> blocks = new HashMap<>();
    MapBlock mapBlock;
    int counter = 0;

    public MapLoader(String mapFile) throws FileNotFoundException {
        String fileName = mapFile;
        FileReader fileIn = new FileReader(fileName);
        Scanner scanner = new Scanner(fileIn);
        int posX = 0;
        int posY = 0;

        while (scanner.hasNextLine()) {
            char[] chars = scanner.nextLine().toCharArray();
            for (int i = 0; i < chars.length; i++) {
                posY = i;
                mapBlock = new MapBlock(posX, posY);
                char letter = chars[i];
                mapBlock.setBlockTypeLetter(letter);
                mapBlock.setPositionX(posX);
                mapBlock.setPositionY(posY);
                if (letter == 'B') {
                    mapBlock.setBlock(true);
                    mapBlock.setName("Block");
                }
                else if (letter == 'R') {
                    mapBlock.setBlock(false);
                    mapBlock.setPic("src/Game/img/roadRoad.png");
                    mapBlock.setPictureFar("src/Game/img/roadRoad.png");
                    mapBlock.setName("Road");
                }
                else if (letter == 'C') {
                    mapBlock.setBlock(true);
                    mapBlock.setPic("src/Game/img/castle.png");
                    mapBlock.setPictureFar("src/Game/img/roadCastle.png");
                    mapBlock.setName("Castle");
                }
                else if (letter == 'T') {
                    mapBlock.setBlock(true);
                    mapBlock.setPic("src/Game/img/forest.png");
                    mapBlock.setPictureFar("src/Game/img/roadForest.png");
                    mapBlock.setName("Tree");
                }
                else if (letter == 'S') {
                    mapBlock.setBlock(false);
                    mapBlock.setPic("src/Game/img/sand.png");
                    mapBlock.setPictureFar("src/Game/img/sandForest.png");
                    mapBlock.setName("Sand");
                }
                blocks.put(counter, mapBlock);
                counter++;
            }
            posX++;
        }
    }

    public Character blockLetter(int posX, int posY){
        char blockLetter;
        for (int i = 0; i<blocks.size(); i++){
           mapBlock = blocks.get(i);
           if (mapBlock.getPositionX() == posX && mapBlock.getPositionY() == posY){
               blockLetter = mapBlock.getBlockTypeLetter();
               return blockLetter;
           }
        }
        return null;
    }

    public String blockName(int posX, int posY){
        String blockname;
        for (int i = 0; i<blocks.size(); i++){
            mapBlock = blocks.get(i);
            if (mapBlock.getPositionX() == posX && mapBlock.getPositionY() == posY){
                blockname = mapBlock.getName();
                return blockname;
            }
        }
        return null;
    }

    public String blockPicture(int posX, int posY){
        String blockPicture;
        for (int i = 0; i<blocks.size(); i++){
            mapBlock = blocks.get(i);
            if (mapBlock.getPositionX() == posX && mapBlock.getPositionY() == posY){
                blockPicture = mapBlock.getPic();
                return blockPicture;
            }
        }
        return null;
    }

    public String blockFarPicture(int posX, int posY){
        String blockPicture;
        for (int i = 0; i<blocks.size(); i++){
            mapBlock = blocks.get(i);
            if (mapBlock.getPositionX() == posX && mapBlock.getPositionY() == posY){
                blockPicture = mapBlock.getPictureFar();
                return blockPicture;
            }
        }
        return null;
    }

    public boolean blockIsBlocked(int posX, int posY){
        boolean blockIsBlocked = false;
        for (int i = 0; i<blocks.size(); i++){
            mapBlock = blocks.get(i);
            if (mapBlock.getPositionX() == posX && mapBlock.getPositionY() == posY){
                blockIsBlocked = mapBlock.isBlock();
                return blockIsBlocked;
            }
        }
        return blockIsBlocked;
    }

}

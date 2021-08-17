package Game;

public class MapBlock {
    public char blockTypeLetter;
    public String name;
    public boolean block;
    public String pic;
    String pictureFar;
    public int positionX;
    public int positionY;
    boolean pickable;

    public MapBlock(int posX, int posY){
        String name = getName();
        boolean block = isBlock();
        boolean pickable = isPickable();
        String pic = getPic();
        String pictureFar = getPictureFar();
        int positionX = posX;
        int positionY = posY;
    }

    public boolean isPickable() {
        return pickable;
    }

    public void setPickable(boolean pickable) {
        this.pickable = pickable;
    }

    public void setPictureFar(String pictureFar) {
        this.pictureFar = pictureFar;
    }

    public String getPictureFar() {
        return pictureFar;
    }

    public void setBlockTypeLetter(char blockTypeLetter) {
        this.blockTypeLetter = blockTypeLetter;
    }

    public char getBlockTypeLetter() {
        return blockTypeLetter;
    }

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getPositionY() {
        return positionY;
    }
}

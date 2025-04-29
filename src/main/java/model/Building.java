package model;

public class Building {
    private final int startX;
    private final int startY;
    private final int width;
    private final int height;
    private Map map;

    public Building(int startX, int startY, int width, int height, Map map) {
        this.startX = startX;
        this.startY = startY;
        this.width = width;
        this.height = height;
        this.map = map;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}

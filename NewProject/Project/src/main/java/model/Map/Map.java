package model.Map;

import model.Position;

public class Map {
    private final int width;
    private final int height;
    private final Tile[][] tiles;
    private Item[][] items;
    private char[][] mapShow;

    public Map(int width, int height, Tile[][] tiles, Item[][] items, char[][] mapShowing) {
        this.width = width;
        this.height = height;
        this.tiles = tiles;
        this.items = items;
        this.mapShow = mapShowing;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public Tile getTile(Position position) {
        return tiles[position.x][position.y];
    }

    public Item[][] getItems() {
        return items;
    }

    public Item getItem(Position position) {
        return items[position.x][position.y];
    }

    public void setItem(Position position, Item item) {
        items[position.x][position.y] = item;
    }

    public char[][] getMapShow() {
        return mapShow;
    }

    public void setMapShowInPosition(Position position, char sign) {
        this.mapShow[position.x][position.y] = sign;
    }
}
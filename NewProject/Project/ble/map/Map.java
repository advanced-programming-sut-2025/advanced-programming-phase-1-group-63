package model.map;

import model.Position;

public class Map {
    private final int width;
    private final int height;
    private final Tile[][] tiles;
    private Item[][] items;
    private char[][] mapSigns;

    public Map(int width, int height, Tile[][] tiles, Item[][] items, char[][] mapShowing) {
        this.width = width;
        this.height = height;
        this.tiles = tiles;
        this.items = items;
        this.mapSigns = mapShowing;
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

    public char[][] getMapSigns() {
        return mapSigns;
    }

    public void setMapShowInPosition(Position position, char sign) {
        this.mapSigns[position.x][position.y] = sign;
    }
}
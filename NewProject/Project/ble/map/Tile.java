package model.map;

public enum Tile {
    VerticalWall(false, false, false, '|'),
    HorizontalWall(false, false, false, '_'),
    Door(true, false, false, '/'),
    Street(true, false, false, '#'),
    PlowedTile(true, false, false, '▫'),
    UnPlowedTile(true, false, false, '▪'),
    Grass(false, false, false, '@'),
    Lake(true, true, false, '0'),
    Building(true, false, false, ' ');

    public final boolean walkable;
    public final boolean fishable;
    public final boolean chopable;
    public final char sign;

    Tile(boolean walkable, boolean fishable, boolean chopable, char sign) {
        this.walkable = walkable;
        this.fishable = fishable;
        this.chopable = chopable;
        this.sign = sign;
    }
}

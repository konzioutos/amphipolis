package model.Tiles;

public abstract class StatueTile extends FindingTile {

    private StatueType type;

    public StatueTile(StatueType type) {
        super(FindingTileCategory.STATUE);
        this.type = type;
    }

    public StatueType getType() {
        return type;
    }
}

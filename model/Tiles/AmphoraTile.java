package model.Tiles;

public class AmphoraTile extends FindingTile {

    private AmphoraColor color;
    /**
     * Constructor
    */
    public AmphoraTile(AmphoraColor color, String amphoraImageSrc) {
        super(FindingTileCategory.AMPHORA);
        super.setTileImageSrc(amphoraImageSrc);
        this.color = color;
    }

    public AmphoraColor getColor() {
        return color;
    }
}

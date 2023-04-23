package model.Tiles;

public class MosaicTile extends FindingTile {

    private MosaicColor color;
    
    /**
     * Constructor
    */
    
    public MosaicTile(MosaicColor color, String mosaicImageSrc) {
        super(FindingTileCategory.MOSAIC);
        super.setTileImageSrc(mosaicImageSrc);
        this.color = color;
    }
    /**
     * Accessor
     * pairnei ta xrwmata
    */
    public MosaicColor getColor() {
        return color;
    }
}

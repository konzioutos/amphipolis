package model.Tiles;

public class SkeletonTile extends FindingTile {

    // to idos tou skeletou (iparxoun 4 diaforetika idi skeletou)
    private SkeletonType type;

    /**
     * Constructor
    */
    
    public SkeletonTile(SkeletonType type, String skeletonImageSrc) {
        super(FindingTileCategory.SKELETON);
        super.setTileImageSrc(skeletonImageSrc);
        this.type = type;
    }
    
    /**
     * Accessor
     * pairnei tupous
    */
    
    public SkeletonType getType() {
        return type;
    }
}

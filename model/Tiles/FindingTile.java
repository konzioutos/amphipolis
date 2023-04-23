package model.Tiles;

/**
 * auti i klasi montelopoiei ta plakidia eurimatos tou paixnidou
 * ta plakidia auta benoun se diaforetikes perioxes analaoga me ton tipo tous
 */
public abstract class FindingTile extends Tile {

    private FindingTileCategory findingTileCategory;

    /**
     * o constructor gia ti dimiourgia enos FindingTile den kathorizei akoma ti fotografia
     * @param findingTileCategory mporei na parei tis times AMPHORA, STATUE, MOSAIC i SKELETON
     */
    public FindingTile(FindingTileCategory findingTileCategory) {
        super(TileCategory.FINDING);
        this.findingTileCategory = findingTileCategory;
    }

    public FindingTileCategory getFindingTileCategory() {
        return findingTileCategory;
    }
}

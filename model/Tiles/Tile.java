package model.Tiles;

public abstract class Tile {

    // mas enimeronei an to plakidio einai eurimatos i katolisthisis
    private TileCategory tileCategory;

    private String tileImageSrc;

    /**
     * constructor
     * auton ton constructor ton xrisimopoioume sta findind tiles opou i fotografia kathorizete poio katw stin ierarxia
     * @param tileCategory
     */
    public Tile(TileCategory tileCategory) {
        this.tileCategory = tileCategory;
    }

    /**
     * constructor
     * autos o constructor xrisimopoieite gia tin arxikopoiisi twn Landsliede plakidion
     * @param tileCategory
     * @param tileImageSrc
     */
    public Tile(TileCategory tileCategory, String tileImageSrc) {
        this.tileCategory = tileCategory;
        this.tileImageSrc = tileImageSrc;
    }
    /**
     * Accessor
     * pairnei th kathgoria twn plakidiwn
    */
    public TileCategory getTileCategory() {
        return tileCategory;
    }
    /**
     * Accessor
     * pairnei thn eikona
    */
    public String getTileImageSrc() {
        return tileImageSrc;
    }

    /**
     * Transformer
     * auti ti methodo tin xrisimopoioume gia na dosoume tin eikona tou plakidiou me tin klisi tou constructor ton ipoklaseon
     * mias pou stin ierarxia mesolavoune kalseis pou einai abstract kai kata sinepeia den einai iparkta plakidia
     * @param tileImageSrc
     */
    public void setTileImageSrc(String tileImageSrc) {
        this.tileImageSrc = tileImageSrc;
    }
}

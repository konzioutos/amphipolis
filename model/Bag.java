package model;

import model.Tiles.FindingTile;
import model.Tiles.FindingTileCategory;
import model.Tiles.Tile;
import model.Tiles.TileCategory;


import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Bag {

    private ArrayList<Tile> bagTiles;

    public Bag(ArrayList<Tile> bagTiles) {
        this.bagTiles = bagTiles;
    }

    /**
     * Accessor
     * epistrefei tixea ena plakidio opoia exei afereesi apo ti lista
     * to plakidio mporei na einai opoiadipote tipou
     *
     * postecondition: epistrefei 1 tixeo plakidia
     *
     * @return ena tixeo plakidio apo ti lista (gia xrisi mesa sto paixnidi)
     */
    public Tile getRandomTile() {

        int randomIndex = ThreadLocalRandom.current().nextInt(0, bagTiles.size());

        // to plakidio aferite apo ti sakoula
        return bagTiles.remove(randomIndex);
    }

    /**
     * Accessor
     * Epistrefei ena plakidio Amphorea gia tin topothetisi sto tablo kata tin arxikopoiisi tou
     *
     * postcondition: ena tixaio plakidio amphorea
     *
     * @return ena tixaio plakidio Amphorea
     */
    public Tile getFistAmphoraTile() {

        while (true) {
            // dimiourgoume enan tixeo arithmo
            int randomIndex = ThreadLocalRandom.current().nextInt(0, bagTiles.size());

            // pernoume to plakidio pou antistixei se auton
            Tile mTile = bagTiles.get(randomIndex);

            // an einai tou tipou pou theloume to epistrefoume, diaforetika ksanaprospathoume
            if(mTile.getTileCategory().equals(TileCategory.FINDING)) {
                FindingTile mFindingTile = (FindingTile) mTile;

                if(mFindingTile.getFindingTileCategory().equals(FindingTileCategory.AMPHORA)) {
                    return bagTiles.remove(randomIndex);
                }
            }
        }
    }

    /**
     * Accessor
     * Epistrefei ena plakidio Mosaic gia tin topothetisi sto tablo kata tin arxikopoiisi tou
     *
     * postcondition: ena tixaio plakidio mosaikou
     *
     * @return ena tixaio plakidio Mosaic
     */
    public Tile getFirstMosaicTile() {

        while (true) {
            // dimiourgoume enan tixeo arithmo
            int randomIndex = ThreadLocalRandom.current().nextInt(0, bagTiles.size());

            // pernoume to plakidio pou antistixei se auton
            Tile mTile = bagTiles.get(randomIndex);

            // an einai tou tipou pou theloume to epistrefoume, diaforetika ksanaprospathoume
            if(mTile.getTileCategory().equals(TileCategory.FINDING)) {
                FindingTile mFindingTile = (FindingTile) mTile;

                if(mFindingTile.getFindingTileCategory().equals(FindingTileCategory.MOSAIC)) {
                    return bagTiles.remove(randomIndex);
                }
            }
        }
    }

    /**
     * Accessor
     * Epistrefei ena plakidio Statue gia tin topothetisi sto tablo kata tin arxikopoiisi tou
     *
     * postcondition: ena tixaio plakidio agalmatos
     *
     * @return ena tixaio plakidio Statue
     */
    public Tile getFirstStatueTile() {

        while (true) {
            // dimiourgoume enan tixeo arithmo
            int randomIndex = ThreadLocalRandom.current().nextInt(0, bagTiles.size());

            // pernoume to plakidio pou antistixei se auton
            Tile mTile = bagTiles.get(randomIndex);

            // an einai tou tipou pou theloume to epistrefoume, diaforetika ksanaprospathoume
            if(mTile.getTileCategory().equals(TileCategory.FINDING)) {
                FindingTile mFindingTile = (FindingTile) mTile;

                if(mFindingTile.getFindingTileCategory().equals(FindingTileCategory.STATUE)) {
                    return bagTiles.remove(randomIndex);
                }
            }
        }
    }

    /**
     * Accessor
     * Epistrefei ena plakidio Skeleton gia tin topothetisi sto tablo kata tin arxikopoiisi tou
     *
     * postcondition: ena tixaio plakidio skeletou
     *
     * @return ena tixaio plakidio Skeeleton
     */
    public Tile getFirstSkeletonTile() {

        while (true) {
            // dimiourgoume enan tixeo arithmo
            int randomIndex = ThreadLocalRandom.current().nextInt(0, bagTiles.size());

            // pernoume to plakidio pou antistixei se auton
            Tile mTile = bagTiles.get(randomIndex);

            // an einai tou tipou pou theloume to epistrefoume, diaforetika ksanaprospathoume
            if(mTile.getTileCategory().equals(TileCategory.FINDING)) {
                FindingTile mFindingTile = (FindingTile) mTile;

                if(mFindingTile.getFindingTileCategory().equals(FindingTileCategory.SKELETON)) {
                    return bagTiles.remove(randomIndex);
                }
            }
        }
    }
}

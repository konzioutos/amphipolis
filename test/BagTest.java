package test;

import model.Bag;
import model.Board;
import model.Tiles.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class BagTest {

    private Board mBoard;
    private Bag mBag;

    @Test
    public void getFistAmphoraTile() {

        // arxikopoio tin sakoula me ta plakidia
        mBoard  = new Board();
        mBoard.initGameTiles();
        mBag = new Bag(mBoard.getAllGameTiles());

        // elegxw an oles tis fores i sinartisi tha dwsei plakidio tipou amphora
        for(int i=0; i<10; i++) {
            AmphoraTile mAmphora =  (AmphoraTile) mBag.getFistAmphoraTile();
            assertEquals(FindingTileCategory.AMPHORA, mAmphora.getFindingTileCategory());
        }

    }

    @Test
    public void getFirstMosaicTile() {

        // arxikopoio tin sakoula me ta plakidia
        mBoard  = new Board();
        mBoard.initGameTiles();
        mBag = new Bag(mBoard.getAllGameTiles());

        // elegxw an oles tis fores i sinartisi tha dwsei plakidio tipou mosaikou
        for(int i=0; i<10; i++) {
            MosaicTile mMosaicTile =  (MosaicTile) mBag.getFirstMosaicTile();
            assertEquals(FindingTileCategory.MOSAIC, mMosaicTile.getFindingTileCategory());
        }
    }

    @Test
    public void getFirstStatueTile() {

        // arxikopoio tin sakoula me ta plakidia
        mBoard  = new Board();
        mBoard.initGameTiles();
        mBag = new Bag(mBoard.getAllGameTiles());

        // elegxw an oles tis fores i sinartisi tha dwsei plakidio tipou agalmatos
        for(int i=0; i<10; i++) {
            StatueTile mStatueTile =  (StatueTile) mBag.getFirstStatueTile();
            assertEquals(FindingTileCategory.STATUE, mStatueTile.getFindingTileCategory());
        }
    }

    @Test
    public void getFirstSkeletonTile() {

        // arxikopoio tin sakoula me ta plakidia
        mBoard  = new Board();
        mBoard.initGameTiles();
        mBag = new Bag(mBoard.getAllGameTiles());

        // elegxw an oles tis fores i sinartisi tha dwsei plakidio tipou agalmatos
        for(int i=0; i<10; i++) {
            SkeletonTile mSkeletonTile =  (SkeletonTile) mBag.getFirstSkeletonTile();
            assertEquals(FindingTileCategory.SKELETON, mSkeletonTile.getFindingTileCategory());
        }
    }
}
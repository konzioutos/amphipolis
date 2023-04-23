package test;

import model.Board;
import model.Tiles.*;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BoardTest {

    private Board mBoard  = new Board();

    @Test
    public void initGameTiles() {

        mBoard.initGameTiles();

        // expected number of tiles
        int mosaicNumExp = 27;
        int skeletonNumExp = 30;
        int landslideNumExp = 24;
        int statueNumExp = 24;
        int amphoraNumExp = 30;

        int mosaicNum = 0;
        int skeletonNum = 0;
        int landslideNum = 0;
        int statueNum = 0;
        int amphoraNum = 0;

        for(Tile mTile : mBoard.getAllGameTiles()) {

            if(mTile.getTileCategory().equals(TileCategory.LANDSLIDE)) {
                landslideNum++;
            }
            else {
                FindingTile mFindingTile = (FindingTile) mTile;

                if(mFindingTile.getFindingTileCategory().equals(FindingTileCategory.MOSAIC))
                    mosaicNum++;

                if(mFindingTile.getFindingTileCategory().equals(FindingTileCategory.SKELETON))
                    skeletonNum++;

                if(mFindingTile.getFindingTileCategory().equals(FindingTileCategory.STATUE))
                    statueNum++;

                if(mFindingTile.getFindingTileCategory().equals(FindingTileCategory.AMPHORA))
                    amphoraNum++;
            }
        }

        assertEquals(mosaicNumExp,mosaicNum);
        assertEquals(skeletonNumExp,skeletonNum);
        assertEquals(landslideNumExp,landslideNum);
        assertEquals(statueNumExp,statueNum);
        assertEquals(amphoraNumExp,amphoraNum);
    }
}
package test;

import model.Bag;
import model.Board;
import model.Player;
import model.Tiles.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    private Board mBoard;
    private Bag mBag;

    @Test
    public void addTileToEarnedTilesAndGetEarnedTiles() {

        // arxikopoio tin sakoula me ta plakidia
        mBoard  = new Board();
        mBoard.initGameTiles();
        mBag = new Bag(mBoard.getAllGameTiles());

        // topothetoume 4 tixea plakidia sto board
        mBoard.addTileToBoard(mBag.getRandomTile());
        mBoard.addTileToBoard(mBag.getRandomTile());
        mBoard.addTileToBoard(mBag.getRandomTile());
        mBoard.addTileToBoard(mBag.getRandomTile());

        Player mPlayer = new Player(0,"Test Player");

        // travame to prwto plakidio apo to board (den kseroume ti einai)
        Tile mTile = mBoard.getBoardTiles().remove(0);
        mPlayer.addTileToEarnedTiles(mTile);

        // apomenoun 2 plakidia sto board
        assertEquals(3, mBoard.getBoardTiles().size());

        // o player exei logika 1 plakidio
        assertEquals(1,mPlayer.getEarnedTiles().size());

        // elegxoume na doume an einai to idio
        assertEquals(mTile, mPlayer.getEarnedTiles().get(0));

        // aferoume kai allo 1 plakidio apo to board (den xeroume ti einai)
        mTile = mBoard.getBoardTiles().get(0);

        // to pernei o xristis
        mPlayer.addTileToEarnedTiles(mTile);

        // perimenoume to xristi na exei 2 plakidia
        assertEquals(2, mPlayer.getEarnedTiles().size());
    }

    @Test
    public void getStatueScore() {

        Player p1 = new Player(0,"p_1");
        Player p2 = new Player(1,"p_2");
        Player p3 = new Player(2,"p_3");
        Player p4 = new Player(3,"p_4");

        // p1 5 x sphinx and 5 x Caryatid ------------
        for(int i = 0; i<5; i++) {
            SphinxTile mSphinxTile = new SphinxTile("fake_image.png");
            CaryatidTile mCaryatidTile = new CaryatidTile("fake_image.png");

            p1.addTileToEarnedTiles(mSphinxTile);
            p1.addTileToEarnedTiles(mCaryatidTile);
        }
        //--------------------------------------------


        // p2 5 x sphinx and 4 x Caryatid ------------
        for(int i = 0; i<5; i++) {
            SphinxTile mSphinxTile = new SphinxTile("fake_image.png");
            p2.addTileToEarnedTiles(mSphinxTile);
        }

        for(int i = 0; i<4; i++) {
            CaryatidTile mCaryatidTile = new CaryatidTile("fake_image.png");
            p2.addTileToEarnedTiles(mCaryatidTile);
        }
        //--------------------------------------------


        // p2 3 x sphinx and 6 x Caryatid ------------
        for(int i = 0; i<3; i++) {
            SphinxTile mSphinxTile = new SphinxTile("fake_image.png");
            p3.addTileToEarnedTiles(mSphinxTile);
        }

        for(int i = 0; i<6; i++) {
            CaryatidTile mCaryatidTile = new CaryatidTile("fake_image.png");
            p3.addTileToEarnedTiles(mCaryatidTile);
        }
        //--------------------------------------------

        // p4 1 x Sphinx
        for(int i = 0; i<1; i++) {
            SphinxTile mSphinxTile = new SphinxTile("fake_image.png");
            //CaryatidTile mCaryatidTile = new CaryatidTile("fake_image.png");
            p4.addTileToEarnedTiles(mSphinxTile);
            //p4.addTileToEarnedTiles(mCaryatidTile);
        }


        int p1c = p1.getCaryatidNum();
        int p1s = p1.getSphinxNum();

        int p2c = p2.getCaryatidNum();
        int p2s = p2.getSphinxNum();

        int p3c = p3.getCaryatidNum();
        int p3s = p3.getSphinxNum();

        int p4c = p4.getCaryatidNum();
        int p4s = p4.getSphinxNum();


        assertEquals(5,p1s);
        assertEquals(5,p1c);

        assertEquals(5,p2s);
        assertEquals(4,p2c);

        assertEquals(3,p3s);
        assertEquals(6,p3c);

        assertEquals(1,p4s);
        assertEquals(0,p4c);

        assertEquals(9,p1.getStatueScore(p2c,p3c,p4c,p2s,p3s,p4s));
        assertEquals(9,p2.getStatueScore(p1c,p3c,p4c,p1s,p3s,p4s));
        assertEquals(9,p3.getStatueScore(p1c,p2c,p4c,p1s,p2s,p4s));
        assertEquals(0,p4.getStatueScore(p1c,p2c,p3c,p1s,p2s,p3s));
    }

    @Test
    public void getMosaicsScore() {
        Player p1 = new Player(0,"p_1");

        for(int i = 0; i<7; i++) {
            MosaicTile mMosaicTile = new MosaicTile(MosaicColor.RED,"fake_image.png");
            p1.addTileToEarnedTiles(mMosaicTile);
        }

        for(int i = 0; i<11; i++) {
            MosaicTile mMosaicTile = new MosaicTile(MosaicColor.GREEN,"fake_image.png");
            p1.addTileToEarnedTiles(mMosaicTile);
        }

        for(int i = 0; i<3; i++) {
            MosaicTile mMosaicTile = new MosaicTile(MosaicColor.YELLOW,"fake_image.png");
            p1.addTileToEarnedTiles(mMosaicTile);
        }

        // fullGreen = 1, fullRed = 1, fullYellow = 1, restTiles: yellow = 3, green = 3, red = 3
        // 4 + 4 + 4 + (2*2) = 12
        assertEquals(16,p1.getMosaicsScore());
    }

    @Test
    public void getAmphoraScore() {
        Player p1 = new Player(0,"p_1");

        for(int i = 0; i<3; i++) {
            AmphoraTile mAmphoraTile = new AmphoraTile(AmphoraColor.RED,"fake_image.png");
            p1.addTileToEarnedTiles(mAmphoraTile);
        }

        for(int i = 0; i<2; i++) {
            AmphoraTile mAmphoraTile = new AmphoraTile(AmphoraColor.GREEN,"fake_image.png");
            p1.addTileToEarnedTiles(mAmphoraTile);
        }

        for(int i = 0; i<3; i++) {
            AmphoraTile mAmphoraTile = new AmphoraTile(AmphoraColor.BLUE,"fake_image.png");
            p1.addTileToEarnedTiles(mAmphoraTile);
        }

        for(int i = 0; i<1; i++) {
            AmphoraTile mAmphoraTile = new AmphoraTile(AmphoraColor.YELLOW, "fake_image.png");
            p1.addTileToEarnedTiles(mAmphoraTile);
        }

        for(int i = 0; i<2; i++) {
            AmphoraTile mAmphoraTile = new AmphoraTile(AmphoraColor.BROWN,"fake_image.png");
            p1.addTileToEarnedTiles(mAmphoraTile);
        }

        for(int i = 0; i<4; i++) {
            AmphoraTile mAmphoraTile = new AmphoraTile(AmphoraColor.PURPLE,"fake_image.png");
            p1.addTileToEarnedTiles(mAmphoraTile);
        }

        // (1 x 6-ada + 1 x 5-ada + 1 x 3-ada) => score = 11
        assertEquals(11,p1.getAmphoraScore());
    }

    @Test
    public void getSkeletonsScore() {
        Player p1 = new Player(0,"p_1");

        for(int i = 0; i<4; i++) {
            SkeletonTile mSkeletonTile = new SkeletonTile(SkeletonType.SMALL_TOP,"fake.png");
            p1.addTileToEarnedTiles(mSkeletonTile);
        }

        for(int i = 0; i<3; i++) {
            SkeletonTile mSkeletonTile = new SkeletonTile(SkeletonType.SMALL_BOTTOM,"fake.png");
            p1.addTileToEarnedTiles(mSkeletonTile);
        }

        for(int i = 0; i<7; i++) {
            SkeletonTile mSkeletonTile = new SkeletonTile(SkeletonType.BIG_TOP,"fake.png");
            p1.addTileToEarnedTiles(mSkeletonTile);
        }

        for(int i = 0; i<5; i++) {
            SkeletonTile mSkeletonTile = new SkeletonTile(SkeletonType.BIG_BOTTOM,"fake.png");
            p1.addTileToEarnedTiles(mSkeletonTile);
        }

        // 3 small + 5 big = 2 families + 1 enilikas + 1 paidi = (2 * 6) + 1 + 1
        assertEquals(14,p1.getSkeletonsScore());
    }
}
package model;

import model.Cards.*;
import model.Tiles.*;

import java.util.ArrayList;

/**
 * I klasi auti modelopoiei to tablo tou paixnidiou, i lista boardTiles krataei ta plakidia pou vriskonte kathe xroniki stigmi sto tablo.
 * Einai akoma ipeuthini gia tin arxikopoiisi tou paixnidou, arxikopoiei diladi ta plakidia ta opoia metaferonte meta sti klasi [Bag],
 * alla kai tis kartes xaraktiron tis opoies metaferei meta stous paixtes
 */
public class Board {

    // oi kartes tou kathe paixti - xrisi stin arxikopoisis (kati antistixo me to mirasma twn kartwn stous paixes)
    private ArrayList<CharacterCard> cardsForPlayer1;
    private ArrayList<CharacterCard> cardsForPlayer2;
    private ArrayList<CharacterCard> cardsForPlayer3;
    private ArrayList<CharacterCard> cardsForPlayer4;

    // ola ta plakidia tou paixnidou (xrisi stin arxikopoiisi)
    private ArrayList<Tile> allGameTiles;

    // ta plakidia pou vriskonte panw sto tablo
    private ArrayList<Tile> boardTiles;


    public Board() {

        allGameTiles = new ArrayList<Tile>();

        cardsForPlayer1 = new ArrayList<CharacterCard>();
        cardsForPlayer2 = new ArrayList<CharacterCard>();
        cardsForPlayer3 = new ArrayList<CharacterCard>();
        cardsForPlayer4 = new ArrayList<CharacterCard>();

        boardTiles = new ArrayList<Tile>();
    }

    public void initGameCards() {

        Archaeologist archaeologist1 = new Archaeologist("images/archaeologist.png");
        Assistant assistant1 = new Assistant("images/assistant.png");
        Digger digger1 = new Digger("images/digger.png");
        Professor professor1 = new Professor("images/professor.png");

        cardsForPlayer1.add(archaeologist1);
        cardsForPlayer1.add(assistant1);
        cardsForPlayer1.add(digger1);
        cardsForPlayer1.add(professor1);

        Archaeologist archaeologist2 = new Archaeologist("images/archaeologist.png");
        Assistant assistant2 = new Assistant("images/assistant.png");
        Digger digger2 = new Digger("images/digger.png");
        Professor professor2 = new Professor("images/professor.png");

        cardsForPlayer2.add(archaeologist2);
        cardsForPlayer2.add(assistant2);
        cardsForPlayer2.add(digger2);
        cardsForPlayer2.add(professor2);

        Archaeologist archaeologist3 = new Archaeologist("images/archaeologist.png");
        Assistant assistant3 = new Assistant("images/assistant.png");
        Digger digger3 = new Digger("images/digger.png");
        Professor professor3 = new Professor("images/professor.png");

        cardsForPlayer3.add(archaeologist3);
        cardsForPlayer3.add(assistant3);
        cardsForPlayer3.add(digger3);
        cardsForPlayer3.add(professor3);

        Archaeologist archaeologist4 = new Archaeologist("images/archaeologist.png");
        Assistant assistant4 = new Assistant("images/assistant.png");
        Digger digger4 = new Digger("images/digger.png");
        Professor professor4 = new Professor("images/professor.png");

        cardsForPlayer4.add(archaeologist4);
        cardsForPlayer4.add(assistant4);
        cardsForPlayer4.add(digger4);
        cardsForPlayer4.add(professor4);
    }
    public void initGameTiles() {

        initMosaicTiles();

        initStatueTiles();

        initSkeletonTiles();

        initAmphoraTiles();

        initLandslideTiles();
    }
    /**
     * Accessor
     * pairnei tis kartes xaraktirwn 
    */
    public ArrayList<CharacterCard> getPlayer1Cards() {
        return cardsForPlayer1;
    }
    /**
     * Accessor
     * pairnei tis kartes xaraktirwn 
    */
    public ArrayList<CharacterCard> getPlayer2Cards() {
        return cardsForPlayer2;
    }
    /**
     * Accessor
     * pairnei tis kartes xaraktirwn 
    */
    public ArrayList<CharacterCard> getPlayer3Cards() {
        return cardsForPlayer3;
    }
    /**
     * Accessor
     * pairnei tis kartes xaraktirwn 
    */
    public ArrayList<CharacterCard> getPlayer4Cards() {
        return cardsForPlayer4;
    }
    /**
     * Accessor
     * pairnei ola ta plakidia tou paixnidiou
    */
    public ArrayList<Tile> getAllGameTiles() {
        return allGameTiles;
    }
    /**
     * Accessor
     * pairnei ola ta plakidia tou tamplo
    */
    public ArrayList<Tile> getBoardTiles() {
        return boardTiles;
    }
    /**
     * transformer
     * vazei ta plakidia sto tamplo
    */
    public void addTileToBoard(Tile tile) {
        boardTiles.add(tile);
    }

    /**
     * Transformer
     * arxikopoiisi twn amphoreon 5 x 6 (xrwmata) = 30
     */
    private void initAmphoraTiles() {

        int amphoraNumPerColor = 5;

        // blue
        for(int i=0; i<amphoraNumPerColor; i++) {
            AmphoraTile tempTile = new AmphoraTile(AmphoraColor.BLUE,"images/amphora_blue.png");
            allGameTiles.add(tempTile);
        }

        // brown
        for(int i=0; i<amphoraNumPerColor; i++) {
            AmphoraTile tempTile = new AmphoraTile(AmphoraColor.BROWN,"images/amphora_brown.png");
            allGameTiles.add(tempTile);
        }

        // red
        for(int i=0; i<amphoraNumPerColor; i++) {
            AmphoraTile tempTile = new AmphoraTile(AmphoraColor.RED,"images/amphora_red.png");
            allGameTiles.add(tempTile);
        }

        // green
        for(int i=0; i<amphoraNumPerColor; i++) {
            AmphoraTile tempTile = new AmphoraTile(AmphoraColor.GREEN,"images/amphora_green.png");
            allGameTiles.add(tempTile);
        }

        // purple
        for(int i=0; i<amphoraNumPerColor; i++) {
            AmphoraTile tempTile = new AmphoraTile(AmphoraColor.PURPLE,"images/amphora_purple.png");
            allGameTiles.add(tempTile);
        }

        // yellow
        for(int i=0; i<amphoraNumPerColor; i++) {
            AmphoraTile tempTile = new AmphoraTile(AmphoraColor.YELLOW,"images/amphora_yellow.png");
            allGameTiles.add(tempTile);
        }
    }


    /**
     * Transformer
     * arxikopoiisi twn mosaikon 3 x 9 (xrwmata) = 27
     */
    private void initMosaicTiles() {

        int mosaicNumPerColor = 9;

        // green
        for(int i=0; i<mosaicNumPerColor; i++) {
            MosaicTile tempTile = new MosaicTile(MosaicColor.GREEN,"images/mosaic_green.png");
            allGameTiles.add(tempTile);
        }

        // red
        for(int i=0; i<mosaicNumPerColor; i++) {
            MosaicTile tempTile = new MosaicTile(MosaicColor.RED,"images/mosaic_red.png");
            allGameTiles.add(tempTile);
        }

        // yellow
        for(int i=0; i<mosaicNumPerColor; i++) {
            MosaicTile tempTile = new MosaicTile(MosaicColor.YELLOW,"images/mosaic_yellow.png");
            allGameTiles.add(tempTile);
        }
    }

    /**
     * Transformer
     * arxikopoiisi twn agalamaton 2 x 12 (xrwmata) = 24
     */
    private void initStatueTiles() {

        int statuesPerType = 12;

        // kariatides
        for(int i=0; i<statuesPerType; i++) {
            CaryatidTile tempTile = new CaryatidTile("images/caryatid.png");
            allGameTiles.add(tempTile);
        }


        // sfigges
        for(int i=0; i<statuesPerType; i++) {
            SphinxTile tempTile = new SphinxTile("images/sphinx.png");
            allGameTiles.add(tempTile);
        }
    }

    /**
     * Transformer
     * arxikopoiisi twn katolisthiseon 24
     */
    private void initLandslideTiles() {

        for(int i=0; i<24; i++) {
            LandslideTile tempTile = new LandslideTile("images/landslide.png");
            allGameTiles.add(tempTile);
        }
    }

    /**
     * Transformer
     * arxikopoiisi twn skeleton 30 (5 katw meri mikron skeleton, 5 panw mikron + 10 panw megalon + 10 katw megalon)
     */
    private void initSkeletonTiles() {

        int smallSkeletonsPerType = 5;
        int bigSkeletonsPerType = 10;

        // mikroi skeletoi - panw
        for(int i=0; i<smallSkeletonsPerType; i++) {
            SkeletonTile tempTile = new SkeletonTile(SkeletonType.SMALL_TOP, "images/skeleton_small_top.png");
            allGameTiles.add(tempTile);
        }

        // mikroi skeletoi - katw
        for(int i=0; i<smallSkeletonsPerType; i++) {
            SkeletonTile tempTile = new SkeletonTile(SkeletonType.SMALL_BOTTOM, "images/skeleton_small_bottom.png");
            allGameTiles.add(tempTile);
        }

        // megaloi skeletoi - panw
        for(int i=0; i<bigSkeletonsPerType; i++) {
            SkeletonTile tempTile = new SkeletonTile(SkeletonType.BIG_TOP, "images/skeleton_big_top.png");
            allGameTiles.add(tempTile);
        }

        // megaloi skeletoi - katw
        for(int i=0; i<bigSkeletonsPerType; i++) {
            SkeletonTile tempTile = new SkeletonTile(SkeletonType.BIG_BOTTOM, "images/skeleton_big_bottom.png");
            allGameTiles.add(tempTile);
        }
    }
}
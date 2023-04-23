package model;

import model.Cards.CharacterCard;
import model.Tiles.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * auti i klasi prosomionei ton paixtis (anthropos) tou paixnidiou
 * krataei tis diathesimes kartes xaraktiron pou exei, ta plakidia pou exei sileksei kapoia trexonta plakidia ktl
 */
public class Player {

    private int gottenTilesForTurn;
    private FindingTileCategory selectedTileAreaForThisTurn;

    // xrisi gia ti katametrisi
    private int playerId;

    private String playerName;

    // ta plakidia pou exei sileksei enas paixtis
    private ArrayList<Tile> earnedTiles;

    // oi kartes xaraktiron kathe paixti
    private ArrayList<CharacterCard> characterCards;

    public Player(int index, String name) {

        this.playerId = index;
        this.playerName = name;

        characterCards = new ArrayList<CharacterCard>();
        earnedTiles = new ArrayList<Tile>();

        // gia ton elegxo ton epitrepton plakidion pou borei na epileksei o xristis
        gottenTilesForTurn = 0;
        selectedTileAreaForThisTurn = null;
    }

    public void addCards(CharacterCard card) {
        this.characterCards.add(card);
    }

    public ArrayList<CharacterCard> getCharacterCards() {

        return characterCards;
    }

    public String getPlayerName() {
        return playerName;
    }

    /**
     * I sinartisi auti prosthetei to komati pou epelekse o paixtis sti lista tou.
     * Paralila voithaei na elegxoume oti den o paixtis tha parei 2 komatia apo tin idia perioxi
     *
     * @param tile to komati pou thelei na parei o xristis
     */
    public void addTileToEarnedTiles(Tile tile) {

        earnedTiles.add(tile);

        gottenTilesForTurn++;

        // apo to komati pou travikse o xristis vriskoume tin perioxi apo tin opoia pire o xristis to komati
        FindingTile mFindingTile = (FindingTile) tile;
        FindingTileCategory currentTileArea = mFindingTile.getFindingTileCategory();

        // orizoume perioxi epilogis xristi gia auto to giro an einai to prwto komati pou travaei
        if(this.selectedTileAreaForThisTurn == null) {
            this.selectedTileAreaForThisTurn = currentTileArea;
        }
    }

    public ArrayList<Tile> getEarnedTiles() {
        return earnedTiles;
    }

    /**
     * Auti i sinartisi einai i sinartisi vasikou elegxou to gia to an borei ena paixtis na traviksei apo mia perioxi i oxi
     *
     * @param currentTileArea i perioxi apo tin opoia prospathei na traviksei plakidio
     * @return true an borei o paiktis na parei to plakidio, false diaforetika
     */
    public boolean isPossibleToGetThisTile(FindingTileCategory currentTileArea) {

        // o paixtis den exei traviksei komati apo alli perioxi (einai to proto komati pou pernei o paixtis)
        if(this.selectedTileAreaForThisTurn == null) {
            return true;
        }
        else {
            if(gottenTilesForTurn < 2 && selectedTileAreaForThisTurn == currentTileArea) {
                return true;
            }
            else {
                return false;
            }
        }
    }


    /**
     * Ti sinartisi auti prepei na ti kaloume kathe fora pou teliwnei o giros enos paixti
     */
    public void preparePlayerToStartHisTurn() {
        gottenTilesForTurn = 0;
        selectedTileAreaForThisTurn = null;
    }

    /**
     * Auti i sinartisi ipologizei to score pou exei o paixtis apo tin katametrisi twn amphoreon pou exei kerdisei.
     * Kalite mazi me tis ipolipes sinartiseis ipologismou tou score sto telos tou paixnidiou
     *
     * @return to score apo ti katametrisi ton amphoreon
     */
    // douleuei swsta - des test gia ton player
    public int getAmphoraScore() {

        int numRed = 0;
        int numGreen = 0;
        int numYellow = 0;
        int numBlue = 0;
        int numBrown = 0;
        int numPurple = 0;

        int collections6 = 0;
        int collections5 = 0;
        int collections4 = 0;
        int collections3 = 0;

        for(Tile curTile : earnedTiles) {
            FindingTile mFindingTile = (FindingTile) curTile;

            if(mFindingTile.getFindingTileCategory().equals(FindingTileCategory.AMPHORA)) {
                // we found an Amphora tile
                AmphoraTile mAmphoraTile = (AmphoraTile) mFindingTile;

                if(mAmphoraTile.getColor().equals(AmphoraColor.RED)) {
                    // we found a red amphora
                    numRed++;
                }

                if(mAmphoraTile.getColor().equals(AmphoraColor.GREEN)) {
                    // we found a green amphora
                    numGreen++;
                }

                if(mAmphoraTile.getColor().equals(AmphoraColor.YELLOW)) {
                    // we found a yellow amphora
                    numYellow++;
                }

                if(mAmphoraTile.getColor().equals(AmphoraColor.BLUE)) {
                    // we found a blue amphora
                    numBlue++;
                }

                if(mAmphoraTile.getColor().equals(AmphoraColor.BROWN)) {
                    // we found a blue amphora
                    numBrown++;
                }

                if(mAmphoraTile.getColor().equals(AmphoraColor.PURPLE)) {
                    // we found a blue amphora
                    numPurple++;
                }
            }
        }

        int[] amphoraNumPerColor = {numRed, numGreen, numYellow, numBlue, numBrown, numPurple};

        int collectedAmphora;

        // to 5 to epelexa giati tha exoume to poli 5 epanalipseis
        for(int i=0;i<5;i++) {

            collectedAmphora = 0;

            for (int j = 0; j < 6; j++) {

                if (amphoraNumPerColor[j] > 0) {
                    // an iparxei amphora tou sigekrimenou xromatos (den mas miazei poiou) tote proshtese to stin silogi
                    collectedAmphora++;

                    // aferese ton amphorea apo to apothema
                    amphoraNumPerColor[j]--;
                }
            }

            switch (collectedAmphora) {
                case 6:
                    collections6++;
                    break;
                case 5:
                    collections5++;
                    break;
                case 4:
                    collections4++;
                    break;
                case 3:
                    collections3++;
                    break;
            }

        }

        return ((6 * collections6) + (4 * collections5) + (2 * collections4) + (1 * collections3));
    }

    /**
     * Auti i sinartisi ipologizei to score pou exei o paixtis apo tin katametrisi twn skeleton pou exei kerdisei.
     * Kalite mazi me tis ipolipes sinartiseis ipologismou tou score sto telos tou paixnidiou
     *
     * @return to score apo ti katametrisi ton skeleton
     */
    // checked kai douleuei - des ta test tou Player
    public int getSkeletonsScore() {

        int bigTop = 0;
        int bigBottom = 0;
        int smallTop = 0;
        int smallBottom = 0;


        for(Tile curTile : earnedTiles) {
            FindingTile mFindingTile = (FindingTile) curTile;

            if (mFindingTile.getFindingTileCategory().equals(FindingTileCategory.SKELETON)) {
                // we found an Skeleton tile
                SkeletonTile mSkeletonTile = (SkeletonTile) mFindingTile;

                if (mSkeletonTile.getType().equals(SkeletonType.BIG_TOP)) {
                    bigTop++;
                }
                if (mSkeletonTile.getType().equals(SkeletonType.BIG_BOTTOM)) {
                    bigBottom++;
                }
                if (mSkeletonTile.getType().equals(SkeletonType.SMALL_TOP)) {
                    smallTop++;
                }
                if (mSkeletonTile.getType().equals(SkeletonType.SMALL_BOTTOM)) {
                    smallBottom++;
                }
            }
        }

        // ipologizoume tous oloklirous skeletous
        int bigWholeSkeletons = 0;
        int smallWholeSkeletons = 0;

        if(bigTop > bigBottom) {
            bigWholeSkeletons = bigBottom;
        }
        else {
            bigWholeSkeletons = bigTop;
        }

        // meta gia tous mikrous
        if(smallTop > smallBottom) {
            smallWholeSkeletons = smallBottom;
        }
        else {
            smallWholeSkeletons = smallTop;
        }

        // dimiourgoume zeugaria skeleton kai kratame kai an iparxei kappoios skeletos bakouris
        int skeletonCouples =  bigWholeSkeletons / 2;
        int skeletonSingles = bigWholeSkeletons % 2;

        // pithana paidia skeleton gia iothesia (gia eukolia stin anagnosi tou kodika)
        int skeletonChildren = smallWholeSkeletons;

        // dimiourgoume oikogenies skeleton
        int skeletonFamilies = 0;

        int limit = skeletonCouples;
        for(int i=0; i<limit; i++) {

            if(skeletonChildren > 0) {
                // exoume mia nea ikogenia skeleton
                skeletonFamilies++;

                // aferoume ena paidi
                skeletonChildren--;

                // aferoume ena zeugari
                skeletonCouples--;
            }
        }

        return ( (6 * skeletonFamilies) + (2 * skeletonCouples) + skeletonSingles + skeletonChildren);
    }

    /**
     * Auti i sinartisi ipologizei to score pou exei o paixtis apo tin katametrisi twn mosaikon pou exei kerdisei.
     * Kalite mazi me tis ipolipes sinartiseis ipologismou tou score sto telos tou paixnidiou
     *
     * @return to score apo ti katametrisi ton mosaikon
     */
    // douleuei swsta - des test gia ton player
    public int getMosaicsScore() {

        int numRed = 0;
        int numGreen = 0;
        int numYellow = 0;

        for(Tile curTile : earnedTiles) {
            FindingTile mFindingTile = (FindingTile) curTile;

            if(mFindingTile.getFindingTileCategory().equals(FindingTileCategory.MOSAIC)) {
                // we found a mosaic tile
                MosaicTile mMosaicTile = (MosaicTile) mFindingTile;

                if(mMosaicTile.getColor().equals(MosaicColor.RED)) {
                    // we found a red mosaic
                    numRed++;
                }

                if(mMosaicTile.getColor().equals(MosaicColor.GREEN)) {
                    // we found a green mosaic
                    numGreen++;
                }

                if(mMosaicTile.getColor().equals(MosaicColor.YELLOW)) {
                    // we found a yellow mosaic
                    numYellow++;
                }
            }
        }

        //----------------------------------------------
        // ipologismos score mosaikon idou xromatos
        int greenWholeMosaics = numGreen / 4;
        int redWholeMosaics = numRed / 4;
        int yellowWholeMosaics = numYellow / 4;

        int fullMosaicsScore = 4 * (greenWholeMosaics + redWholeMosaics + yellowWholeMosaics);
        //------------------------------------------------


        //------------------------------------------------
        // ipologismos score mosaikon diaforetikou xromatos
        int restGreenMosaicTiles = numGreen % 4;
        int restRedMosaicTiles = numRed % 4;
        int restYellowMosaicTiles = numGreen % 4;

        int allRestMosaicTiles = restGreenMosaicTiles + restRedMosaicTiles + restYellowMosaicTiles;

        int mixedColorWholeMosaics = allRestMosaicTiles / 4;

        int mixedMosaicScore = 2 * mixedColorWholeMosaics;
        //------------------------------------------------


        return (fullMosaicsScore + mixedMosaicScore);
    }

    /**
     * Auti i sinartisi ipologizei ton arithmo ton sfigkon pou exei kerdisei o xristis.
     * xrisimopoieite gia na bei san orisma stis sinartiseis ipologismou tou score ton ipolipon paixton
     *
     * @return ton arithmo ton sfigkon pou exei mazepsei o xristis
     */
    public int getSphinxNum() {
        int sphinxNum = 0;

        for(Tile curTile : earnedTiles) {
            FindingTile mFindingTile = (FindingTile) curTile;

            if(mFindingTile.getFindingTileCategory().equals(FindingTileCategory.STATUE)) {
                // we found a statue tile
                StatueTile mStatueTile = (StatueTile) mFindingTile;

                if(mStatueTile.getType().equals(StatueType.SPHINX)) {
                    // we found a sphinx tile
                    sphinxNum++;
                }
            }
        }

        return sphinxNum;
    }

    /**
     * Auti i sinartisi ipologizei ton arithmo ton kariatidon pou exei kerdisei o xristis.
     * xrisimopoieite gia na bei san orisma stis sinartiseis ipologismou tou score ton ipolipon paixton
     *
     * @return ton arithmo ton kariatidon pou exei mazepsei o xristis
     */
    public int getCaryatidNum() {
        int caryatidNum = 0;

        for(Tile curTile : earnedTiles) {
            FindingTile mFindingTile = (FindingTile) curTile;

            if(mFindingTile.getFindingTileCategory().equals(FindingTileCategory.STATUE)) {
                // we found a statue tile
                StatueTile mStatueTile = (StatueTile) mFindingTile;

                if(mStatueTile.getType().equals(StatueType.CARYATID)) {
                    // we found a sphinx tile
                    caryatidNum++;
                }
            }
        }

        return caryatidNum;
    }

    /**
     * Auti i sinartisi ipologizei to score pou exei o paixtis apo tin katametrisi twn agalmaton pou exei kerdisei.
     * Kalite mazi me tis ipolipes sinartiseis ipologismou tou score sto telos tou paixnidiou
     *
     * @param caryatidNum1 o arithmos twn kariatidon tou allou paixti 1
     * @param sphinxNum1 o arithmos twn sfigkon tou allou paixti 1
     * @param caryatidNum2 o arithmos twn kariatidon tou allou paixti 2
     * @param sphinxNum2 o arithmos twn sfigkon tou allou paixti 2
     * @param caryatidNum3 o arithmos twn kariatidon tou allou paixti 3
     * @param sphinxNum3 o arithmos twn sfigkon tou allou paixti 3
     *
     * @return to score apo ti katametrisi ton agalmaton
     */
    // douleuei swsta - des test gia ton player
    public int getStatueScore(int caryatidNum1, int caryatidNum2, int caryatidNum3,  int sphinxNum1, int sphinxNum2, int sphinxNum3) {

        int sphinxScore = 0;
        int caryatidScore = 0;

        // ipologismos tou arithmou ton kariatidon kai ton sfigkwn tou paixti
        int curPlayerCaryatidNum = this.getCaryatidNum();
        int curPlayerSphinxNum = this.getSphinxNum();

        // to score me vasi tin katataksi
        int rang1Score = 6;
        int rang2Score = 3;
        int rang3Score = 0;

        //-------------------------------------------------
        // ipologismos tou score gia tis sfigkes
        int[] allSphinxScores = {curPlayerSphinxNum, sphinxNum1, sphinxNum2, sphinxNum3};

        // meta to sortarisma to allSphinxScores[0] tha exei to mikrotero arithmo kai to allSphinxScores[3] ton megalitero
        Arrays.sort(allSphinxScores);

        if(curPlayerSphinxNum >= allSphinxScores[3]) {
            // rang1
            sphinxScore = rang1Score;
        }
        else {
            if(curPlayerSphinxNum <= allSphinxScores[0]) {
                // rang3
                sphinxScore = rang3Score;
            }
            else {
                // rang2
                sphinxScore = rang2Score;
            }
        }
        //------------------------------------------------


        //-------------------------------------------------
        // ipologismos tou score gia tis kariatides
        int[] allCaryatidScores = {curPlayerCaryatidNum, caryatidNum1, caryatidNum2, caryatidNum3};

        // meta to sortarisma to allCaryatidScores[0] tha exei to mikrotero arithmo kai to allCaryatidScores[3] ton megalitero
        Arrays.sort(allCaryatidScores);

        if(curPlayerCaryatidNum >= allCaryatidScores[3]) {
            // rang1
            caryatidScore = rang1Score;
        }
        else {
            if(curPlayerCaryatidNum <= allCaryatidScores[0]) {
                // rang3
                caryatidScore = rang3Score;
            }
            else {
                // rang2
                caryatidScore = rang2Score;
            }
        }
        //------------------------------------------------

        // to score apo ta agalmata einai to athrisma ton 2 score
        return (sphinxScore + caryatidScore);
    }
}
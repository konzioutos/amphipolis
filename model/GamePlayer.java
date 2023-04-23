package model;

import model.Tiles.Tile;

import java.util.ArrayList;

/**
 * Auto einai to interface tou kathe paixti tou paixnidiou kathorizei tis litourgies pou prepei na
 * kanei kathe paixtis, to interface auto dimiourgithike oste an sto melon prostethoun paixtes me AI
 * na mproroun na ensomatothoun poli eukola stin efarmogi xwris allage
 */
public interface GamePlayer {

    /**
     * Accessor
     * methodos pou mas dinei to onoma tou paixtei
     *
     * @return to onoma tou paixti
     */
    public String getPlayerName();


    /**
     * Accessor
     * i methodos auti pairnei ta plakidia apo to tin perioxi epilogis tou apo to board
     * kai ta apothikeuei stin lista me ta plakidia tou
     *
     * @param tiles i lista borei na periexei mexri 2 plakidia
     */
    public void getBoardTiles(ArrayList<Tile> tiles);


    /**
     * Transformer
     * i methodos auti epistrefei ta plakidia pou exei o kathe pextis.
     * i katametrisi epilexthike na gineete ston controller anti gia tin klasi tou player
     * me ton tropo auton mporei na ginei ipologismos ton ponton ton agalmaton opou xreiazete
     * sigkrisi tou arithmou ton paixton
     *
     * @return lista me ola ta plakidia pou exei sileksei o paixtis
     */
    public ArrayList<Tile> returnFindingTiles();


    /**
     * transformer
     * paizei mia karta xaraktira apo to xeri kai pairnei ta plakidia pou tou prosferei to paiksimo
     *
     * @param card i karta xaraktira pou epilegei na paixei o paixtis
     */
    public void playCharacter(Character card);
}

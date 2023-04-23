package view;

import model.Cards.CharacterCard;
import model.Tiles.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

public class View extends JFrame {

    private JButton[] playerCards = new JButton[4];

    private JLabel[] mosaicPositions;
    private JLabel[] statuesPositions;
    private JLabel[] amphoraPositions;
    private JLabel[] skeletonsPositions;
    private JLabel[] landslidePositions;

    private JLabel[] playerTilesPositions;

    private view.JLayeredPaneExtension basic_panel;

    private JLayeredPane cardsPane;
    private JLayeredPane buttonsPane;

    private ClassLoader cldr;

    private JButton drawTilesButton;
    private JButton endTurnButton;

    JLabel tile;

    JTextArea infobox;

    /**
     * Accessor
    */
    public JButton[] getPlayerCards() {
        return playerCards;
    }
    /**
     * Accessor
    */
    public JLabel[] getMosaicPositions() {
        return mosaicPositions;
    }
    /**
     * Accessor
    */
    public JLabel[] getStatuesPositions() {
        return statuesPositions;
    }
    /**
     * Accessor
    */
    public JLabel[] getAmphoraPositions() {
        return amphoraPositions;
    }
    /**
     * Accessor
    */
    public JLabel[] getSkeletonsPositions() {
        return skeletonsPositions;
    }
    /**
     * Transformer
     * arxikopoihsh kartwn grafika
    */
    public void initCards(ArrayList<CharacterCard> cards) {
        for (int i = 0; i <= 3; i++) {
            playerCards[i] = new JButton();
            playerCards[i].setName(Integer.toString(i));
            playerCards[i].setBounds(30 + i * 110, 20, 100, 163);
            URL imageURL2 = cldr.getResource(cards.get(i).getImageSrc()); //image
            Image image2 = new ImageIcon(imageURL2).getImage();
            image2 = image2.getScaledInstance(100, 163, Image.SCALE_SMOOTH);
            playerCards[i].setIcon(new ImageIcon(image2));
            cardsPane.add(playerCards[i], 0);
        }
    }
    /**
     * Transformer
     * arxikopoihsh koumpiwn
    */
    public void initMainButtons() {

        drawTilesButton = new JButton("Draw Tiles");
        drawTilesButton.setBounds(40,20,200,80);
        buttonsPane.add(drawTilesButton,1);

        endTurnButton = new JButton("End Turn");
        endTurnButton.setBounds(260,20,200,80);
        buttonsPane.add(endTurnButton);
    }
    /**
     * constructor
    */
    public View() {
        cldr = this.getClass().getClassLoader();
        this.setResizable(false);
        this.setTitle("Amphipolis");
        this.setPreferredSize(new Dimension(1400, 1025));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * Transformer
     * ananewnw to mhnyma
    */
    public void updateInfobox(String message) {
        infobox.setText(message);
        basic_panel.repaint();
    }

    /**
     * Transformer
     *  topothetei pros emfanisi ta kerdismena komatia tou ekastote energou paixti (tou paixti pou einai i seira tou)
    */
    public void addActivePlayerEarnedTiles(ArrayList<Tile> earnedTiles) {

        this.clearPlayerEarnedViewsTiles();

        int earnedTilesIndex = 0;

        for(Tile mTile : earnedTiles) {

            tile = new JLabel();
            URL imageURL = cldr.getResource(mTile.getTileImageSrc()); //image
            Image image = new ImageIcon(imageURL).getImage();
            image = image.getScaledInstance(40,40, Image.SCALE_SMOOTH);
            tile.setIcon(new ImageIcon(image));
            tile.setBounds(0,0,40, 40);

            playerTilesPositions[earnedTilesIndex].add(tile,0);
            playerTilesPositions[earnedTilesIndex].setBackground(Color.RED);
            earnedTilesIndex++;
        }
        basic_panel.repaint();
    }

    /**
     * Transformer
     *  topothetei ta plakidia sto tamblo
    */
    public void addTilesToBoard(ArrayList<Tile> boardTiles) {

        this.clearAllBoardViewsTiles();

        int mosaicNum = 0;
        int statueNum = 0;
        int skeletonNum = 0;
        int landslideNum = 0;
        int amphoraNum = 0;

        for(Tile mTile : boardTiles) {

            // get finding tiles
            if(mTile.getTileCategory().equals(TileCategory.FINDING)) {
                FindingTile mFindingTile = (FindingTile) mTile;

                // get mosaic tiles
                if(mFindingTile.getFindingTileCategory().equals(FindingTileCategory.MOSAIC)) {

                    MosaicTile mMosaicTile = (MosaicTile) mFindingTile;

                    // create tile visually
                    tile = new JLabel();
                    URL imageURL = cldr.getResource(mMosaicTile.getTileImageSrc()); //image
                    Image image = new ImageIcon(imageURL).getImage();
                    image = image.getScaledInstance(40,40, Image.SCALE_SMOOTH);
                    tile.setIcon(new ImageIcon(image));
                    tile.setBounds(0,0,40, 40);

                    mosaicPositions[mosaicNum].add(tile,0);
                    mosaicPositions[mosaicNum].setBackground(Color.RED);

                    mosaicNum++;
                }

                // get statue tiles
                if(mFindingTile.getFindingTileCategory().equals(FindingTileCategory.STATUE)) {

                    StatueTile mStatueTile = (StatueTile) mFindingTile;

                    // create tile visually
                    tile = new JLabel();
                    URL imageURL = cldr.getResource(mStatueTile.getTileImageSrc()); //image
                    Image image = new ImageIcon(imageURL).getImage();
                    image = image.getScaledInstance(40,40, Image.SCALE_SMOOTH);
                    tile.setIcon(new ImageIcon(image));
                    tile.setBounds(0,0,40, 40);

                    statuesPositions[statueNum].add(tile,0);
                    statuesPositions[statueNum].setBackground(Color.RED);
                    statueNum++;
                }

                // get amphora tiles
                if(mFindingTile.getFindingTileCategory().equals(FindingTileCategory.AMPHORA)) {

                    AmphoraTile mAmphoraTile = (AmphoraTile) mFindingTile;

                    // create tile visually
                    tile = new JLabel();
                    URL imageURL = cldr.getResource(mAmphoraTile.getTileImageSrc()); //image
                    Image image = new ImageIcon(imageURL).getImage();
                    image = image.getScaledInstance(40,40, Image.SCALE_SMOOTH);
                    tile.setIcon(new ImageIcon(image));
                    tile.setBounds(0,0,40, 40);

                    amphoraPositions[amphoraNum].add(tile,0);
                    amphoraPositions[amphoraNum].setBackground(Color.RED);
                    amphoraNum++;
                }

                // get skeletons tiles
                if(mFindingTile.getFindingTileCategory().equals(FindingTileCategory.SKELETON)) {

                    SkeletonTile mSkeletonTile = (SkeletonTile) mFindingTile;

                    // create tile visually
                    tile = new JLabel();
                    URL imageURL = cldr.getResource(mSkeletonTile.getTileImageSrc()); //image
                    Image image = new ImageIcon(imageURL).getImage();
                    image = image.getScaledInstance(40,40, Image.SCALE_SMOOTH);
                    tile.setIcon(new ImageIcon(image));
                    tile.setBounds(0,0,40, 40);

                    skeletonsPositions[skeletonNum].add(tile,0);
                    skeletonsPositions[skeletonNum].setBackground(Color.RED);
                    skeletonNum++;
                }
            }
            // landslide tiles
            else {
                LandslideTile mLandslideTile = (LandslideTile) mTile;

                // create tile visually
                tile = new JLabel();
                URL imageURL = cldr.getResource(mLandslideTile.getTileImageSrc()); //image
                Image image = new ImageIcon(imageURL).getImage();
                image = image.getScaledInstance(40,40, Image.SCALE_SMOOTH);
                tile.setIcon(new ImageIcon(image));
                tile.setBounds(0,0,40, 40);

                landslidePositions[landslideNum].add(tile,0);
                landslidePositions[landslideNum].setBackground(Color.RED);
                landslideNum++;
            }
        }

        basic_panel.repaint();
    }
    
    /**
     * Transformer
    */
    public void addDrawTilesListener(ActionListener listenDrawTilesButton) {

        drawTilesButton.addActionListener(listenDrawTilesButton);
    }
    /**
     * Transformer
    */
    public void addEndTurnListener(ActionListener listenerEndTurnButton) {

        endTurnButton.addActionListener(listenerEndTurnButton);
    }
    
    /**
     * Transformer
     *  arxikopoiei ta components grafika
    */

    public void initComponents(ArrayList<CharacterCard> cards, ArrayList<Tile> boardTiles) {

        URL imageURL = cldr.getResource("images/background.png");
        Image image = new ImageIcon(imageURL).getImage();
        image = image.getScaledInstance(900,900, Image.SCALE_SMOOTH);
        basic_panel = new view.JLayeredPaneExtension(image);

        cardsPane = new JLayeredPane();
        cardsPane.setBounds(900, 200, 600, 203);
        cardsPane.setBackground(Color.WHITE);
        cardsPane.setOpaque(true);

        // dimiourgei optika tis kartes tou paixti
        this.initCards(cards);

        // buttons pane
        buttonsPane = new JLayeredPane();
        buttonsPane.setBounds(900,600,600,120);
        buttonsPane.setBackground(Color.WHITE);
        buttonsPane.setOpaque(true);
        this.initMainButtons();

        infobox = new JTextArea();
        infobox.setBounds(900, 100, 600, 50);
        infobox.setBackground(Color.WHITE);
        infobox.setOpaque(true);
        //infobox.setText("Choose any Card!");

        // mosaics tiles positions
        mosaicPositions = new JLabel[20];

        for (int i = 0; i <= 19; i++) {

            mosaicPositions[i] = new JLabel("" + (i + 1));
            mosaicPositions[i].setBackground(Color.white);

            if (i<=4) {
                mosaicPositions[i].setBounds(38 + i * 50, 30, 40,40);
            }
            if (i>=5 && i<=9) {
                mosaicPositions[i].setBounds(38 + (i-5) * 50, 90, 40, 40);
            }
            if (i>=10 && i<=14) {
                mosaicPositions[i].setBounds(38 + (i-10) * 50, 150, 40, 40);
            }
            if (i>=15 && i<=19) {
                mosaicPositions[i].setBounds(38 + (i-15) * 50, 210, 40, 40);
            }

            mosaicPositions[i].setOpaque(true);
            basic_panel.add(mosaicPositions[i], 0);
        }

        // statues tiles positions
        statuesPositions = new JLabel[20];

        for (int i = 0; i <= 19; i++) {

            statuesPositions[i] = new JLabel("" + (i + 1));
            statuesPositions[i].setBackground(Color.white);

            if (i<=4) {
                statuesPositions[i].setBounds(625 + i * 50, 30, 40,40);
            }
            if (i>=5 && i<=9) {
                statuesPositions[i].setBounds(625 + (i-5) * 50, 90, 40, 40);
            }
            if (i>=10 && i<=14) {
                statuesPositions[i].setBounds(625 + (i-10) * 50, 150, 40, 40);
            }
            if (i>=15 && i<=19) {
                statuesPositions[i].setBounds(625 + (i-15) * 50, 210, 40, 40);
            }

            statuesPositions[i].setOpaque(true);
            basic_panel.add(statuesPositions[i], 0);
        }
        // amphora tiles positions
        amphoraPositions = new JLabel[20];

        for (int i = 0; i <= 19; i++) {

            amphoraPositions[i] = new JLabel("" + (i + 1));
            amphoraPositions[i].setBackground(Color.white);

            if (i<=4) {
                amphoraPositions[i].setBounds(38 + i * 50, 650, 40,40);
            }
            if (i>=5 && i<=9) {
                amphoraPositions[i].setBounds(38 + (i-5) * 50, 710, 40, 40);
            }
            if (i>=10 && i<=14) {
                amphoraPositions[i].setBounds(38 + (i-10) * 50, 770, 40, 40);
            }
            if (i>=15 && i<=19) {
                amphoraPositions[i].setBounds(38 + (i-15) * 50, 830, 40, 40);
            }

            amphoraPositions[i].setOpaque(true);
            basic_panel.add(amphoraPositions[i], 0);
        }

        // skeletons tiles positions
        skeletonsPositions = new JLabel[20];

        for (int i = 0; i <= 19; i++) {

            skeletonsPositions[i] = new JLabel("" + (i + 1));
            skeletonsPositions[i].setBackground(Color.white);

            if (i<=4) {
                skeletonsPositions[i].setBounds(625 + i * 50, 650, 40,40);
            }
            if (i>=5 && i<=9) {
                skeletonsPositions[i].setBounds(625 + (i-5) * 50, 710, 40, 40);
            }
            if (i>=10 && i<=14) {
                skeletonsPositions[i].setBounds(625 + (i-10) * 50, 770, 40, 40);
            }
            if (i>=15 && i<=19) {
                skeletonsPositions[i].setBounds(625 + (i-15) * 50, 830, 40, 40);
            }

            skeletonsPositions[i].setOpaque(true);
            basic_panel.add(skeletonsPositions[i], 0);
        }

        // amphora tiles positions
        landslidePositions = new JLabel[16];

        for (int i = 0; i <= 15; i++) {

            landslidePositions[i] = new JLabel("" + (i + 1));
            landslidePositions[i].setBackground(Color.white);

            if (i<=3) {
                landslidePositions[i].setBounds(355 + i * 50, 410, 40,40);
            }
            if (i>=4 && i<=7) {
                landslidePositions[i].setBounds(355 + (i-4) * 50, 470, 40, 40);
            }
            if (i>=8 && i<=11) {
                landslidePositions[i].setBounds(355 + (i-8) * 50, 530, 40, 40);
            }
            if (i>=12 && i<=15) {
                landslidePositions[i].setBounds(355 + (i-12) * 50, 590, 40, 40);
            }

            landslidePositions[i].setOpaque(true);
            basic_panel.add(landslidePositions[i], 0);
        }

        // player earned tiles positions
        playerTilesPositions = new JLabel[28];

        for (int i = 0; i <= 27; i++) {

            playerTilesPositions[i] = new JLabel("" + (i + 1));
            playerTilesPositions[i].setBackground(Color.white);
            playerTilesPositions[i].setBounds(2 + i * 50, 930, 40,40);
            playerTilesPositions[i].setOpaque(true);
            basic_panel.add(playerTilesPositions[i], 0);
        }

        // add panes to panel
        basic_panel.add(cardsPane, 0);
        basic_panel.add(buttonsPane,0);
        basic_panel.add(infobox, 0);

        // prosthetei ta plakidia sto tablo
        this.addTilesToBoard(boardTiles);


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(basic_panel, GroupLayout.PREFERRED_SIZE, 1430, GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(basic_panel, GroupLayout.PREFERRED_SIZE, 1430, GroupLayout.PREFERRED_SIZE));
        pack();

        basic_panel.repaint();
    }
    
    /**
     * Transformer
     *  katharizei to tamplo
    */
    
    private void clearAllBoardViewsTiles() {

        for(int i = 0; i < mosaicPositions.length; i++) {
            if(mosaicPositions[i] != null && mosaicPositions[i].getBackground().equals(Color.RED)) {
                mosaicPositions[i].remove(0);
                mosaicPositions[i].setBackground(Color.WHITE);
            }
        }

        for(int i = 0; i < statuesPositions.length; i++) {
            if(statuesPositions[i] != null && statuesPositions[i].getBackground().equals(Color.RED)) {
                statuesPositions[i].remove(0);
                statuesPositions[i].setBackground(Color.WHITE);
            }
        }

        for(int i = 0; i < amphoraPositions.length; i++) {
            if(amphoraPositions[i] != null && amphoraPositions[i].getBackground().equals(Color.RED)) {
                amphoraPositions[i].remove(0);
                amphoraPositions[i].setBackground(Color.WHITE);
            }
        }

        for(int i = 0; i < skeletonsPositions.length; i++) {
            if(skeletonsPositions[i] != null && skeletonsPositions[i].getBackground().equals(Color.RED)) {
                skeletonsPositions[i].remove(0);
                skeletonsPositions[i].setBackground(Color.WHITE);
            }
        }
    }

    
    /**
     * Transformer
     * katharizei ta kerdizmena plakidia
    */
    
    private void clearPlayerEarnedViewsTiles() {

        for(int i=0; i<playerTilesPositions.length; i++) {
            if(playerTilesPositions[i] != null && playerTilesPositions[i].getBackground().equals(Color.RED)) {
                playerTilesPositions[i].remove(0);
                playerTilesPositions[i].setBackground(Color.WHITE);
            }
        }
    }
    
    /**
     * Transformer
     *  anavathmizei tis kartes xaraktirwn
    */
    public void updatePlayerCards(ArrayList<CharacterCard> playerCards) {
        initCards(playerCards);
        basic_panel.repaint();
    }
}

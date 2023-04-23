package controller;

import model.Bag;
import model.Board;
import model.Player;
import model.Tiles.FindingTile;
import model.Tiles.FindingTileCategory;
import model.Tiles.Tile;
import model.Tiles.TileCategory;
import view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Controller {

	Board board;
	View view;
	Player players[] = new Player[4];
	Bag bag;
	int activePlayerIndex;

	public void initialize() {

		players[0] = new Player(0, "Player 1");
		players[1] = new Player(1, "Player 2");
		players[2] = new Player(2, "Player 3");
		players[3] = new Player(3, "Player 4");

		board = new Board();
		board.initGameCards();
		board.initGameTiles();

		// ola ta plakidia tou paixnidou benoun sti sakoula
		bag = new Bag(board.getAllGameTiles());

		set4FirstTilesToBoard();

		playersGetTheirCards();

		view = new View();
		view.initComponents(players[0].getCharacterCards(), board.getBoardTiles());
		view.setVisible(true);

		// prwta paizei o players[0], meta o 1, meta o 2, ...
		activePlayerIndex = 0;

		view.updateInfobox("Game started... " + players[activePlayerIndex].getPlayerName() + " is your turn!");

		setListeners();
	}

	public void setListeners() {

		// cards listeners
		for (int i = 0; i < view.getPlayerCards().length; i++) {
			view.getPlayerCards()[i].addMouseListener(new CardListener());
		}

		// finding tiles listeners

		// Mosaic Listeners
		for (int i = 0; i < view.getMosaicPositions().length; i++) {

			view.getMosaicPositions()[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					onMosaicMouseClicked(e);
					System.out.println("......mosaic was clicked");
				}
			});
		}

		// Statue Listeners
		for (int i = 0; i < view.getStatuesPositions().length; i++) {

			view.getStatuesPositions()[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					onStatueMouseClicked(e);
					System.out.println(".......statue was clicked");
				}
			});
		}

		// Amphora Listeners
		for (int i = 0; i < view.getAmphoraPositions().length; i++) {

			view.getAmphoraPositions()[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					onAmphoraMouseClicked(e);
					System.out.println(".......amphora was clicked");
				}
			});
		}

		// Skeleton Listeners
		for (int i = 0; i < view.getSkeletonsPositions().length; i++) {

			view.getSkeletonsPositions()[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					onSkeletonMouseClicked(e);
					System.out.println(".......skeleton was clicked");
				}
			});
		}

		// buttons listeners
		this.view.addDrawTilesListener(new DrawTilesListener());
		this.view.addEndTurnListener(new EndTurnListener());
	}

	/**
	 * END TURN ACTIONS
	 */
	private class EndTurnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (activePlayerIndex == 3) {
				activePlayerIndex = 0;
			} else {
				activePlayerIndex++;
			}

			// load active player tiles to view
			view.addActivePlayerEarnedTiles(players[activePlayerIndex].getEarnedTiles());

			String playerName = players[activePlayerIndex].getPlayerName();

			// prompt active player to play
			int playerEarnedTilesNum = players[activePlayerIndex].getEarnedTiles().size();
			view.updateInfobox(playerName + " is your turn! You earned " + playerEarnedTilesNum + " Tile so far...");

			// midenizei tous metrites gia arithmo komatiwn kai perioxi gia to neo giro
			players[activePlayerIndex].preparePlayerToStartHisTurn();

			// TODO - Test it
			// view.updatePlayerCards(players[activePlayerIndex].getCharacterCards());
		}
	}

	/**
	 * Transformer
	 * DRAW TILES ACTIONS
	 */
	private class DrawTilesListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			view.updateInfobox(players[activePlayerIndex].getPlayerName() + " draw 4 tiles...");

			// prosthetoume ta plakidia apo ti sakoula sto board
			board.addTileToBoard(bag.getRandomTile());
			board.addTileToBoard(bag.getRandomTile());
			board.addTileToBoard(bag.getRandomTile());
			board.addTileToBoard(bag.getRandomTile());

			// ananeonoume to view
			view.addTilesToBoard(board.getBoardTiles());

			if (checkIfGameFinished(board.getBoardTiles()) == true) {

				try {
					int pl0_score = players[0].getSkeletonsScore() + players[0].getAmphoraScore()
							+ players[0].getMosaicsScore()
							+ players[0].getStatueScore(players[1].getCaryatidNum(), players[2].getCaryatidNum(),
									players[3].getCaryatidNum(), players[1].getSphinxNum(), players[2].getSphinxNum(),
									players[3].getSphinxNum());
					int pl1_score = players[1].getSkeletonsScore() + players[1].getAmphoraScore()
							+ players[1].getMosaicsScore()
							+ players[1].getStatueScore(players[0].getCaryatidNum(), players[2].getCaryatidNum(),
									players[3].getCaryatidNum(), players[0].getSphinxNum(), players[2].getSphinxNum(),
									players[3].getSphinxNum());
					int pl2_score = players[2].getSkeletonsScore() + players[2].getAmphoraScore()
							+ players[2].getMosaicsScore()
							+ players[2].getStatueScore(players[1].getCaryatidNum(), players[0].getCaryatidNum(),
									players[3].getCaryatidNum(), players[1].getSphinxNum(), players[0].getSphinxNum(),
									players[3].getSphinxNum());
					int pl3_score = players[3].getSkeletonsScore() + players[3].getAmphoraScore()
							+ players[3].getMosaicsScore()
							+ players[3].getStatueScore(players[1].getCaryatidNum(), players[2].getCaryatidNum(),
									players[0].getCaryatidNum(), players[1].getSphinxNum(), players[2].getSphinxNum(),
									players[0].getSphinxNum());
					
					int winner=-1;
					if (pl0_score > pl1_score && pl0_score > pl2_score && pl0_score > pl3_score) {
						winner=0;
					}
					else if(pl1_score > pl0_score && pl1_score > pl2_score && pl1_score > pl3_score) {
						winner=1;
					}
					else if(pl2_score > pl0_score && pl2_score > pl1_score && pl2_score > pl3_score){
						winner=2;
					}
					else if(pl3_score > pl0_score && pl3_score > pl1_score && pl3_score > pl2_score){
						winner=3;
					}

					JOptionPane.showMessageDialog(view, "Game ended!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
					if(winner!=-1) {
						JOptionPane.showMessageDialog(view, "Winner is player"+winner,"Winner!", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(view,"No Winner","Winner!",JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (NumberFormatException ex) {
					System.out.println(ex);
				}
			}
		}
	}

	/**
	 * Transformer
	 * Mosaic Tile Clicked
	 *
	 * Oles oi energies gia na figei to tile apo to board kai na paei sti katoxi tou
	 * paixti. Kathos kai oles oi energies gia na ginei i apikonisi olwn ton
	 * parapanw sto view
	 *
	 * @param e to event tou mouse click
	 */
	public void onMosaicMouseClicked(MouseEvent e) {

		for (int i = 0; i < view.getMosaicPositions().length; i++) {
			if (e.getSource() == view.getMosaicPositions()[i]) {

				// exoume valei allaksei to xroma twn theseon pou exoun icon se kokkino etsi
				// kseroume pws o paixtis patise
				// to 1o, 2o, 3o, ktl apo ta mosaica
				if (view.getMosaicPositions()[i].getBackground().equals(Color.RED)) {

					if (players[activePlayerIndex].isPossibleToGetThisTile(FindingTileCategory.MOSAIC)) {

						System.out.println("User Get Mosaic Tile...");

						// get mosaic tile
						Tile selectedTile = getFindingTileFromBoard(FindingTileCategory.MOSAIC, i);

						// added to players earned tiles
						players[activePlayerIndex].addTileToEarnedTiles(selectedTile);

						// re display all board tiles
						view.addTilesToBoard(board.getBoardTiles());

						// re display player earned tiles
						view.addActivePlayerEarnedTiles(players[activePlayerIndex].getEarnedTiles());
					}
				}
			}
		}
	}

	/**
	 * Transformer
	 * Statue Tile Clicked
	 *
	 * Oles oi energies gia na figei to tile apo to board kai na paei sti katoxi tou
	 * paixti. Kathos kai oles oi energies gia na ginei i apikonisi olwn ton
	 * parapanw sto view
	 *
	 * @param e to event tou mouse click
	 */
	public void onStatueMouseClicked(MouseEvent e) {

		for (int i = 0; i < view.getStatuesPositions().length; i++) {
			if (e.getSource() == view.getStatuesPositions()[i]) {

				// exoume valei allaksei to xroma twn theseon pou exoun icon se kokkino etsi
				// kseroume pws o paixtis patise
				// to 1o, 2o, 3o, ktl apo ta statue
				if (view.getStatuesPositions()[i].getBackground().equals(Color.RED)) {

					if (players[activePlayerIndex].isPossibleToGetThisTile(FindingTileCategory.STATUE)) {

						System.out.println("User Get STATUE Tile...");

						// get statue tile
						Tile selectedTile = getFindingTileFromBoard(FindingTileCategory.STATUE, i);

						// added to players earned tiles
						players[activePlayerIndex].addTileToEarnedTiles(selectedTile);

						// re display all board tiles
						view.addTilesToBoard(board.getBoardTiles());

						// re display player earned tiles
						view.addActivePlayerEarnedTiles(players[activePlayerIndex].getEarnedTiles());
					}
				}
			}
		}
	}

	/**
	 * Transformer
	 * Skeleton Tile Clicked
	 *
	 * Oles oi energies gia na figei to tile apo to board kai na paei sti katoxi tou
	 * paixti. Kathos kai oles oi energies gia na ginei i apikonisi olwn ton
	 * parapanw sto view
	 *
	 * @param e to event tou mouse click
	 */
	public void onSkeletonMouseClicked(MouseEvent e) {

		for (int i = 0; i < view.getSkeletonsPositions().length; i++) {
			if (e.getSource() == view.getSkeletonsPositions()[i]) {

				// exoume valei allaksei to xroma twn theseon pou exoun icon se kokkino etsi
				// kseroume pws o paixtis patise
				// to 1o, 2o, 3o, ktl apo ta statue
				if (view.getSkeletonsPositions()[i].getBackground().equals(Color.RED)) {

					if (players[activePlayerIndex].isPossibleToGetThisTile(FindingTileCategory.SKELETON)) {

						System.out.println("User Get SKELETON Tile...");

						// get skeleton tile
						Tile selectedTile = getFindingTileFromBoard(FindingTileCategory.SKELETON, i);

						// added to players earned tiles
						players[activePlayerIndex].addTileToEarnedTiles(selectedTile);

						// re display all board tiles
						view.addTilesToBoard(board.getBoardTiles());

						// re display player earned tiles
						view.addActivePlayerEarnedTiles(players[activePlayerIndex].getEarnedTiles());
					}
				}
			}
		}
	}

	/**
	 * Amphora Tile Clicked
	 *
	 * Oles oi energies gia na figei to tile apo to board kai na paei sti katoxi tou
	 * paixti. Kathos kai oles oi energies gia na ginei i apikonisi olwn ton
	 * parapanw sto view
	 *
	 * @param e to event tou mouse click
	 */
	public void onAmphoraMouseClicked(MouseEvent e) {

		for (int i = 0; i < view.getAmphoraPositions().length; i++) {
			if (e.getSource() == view.getAmphoraPositions()[i]) {

				// exoume valei allaksei to xroma twn theseon pou exoun icon se kokkino etsi
				// kseroume pws o paixtis patise
				// to 1o, 2o, 3o, ktl apo ta statue
				if (view.getAmphoraPositions()[i].getBackground().equals(Color.RED)) {

					if (players[activePlayerIndex].isPossibleToGetThisTile(FindingTileCategory.AMPHORA)) {

						System.out.println("User Get AMPHORA Tile...");

						// get statue tile
						Tile selectedTile = getFindingTileFromBoard(FindingTileCategory.AMPHORA, i);

						// added to players earned tiles
						players[activePlayerIndex].addTileToEarnedTiles(selectedTile);

						// re display all board tiles
						view.addTilesToBoard(board.getBoardTiles());

						// re display player earned tiles
						view.addActivePlayerEarnedTiles(players[activePlayerIndex].getEarnedTiles());
					}
				}
			}
		}
	}

	private class CardListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			JButton but = ((JButton) e.getSource());

			System.out.println("card clicked:" + but.getName());

			int cardInPlayerPosition = Integer.parseInt(but.getName());

			if (SwingUtilities.isLeftMouseButton(e)) {

				JOptionPane.showMessageDialog(view, "Card Clicked: " + cardInPlayerPosition, "Card Clicked!",
						JOptionPane.WARNING_MESSAGE);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}

	private void playersGetTheirCards() {
		// o player1 pairnei tis kartes tou
		for (int i = 0; i < 4; i++) {
			players[0].addCards(board.getPlayer1Cards().remove(0));
		}

		// o player2 pairnei tis kartes tou
		for (int i = 0; i < 4; i++) {
			players[1].addCards(board.getPlayer2Cards().remove(0));
		}

		// o player3 pairnei tis kartes tou
		for (int i = 0; i < 4; i++) {
			players[2].addCards(board.getPlayer3Cards().remove(0));
		}

		// o player4 pairnei tis kartes tou
		for (int i = 0; i < 4; i++) {
			players[3].addCards(board.getPlayer4Cards().remove(0));
		}
	}

	private void set4FirstTilesToBoard() {
		// travame apo ti sakoula 1 plakidio apo kathe katigoria kai to topothetoume sto
		// tablo
		board.addTileToBoard(bag.getFistAmphoraTile());
		board.addTileToBoard(bag.getFirstSkeletonTile());
		board.addTileToBoard(bag.getFirstMosaicTile());
		board.addTileToBoard(bag.getFirstStatueTile());
	}

	// douleuei kata oli thn diarkeia
	private boolean checkIfGameFinished(ArrayList<Tile> boardTiles) {

		int freeLandslidesTiles = 16;

		for (Tile curTile : boardTiles) {
			if (curTile.getTileCategory().equals(TileCategory.LANDSLIDE)) {
				freeLandslidesTiles--;
				if (freeLandslidesTiles == 0) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Accessor
	 * I sinartisi auti tha epistrepsei apo to ArrayList tou board to komati pou
	 * epelekse o xristis apo to view. Diladi o o xristis epelekse to 2 komati tou
	 * mosaikou tha paei kai tha to edopisei ti thesi tou sto board kai tha to
	 * epistrepsei
	 *
	 * @param index        i thesi stin opoia vriskete to komati sto tablo
	 * @param tileCategory o tipos tou komatiou pou anazitame
	 *
	 * @return to plakidio pou to board sto opoio vriskete to opoio antistixei se
	 *         auti ti thesi
	 */
	private Tile getFindingTileFromBoard(FindingTileCategory tileCategory, int index) {

		int boardTileIndex = 0; // i thesi ston bordTiles arrayList
		int currentSpecificCategoryTileIndex = 0; // o trexon arithmos tou komatiou sto view

		for (Tile currentTile : this.board.getBoardTiles()) {
			if (currentTile.getTileCategory().equals(TileCategory.FINDING)) {
				FindingTile mFindingTile = (FindingTile) currentTile;

				// vrikame ena komati tis katigorias pou theloume
				if (mFindingTile.getFindingTileCategory().equals(tileCategory)) {

					// an einai to mosaico pou psaxnoume (to epelekse o xristis)
					if (index == currentSpecificCategoryTileIndex) {

						return this.board.getBoardTiles().remove(boardTileIndex);
					} else {
						currentSpecificCategoryTileIndex++;
					}
				}
			}
			boardTileIndex++;
		}
		return null;
	}
}

package model.Cards;

/**
 * I klasi auti prosomeiwnei ti geniki leitourgikotita pou exoun oi kartes me tous xaraktires
 * tou paixti
 */
public abstract class CharacterCard {

    private String imageSrc;

    private boolean isPlayed;
    /**
     * Constructor
    */
    public CharacterCard(String imageSrc) {

        this.isPlayed = false;
        this.imageSrc = imageSrc;
    }

    
    public abstract void playCard();
    
    /**
     * Observer
     * an exei paixtei
    */
    public boolean isPlayed() {
        return isPlayed;
    }

    public String getImageSrc() {
        return imageSrc;
    }
}

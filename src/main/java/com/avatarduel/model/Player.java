package com.avatarduel.model;

import com.avatarduel.exceptions.hand.InsufficientPowerException;
import com.avatarduel.model.card.Attribute;
import com.avatarduel.model.card.Card;
import com.avatarduel.model.card.Element;
import com.avatarduel.model.cards.Deck;
import com.avatarduel.model.cards.HandCards;
import com.avatarduel.model.field.CardField;
import com.avatarduel.util.Constants;

import java.io.IOException;
import java.net.URISyntaxException;

public class Player {
    private String name;
    private int HP;
    private Power powerNow;
    private Power maxPower;
    private Deck deck;
    private HandCards handCards;
    public CardField field;

    public Player(String name) throws IOException, URISyntaxException {
        this.name = name;
        this.HP = Constants.playerInitialHP;
        powerNow = new Power();
        maxPower = new Power();
        deck = new Deck();
        handCards = new HandCards(deck.takes(Constants.playerInitialCard));
        field = new CardField();
    }

    public int getHP() {
        return HP;
    }

    public HandCards getHandCards() {
        return handCards;
    }

    public Deck getDeck() {
        return deck;
    }

    public String getName() {
        return name;
    }
    
    public Power getPowerNow() {
        return powerNow;
    }

    public Power getMaxPower() {
        return maxPower;
    }

    public void setHP(int HP) {
        if (HP <= 0) {
            HP = 0;
        }
        this.HP = HP;
    }

    public void reduceHP(int value) {
        setHP(HP-value);
    }

    public void draw() {
        if (this.getHandCards().size() < Constants.maxCardOnHand) {
            handCards.add(deck.take());
        }
    }

    public Card takeCard(int index) throws InsufficientPowerException {
        Card takenCard = null;
        if (index >= 0 && index < handCards.size()) {
            if (handCards.peek(index) instanceof com.avatarduel.model.card.Land) {
                takenCard = handCards.take(index);
                powerNow.add(takenCard.getElement());
                maxPower.add(takenCard.getElement());
            } else {
                if (powerNow.get(handCards.peek(index).getElement()) >= handCards.peek(index).getAttribute(Attribute.POWER)) {
                    takenCard = handCards.take(index);
                    Element takenCardElement = takenCard.getElement();
                    powerNow.set(takenCardElement, powerNow.get(takenCardElement) - takenCard.getAttribute(Attribute.POWER));
                } else {
                    throw new InsufficientPowerException(handCards.peek(index).getElement());
                }
            }
        }
        return takenCard;
    }

    public void resetPowerNow() {
        powerNow = new Power(maxPower);
    }
}

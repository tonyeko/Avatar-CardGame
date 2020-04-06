package com.avatarduel.model.Field;

import com.avatarduel.model.Card.Card;
import com.avatarduel.model.SummonedCharacter;

public class CharacterField implements Field {
    private SummonedCharacter[] field;

    public CharacterField() {
        field = new SummonedCharacter[8];
    }
    public SummonedCharacter[] getField() { return field; }

    public void placeCard(int index, Card card) {
        if (field[index] == null) {
            field[index] = new SummonedCharacter(card, true);
            // habis placeCard invoke player buat milih mau attack mode atau defense mode dari GUI, kalo mau defense -> panggil summonedCharacter.rotate();
        } // else throw exception (?)
    }

    public Card removeCard(int index) {
        SummonedCharacter result = field[index];
        field[index] = null;
        return result.getCharacter();
    }

    public Card getCard(int index) {
        return field[index].getCharacter();
    }

    public void changeCardPosition(int index) {
        field[index].rotate();
    }
}

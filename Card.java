package csc331proj03;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hector Felix
 */
public class Card {
    // Spades	-->	0
    // Hearts	-->	1
    // Diamonds -->	2
    // Clubs	-->	3

    private int suit;
    private int value;
    private String name;

    public Card(int value, int suit) {
        this.value = value;
        this.suit = suit;
    }
    
    public int getSuit() {
        return this.suit;
    }
    public int getValue() {
        return this.value;
    }
    

    public String toString() {
        String[] ranks = {null, "Ace", "2", "3", "4", "5", "6",
            "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] suits = {"Spades","Hearts","Diamonds","Clubs"};
        String s = ranks[this.value] + " of " + suits[this.suit];
        return s;
    }
}

/* clubs have more value than diamonds, which in
tu/rn has greater value than hearts, and hearts have greater value than spades
*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc331proj03;

/**
 *
 * @author Hector Felix
 */
public class PlayCards {

    public SingleLinkedListQueue player1Hand = new SingleLinkedListQueue();
    public SingleLinkedListQueue player2Hand = new SingleLinkedListQueue();
    public SingleLinkedListQueue player3Hand = new SingleLinkedListQueue();
    public SingleLinkedListQueue player4Hand = new SingleLinkedListQueue();
    public SingleLinkedList deckOfCards = new SingleLinkedList();
    public SingleLinkedList shuffledCards = new SingleLinkedList();

    public SingleLinkedListQueue firstPlayerOut = new SingleLinkedListQueue();
    public SingleLinkedListQueue secondPlayerOut = new SingleLinkedListQueue();
    public SingleLinkedListQueue thirdPlayerOut = new SingleLinkedListQueue();
    public SingleLinkedListQueue winningPlayer = new SingleLinkedListQueue();

    public ArrayList<SingleLinkedListQueue> playerList = new ArrayList<>();

    public void letsPlay() {

        makeDeck();
        shuffleDeck();

        int playersRemaining;
        int roundCount = 1;
        int largest = 0;
        int winnerCount = 0;
        Card hand1Top;
        Card hand2Top;
        Card hand3Top;
        Card hand4Top;

        for (int i = 0; i < 13; i++) {
            player1Hand.insert(shuffledCards.removeFirst().data);
            player2Hand.insert(shuffledCards.removeFirst().data);
            player3Hand.insert(shuffledCards.removeFirst().data);
            player4Hand.insert(shuffledCards.removeFirst().data);
        }

        playerList.add(player1Hand);
        playerList.add(player2Hand);
        playerList.add(player3Hand);
        playerList.add(player4Hand);

        for (int i = 0; i < playerList.getSize(); i++) {

        }

        while (player1Hand.getSize() < 52 && player2Hand.getSize() < 52
                && player3Hand.getSize() < 52 && player4Hand.getSize() < 52 && roundCount < 16) {
//while (player1Hand.getSize() < 52 && player2Hand.getSize() < 52
//                && player3Hand.getSize() < 52 && player4Hand.getSize() < 52) {

            System.out.println("\n~-~-~-~-~-~-~ Round: " + roundCount + " ~-~-~-~-~-~-~-~");
            playersRemaining = 0;

            //Run the game to 15 rounds or until one player has all their cards
            //Find Winner (who has most cards after 15 rounds - or declare tie, who tied, and how many cards did they have)
            if (!player1Hand.isEmpty()) {
                playersRemaining++;
            }
            if (!player2Hand.isEmpty()) {
                playersRemaining++;
            }
            if (!player3Hand.isEmpty()) {
                playersRemaining++;
            }
            if (!player4Hand.isEmpty()) {
                playersRemaining++;
            }

            //System.out.println("Players Remaining: "+playersRemaining);
//            switch (playersRemaining) {
//                case 4:
//                    playHand(player1Hand,player2Hand,player3Hand,player4Hand);
//                    if(player1Hand.isEmpty())
//                        firstPlayerOut = player1Hand;
//                    if(player2Hand.isEmpty())
//                        firstPlayerOut = player1Hand;
//                    if(player3Hand.isEmpty())
//                        firstPlayerOut = player1Hand;
//                    if(player4Hand.isEmpty())
//                        firstPlayerOut = player1Hand;
//                    break;
//                case 3:
//                    if(player1Hand.isEmpty())
//                        playHand(player2Hand,player3Hand,player4Hand);
//                    if(player2Hand.isEmpty())
//                        playHand(player1Hand,player3Hand,player4Hand);
//                    if(player3Hand.isEmpty())
//                        playHand(player1Hand,player2Hand,player4Hand);
//                    if(player4Hand.isEmpty())
//                        playHand(player1Hand,player2Hand,player3Hand);
//                    
//                    playHand(player1Hand,player2Hand,player3Hand);
//                    break;
//                case 2:
//                    if(player1Hand.isEmpty())
//                        
//                    playHand(player1Hand,player2Hand);
//                    break;
//                case 1:
//                    System.out.println("Player Remaining is Winner!");
//                    break;
//                default:
//                    break;
//            }
            if (player1Hand.isEmpty() && !player2Hand.isEmpty() && !player3Hand.isEmpty() && !player4Hand.isEmpty()) {

                hand2Top = (Card) player2Hand.front.data;
                hand3Top = (Card) player3Hand.front.data;
                hand4Top = (Card) player4Hand.front.data;

                Card winningCard = getMaxCard(hand2Top, hand3Top, hand4Top);

                //System.out.println("Player 1 (" + player1Hand.getSize() + " Cards Left): " + player1Hand.peek());
                System.out.println("Player 2 (" + player2Hand.getSize() + " Cards Left): " + player2Hand.peek());
                System.out.println("Player 3 (" + player3Hand.getSize() + " Cards Left): " + player3Hand.peek());
                System.out.println("Player 4 (" + player4Hand.getSize() + " Cards Left): " + player4Hand.peek());

                System.out.println("Winning Card: " + winningCard);

                if (player2Hand.peek().equals(winningCard)) {
                    player2Hand.insert(player2Hand.remove());
                    //player2Hand.insert(player1Hand.remove());
                    player2Hand.insert(player3Hand.remove());
                    player2Hand.insert(player4Hand.remove());
                } else if (player3Hand.peek().equals(winningCard)) {
                    player3Hand.insert(player3Hand.remove());
                    //player3Hand.insert(player1Hand.remove());
                    player3Hand.insert(player2Hand.remove());
                    player3Hand.insert(player4Hand.remove());
                } else if (player4Hand.peek().equals(winningCard)) {
                    player4Hand.insert(player4Hand.remove());
                    //player4Hand.insert(player1Hand.remove());
                    player4Hand.insert(player2Hand.remove());
                    player4Hand.insert(player3Hand.remove());
                }
            }

            if (player2Hand.isEmpty() && !player1Hand.isEmpty() && !player3Hand.isEmpty() && !player4Hand.isEmpty()) {

                hand1Top = (Card) player1Hand.front.data;
                hand3Top = (Card) player3Hand.front.data;
                hand4Top = (Card) player4Hand.front.data;

                Card winningCard = getMaxCard(hand1Top, hand3Top, hand4Top);

                System.out.println("Player 1 (" + player1Hand.getSize() + " Cards Left): " + player1Hand.peek());
                // System.out.println("Player 2 (" + player2Hand.getSize() + " Cards Left): " + player2Hand.peek());
                System.out.println("Player 3 (" + player3Hand.getSize() + " Cards Left): " + player3Hand.peek());
                System.out.println("Player 4 (" + player4Hand.getSize() + " Cards Left): " + player4Hand.peek());

                System.out.println("Winning Card: " + winningCard);

                if (player1Hand.peek().equals(winningCard)) {
                    player1Hand.insert(player1Hand.remove());
                    //player1Hand.insert(player2Hand.remove());
                    player1Hand.insert(player3Hand.remove());
                    player1Hand.insert(player4Hand.remove());
                } else if (player3Hand.peek().equals(winningCard)) {
                    player3Hand.insert(player3Hand.remove());
                    player3Hand.insert(player1Hand.remove());
                    // player3Hand.insert(player2Hand.remove());
                    player3Hand.insert(player4Hand.remove());
                } else if (player4Hand.peek().equals(winningCard)) {
                    player4Hand.insert(player4Hand.remove());
                    player4Hand.insert(player1Hand.remove());
                    //player4Hand.insert(player2Hand.remove());
                    player4Hand.insert(player3Hand.remove());
                }
            }

            if (player3Hand.isEmpty() && !player1Hand.isEmpty() && !player2Hand.isEmpty() && !player4Hand.isEmpty()) {

                hand2Top = (Card) player2Hand.front.data;
                hand1Top = (Card) player1Hand.front.data;
                hand4Top = (Card) player4Hand.front.data;

                Card winningCard = getMaxCard(hand1Top, hand2Top, hand4Top);

                System.out.println("Player 1 (" + player1Hand.getSize() + " Cards Left): " + player1Hand.peek());
                System.out.println("Player 2 (" + player2Hand.getSize() + " Cards Left): " + player2Hand.peek());
                //System.out.println("Player 3 (" + player3Hand.getSize() + " Cards Left): " + player3Hand.peek());
                System.out.println("Player 4 (" + player4Hand.getSize() + " Cards Left): " + player4Hand.peek());
                System.out.println("Winning Card: " + winningCard);

                if (player1Hand.peek().equals(winningCard)) {
                    player1Hand.insert(player1Hand.remove());
                    player1Hand.insert(player2Hand.remove());
                    //player1Hand.insert(player3Hand.remove());
                    player1Hand.insert(player4Hand.remove());
                } else if (player2Hand.peek().equals(winningCard)) {
                    player2Hand.insert(player2Hand.remove());
                    player2Hand.insert(player1Hand.remove());
                    //player2Hand.insert(player3Hand.remove());
                    player2Hand.insert(player4Hand.remove());
                } else if (player4Hand.peek().equals(winningCard)) {
                    player4Hand.insert(player4Hand.remove());
                    player4Hand.insert(player1Hand.remove());
                    player4Hand.insert(player2Hand.remove());
                    //player4Hand.insert(player3Hand.remove());
                }

            }

            if (player4Hand.isEmpty() && !player1Hand.isEmpty() && !player2Hand.isEmpty() && !player3Hand.isEmpty()) {

                hand1Top = (Card) player1Hand.front.data;
                hand2Top = (Card) player2Hand.front.data;
                hand3Top = (Card) player3Hand.front.data;

                Card winningCard = getMaxCard(hand1Top, hand2Top, hand3Top);

                System.out.println("Player 1 (" + player1Hand.getSize() + " Cards Left): " + player1Hand.peek());
                System.out.println("Player 2 (" + player2Hand.getSize() + " Cards Left): " + player2Hand.peek());
                System.out.println("Player 3 (" + player3Hand.getSize() + " Cards Left): " + player3Hand.peek());
                System.out.println("Winning Card: " + winningCard);

                if (player1Hand.peek().equals(winningCard)) {
                    player1Hand.insert(player1Hand.remove());
                    player1Hand.insert(player2Hand.remove());
                    player1Hand.insert(player3Hand.remove());
                    //player1Hand.insert(player4Hand.remove());
                } else if (player2Hand.peek().equals(winningCard)) {
                    player2Hand.insert(player2Hand.remove());
                    player2Hand.insert(player1Hand.remove());
                    player2Hand.insert(player3Hand.remove());
                    //player2Hand.insert(player4Hand.remove());
                } else if (player3Hand.peek().equals(winningCard)) {
                    player3Hand.insert(player3Hand.remove());
                    player3Hand.insert(player1Hand.remove());
                    player3Hand.insert(player2Hand.remove());
                    //player3Hand.insert(player4Hand.remove());
                }

            }

            if (player1Hand.isEmpty() && player2Hand.isEmpty() && !player3Hand.isEmpty() && !player4Hand.isEmpty()) {

                hand3Top = (Card) player3Hand.front.data;
                hand4Top = (Card) player4Hand.front.data;

                Card winningCard = getMaxCard(hand3Top, hand4Top);

                //System.out.println("Player 1 (" + player1Hand.getSize() + " Cards Left): " + player1Hand.peek());
//                System.out.println("Player 2 (" + player2Hand.getSize() + " Cards Left): " + player2Hand.peek());
                System.out.println("Player 3 (" + player3Hand.getSize() + " Cards Left): " + player3Hand.peek());
                System.out.println("Player 4 (" + player4Hand.getSize() + " Cards Left): " + player4Hand.peek());
                System.out.println("Winning Card: " + winningCard);

                if (player3Hand.peek().equals(winningCard)) {
                    player3Hand.insert(player3Hand.remove());
                    //player3Hand.insert(player1Hand.remove());
                    //player3Hand.insert(player2Hand.remove());
                    player3Hand.insert(player4Hand.remove());
                } else if (player4Hand.peek().equals(winningCard)) {
                    player4Hand.insert(player4Hand.remove());
                    //player4Hand.insert(player1Hand.remove());
                    //player4Hand.insert(player2Hand.remove());
                    player4Hand.insert(player3Hand.remove());
                }

            }

            if (player1Hand.isEmpty() && player3Hand.isEmpty() && !player2Hand.isEmpty() && !player4Hand.isEmpty()) {

                hand2Top = (Card) player2Hand.front.data;
                hand4Top = (Card) player4Hand.front.data;

                Card winningCard = getMaxCard(hand2Top, hand4Top);
                System.out.println("Player 2 (" + player2Hand.getSize() + " Cards Left): " + player2Hand.peek());
                System.out.println("Player 4 (" + player4Hand.getSize() + " Cards Left): " + player4Hand.peek());

                System.out.println("Winning Card: " + winningCard);

                if (player2Hand.peek().equals(winningCard)) {
                    player2Hand.insert(player2Hand.remove());
                    player2Hand.insert(player4Hand.remove());
                } else if (player4Hand.peek().equals(winningCard)) {
                    player4Hand.insert(player4Hand.remove());
                    player4Hand.insert(player2Hand.remove());
                }
            }

            if (player1Hand.isEmpty() && player4Hand.isEmpty() && !player2Hand.isEmpty() && !player3Hand.isEmpty()) {

                hand3Top = (Card) player3Hand.front.data;
                hand2Top = (Card) player2Hand.front.data;

                Card winningCard = getMaxCard(hand2Top, hand3Top);

                System.out.println("Player 2 (" + player2Hand.getSize() + " Cards Left): " + player2Hand.peek());
                System.out.println("Player 3 (" + player3Hand.getSize() + " Cards Left): " + player3Hand.peek());

                System.out.println("Winning Card: " + winningCard);

                if (player2Hand.peek().equals(winningCard)) {
                    player2Hand.insert(player2Hand.remove());
                    //player3Hand.insert(player1Hand.remove());
                    //player3Hand.insert(player2Hand.remove());
                    player2Hand.insert(player3Hand.remove());
                } else if (player3Hand.peek().equals(winningCard)) {
                    player3Hand.insert(player3Hand.remove());
                    //player4Hand.insert(player1Hand.remove());
                    //player4Hand.insert(player2Hand.remove());
                    player3Hand.insert(player2Hand.remove());
                }
            }

            if (player2Hand.isEmpty() && player3Hand.isEmpty() && !player1Hand.isEmpty() && !player4Hand.isEmpty()) {

                hand1Top = (Card) player1Hand.front.data;
                hand4Top = (Card) player4Hand.front.data;

                Card winningCard = getMaxCard(hand1Top, hand4Top);

                System.out.println("Player 1 (" + player1Hand.getSize() + " Cards Left): " + player1Hand.peek());
                System.out.println("Player 4 (" + player4Hand.getSize() + " Cards Left): " + player4Hand.peek());

                System.out.println("Winning Card: " + winningCard);

                if (player1Hand.peek().equals(winningCard)) {
                    player1Hand.insert(player1Hand.remove());
                    //player3Hand.insert(player1Hand.remove());
                    //player3Hand.insert(player2Hand.remove());
                    player1Hand.insert(player4Hand.remove());
                } else if (player4Hand.peek().equals(winningCard)) {
                    player4Hand.insert(player4Hand.remove());
                    //player4Hand.insert(player1Hand.remove());
                    //player4Hand.insert(player2Hand.remove());
                    player4Hand.insert(player1Hand.remove());
                }
            }

            if (player2Hand.isEmpty() && player4Hand.isEmpty() && !player1Hand.isEmpty() && !player3Hand.isEmpty()) {

                hand1Top = (Card) player1Hand.front.data;
                hand3Top = (Card) player3Hand.front.data;

                Card winningCard = getMaxCard(hand1Top, hand3Top);
                System.out.println("Player 1 (" + player1Hand.getSize() + " Cards Left): " + player1Hand.peek());
                System.out.println("Player 3 (" + player3Hand.getSize() + " Cards Left): " + player3Hand.peek());

                System.out.println("Winning Card: " + winningCard);

                if (player1Hand.peek().equals(winningCard)) {
                    player1Hand.insert(player1Hand.remove());
                    //player3Hand.insert(player1Hand.remove());
                    //player3Hand.insert(player2Hand.remove());
                    player1Hand.insert(player3Hand.remove());
                } else if (player3Hand.peek().equals(winningCard)) {
                    player3Hand.insert(player3Hand.remove());
                    //player4Hand.insert(player1Hand.remove());
                    //player4Hand.insert(player2Hand.remove());
                    player3Hand.insert(player1Hand.remove());
                }
            }

            if (player3Hand.isEmpty() && player4Hand.isEmpty() && !player1Hand.isEmpty() && !player2Hand.isEmpty()) {

                hand1Top = (Card) player1Hand.front.data;
                hand2Top = (Card) player2Hand.front.data;

                Card winningCard = getMaxCard(hand1Top, hand2Top);

                System.out.println("Player 1 (" + player1Hand.getSize() + " Cards Left): " + player1Hand.peek());
                System.out.println("Player 2 (" + player2Hand.getSize() + " Cards Left): " + player2Hand.peek());

                System.out.println("Winning Card: " + winningCard);

                if (player1Hand.peek().equals(winningCard)) {
                    player1Hand.insert(player1Hand.remove());
                    //player3Hand.insert(player1Hand.remove());
                    //player3Hand.insert(player2Hand.remove());
                    player1Hand.insert(player2Hand.remove());
                } else if (player2Hand.peek().equals(winningCard)) {
                    player2Hand.insert(player2Hand.remove());
                    //player4Hand.insert(player1Hand.remove());
                    //player4Hand.insert(player2Hand.remove());
                    player2Hand.insert(player1Hand.remove());
                }
            }

//            if (!player1Hand.isEmpty() && !player2Hand.isEmpty() && !player3Hand.isEmpty() && !player4Hand.isEmpty()) {
//                playHand(player1Hand,player2Hand,player3Hand,player4Hand);
//            }
            if (!player1Hand.isEmpty() && !player2Hand.isEmpty() && !player3Hand.isEmpty() && !player4Hand.isEmpty()) {

                hand1Top = (Card) player1Hand.front.data;
                hand2Top = (Card) player2Hand.front.data;
                hand3Top = (Card) player3Hand.front.data;
                hand4Top = (Card) player4Hand.front.data;

                //NEED TO HANDLE CASE WHERE USER HAND IS EMPTY - then do not peek or remove
                Card winningCard = getMaxCard(hand1Top, hand2Top, hand3Top, hand4Top);

                System.out.println("Player 1 (" + player1Hand.getSize() + " Cards Left): " + player1Hand.peek());
                System.out.println("Player 2 (" + player2Hand.getSize() + " Cards Left): " + player2Hand.peek());
                System.out.println("Player 3 (" + player3Hand.getSize() + " Cards Left): " + player3Hand.peek());
                System.out.println("Player 4 (" + player4Hand.getSize() + " Cards Left): " + player4Hand.peek());

                System.out.println("Winning Card: " + winningCard);

                if (player1Hand.peek().equals(winningCard)) {
                    player1Hand.insert(player1Hand.remove());
                    player1Hand.insert(player2Hand.remove());
                    player1Hand.insert(player3Hand.remove());
                    player1Hand.insert(player4Hand.remove());
                } else if (player2Hand.peek().equals(winningCard)) {
                    player2Hand.insert(player2Hand.remove());
                    player2Hand.insert(player1Hand.remove());
                    player2Hand.insert(player3Hand.remove());
                    player2Hand.insert(player4Hand.remove());
                } else if (player3Hand.peek().equals(winningCard)) {
                    player3Hand.insert(player3Hand.remove());
                    player3Hand.insert(player1Hand.remove());
                    player3Hand.insert(player2Hand.remove());
                    player3Hand.insert(player4Hand.remove());
                } else if (player4Hand.peek().equals(winningCard)) {
                    player4Hand.insert(player4Hand.remove());
                    player4Hand.insert(player1Hand.remove());
                    player4Hand.insert(player2Hand.remove());
                    player4Hand.insert(player3Hand.remove());
                }
            }
            roundCount++;
            
            System.out.println("\n---Player 1 Hand---");
            player1Hand.printQueue();
            
            System.out.println("---Player 2 Hand---");
            player2Hand.printQueue();
            
            System.out.println("---Player 3 Hand---");
            player3Hand.printQueue();
            
            System.out.println("---Player 4 Hand---");
            player4Hand.printQueue();
        }

        System.out.println("\n~-~-~-~-GAME~-~-OVER~-~-~-~\nPlayer 1 Cards Remaining: " + player1Hand.getSize());
        System.out.println("Player 2 Cards Remaining: " + player2Hand.getSize());
        System.out.println("Player 3 Cards Remaining: " + player3Hand.getSize());
        System.out.println("Player 4 Cards Remaining: " + player4Hand.getSize());

        if (player1Hand.getSize() == 52) {
            System.out.println("\nPlayer 1 is the winner!");
        } else if (player2Hand.getSize() == 52) {
            System.out.println("\nPlayer 2 is the winner!");
        } else if (player3Hand.getSize() == 52) {
            System.out.println("\nPlayer 3 is the winner!");
        } else if (player4Hand.getSize() == 52) {
            System.out.println("\nPlayer 4 is the winner!");
        } else {
            largest = getMax(player1Hand, player2Hand, player3Hand, player4Hand);
            System.out.println();
            //System.out.println("Largest:  "+largest);
            if (player1Hand.getSize() == largest) {
                System.out.println("Player 1 Wins!");
                winnerCount++;
            }
            if (player2Hand.getSize() == largest) {
                System.out.println("Player 2 Wins!");
                winnerCount++;
            }
            if (player3Hand.getSize() == largest) {
                System.out.println("Player 3 Wins!");
                winnerCount++;
            }
            if (player4Hand.getSize() == largest) {
                System.out.println("Player 4 Wins!");
                winnerCount++;
            }
            if (winnerCount > 1) {
                System.out.println("There is a " + winnerCount + "-Way TIE!");
            }
        }
    }

    public void shuffleDeck() {

        while (deckOfCards.getSize() > 0) {
            int index = (int) (Math.random() * deckOfCards.getSize());
            Node deleted = (Node) deckOfCards.removeAfter(index);
            shuffledCards.addLast(deleted.data);
        }
    }

    public void makeDeck() {
        for (int i = 0; i <= 3; i++) {
            for (int j = 1; j < 14; j++) {
                Card card = new Card(j, i);
                deckOfCards.addLast(card);
            }
        }
    }

    public static int getMax(SingleLinkedListQueue a, SingleLinkedListQueue b, SingleLinkedListQueue c, SingleLinkedListQueue d) {
        return Math.max(a.getSize(), Math.max(b.getSize(), Math.max(c.getSize(), d.getSize())));
    }

    public static Card getMaxCard(Card a, Card b, Card c, Card d) {
        Card maxCard = null;

        //System.out.println(maxCard.getValue());
        if (a.getValue() > b.getValue() && a.getValue() > c.getValue() && a.getValue() > d.getValue()) {
            maxCard = a;
        } else if (b.getValue() > a.getValue() && b.getValue() > c.getValue() && b.getValue() > d.getValue()) {
            maxCard = b;
        } else if (c.getValue() > a.getValue() && c.getValue() > b.getValue() && c.getValue() > d.getValue()) {
            maxCard = c;
        } else if (d.getValue() > a.getValue() && d.getValue() > b.getValue() && d.getValue() > c.getValue()) {
            maxCard = d;
        } else if (a.getValue() == b.getValue()) {
            if (a.getSuit() > b.getSuit()) {
                maxCard = a;
            } else {
                maxCard = b;
            }
        } else if (a.getValue() == c.getValue()) {
            if (a.getSuit() > c.getSuit()) {
                maxCard = a;
            } else {
                maxCard = c;
            }
        } else if (a.getValue() == d.getValue()) {
            if (a.getSuit() > d.getSuit()) {
                maxCard = a;
            } else {
                maxCard = d;
            }
        } else if (b.getValue() == c.getValue()) {
            if (b.getSuit() > c.getSuit()) {
                maxCard = b;
            } else {
                maxCard = c;
            }
        } else if (b.getValue() == d.getValue()) {
            if (b.getSuit() > d.getSuit()) {
                maxCard = b;
            } else {
                maxCard = d;
            }
        } else if (c.getValue() == d.getValue()) {
            if (c.getSuit() > d.getSuit()) {
                maxCard = c;
            } else {
                maxCard = d;
            }
        }
        return maxCard;
    }

    public static Card getMaxCard(Card a, Card b, Card c) {
        Card maxCard = null;

        if (a.getValue() > b.getValue() && a.getValue() > c.getValue()) {
            maxCard = a;
        } else if (b.getValue() > a.getValue() && b.getValue() > c.getValue()) {
            maxCard = b;
        } else if (c.getValue() > a.getValue() && c.getValue() > b.getValue()) {
            maxCard = c;
        } else if (a.getValue() == b.getValue()) {
            if (a.getSuit() > b.getSuit()) {
                maxCard = a;
            } else {
                maxCard = b;
            }
        } else if (a.getValue() == c.getValue()) {
            if (a.getSuit() > c.getSuit()) {
                maxCard = a;
            } else {
                maxCard = c;
            }
        } else if (b.getValue() == c.getValue()) {
            if (b.getSuit() > c.getSuit()) {
                maxCard = b;
            } else {
                maxCard = c;
            }
        }
        return maxCard;
    }

    public static Card getMaxCard(Card a, Card b) {
        Card maxCard = null;

        if (a.getValue() > b.getValue()) {
            maxCard = a;
        } else if (b.getValue() > a.getValue()) {
            maxCard = b;
        } else if (a.getValue() == b.getValue()) {
            if (a.getSuit() > b.getSuit()) {
                maxCard = a;
            } else {
                maxCard = b;
            }
        }
        return maxCard;
    }

    public static SingleLinkedListQueue playHand(SingleLinkedListQueue a, SingleLinkedListQueue b, SingleLinkedListQueue c, SingleLinkedListQueue d) {

        //Make recursive call and base case is when one player is knocked out
        Card hand1Top;
        Card hand2Top;
        Card hand3Top;
        Card hand4Top;

        hand1Top = (Card) a.front.data;
        hand2Top = (Card) b.front.data;
        hand3Top = (Card) c.front.data;
        hand4Top = (Card) d.front.data;

        //NEED TO HANDLE CASE WHERE USER HAND IS EMPTY - then do not peek or remove
        Card winningCard = getMaxCard(hand1Top, hand2Top, hand3Top, hand4Top);

        System.out.println("Player 1 (" + a.getSize() + " Cards Left): " + a.peek());
        System.out.println("Player 2 (" + b.getSize() + " Cards Left): " + b.peek());
        System.out.println("Player 3 (" + c.getSize() + " Cards Left): " + c.peek());
        System.out.println("Player 4 (" + d.getSize() + " Cards Left): " + d.peek());

        System.out.println("Winning Card: " + winningCard);

        if (a.peek().equals(winningCard)) {
            a.insert(a.remove());
            a.insert(b.remove());
            a.insert(c.remove());
            a.insert(d.remove());

        } else if (b.peek().equals(winningCard)) {
            b.insert(b.remove());
            b.insert(a.remove());
            b.insert(c.remove());
            b.insert(d.remove());

        } else if (c.peek().equals(winningCard)) {
            c.insert(c.remove());
            c.insert(a.remove());
            c.insert(b.remove());
            c.insert(d.remove());

        } else if (d.peek().equals(winningCard)) {
            d.insert(d.remove());
            d.insert(a.remove());
            d.insert(b.remove());
            d.insert(c.remove());

        }
        return null;
    }

    public static SingleLinkedListQueue playHand(SingleLinkedListQueue a, SingleLinkedListQueue b, SingleLinkedListQueue c) {

        Card hand1Top;
        Card hand2Top;
        Card hand3Top;

        hand1Top = (Card) a.front.data;
        hand2Top = (Card) b.front.data;
        hand3Top = (Card) c.front.data;

        //NEED TO HANDLE CASE WHERE USER HAND IS EMPTY - then do not peek or remove
        Card winningCard = getMaxCard(hand1Top, hand2Top, hand3Top);

        System.out.println("Player 1 (" + a.getSize() + " Cards Left): " + a.peek());
        System.out.println("Player 2 (" + b.getSize() + " Cards Left): " + b.peek());
        System.out.println("Player 3 (" + c.getSize() + " Cards Left): " + c.peek());

        System.out.println("Winning Card: " + winningCard);

        if (a.peek().equals(winningCard)) {
            a.insert(a.remove());
            a.insert(b.remove());
            a.insert(c.remove());
            return a;
        } else if (b.peek().equals(winningCard)) {
            b.insert(b.remove());
            b.insert(a.remove());
            b.insert(c.remove());
            return b;
        } else if (c.peek().equals(winningCard)) {
            c.insert(c.remove());
            c.insert(a.remove());
            c.insert(b.remove());
            return c;
        }
        return null;
    }

    public static SingleLinkedListQueue playHand(SingleLinkedListQueue a, SingleLinkedListQueue b) {

        Card hand1Top;
        Card hand2Top;
        Card hand3Top;

        hand1Top = (Card) a.front.data;
        hand2Top = (Card) b.front.data;

        //NEED TO HANDLE CASE WHERE USER HAND IS EMPTY - then do not peek or remove
        Card winningCard = getMaxCard(hand1Top, hand2Top);

        System.out.println("Player 1 (" + a.getSize() + " Cards Left): " + a.peek());
        System.out.println("Player 2 (" + b.getSize() + " Cards Left): " + b.peek());

        System.out.println("Winning Card: " + winningCard);

        if (a.peek().equals(winningCard)) {
            a.insert(a.remove());
            a.insert(b.remove());
            return a;
        } else if (b.peek().equals(winningCard)) {
            b.insert(b.remove());
            b.insert(a.remove());
            return b;
        }
        return null;
    }
}

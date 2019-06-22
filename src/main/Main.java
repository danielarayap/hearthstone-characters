package main;
import hearthstone.*;

public class Main {

    private static void displayWinner(Card firstCard, Card secondCard){
        System.out.println(firstCard.getName() + " defeated " + secondCard.getName() + ". " + firstCard.getName() +
                " wins!\n");
    }

    private static void displayStatus(Card firstCard, Card secondCard){
        System.out.println(firstCard.getName() + "(" + firstCard.getHealth() + " HP)" + " ---------------vs------------- " +
                secondCard.getName() + "(" + secondCard.getHealth() + " HP)\n");
    }

    private static void displayResult(Card firstCard, Card secondCard){
        displayStatus(firstCard, secondCard);
        if(firstCard.isDead())
            displayWinner(secondCard, firstCard);
        else
            displayWinner(firstCard, secondCard);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("\nThis is a simulation of a battle between HearthStone characters.\n");
        Thread.sleep(1000);
        Card card1 = new Assassin("Lord Jaraxxus", 30, 5);
        Card card2 = new Assassin("Deadscale Knight", 30, 5);
        displayStatus(card1, card2);
        while (true) {
            Thread.sleep(2000);
            if (Math.random() > 0.5) {
                card1.attack(card2);
                if (card2.isDead())
                    break;
                card2.attack(card1);
                if (card1.isDead())
                    break;
            } else {
                card2.attack(card1);
                if (card1.isDead())
                    break;
                card1.attack(card2);
                if (card2.isDead())
                    break;
            }
            Thread.sleep(2000);
            displayStatus(card1, card2);
        }
        displayResult(card1, card2);
    }

}

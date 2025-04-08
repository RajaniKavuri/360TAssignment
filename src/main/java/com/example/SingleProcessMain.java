package com.example;

/**
 * Runs the player communication in a single Java process using threads.
 */
public class SingleProcessMain {
    public static void main(String[] args) {
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");

        player1.setOtherPlayer(player2);
        player2.setOtherPlayer(player1);

        System.out.println("Starting single process communication...");
        player1.sendMessage("Hello from Player1");
    }
}

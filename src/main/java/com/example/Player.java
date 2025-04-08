package com.example;

/**
 * Represents a player in the communication system.
 * Each player can send and receive messages.
 */
public class Player {
    private final String name;
    private Player otherPlayer;
    private int messageCount = 0;
    private static final int MAX_MESSAGES = 10; // Limit to prevent infinite recursion

    public Player(String name) {
        this.name = name;
    }

    public void setOtherPlayer(Player otherPlayer) {
        this.otherPlayer = otherPlayer;
    }

    public void sendMessage(String message) {
        if (messageCount >= MAX_MESSAGES) {
            System.out.println(name + " reached message limit.");
            return;
        }
        System.out.println(name + " sending: " + message);
        messageCount++;

        if (otherPlayer != null) {
            otherPlayer.receiveMessage("Reply " + messageCount);
        }
    }

    public void receiveMessage(String message) {
        System.out.println(name + " received: " + message);
        if (messageCount < MAX_MESSAGES) {
            sendMessage("Reply " + (messageCount + 1));
        }
    }

    public int getMessageCount() {
        return messageCount;
    }
}

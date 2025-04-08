package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PlayerTest {
    @Test
    void testPlayerSendsAndReceivesMessages() {
        Player player1 = new Player("Player1");
        Player player2 = mock(Player.class);  // Mock player2

        player1.setOtherPlayer(player2);
        player1.sendMessage("Hello");

        // Verify player2 received the message
        verify(player2, times(1)).receiveMessage("Reply 1");

        // Verify player1 message count increased
        assertEquals(1, player1.getMessageCount());
    }
}

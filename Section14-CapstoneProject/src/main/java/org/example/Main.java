package org.example;

import org.example.services.GameService;

public class Main {
    public static void main(String[] args) {
        GameService gameService = new GameService();
        gameService.playHangman();
    }
}
package com.java.lld.snakeladder.service;

import com.java.lld.snakeladder.entity.*;

import java.util.List;

public interface GameClient {

    void initGame(int boardSize, List<Snake> snakes, List<Ladder> ladders, List<Player> players);
    int move(String playerId, List<Integer> values);
    int getPlayerCurrentPosition(String playerId);
}

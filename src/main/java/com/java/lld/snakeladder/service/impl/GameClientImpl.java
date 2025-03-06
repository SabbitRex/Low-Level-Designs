package com.java.lld.snakeladder.service.impl;

import com.java.lld.snakeladder.entity.*;
import com.java.lld.snakeladder.service.GameClient;
import com.java.lld.snakeladder.strategy.MStrategy;
import com.java.lld.snakeladder.validation.CellValidation;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Builder
@Getter
@Setter
public class GameClientImpl implements GameClient {

    private Board board;
    private Map<String, Integer> playerPosMap;
    private MStrategy mStrategy;

    @Override
    public void initGame(int boardSize, List<Snake> snakes, List<Ladder> ladders, List<Player> players) {

        this.board = Board.builder()
                .boardSize(boardSize)
                .boardBlocks(boardSize*boardSize)
                .snakePosMap(this.placeSnakeOnBoard(snakes))
                .ladderPosMap(this.placeLadderOnBoard(ladders))
                .build();

        this.initPlayerOnBoard(players);
    }

    @Override
    public int move(String playerId, List<Integer> values) {

        int playerCurrentPos = this.playerPosMap.get(playerId);
        Map<Integer, Integer> ladderPosMap= this.board.getLadderPosMap();
        Map<Integer, Integer> snakePosMap= this.board.getSnakePosMap();

        int valueBasedOnStrategy = this.mStrategy.finalPosFromStrategy(values);
        boolean valid = CellValidation.validateNewPosition(valueBasedOnStrategy + playerCurrentPos);

        if (!valid) {
            System.out.println("Invalid move!");
            return playerCurrentPos;
        }

        int playerNewPos = playerCurrentPos + valueBasedOnStrategy;

        if (ladderPosMap.containsKey(playerNewPos)) {

            this.playerPosMap.put(playerId, ladderPosMap.get(playerNewPos));
            return ladderPosMap.get(playerNewPos);

        } else if (snakePosMap.containsKey(playerNewPos)) {

            this.playerPosMap.put(playerId, snakePosMap.get(playerNewPos));
            return snakePosMap.get(playerNewPos);

        } else {

            for (Map.Entry<String, Integer> entry : this.playerPosMap.entrySet()) {

                String prevPlayerId = entry.getKey();
                int prevPlayerCurrentPos = entry.getValue();

                if (prevPlayerCurrentPos == playerCurrentPos && !Objects.equals(prevPlayerId, playerId)) {

                    this.playerPosMap.put(prevPlayerId, 1);
                    this.playerPosMap.put(playerId, playerNewPos);

                } else {

                    this.playerPosMap.put(playerId, playerNewPos);
                }
            }

            return playerNewPos;
        }
    }

    @Override
    public int getPlayerCurrentPosition(String playerId) {

        return this.playerPosMap.get(playerId);
    }

    private void initPlayerOnBoard(List<Player> players) {

        this.playerPosMap = new HashMap<>();

        for (Player player : players) {
            this.playerPosMap.put(player.getUserId(), 1);
        }
    }

    private Map<Integer, Integer> placeSnakeOnBoard(List<Snake> snakes) {

        Map<Integer, Integer> map = new HashMap<>();

        for (Snake snake : snakes) {

            int head = snake.getHead();
            int tail = snake.getTail();
            map.put(head, tail);
        }

        return map;
    }

    private Map<Integer, Integer> placeLadderOnBoard(List<Ladder> ladders) {

        Map<Integer, Integer> map = new HashMap<>();

        for (Ladder ladder : ladders) {

            int climbFrom = ladder.getClimbFrom();
            int getClimbTo = ladder.getClimbTo();
            map.put(climbFrom, getClimbTo);
        }

        return map;
    }
}

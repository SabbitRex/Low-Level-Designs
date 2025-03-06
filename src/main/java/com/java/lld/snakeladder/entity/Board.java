package com.java.lld.snakeladder.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Builder
@Getter
@Setter
public class Board {

    private int boardSize;
    private int boardBlocks;
    private Map<Integer, Integer> snakePosMap;
    private Map<Integer, Integer> ladderPosMap;
}
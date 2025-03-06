package com.java.lld.snakeladder.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Builder
@Getter
@Setter
public class Game {
    private Board board;
    private Map<String, Integer> playerPosMap;
}

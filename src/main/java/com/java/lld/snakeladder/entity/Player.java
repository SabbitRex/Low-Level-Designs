package com.java.lld.snakeladder.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Player {

    private String userId;
    private int currentBoardPos;
}

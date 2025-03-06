package com.java.lld.snakeladder.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Snake {
    private int head;
    private int tail;
}

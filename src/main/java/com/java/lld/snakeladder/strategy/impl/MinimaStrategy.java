package com.java.lld.snakeladder.strategy.impl;

import com.java.lld.snakeladder.strategy.MStrategy;
import lombok.Builder;

import java.util.List;

@Builder
public class MinimaStrategy implements MStrategy {
    @Override
    public int finalPosFromStrategy(List<Integer> values) {

        int result = Integer.MAX_VALUE;

        for (int value : values) {

            result = Math.min(result, value);
        }

        return result;
    }
}

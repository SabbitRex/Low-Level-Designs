package com.java.lld.snakeladder.strategy.impl;

import com.java.lld.snakeladder.strategy.MStrategy;
import lombok.Builder;

import java.util.List;

@Builder
public class SumStrategy implements MStrategy {

    @Override
    public int finalPosFromStrategy(List<Integer> values) {

        int result = 0;

        for (int value : values) {

            result = result + value;
        }

        return result;
    }
}

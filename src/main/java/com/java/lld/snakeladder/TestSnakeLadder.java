package com.java.lld.snakeladder;

import com.java.lld.snakeladder.entity.Ladder;
import com.java.lld.snakeladder.entity.Player;
import com.java.lld.snakeladder.entity.Snake;
import com.java.lld.snakeladder.service.GameClient;
import com.java.lld.snakeladder.service.impl.GameClientImpl;
import com.java.lld.snakeladder.strategy.MStrategy;
import com.java.lld.snakeladder.strategy.impl.MaximaStrategy;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TestSnakeLadder {

    public static void main(String[] args) throws Exception {

        JSONObject jsonObject = loadJsonObjectFromConfiguration();

        List<Snake> snakes = getSnakesFromInput(jsonObject.getJSONArray("snakes"));
        List<Ladder> ladders = getLaddersFromInput(jsonObject.getJSONArray("ladders"));
        List<Player> players = getPlayersFromInput(jsonObject.getJSONArray("players"));
        int boardSize = jsonObject.optInt("boardSize", 10);
        int diceCount = 3;

        MStrategy strategy = MaximaStrategy.builder().build();
        GameClient gameClient = GameClientImpl.builder().mStrategy(strategy).build();
        gameClient.initGame(boardSize, snakes, ladders, players);

        String winnerId = null;

        int playerCount = players.size();
        int turnsTaken = 0;

        while (true) {

            List<Integer> values = rollDice(diceCount);
            Player player = players.get(turnsTaken);
            String playerId = player.getUserId();
            int playerCurrentPos = gameClient.getPlayerCurrentPosition(playerId);

            int playerNewPos = gameClient.move(playerId, values);

            player.setCurrentBoardPos(playerNewPos);
            players.add(player);

            System.out.printf("%s rolled a %s and moved from %s to %s%n",
                    playerId, "diceRoll", playerCurrentPos, playerNewPos);

            if (playerNewPos == 100) {
                winnerId = playerId;
                break;
            }

            turnsTaken++;

            if (turnsTaken >= playerCount) {
                turnsTaken = 0;
            }
        }

        System.out.println("Winner: " + winnerId);
    }

    private static List<Integer> rollDice(int diceCount) {

        List<Integer> result = new ArrayList<>();

        for (int i=0; i<diceCount; i++) {

            int rollValue = (int) (Math.random() * 6) + 1;
            result.add(rollValue);
        }

        return result;
    }

    private static JSONObject loadJsonObjectFromConfiguration() throws IOException {

        InputStream inputStream = TestSnakeLadder.class.getClassLoader().getResourceAsStream("configuration.json");

        if (inputStream == null) {
            throw new FileNotFoundException("File not found in resources: configuration.json");
        }

        String content = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        return new JSONObject(content);
    }

    private static JSONObject readJsonFromFile(String filePath) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        return new JSONObject(content);
    }

    private static List<Snake> getSnakesFromInput(JSONArray snakesArray) {

        List<Snake> snakes = new ArrayList<>();

        for (int i = 0; i < snakesArray.length(); i++) {
            JSONObject snakeObject = snakesArray.getJSONObject(i);
            Snake snake = Snake.builder().head(snakeObject.getInt("head")).tail(snakeObject.getInt("tail")).build();
            snakes.add(snake);
        }

        return snakes;
    }

    private static List<Ladder> getLaddersFromInput(JSONArray laddersArray) {

        List<Ladder> ladders = new ArrayList<>();

        for (int i = 0; i < laddersArray.length(); i++) {

            JSONObject ladderObject = laddersArray.getJSONObject(i);
            Ladder ladder = Ladder.builder().climbFrom(ladderObject.getInt("bottom")).climbTo(ladderObject.getInt("top")).build();
            ladders.add(ladder);
        }

        return ladders;
    }

    private static List<Player> getPlayersFromInput(JSONArray playersArray) {

        List<Player> players = new ArrayList<>();

        for (int i = 0; i < playersArray.length(); i++) {

            JSONObject playerObject = playersArray.getJSONObject(i);
            Player player = Player.builder().userId(playerObject.getString("name")).currentBoardPos(1).build();
            players.add(player);
        }

        return players;
    }
}
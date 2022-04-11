package com.bridgelabz;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.util.Random;


public class SnakeLadder {
    static Logger logger = Logger.getLogger(SnakeLadder.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();
        final int NO_PLAY = 1;
        final int LADDER = 2;
        final int SNAKE = 3;
        final int WIN_POSITION = 100;

        logger.info("Welcome to Snake and Ladder Simulation");

        int player = 0;
        int[] playerPosition = {0, 0};
        Random random = new Random();
        int dieroll;
        int[] dierollcount = {0, 0};
        while (playerPosition[player] < 100) {
            dieroll = random.nextInt(1, 7);
            dierollcount[player]++;
            int check = random.nextInt(1, 4);

            switch (check) {
                case NO_PLAY:
                    playerPosition[player] += 0;
                    break;
                case LADDER:
                    if ((playerPosition[player] + dieroll) <= 100)
                        playerPosition[player] += dieroll;
                    break;
                case SNAKE:
                    playerPosition[player] -= dieroll;
                    if (playerPosition[player] < 0)
                        playerPosition[player] = 0;
                    break;
            }

            logger.info(" position of player " + (player + 1) + " is at " + playerPosition[player]);
            if ((check == 1 || check == 3) && playerPosition[player] != WIN_POSITION)
                if (player == 0)
                    player = 1;
                else
                    player = 0;

        }
        logger.info("player " + (player + 1) + " won the game and rolled the dice " + dierollcount[player] + " no. of time to reach position 100 ");
    }
}







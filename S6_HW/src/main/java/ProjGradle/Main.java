package ProjGradle;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    //TRIAL is number of iterations.
    private static final int TRIAL = 100;
    //COUNT_DOOR is number of doors for the draw.
    private static final int COUNT_DOOR = 3;

    public static void main(String[] args) {

        //Wins is winning counter.
        int wins = 0;
        //Lose is winning counter when changing door.
        int lose = 0;
        //CarDoor is door with car.
        int carDoor;
        //PlayerChoice is player-selected door.
        int playerChoice;
        //OpenedDoor is door opened by the leader.
        int openedDoor;
        //SwitchDoor is door re-selected by the player after the first move.
        int switchDoor;

        Random rand = new Random();
        Map<Integer, String> result = new HashMap<>();

        for (int i = 1; i <= TRIAL; i++) {
            carDoor = rand.nextInt(COUNT_DOOR);
            System.out.printf("Машина за дверью № %d\n", carDoor);
            playerChoice = rand.nextInt(COUNT_DOOR);
            System.out.printf("Игрок выбрал дверь № %d\n", playerChoice);
            do {
                openedDoor = rand.nextInt(COUNT_DOOR);
                System.out.printf("Я открою дверь № %d\n", openedDoor);
            } while (openedDoor == playerChoice || openedDoor == carDoor);

            do {
                switchDoor = COUNT_DOOR - playerChoice - openedDoor; //выбор оставшейся двери, после того как одну открыли
                System.out.printf("Вы поменяли дверь на %d\n", switchDoor);
            } while (switchDoor == openedDoor);

            if (playerChoice == carDoor) {
                wins++;
                result.put(i, "Победа с первой попытки");
                System.out.printf("Поздравляю, Вы выиграли с первого раза %d\n", playerChoice);
            }

            if (switchDoor == carDoor) {
                lose++;
                result.put(i, "Победа при перевыборе двери");
                System.out.printf("Поздравляю, Вы выиграли поменяв дверь на %d\n", switchDoor);
            }
            System.out.println();
        }

        float resWin = (float) wins / TRIAL * 100;
        float resLose = (float) lose / TRIAL * 100;

        for (Map.Entry<Integer, String> entry : result.entrySet()){
            System.out.println("Попытка: " + entry.getKey() + " - " + entry.getValue());
        }

        System.out.println("Wins " + resWin + " " + wins);
        System.out.println("Lose " + resLose + " " + lose);

    }
}
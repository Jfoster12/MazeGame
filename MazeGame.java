
import java.util.Scanner;
import java.util.Random;

public class MazeGame {
    public static void main(String[] args) {
        char[][][] levels = {
            { // Level 1
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', 'S', ' ', '#', ' ', '#', ' ', ' ', ' ', '#'},
                {'#', ' ', '#', '#', ' ', '#', '#', '#', ' ', '#'},
                {'#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#'},
                {'#', ' ', '#', '#', '#', '#', ' ', '#', ' ', '#'},
                {'#', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', 'E', '#'}
            },
            { // Level 2
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', 'S', ' ', '#', ' ', '#', ' ', ' ', ' ', '#'},
                {'#', ' ', '#', '#', ' ', '#', '#', '#', ' ', '#'},
                {'#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#'},
                {'#', ' ', '#', '#', 'E', '#', ' ', '#', ' ', '#'},
                {'#', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', 'B', '#'}
            },
            { // Level 3
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', 'S', ' ', '#', ' ', '#', ' ', ' ', ' ', '#'},
                {'#', ' ', ' ', '#', ' ', ' ', '#', '#', ' ', '#'},
                {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', ' ', ' ', ' ', ' ', '#', '#', ' ', 'E', '#'},
                {'#', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
            }
        };

        int currentLevel = 0;
        int playerX = 1, playerY = 1;

        int playerHealth = 100;
        int playerAttack = 20;

        int[] enemyX = {4, 7, 4}; // X-coordinate of enemies on levels 1, 2, and 3
        int[] enemyY = {4, 8, 8}; // Y-coordinate of enemies on levels 1, 2, and 3
        int[] enemyHealth = {50, 70, 60}; // Enemy health on levels 1, 2, and 3
        int enemyAttack = 25; // Enemy attack power

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (currentLevel < levels.length) {
            char[][] level = levels[currentLevel];

            while (true) {
                // Print the current level's maze
                for (char[] row : level) {
                    for (char cell : row) {
                        System.out.print(cell);
                    }
                    System.out.println();
                }

                // Check if the player has reached the exit
                if (playerX == level.length - 2 && playerY == level[0].length - 2) {
                    System.out.println("You have reached the exit of level " + (currentLevel + 1) + "!");
                    currentLevel++;

                    if (currentLevel == levels.length) {
                        System.out.println("Congratulations! You have completed all levels.");
                        return;
                    } else {
                        System.out.println("Entering level " + (currentLevel + 1) + "...");
                        playerX = 1;
                        playerY = 1;
                        break;
                    }
                }

                // Check for enemy encounter
                if (playerX == enemyX[currentLevel] && playerY == enemyY[currentLevel]) {
                    System.out.println("You have encountered an enemy!");
                    System.out.println("Enemy Health: " + enemyHealth[currentLevel]);
                    System.out.println("Your Health: " + playerHealth);

                    while (playerHealth > 0 && enemyHealth[currentLevel] > 0) {
                        // Player attacks
                        int playerDamage = random.nextInt(playerAttack);
                        enemyHealth[currentLevel] -= playerDamage;
                        System.out.println("You dealt " + playerDamage + " damage to the enemy. Enemy Health: " + enemyHealth[currentLevel]);

                        // Enemy attacks
                        int enemyDamage = random.nextInt(enemyAttack);
                        playerHealth -= enemyDamage;
                        System.out.println("The enemy dealt " + enemyDamage + " damage to you. Your Health: " + playerHealth);
                    }

                    if (playerHealth <= 0) {
                        System.out.println("You were defeated by the enemy. Game over.");
                        return;
                    } else {
                        System.out.println("You defeated the enemy!");
                    }
                }

                // Player movement logic (similar to previous code)
                // ...

                // Handle other player inputs, if any (e.g., picking up items)
                // ...
            }
        }
    }
}

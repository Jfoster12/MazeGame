# MazeGame
The provided Java code is an expanded version of the maze game with three levels, each containing an enemy encounter. Here's an explanation of how the code works:

Level Definitions: The maze levels are represented as a 3D character array called levels. Each level is a 2D character array, where each character represents a position in the maze. There are three levels defined in this code.

Current Level Tracking: The currentLevel variable is introduced to keep track of the player's progress through the levels. It starts at 0 (the first level).

Player's Position: playerX and playerY represent the player's current position within the maze.

Player Attributes: playerHealth represents the player's health, and playerAttack represents the player's attack power.

Enemy Information: Arrays enemyX, enemyY, and enemyHealth are used to store information about the enemies on each level. Each array corresponds to a level, specifying the enemy's X-coordinate, Y-coordinate, and health. enemyAttack represents the enemy's attack power, which is the same for all levels.

Scanner and Random: Scanner is used for user input, and Random is used to generate random numbers for damage calculations.

Game Loop: The outer while loop manages the player's progress through the levels. It continues until the player completes all levels or is defeated.

Maze Printing: Inside the loop, the code prints the current level's maze using nested loops, displaying each character on the screen.

Exit Check: The code checks if the player has reached the exit of the current level. If the player reaches the exit, it prints a message, increments the currentLevel, and either congratulates the player for completing all levels or proceeds to the next level.

Enemy Encounters: If the player's position matches an enemy's position on the current level, the code triggers an enemy encounter. It displays the enemy's health, the player's health, and enters a battle loop.

Battle Loop: In the battle loop, the player and the enemy take turns attacking each other. Damage dealt is calculated randomly within their respective attack ranges. The loop continues until either the player's health or the enemy's health drops to zero or below.

Battle Outcomes: After the battle loop, the code checks the outcome:

If the player's health reaches zero or below, the player is defeated, and the game ends.
If the enemy's health reaches zero or below, the player wins the battle and continues to explore the level.
Player Movement and Input: The code includes logic for player movement within the maze, similar to the previous code versions. The player can navigate through the maze and make choices like attacking or picking up items (not fully implemented in the provided code).

Game Progression: As the player progresses through levels, the code handles level transitions, enemy encounters, and the ultimate outcome of completing all levels or being defeated.

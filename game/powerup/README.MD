# PowerUp Game Code

**Creator:** M Talha Khalid

This repository contains the Java code for the PowerUp game, a challenging puzzle game where you need to unlock a vending machine by entering the correct combination of numbers. The code is designed to run on various platforms, including Windows, Mac, and Linux.

## Features

- Interface `PopUpGameFunc` with a method `Chk_tf_cell()` to check true and false values in cells.
- Interface `PopFunc` extending `PopUpGameFunc` with methods for input, output, verification, and cell checking.
- Abstract class `UserInput` implementing `PopFunc` with functionalities for user input, output, verification, and cell checking.
- Class `PowerUp` extending `UserInput` and implementing `PopUpGameFunc`, providing additional game-specific logic.
- Random number generation for the password combination.
- User input validation for digit entry.
- Output display showing user input and comparison with the password combination.
- Game win/lose conditions based on the number of tries and correct/incorrect cell values.

## Usage

To run the PowerUp game, execute the `PowerUpGamesD2RPG` class. Follow the prompts to enter the four numbers and try to unlock the vending machine. You have a limited number of tries, and the game ends when you run out of tries or successfully unlock the machine.

Enjoy the challenge and have fun playing the PowerUp game!

![Java Logo](https://cdn.iconscout.com/icon/free/png-256/java-43-569305.png)

# Sudoku

A JavaFX-based Sudoku game that allows players to generate, play, and save Sudoku puzzles. Choose from easy, medium, or hard difficulty levels, fill in the board, and enjoy a simple yet engaging experience with save/load functionality.

## Features
- Generate Sudoku puzzles with three difficulty levels: Easy, Medium, and Hard.
- Interactive gameplay with a 9x9 grid and number input via buttons.
- Save up to three game states to CSV files in the user's home directory (`~/SudokuSaves/`).
- Load previously saved games from available slots.
- Check for correct moves and detect when the puzzle is solved.
- Simple navigation between menu, game, level selection, and win screens.

## Prerequisites
To run this project, you need:
- **Java Development Kit (JDK)**: Version 11 or later (tested with JDK 21).
- **JavaFX SDK**: Version 24 (or compatible with your JDK).
- Required JavaFX modules:
    - `javafx.controls` – for UI components.
    - `javafx.fxml` – for FXML-based layouts.
- An IDE (optional): IntelliJ IDEA or PyCharm with Java support is recommended.

## Installation
1. **Clone the repository:**
   ```bash
   git clone https://github.com/agorski1/SudokuGame.git
   cd SudokuGame
   ```
2. Download JavaFX SDK:
 - Visit gluonhq.com and download JavaFX SDK (e.g., version 24).
 - Extract it to a directory, e.g., `C:\JavaFX\javafx-sdk-24`.
## Usage
1. Compile the project:
```bash
javac --module-path "C:\JavaFX\javafx-sdk-24\lib" --add-modules javafx.controls,javafx.fxml -d out src\main\java\com\example\sudoku\*.java src\main\java\module-info.java
```
2. Run the game:
```bash
java --module-path "C:\JavaFX\javafx-sdk-24\lib" --add-modules javafx.controls,javafx.fxml -cp out com.example.sudoku.Main
```
## Running in an IDE (e.g., IntelliJ IDEA)
1. Open the project in your IDE.
2. Add JavaFX SDK as a library:
- File → Project Structure → Libraries → "+" → Java → select `C:\JavaFX\javafx-sdk-24\lib`.
3. Configure VM Options:
 - Run → Edit Configurations → VM Options:
```bash
--module-path "C:\JavaFX\javafx-sdk-24\lib" --add-modules javafx.controls,javafx.fxml
```
4. Run the Main class.

## How to Play
 - New Game: Select "New Game" from the menu, choose a difficulty level (Easy, Medium, Hard), and start playing.
 - Gameplay: Click an empty cell, then use the number buttons (1-9) to fill it. Correct moves align with the solved board.
 - Save Game: Click "Save" during gameplay to store the current state in one of three slots.
 - Load Game: Select "Load Game" from the menu and pick a saved slot.
 - Win: Complete the puzzle to see the victory screen.

## Screenshots
Here are some examples of what the game looks like:
- **Main Menu:**  
  ![Main Menu](https://github.com/agorski1/Sudoku/tree/main/screenshots/menu.png)

- **New game:**  
  ![Gameplay](https://github.com/agorski1/Sudoku/tree/main/screenshots/game.png)


- **Load game:**  
  ![Gameplay](https://github.com/agorski1/Sudoku/tree/main/screenshots/gameplay.png)


- **Gameplay:**  
  ![Gameplay](https://github.com/agorski1/Sudoku/tree/main/screenshots/gameplay.png)



## Contributing
Feel free to submit issues or pull requests to improve the game!

## License
This project is licensed under the MIT License - see the  file for details (create one if needed).
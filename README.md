# Slot Machine Simulator

A JavaFX desktop game with three reels, 10 fruit symbols, and simulated bets. Originally completed in May 2022 as a Java coursework project.

## Features

- Three randomized fruit symbols on each spin.
- Positive-number bet input with feedback for invalid entries.
- Two matching symbols pay 3 times the bet; three matching symbols pay 4 times the bet. No match pays zero.
- Displays the current payout and cumulative winnings.
- Keeps the JavaFX interface, game implementation, and interface contract in separate classes.

## Run

Install JDK 17 or newer and Maven 3.9 or newer, then run from this folder:

```sh
mvn clean compile
mvn javafx:run
```

Maven obtains JavaFX dependencies. A desktop session is required to display the game. The 11 bundled images include 10 playable fruit symbols and one initial blank image. Resources load from the classpath, so the app does not depend on an original local folder.

## Project layout

- `src/main/java/application/`: JavaFX application, launcher, game implementation, and interface.
- `src/main/resources/images/`: original coursework image assets.
- `VALIDATION.md`: build and verification record.

The portfolio copy uses neutral class names and Maven packaging. The original payout rules and game logic are retained. The included images came from the original coursework folder; no separate asset license is asserted here.

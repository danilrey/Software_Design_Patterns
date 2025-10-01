import Console.*;
import Game.*;

import java.util.Scanner;

class Client {
    private static final Scanner input = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println(
                    "Welcome to Minecraft Client\n"
                            + "Choose your console:\n"
                            + "0. Exit\n"
                            + "1. PS 4\n"
                            + "2. Xbox Series X\n"
                            + "3. Nintendo Switch\n"
                            + "Type here: "
            );

            int choice = readInt();
            switch (choice) {
                case 1:
                    Console ps = new PS4();
                    Minecraft psGame = new Minecraft(ps);
                    psGame.start();
                    playGame(psGame);
                    break;
                case 2:
                    Console xbox = new XboxSeriesX();
                    Minecraft xboxGame = new Minecraft(xbox);
                    xboxGame.start();
                    playGame(xboxGame);
                    break;
                case 3:
                    Console nintendo = new Nintendo();
                    Minecraft nintendoGame = new Minecraft(nintendo);
                    nintendoGame.start();
                    playGame(nintendoGame);
                case 0:
                    System.out.println("Bye!");
                    System.exit(0);
                    return;
                default:
                    System.out.println("Invalid input try again\n");
            }
        }
    }

    private void playGame(Minecraft game) {
        while (true) {
            System.out.println(
                    "Choose your action:\n"
                            + "0. Exit game\n"
                            + "1. Volume up\n"
                            + "2. Volume down\n"
                            + "3. Build\n"
                            + "4. Explore\n"
                            + "5. Fight\n"
                            + "6. Walk\n"
                            + "7. Run\n"
                            + "8. Mine\n"
                            + "9. Bomb\n"
                            + "Type here: "
            );
            int choice = readInt();
            switch (choice) {
                case 0:
                    game.exit();
                    return;
                case 1: game.volumeUp(); break;
                case 2: game.volumeDown(); break;
                case 3: game.build(); break;
                case 4: game.explore(); break;
                case 5: game.fight(); break;
                case 6: game.walk(); break;
                case 7: game.run(); break;
                case 8: game.mine(); break;
                case 9: game.bomb(); break;
                default:
                    System.out.println("Invalid input try again\n");
            }
        }
    }

    private int readInt() {
        while (true) {
            String line = input.nextLine().trim();
            if (line.isEmpty()) {
                System.out.print("Enter a number: ");
                continue;
            }
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException ex) {
                System.out.print("Not a number. Try again: ");
            }
        }
    }
}

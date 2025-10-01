package Console;

public class XboxSeriesX implements Console{
    private static int volume = 50;
    @Override
    public void exitGame() {
        System.out.println("Exiting Xbox");
    }

    @Override
    public void startGame() {
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⢀⣠⣤⣤⣶⣶⣶⣶⣤⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⡀⠀⠈⠉⠛⠿⣿⣿⣿⣿⠿⠛⠉⠁⠀⢀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⣴⣿⣿⣿⣶⣄⡀⠀⠈⠙⠋⠁⠀⢀⣠⣶⣿⣿⣿⣦⠀⠀⠀\n" +
                "⠀⢀⣾⣿⣿⣿⣿⣿⣿⡿⠂⠀⠀⠀⠀⠐⢿⣿⣿⣿⣿⣿⣿⣷⡀⠀\n" +
                "⠀⣾⣿⣿⣿⣿⣿⣿⠋⠀⠀⠀⢀⡀⠀⠀⠀⠙⣿⣿⣿⣿⣿⣿⣷⠀\n" +
                "⢠⣿⣿⣿⣿⣿⡟⠁⠀⠀⢀⣴⣿⣿⣦⡀⠀⠀⠈⢻⣿⣿⣿⣿⣿⡄\n" +
                "⢸⣿⣿⣿⣿⠏⠀⠀⢀⣴⣿⣿⣿⣿⣿⣿⣦⡀⠀⠀⠹⣿⣿⣿⣿⡇\n" +
                "⠘⣿⣿⣿⠏⠀⠀⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄⠀⠀⠹⣿⣿⣿⠃\n" +
                "⠀⢿⣿⡟⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⡀⠀⢻⣿⡿⠀\n" +
                "⠀⠈⢿⡇⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⢸⡿⠁⠀\n" +
                "⠀⠀⠀⠃⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠘⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠈⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠛⠁⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠈⠙⠛⠛⠿⠿⠿⠿⠛⠛⠋⠁⠀⠀⠀⠀⠀⠀⠀\n");
    }

    @Override
    public void setVolume(int percent) {
        volume = percent;
    }

    @Override
    public int getVolume() {
        return volume;
    }

}

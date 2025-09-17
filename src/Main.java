import Theme.*;
import Widget.Button.Button;
import Widget.Window.Window;
import Widget.Menu.Menu;

public class Main {
    public static void main(String[] args) {
        ThemeFactory darkTheme = new DarkThemeFactory();
        Window window = darkTheme.createWindow();
        window.show();

        ThemeFactory lightTheme = new LightThemeFactory();
        Button btn = lightTheme.createButton();
        btn.click();

        ThemeFactory autoTheme = new AutoThemeFactory();
        Menu menu = autoTheme.createMenu();
        menu.open();


    }
}
import Theme.*;
import Widget.Button.IButton;
import Widget.Window.IWindow;
import Widget.Menu.IMenu;

public class Main {
    public static void main(String[] args) {
        IThemeFactory darkTheme = new DarkTheme();
        IWindow window = darkTheme.createWindow();
        window.show();

        IThemeFactory lightTheme = new LightTheme();
        IButton btn = lightTheme.createButton();
        btn.click();

        IThemeFactory autoTheme = new AutoTheme();
        IMenu autoMenu = autoTheme.createMenu();
        autoMenu.open();


    }
}
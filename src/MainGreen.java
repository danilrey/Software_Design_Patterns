import Theme.GreenThemeFactory;
import Theme.ThemeFactory;

import Widget.Window.Window;
import Widget.Button.Button;
import Widget.Menu.Menu;

public class MainGreen {
    public static void main(String[] args) {
        ThemeFactory greenTheme = new GreenThemeFactory();
        Window window = greenTheme.createWindow();
        window.show();
        Button btn = greenTheme.createButton();
        btn.click();
        Menu menu = greenTheme.createMenu();
        menu.open();
    }
}

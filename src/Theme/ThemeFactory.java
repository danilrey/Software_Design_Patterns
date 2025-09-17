package Theme;

import Widget.Button.Button;
import Widget.Menu.Menu;
import Widget.Window.Window;

public interface ThemeFactory {
    Window createWindow();
    Button createButton();
    Menu createMenu();
}

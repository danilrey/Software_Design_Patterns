package Theme;

import Widget.Button.IButton;
import Widget.Menu.IMenu;
import Widget.Window.IWindow;

public interface IThemeFactory {
    IWindow createWindow();
    IButton createButton();
    IMenu createMenu();
}

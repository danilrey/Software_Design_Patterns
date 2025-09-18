package Theme;

import Widget.Button.*;
import Widget.Menu.*;
import Widget.Window.*;

public class GreenThemeFactory implements ThemeFactory{
    @Override
    public Window createWindow() {
        return new GreenWindow();
    }

    @Override
    public Button createButton() {
        return new GreenButton();
    }

    @Override
    public Menu createMenu() {
        return new GreenMenu();
    }
}

package Theme;

import Widget.Button.*;
import Widget.Menu.*;
import Widget.Window.*;

public class DarkThemeFactory implements ThemeFactory {
    @Override
    public Window createWindow() { return new DarkWindow(); }

    @Override
    public Button createButton() { return new DarkButton(); }

    @Override
    public Menu createMenu() { return new DarkMenu(); }
}

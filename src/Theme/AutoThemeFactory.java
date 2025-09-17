package Theme;

import Widget.Button.*;
import Widget.Menu.*;
import Widget.Window.*;


public class AutoThemeFactory implements ThemeFactory {
    @Override
    public Window createWindow() { return new AutoWindow(); }

    @Override
    public Button createButton() { return new AutoButton(); }

    @Override
    public Menu createMenu() { return new AutoMenu(); }
}

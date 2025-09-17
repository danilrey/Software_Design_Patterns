package Theme;

import Widget.Button.*;
import Widget.Menu.*;
import Widget.Window.*;

public class LightThemeFactory implements ThemeFactory {
    @Override
    public Window createWindow() { return new LightWindow(); }

    @Override
    public Button createButton() { return new LightButton(); }

    @Override
    public Menu createMenu() { return new LightMenu(); }
}

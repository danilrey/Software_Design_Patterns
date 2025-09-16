package Theme;

import Widget.Button.*;
import Widget.Menu.*;
import Widget.Window.*;

public class DarkTheme implements IThemeFactory {
    @Override
    public IWindow createWindow() { return new DarkWindow(); }

    @Override
    public IButton createButton() { return new DarkButton(); }

    @Override
    public IMenu createMenu() { return new DarkMenu(); }
}

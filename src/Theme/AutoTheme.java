package Theme;

import Widget.Button.*;
import Widget.Menu.*;
import Widget.Window.*;


public class AutoTheme implements IThemeFactory{
    @Override
    public IWindow createWindow() { return new AutoWindow(); }

    @Override
    public IButton createButton() { return new AutoButton(); }

    @Override
    public IMenu createMenu() { return new AutoMenu(); }
}

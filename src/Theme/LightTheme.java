package Theme;

import Widget.Button.*;
import Widget.Menu.*;
import Widget.Window.*;

public class LightTheme implements IThemeFactory {
    @Override
    public IWindow createWindow() { return new LightWindow(); }

    @Override
    public IButton createButton() { return new LightButton(); }

    @Override
    public IMenu createMenu() { return new LightMenu(); }
}

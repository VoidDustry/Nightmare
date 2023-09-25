package net.voiddustry.nightmare;

import mindustry.mod.Plugin;
import net.voiddustry.nightmare.game.Events;

@SuppressWarnings("unused")
public class Main extends Plugin {
    public void init() {
        Events.load();
    }
}
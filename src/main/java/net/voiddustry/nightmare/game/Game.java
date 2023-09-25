package net.voiddustry.nightmare.game;

import arc.util.Log;
import arc.util.Timer;
import mindustry.Vars;
import mindustry.gen.Call;
import mindustry.world.Tile;
import net.voiddustry.nightmare.Bundle;

public class Game {
    public static boolean running;
    public static Tile spawn1;
    public static Tile redSpawn1;

    public static Tile spawn2;
    public static Tile redSpawn2;

    public static void initSpawns() {
        spawn1 = Vars.world.tile(58, 34);
        redSpawn1 = Vars.world.tile(40, 92);

        spawn2 = Vars.world.tile(374, 50);
        redSpawn2 = Vars.world.tile(460, 53);
    }

    public static void startGame() {
        task.run();
    }

    private static final Timer.Task task = new Timer.Task() {
        @Override
        public void run() {
            int[] i = {60};
            Timer.schedule(() -> {
                i[0]--;
                if (i[0] <= -1) {
                    Game.running = true;
                    task.cancel();
                } else {
                    Call.infoPopupReliable(Bundle.format("time-left", i[0]), 1, 0, 0, 0, -70, 0);
                }
            }, 0, 1);
        }
    };
}

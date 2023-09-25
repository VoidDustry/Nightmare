package net.voiddustry.nightmare.game;

import arc.util.Log;
import mindustry.game.EventType;
import mindustry.gen.Player;
import net.voiddustry.nightmare.domain.PlayerData;
import net.voiddustry.nightmare.domain.Players;

public class Events {
    public static void load() {
        arc.Events.on(EventType.PlayerConnect.class, event -> {
            Player player = event.player;

            if (!Players.playersMap.containsKey(player.uuid())) {
                Players.playersMap.put(player.uuid(), new PlayerData(player));
            }

            if (Game.running) {
                Players.loadPlayer(player);
            }
        });

        arc.Events.on(EventType.WorldLoadBeginEvent.class, event -> {
            Game.startGame();

        });
        arc.Events.on(EventType.WorldLoadEndEvent.class, event -> Game.initSpawns());
    }
}

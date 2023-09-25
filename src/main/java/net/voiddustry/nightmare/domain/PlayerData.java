package net.voiddustry.nightmare.domain;

import lombok.Getter;
import lombok.Setter;
import mindustry.game.Team;
import mindustry.gen.Player;
import mindustry.gen.Unit;

public class PlayerData {
    @Getter
    @Setter
    private String uuid;
    private Unit unit;
    private Team team;

    public PlayerData(Player player) {
        this.uuid = player.uuid();
        this.team = Team.sharded;
    }
}

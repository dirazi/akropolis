package team.devblook.akropolis;

public enum Permissions {
    // Command permissions
    COMMAND_AKROPOLIS_HELP("command.help"), COMMAND_AKROPOLIS_RELOAD("command.reload"),
    COMMAND_SCOREBOARD_TOGGLE("command.scoreboard"), COMMAND_OPEN_MENUS("command.openmenu"),
    COMMAND_HOLOGRAMS("command.holograms"),

    // Misc permissions
    COMMAND_GAMEMODE("command.gamemode"), COMMAND_GAMEMODE_OTHERS("command.gamemode.others"),
    COMMAND_CLEARCHAT("command.clearchat"), COMMAND_FLIGHT("command.fly"), COMMAND_FLIGHT_OTHERS("command.fly.others"),
    COMMAND_LOCKCHAT("command.lockchat"), COMMAND_SET_LOBBY("command.setlobby"), COMMAND_VANISH("command.vanish"),

    // Bypass permissions
    ANTI_SWEAR_BYPASS("bypass.antiswear"), BLOCKED_COMMANDS_BYPASS("bypass.commands"),
    LOCK_CHAT_BYPASS("bypass.lockchat"), ANTI_WDL_BYPASS("bypass.antiwdl"), DOUBLE_JUMP_BYPASS("bypass.doublejump"),

    // Notification permissions
    ANTI_WDL_NOTIFY("alert.antiwdl"), ANTI_SWEAR_NOTIFY("alert.antiswear"),

    // Event permissions
    EVENT_ITEM_DROP("item.drop"), EVENT_ITEM_PICKUP("item.pickup"), EVENT_PLAYER_PVP("player.pvp"),
    EVENT_BLOCK_INTERACT("block.interact"), EVENT_BLOCK_BREAK("block.break"), EVENT_BLOCK_PLACE("block.place");

    private final String permission;

    Permissions(String permission) {
        this.permission = permission;
    }

    public final String getPermission() {
        return "akropolis." + this.permission;
    }
}
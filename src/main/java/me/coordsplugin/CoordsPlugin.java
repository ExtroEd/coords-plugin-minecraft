package me.coordsplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CoordsPlugin extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        getLogger().info("CoordsPlugin has been enabled!");
        if (getCommand("coords") != null) {
            Objects.requireNonNull(getCommand("coords")).setExecutor(this);
        } else {
            getLogger().warning("Command 'coords' is not defined in plugin.yml.");
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("CoordsPlugin has been disabled!");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
        if (!(sender instanceof Player) || !sender.isOp()) {
            sender.sendMessage("Only operators can use this command.");
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("coords")) {

            if (args.length == 0) {
                sender.sendMessage("Usage: /coords <playername> or /coords nearest or /coords help");
                return true;
            }

            // Command to get coords of nearest player
            if (args.length == 2 && args[0].equalsIgnoreCase("nearest")) {
                Player requestingPlayer = (Player) sender;
                Player target = getNearestPlayer(requestingPlayer);

                if (target == null) {
                    sender.sendMessage("No players found nearby.");
                    return true;
                }

                int x = target.getLocation().getBlockX();
                int y = target.getLocation().getBlockY();
                int z = target.getLocation().getBlockZ();
                String dimension = target.getWorld().getName();

                String displayDimension = switch (dimension) {
                    case "world" -> "Overworld";
                    case "world_nether" -> "Nether";
                    case "world_the_end" -> "The End";
                    default -> dimension;
                };

                sender.sendMessage("Coordinates of " + target.getName() + ":");
                sender.sendMessage("X = " + x);
                sender.sendMessage("Y = " + y);
                sender.sendMessage("Z = " + z);
                sender.sendMessage("World = " + displayDimension);
                return true;
            }

            // Command to get coords of specific player
            if (args.length == 1) {
                Player target = getServer().getPlayer(args[0]);
                if (target == null) {
                    sender.sendMessage("Player not found.");
                    return true;
                }

                int x = target.getLocation().getBlockX();
                int y = target.getLocation().getBlockY();
                int z = target.getLocation().getBlockZ();
                String dimension = target.getWorld().getName();

                String displayDimension = switch (dimension) {
                    case "world" -> "Overworld";
                    case "world_nether" -> "Nether";
                    case "world_the_end" -> "The End";
                    default -> dimension;
                };

                sender.sendMessage("Coordinates of " + target.getName() + ":");
                sender.sendMessage("X = " + x);
                sender.sendMessage("Y = " + y);
                sender.sendMessage("Z = " + z);
                sender.sendMessage("World = " + displayDimension);
                return true;
            }

            // Command /coords help
            if (args[0].equalsIgnoreCase("help")) {
                sender.sendMessage("Coordinates Plugin Commands:");
                sender.sendMessage("/coords <playername> - Get coordinates of the specified player.");
                sender.sendMessage("/coords nearest - Get coordinates of the nearest player to you.");
                sender.sendMessage("/coords help - Show this help message.");
                return true;
            }
        }

        return false;
    }

    // Method for finding nearest player
    private Player getNearestPlayer(Player player) {
        List<Player> players = Bukkit.getServer().getOnlinePlayers().stream()
                .filter(p -> !p.equals(player))
                .sorted(Comparator.comparingDouble(p -> p.getLocation().distance(player.getLocation())))
                .collect(Collectors.toList());

        if (players.isEmpty()) {
            return null;
        }

        return players.get(0);
    }
}

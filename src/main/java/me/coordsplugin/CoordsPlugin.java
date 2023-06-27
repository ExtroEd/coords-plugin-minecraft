package me.coordsplugin;


import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CoordsPlugin extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        getLogger().info("CoordsPlugin has been enabled!");
        getCommand("coords").setExecutor(this);
    }

    @Override
    public void onDisable() {
        getLogger().info("CoordsPlugin has been disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("coords")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Only players that are on the server can use this command.");
                return true;
            }

            if (args.length == 0) {
                sender.sendMessage("Usage: /coords <playername>");
                return true;
            }

            Player target = getServer().getPlayer(args[0]);
            if (target == null) {
                sender.sendMessage("Player not found.");
                return true;
            }

            double x = target.getLocation().getX();
            double y = target.getLocation().getY();
            double z = target.getLocation().getZ();


            sender.sendMessage("Coordinates of " + target.getName() + ":");
            sender.sendMessage("X = " + x);
            sender.sendMessage("Y = " + y);
            sender.sendMessage("Z = " + z);
            return true;
        }

        return false;
    }
}

package io.github.deerjump.gamesplus.commands;

import io.github.deerjump.gamesplus.menu.CardsMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@SuppressWarnings("NullableProblems")
public class CardsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You can't see items, silly :P");
            return true;
        }

        Player player = (Player) sender;
        player.openInventory(new CardsMenu().getInventory());

        return true;
    }
}

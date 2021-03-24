package io.github.deerjump.gamesplus;

import io.github.deerjump.gamesplus.commands.CardsCommand;
import io.github.deerjump.gamesplus.commands.GamesCommand;
import io.github.deerjump.menuapi.MenuListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.function.Consumer;

public class GamesPlus extends JavaPlugin {

   private static GamesPlus self;

    @Override
   @SuppressWarnings("ConstantConditions")
   public void onEnable() {
      self = this;
      Bukkit.getPluginManager().registerEvents(new MenuListener(), this);
      this.getCommand("games").setExecutor(new GamesCommand());
      this.getCommand("cards").setExecutor(new CardsCommand());
   }

   @Override
   public void onDisable() {

   }

   public static void runTaskTimer(Consumer<BukkitTask> bukkitTaskConsumer, long delay, long period) {
      Bukkit.getScheduler().runTaskTimer(self, bukkitTaskConsumer, delay, period );
   }


   public static void runTaskLater(Consumer<BukkitTask> bukkitConsumer, long delay) {
      Bukkit.getScheduler().runTaskLater(self, bukkitConsumer, delay);
   }
}
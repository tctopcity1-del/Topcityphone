
package com.topcity.phone;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class TopCityPhone extends JavaPlugin {

    private NamespacedKey phoneKey;

    @Override
    public void onEnable() {
        phoneKey = new NamespacedKey(this, "topcity_phone");
        getLogger().info("TopCityPhone is enabled!");
    }

    @Override
    public boolean onCommand(
            CommandSender sender,
            Command command,
            String label,
            String[] args
    ) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("This command is for players only.");
            return true;
        }

        if (command.getName().equalsIgnoreCase("phone")) {
            ItemStack phone = new ItemStack(Material.CLOCK);
            ItemMeta meta = phone.getItemMeta();

            meta.setDisplayName("§8§lTOP CITY §f| §7iPhone");
            meta.setLore(List.of(
                    "§7Top City RP",
                    "§8Black Edition",
                    "§eRight-click to open"
            ));
            meta.setCustomModelData(1001);
            meta.getPersistentDataContainer().set(
                    phoneKey,
                    org.bukkit.persistence.PersistentDataType.BYTE,
                    (byte) 1
            );

            phone.setItemMeta(meta);
            player.getInventory().addItem(phone);
            player.sendMessage("§8[§bTop City§8] §fYour phone is ready!");
            return true;
        }

        return false;
    }
}

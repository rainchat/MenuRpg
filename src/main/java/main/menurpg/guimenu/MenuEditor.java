package main.menurpg.guimenu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MenuEditor {
    public MenuEditor(Player player) {
        Inventory inv = Bukkit.createInventory(new MenuHol(), 27, "&8Канистра с водой!");

        for (int i = 0; i < 27; i++) {
            if (!(i >= 10 && i <= 14) && !(i == 16)) {
                inv.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));

            }
        }
        inv.setItem(16, new ItemStack(Material.GREEN_STAINED_GLASS));

        player.openInventory(inv);
    }
}

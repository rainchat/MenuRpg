package main.menurpg.guimenu;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MenuMenager implements Listener {

    @EventHandler
    public void  onClickInventory(InventoryClickEvent e){
        if (e.getClickedInventory() == null) return;
        if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) return;
        Player player = (Player) e.getWhoClicked();

        Inventory inv = e.getView().getTopInventory();
        if (inv.getHolder() instanceof MenuHol) {
            int slot = e.getSlot();
            switch (slot){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    break;
                case 18:
                    break;
                case 19:
                    break;
                case 20:
                    break;
                case 21:
                    break;
                case 22:
                    break;
                case 23:
                    break;


            }


        }

    }
}

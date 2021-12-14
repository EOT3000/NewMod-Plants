package fly.plants.impl;

import com.sk89q.worldedit.event.platform.BlockInteractEvent;
import fly.newmod.NewMod;
import fly.newmod.bases.ModItem;
import fly.newmod.setup.BlockStorage;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class WitheringTable extends ModItem {
    public WitheringTable() {
        super(Material.SMOOTH_STONE_SLAB, "&cWithering Table", "withering_table");
    }

    //TODO: move to ModItem method

    @Override
    public void onInteract(PlayerInteractEvent event) {
        //TODO: finish
    }
}

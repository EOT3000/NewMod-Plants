package e.bases;

import fly.newmod.NewMod;
import fly.newmod.api.item.type.ModItemType;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class SeedsItem extends ModItemType implements Listener {
    private final ModItemType plant;

    public SeedsItem(Material material, Material blockMaterial, String name, TextColor color, String id, JavaPlugin plugin, ModItemType item, ItemStack ingredient) {
        super(material, new NamespacedKey(plugin, id));

        name(name, color);

        this.plant = item;

        SeedsBlock block = new SeedsBlock(blockMaterial, getId());

        setBlock(block);

        NewMod.get().getBlockManager().registerBlock(block);
        NewMod.get().getItemManager().registerItem(this);
    }

    public ModItemType getPlant() {
        return plant;
    }

    @Override
    public void onUse(PlayerInteractEvent event) {
        if(!event.hasBlock()) {
            return;
        }

        Material type = event.getClickedBlock().getType();

        if(event.getBlockFace().equals(BlockFace.UP) && (type.equals(Material.DIRT) || type.equals(Material.GRASS_BLOCK) || type.equals(Material.COARSE_DIRT))) {
            Block r = event.getClickedBlock().getRelative(0, 1, 0);

            if(r.getType().equals(Material.AIR)) {
                r.setType(Material.MELON_STEM);

                BlockStorage storage = NewMod.get().getBlockStorage();

                storage.changeData(r.getLocation(), "id", getId());
            }
        }
    }
}

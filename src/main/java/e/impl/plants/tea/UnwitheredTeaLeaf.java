package e.impl.plants.tea;

import fly.newmod.NewMod;
import fly.newmod.api.item.type.ModItemType;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Leaves;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public class UnwitheredTeaLeaf extends ModItemType {
    private static Random random = new Random();

    private ModItemType withered;

    public UnwitheredTeaLeaf(Material material, String name, int color, String id, JavaPlugin plugin, ModItemType withered) {
        super(material, new NamespacedKey(plugin, id));

        name(name, color);

        this.withered = withered;

        NewMod.get().getItemManager().registerItem(this);
    }

    @Override
    public void tick(Location location, int count) {
        if(random.nextInt(3000) == 0) {
            BlockStorage storage = NewMod.get().getBlockStorage();
            Block b = location.getBlock();

            b.setType(withered.getType());

            Leaves leaves = (Leaves) location.getBlock().getBlockData();

            leaves.setPersistent(true);

            b.setBlockData(leaves);

            storage.changeData(location, "id", withered.getId());
        }
    }
}

package fly.plants.impl;

import fly.newmod.NewMod;
import fly.newmod.bases.ModItem;
import fly.newmod.setup.BlockStorage;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Leaves;

import java.util.Random;

public class UnwitheredTeaLeaf extends ModItem {
    private static Random random = new Random();

    private ModItem withered;

    public UnwitheredTeaLeaf(Material material, String name, int color, String id, ModItem withered) {
        super(material, name, color, id);

        this.withered = withered;
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

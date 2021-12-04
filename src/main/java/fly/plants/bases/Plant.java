package fly.plants.bases;

import fly.newmod.NewMod;
import fly.newmod.bases.ModItem;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Leaves;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.StructureGrowEvent;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Plant extends ModItem implements Listener {
    private Random random = new Random();

    private final int ats;
    private final  Material stage1;
    private final Material stage2;
    private final Material stage3;

    public Plant(Material stage1, Material stage2, Material stage3, String name, String id, int ats) {
        super(stage1, name, id);

        this.stage1 = stage1;
        this.stage2 = stage2;
        this.stage3 = stage3;

        this.ats = ats;
    }

    @Override
    public List<Material> getValidMaterials() {
        return Arrays.asList(stage1, stage2, stage3);
    }

    @Override
    public void tick(Location location) {
        String data = NewMod.get().getBlockStorage().getData(location, "stage");

        if(data.isEmpty()) {
            NewMod.get().getBlockStorage().changeData(location, "stage", "1");
        }

        if(random.nextInt(3000) == 1) {
            if (data.equalsIgnoreCase("1")) {
                Block block = location.getBlock();

                block.setType(stage2);

                Leaves leaves = (Leaves) block.getBlockData();

                leaves.setPersistent(true);

                block.setBlockData(leaves);

                NewMod.get().getBlockStorage().changeData(location, "stage", "2");

                return;
            }

            if (data.equalsIgnoreCase("2")) {
                Block block = location.getBlock();

                block.setType(stage3);

                Leaves leaves = (Leaves) block.getBlockData();

                leaves.setPersistent(true);

                block.setBlockData(leaves);

                NewMod.get().getBlockStorage().changeData(location, "stage", "3");
            }
        }
    }

    @Override
    public void onPlace(Location location) {
        NewMod.get().getBlockStorage().changeData(location, "stage", "1");
    }

    @Override
    public boolean shouldBeGone(Location location) {
        return NewMod.get().getBlockStorage().getData(location, "stage").equalsIgnoreCase("1");
    }

    @EventHandler
    public void onGrow(StructureGrowEvent event) {
        if (isPlant(event.getLocation())) {
            event.setCancelled(true);
        }
    }

    private boolean isPlant(Location location) {
        String data = NewMod.get().getBlockStorage().getData(location, "id");

        if(NewMod.get().getBlockStorage().getType(data) instanceof Plant) {
            return true;
        }

        return false;
    }
}

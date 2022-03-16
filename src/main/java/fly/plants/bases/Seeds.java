package fly.plants.bases;

import fly.newmod.NewMod;
import fly.newmod.bases.ModItem;
import fly.newmod.setup.BlockStorage;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Seeds extends ModItem implements Listener {
    private Plant plant;

    public Seeds(Material material, String name, TextColor color, String id, Plant item, ItemStack ingredient) {
        super(material, name, color, id, ingredient);

        this.plant = item;
    }

    @Override
    public List<Material> getValidMaterials() {
        return Collections.singletonList(Material.MELON_STEM);
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

    @Override
    public void tick(Location location, int count) {
        BlockStorage storage = NewMod.get().getBlockStorage();
        String age = storage.getData(location, "age");

        if(age.isEmpty()) {
            storage.changeData(location, "age", "0");

            age = "0";
        }

        Block b = location.getBlock();

        Ageable ageable = (Ageable) b.getBlockData();

        ageable.setAge(Integer.parseInt(age));

        b.setBlockData(ageable);

        Random random = new Random();

        if(random.nextDouble() < 0.01 && random.nextDouble() < 0.01) {
            ageable.setAge(ageable.getAge()+1);

            storage.changeData(location, "age", String.valueOf(ageable.getAge()));

            if(ageable.getAge() == 5) {
                b.setType(plant.getStage1());

                storage.changeData(location, "id", plant.getId());
            }
        }
    }
}

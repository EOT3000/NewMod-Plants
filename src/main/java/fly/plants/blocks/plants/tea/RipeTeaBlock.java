package fly.plants.blocks.plants.tea;

import fly.newmod.NewMod;
import fly.newmod.api.block.ModBlock;
import fly.newmod.api.block.type.ModBlockType;
import fly.newmod.api.event.BlockEventsListener;
import fly.newmod.api.event.block.ModBlockTickEvent;
import fly.plants.PlantsPlugin;
import fly.plants.blocks.plants.complex.MultiStagePlant;
import fly.plants.setup.PlantsAddonSetup;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Leaves;

import java.util.Random;

public class RipeTeaBlock extends ModBlockType {
    public RipeTeaBlock() {
        super(Material.FLOWERING_AZALEA_LEAVES, new NamespacedKey(PlantsPlugin.get(), "ripe_tea_plant"));

        NewMod.get().getBlockManager().registerBlock(this);
    }
}

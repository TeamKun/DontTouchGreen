package net.kunmc.lab.donttouchgreen;

import net.kunmc.lab.donttouchgreen.listener.PlayerInteractListener;
import net.kunmc.lab.donttouchgreen.task.CheckUnderfootTask;
import net.kunmc.lab.donttouchgreen.task.DetectEntityCollisionTask;
import net.kunmc.lab.donttouchgreen.task.DetectTouchingWallTask;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

public final class DontTouchGreen extends JavaPlugin {
    public static DontTouchGreen instance;
    public static final Set<Material> greenMaterialList = new HashSet<Material>() {{
        add(Material.GRASS_BLOCK);
        add(Material.WARPED_NYLIUM);
        add(Material.WARPED_PLANKS);
        add(Material.OAK_SAPLING);
        add(Material.SPRUCE_SAPLING);
        add(Material.BIRCH_SAPLING);
        add(Material.JUNGLE_SAPLING);
        add(Material.ACACIA_SAPLING);
        add(Material.DARK_OAK_SAPLING);
        add(Material.WARPED_STEM);
        add(Material.STRIPPED_WARPED_STEM);
        add(Material.STRIPPED_WARPED_HYPHAE);
        add(Material.OAK_LEAVES);
        add(Material.SPRUCE_LEAVES);
        add(Material.BIRCH_LEAVES);
        add(Material.JUNGLE_LEAVES);
        add(Material.ACACIA_LEAVES);
        add(Material.DARK_OAK_LEAVES);
        add(Material.STICKY_PISTON);
        add(Material.GRASS);
        add(Material.FERN);
        add(Material.LARGE_FERN);
        add(Material.SEAGRASS);
        add(Material.TALL_SEAGRASS);
        add(Material.LIME_WOOL);
        add(Material.GREEN_WOOL);
        add(Material.DANDELION);
        add(Material.POPPY);
        add(Material.BLUE_ORCHID);
        add(Material.ALLIUM);
        add(Material.AZURE_BLUET);
        add(Material.RED_TULIP);
        add(Material.ORANGE_TULIP);
        add(Material.WHITE_TULIP);
        add(Material.PINK_TULIP);
        add(Material.OXEYE_DAISY);
        add(Material.CORNFLOWER);
        add(Material.LILY_OF_THE_VALLEY);
        add(Material.WARPED_FUNGUS);
        add(Material.WARPED_ROOTS);
        add(Material.NETHER_SPROUTS);
        add(Material.TWISTING_VINES);
        add(Material.SUGAR_CANE);
        add(Material.KELP);
        add(Material.KELP_PLANT);
        add(Material.BAMBOO);
        add(Material.WARPED_SLAB);
        add(Material.PRISMARINE_SLAB);
        add(Material.PRISMARINE_BRICK_SLAB);
        add(Material.DARK_PRISMARINE_SLAB);
        add(Material.MOSSY_COBBLESTONE);
        add(Material.CACTUS);
        add(Material.WARPED_FENCE);
        add(Material.WARPED_TRAPDOOR);
        add(Material.INFESTED_MOSSY_STONE_BRICKS);
        add(Material.MOSSY_STONE_BRICKS);
        add(Material.MELON);
        add(Material.VINE);
        add(Material.WARPED_FENCE_GATE);
        add(Material.LILY_PAD);
        add(Material.END_PORTAL_FRAME);
        add(Material.EMERALD_ORE);
        add(Material.ENDER_CHEST);
        add(Material.EMERALD_BLOCK);
        add(Material.WARPED_STAIRS);
        add(Material.BEACON);
        add(Material.MOSSY_COBBLESTONE_WALL);
        add(Material.PRISMARINE_WALL);
        add(Material.MOSSY_STONE_BRICK_WALL);
        add(Material.WARPED_BUTTON);
        add(Material.LIME_TERRACOTTA);
        add(Material.GREEN_TERRACOTTA);
        add(Material.LIME_CARPET);
        add(Material.GREEN_CARPET);
        add(Material.SLIME_BLOCK);
        add(Material.LILAC);
        add(Material.ROSE_BUSH);
        add(Material.PEONY);
        add(Material.LIME_STAINED_GLASS);
        add(Material.GREEN_STAINED_GLASS);
        add(Material.LIME_STAINED_GLASS_PANE);
        add(Material.GREEN_STAINED_GLASS_PANE);
        add(Material.PRISMARINE);
        add(Material.PRISMARINE_BRICKS);
        add(Material.DARK_PRISMARINE);
        add(Material.PRISMARINE_STAIRS);
        add(Material.PRISMARINE_BRICK_STAIRS);
        add(Material.DARK_PRISMARINE_STAIRS);
        add(Material.SEA_LANTERN);
        add(Material.WARPED_WART_BLOCK);
        add(Material.LIME_SHULKER_BOX);
        add(Material.GREEN_SHULKER_BOX);
        add(Material.LIME_GLAZED_TERRACOTTA);
        add(Material.GREEN_GLAZED_TERRACOTTA);
        add(Material.LIME_CONCRETE);
        add(Material.GREEN_CONCRETE);
        add(Material.LIME_CONCRETE_POWDER);
        add(Material.GREEN_CONCRETE_POWDER);
        add(Material.MOSSY_STONE_BRICK_STAIRS);
        add(Material.MOSSY_COBBLESTONE_STAIRS);
        add(Material.MOSSY_STONE_BRICK_SLAB);
        add(Material.MOSSY_COBBLESTONE_SLAB);
        add(Material.WARPED_DOOR);
        add(Material.WARPED_SIGN);
        add(Material.WARPED_WALL_SIGN);
        add(Material.DRIED_KELP_BLOCK);
        add(Material.LIME_BED);
        add(Material.GREEN_BED);
        add(Material.ZOMBIE_HEAD);
        add(Material.CREEPER_HEAD);
        add(Material.LIME_BANNER);
        add(Material.LIME_WALL_BANNER);
        add(Material.GREEN_BANNER);
        add(Material.GREEN_WALL_BANNER);
    }};
    public static final Set<EntityType> greenEntityList = new HashSet<EntityType>() {{
        add(EntityType.CREEPER);
        add(EntityType.SLIME);
        add(EntityType.ZOMBIE);
        add(EntityType.ZOMBIE_VILLAGER);
        add(EntityType.ZOMBIE_HORSE);
        add(EntityType.PARROT);
    }};

    @Override
    public void onEnable() {
        instance = this;

        new CheckUnderfootTask().runTaskTimerAsynchronously(this, 0, 0);
        new DetectEntityCollisionTask().runTaskTimerAsynchronously(this, 0, 0);
        new DetectTouchingWallTask().runTaskTimerAsynchronously(this, 0, 0);

        getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
    }

    @Override
    public void onDisable() {
    }
}

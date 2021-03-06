package net.lemeow.aimod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.lemeow.aimod.AIMod;
import net.lemeow.aimod.block.custom.InfusionTableBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    // Void Quartz Blocks Inputs

    public static final Block VOID_QUARTZ_ORE = registerBlock("void_quartz_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).requiresTool().strength(50f, 1200f)),
            ItemGroup.BUILDING_BLOCKS,
            UniformIntProvider.create(5, 10));


    public static final Block VOID_QUARTZ_BLOCK = registerBlock("void_quartz_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(50f, 1200f).requiresTool()),
            ItemGroup.MISC, UniformIntProvider.create(5, 10));

    public static final Block INFUSION_TABLE = registerVoidBlock("infusion_table",
            new InfusionTableBlock(FabricBlockSettings.of(Material.STONE).strength(50f,1200f).requiresTool()),
            ItemGroup.BUILDING_BLOCKS);




    // End Forest Blocks?



    public static Block registerBlock(String name, Block block, ItemGroup group, UniformIntProvider uniformIntProvider){
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(AIMod.MOD_ID, name), block);
    }

    public static Block registerVoidBlock(String name, Block block, ItemGroup group){
        registerVoidItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(AIMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group){
        return Registry.register(Registry.ITEM, new Identifier(AIMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    private static Item registerVoidItem(String name, Block block, ItemGroup group){
        return Registry.register(Registry.ITEM, new Identifier(AIMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group).fireproof().rarity(Rarity.EPIC)));
    }


    public static void registerMudBlocks(){
        AIMod.LOGGER.info("Registering ModBlocks for" + AIMod.MOD_ID);
    }
}

package net.tarkstudios.mcmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.sound.SoundEvent;
import net.tarkstudios.mcmod.FrenzyBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.tarkstudios.mcmod.FrenzyBlock.FRENZY_BLOCK;

public class MCMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("mcmod");
	public static final Identifier FRENZY_BLOCK_SOUND_ID = new Identifier("mcmod:frenzy_block_sound");
	public static SoundEvent FRENZY_BLOCK_SOUND_EVENT = new SoundEvent(FRENZY_BLOCK_SOUND_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Registry.register(Registry.BLOCK, new Identifier("mcmod", "frenzy_block"), FRENZY_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("mcmod", "frenzy_block"), new BlockItem(FRENZY_BLOCK, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.SOUND_EVENT, MCMod.FRENZY_BLOCK_SOUND_ID, FRENZY_BLOCK_SOUND_EVENT);

		LOGGER.info("Hello Fabric world!");
	}
}

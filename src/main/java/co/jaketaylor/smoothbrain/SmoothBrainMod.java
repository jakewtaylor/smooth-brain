package co.jaketaylor.smoothbrain;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SmoothBrainMod implements ModInitializer {
	public static final Item SMOOTH_BRAIN = new Item(new Item.Settings().group(ItemGroup.MISC));

	@Override
	public void onInitialize() {
		// Register our item
		Registry.register(Registry.ITEM, new Identifier("smooth_brain", "smooth_brain"), SMOOTH_BRAIN);

		// Subscribe to loot table load
		LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
			System.out.println(id);
		});
	}
}

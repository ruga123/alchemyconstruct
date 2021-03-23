package net.mcreator.alchemyconstruct.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.mcreator.alchemyconstruct.AlchemyConstructModVariables;
import net.mcreator.alchemyconstruct.AlchemyConstructModElements;
import net.mcreator.alchemyconstruct.AlchemyConstructMod;

import java.util.Map;

@AlchemyConstructModElements.ModElement.Tag
public class AlchemicalConcoctionRightClickedInAirProcedure extends AlchemyConstructModElements.ModElement {
	public AlchemicalConcoctionRightClickedInAirProcedure(AlchemyConstructModElements instance) {
		super(instance, 3);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				AlchemyConstructMod.LOGGER.warn("Failed to load dependency entity for procedure AlchemicalConcoctionRightClickedInAir!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				AlchemyConstructMod.LOGGER.warn("Failed to load dependency itemstack for procedure AlchemicalConcoctionRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		{
			ItemStack _setval = (itemstack);
			entity.getCapability(AlchemyConstructModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.UsedConcoction = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}

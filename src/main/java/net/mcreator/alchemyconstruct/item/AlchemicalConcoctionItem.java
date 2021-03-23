
package net.mcreator.alchemyconstruct.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.ActionResult;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.player.PlayerEntity;

import net.mcreator.alchemyconstruct.procedures.AlchemicalConcoctionRightClickedInAirProcedure;
import net.mcreator.alchemyconstruct.AlchemyConstructModElements;

import java.util.Map;
import java.util.HashMap;

@AlchemyConstructModElements.ModElement.Tag
public class AlchemicalConcoctionItem extends AlchemyConstructModElements.ModElement {
	@ObjectHolder("alchemy_construct:alchemical_concoction")
	public static final Item block = null;
	public AlchemicalConcoctionItem(AlchemyConstructModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.BREWING).maxStackSize(8).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(0).saturation(0f).build()));
			setRegistryName("alchemical_concoction");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				AlchemicalConcoctionRightClickedInAirProcedure.executeProcedure($_dependencies);
			}
			return ar;
		}

		@Override
		public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
			ActionResultType retval = super.onItemUseFirst(stack, context);
			World world = context.getWorld();
			BlockPos pos = context.getPos();
			PlayerEntity entity = context.getPlayer();
			Direction direction = context.getFace();
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			ItemStack itemstack = context.getItem();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				AlchemicalConcoctionRightClickedInAirProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}

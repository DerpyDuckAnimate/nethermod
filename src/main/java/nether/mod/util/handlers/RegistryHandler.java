package nether.mod.util.handlers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nether.mod.init.BlockInit;
import nether.mod.init.ItemInit;
import nether.mod.util.IHasModel;
import nether.mod.world.gen.WorldGenCustomStructures;


@EventBusSubscriber
public class RegistryHandler 
{
	public static WorldGenCustomStructures structures = null;
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
	}
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
	}
	

	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		for(Item item : ItemInit.ITEMS)
		{
			if(item instanceof IHasModel)
			{
				((IHasModel)item).registerModels();
			}
		
		
			for(Block block : BlockInit.BLOCKS)
			{
				if(block instanceof IHasModel)
				{
					((IHasModel)block).registerModels();
				}
			}}
		
	}
	
public static void preInitRegistries() {
		
		GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(),0);
	
	
		
		
	}
public static void otherRegistries()
{
	//GameRegistry.registerWorldGenerator(new WorldGenTrees(), 0);

	structures = new WorldGenCustomStructures();

	GameRegistry.registerWorldGenerator(structures, 0);
}


}
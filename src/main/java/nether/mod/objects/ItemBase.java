package nether.mod.objects;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import nether.mod.Main;
import nether.mod.init.ItemInit;
import nether.mod.proxy.ClientProxy;
import nether.mod.util.IHasModel;


public class ItemBase extends Item implements IHasModel {

	public ItemBase(String name)
	{
	setUnlocalizedName(name);
	setRegistryName(name);
	setCreativeTab(CreativeTabs.MISC);
	ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels()
		{
	Main.proxy.registerItemRenderer(this,0,"inventory");
		}
	
	
}
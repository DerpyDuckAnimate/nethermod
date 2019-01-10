package nether.mod.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import nether.mod.blocks.BlockBase;
import nether.mod.objects.ItemBase;

public class BlockInit {
	
public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	
	public static final Block COMPRESSED_BLOCK = new BlockBase("quartz_compressedblock", Material.IRON).setHardness(3.2f);



}

package nether.mod.world.gen;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeHell;
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import nether.mod.init.BlockInit;
import nether.mod.world.gen.generators.WorldGenStructure;
import scala.actors.threadpool.Arrays;

public class WorldGenCustomStructures implements IWorldGenerator {

	
	public static final WorldGenStructure PIGGEN = new WorldGenStructure("piggen");

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		switch(world.provider.getDimension()) {
		
		case 1:
			break;
		case 0: 
			
			
			break; 
		case -1:
			generateStructure(PIGGEN, world, random, chunkX, chunkZ, 3, Blocks.NETHERRACK, BiomeHell.class);
		
			
		}
	}
	private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock, Class<?>...classes)
	{
		ArrayList<Class<?>> classesList = new ArrayList<Class<?>> (Arrays.asList(classes));

		int x = (chunkX * 16) + random.nextInt(15) + 8;
		int z = (chunkZ * 16) + random.nextInt(15) + 8;
		int y = calculateGenerationHeight(world, x, z, topBlock) - 1;


		BlockPos pos = new BlockPos(x, y, z);

		//	Block block = world.getBlockState(new BlockPos(pos.getX() + 9, pos.getY(), pos.getZ() + 17)).getBlock();

		//	if(block == topBlock)
		//	{
		Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();

		if(world.getWorldType() != WorldType.FLAT)
		{
			if(classesList.contains(biome))
			{
				if(random.nextInt(chance) == 0)
				{
					generator.generate(world, random, pos);
				
				}
			}
		}
		
	}
		
		
	
	private static int calculateGenerationHeight(World world, int x, int z, Block topBlock)
	{
		int y = world.getHeight();
		boolean foundGround = false;

		while(!foundGround && y-- >= 0)
		{
			Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
			foundGround = block == topBlock;
		}

		return y;
	}

	

}

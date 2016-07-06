package bq_rf.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import bq_rf.block.TileRfStation;
import bq_rf.client.gui.inventory.ContainerRfStation;
import bq_rf.client.gui.inventory.GuiRfStation;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
		
		if(ID == 0 && tile instanceof TileRfStation)
		{
			return new ContainerRfStation(player.inventory, (TileRfStation)tile);
		}
		
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
		
		if(ID == 0 && tile instanceof TileRfStation)
		{
			return new GuiRfStation(null, player.inventory, (TileRfStation)tile);
		}
		
		return null;
	}
}

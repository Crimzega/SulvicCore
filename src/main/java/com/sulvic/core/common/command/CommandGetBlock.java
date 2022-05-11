package com.sulvic.core.common.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;

public class CommandGetBlock extends CommandBase{
	
	public int getRequiredPermissionLevel(){ return 1; }
	
	public String getCommandName(){ return "getblock"; }
	
	public String getCommandUsage(ICommandSender sender){ return "sulvicCommand.getBlock.usage"; }
	
	public void processCommand(ICommandSender sender, String[] args){
		if(args.length >= 1 || args.length >= 3){
			ChunkCoordinates playerCoords = sender.getPlayerCoordinates();
			int posX = playerCoords.posX, posY = playerCoords.posY, posZ = playerCoords.posZ;
			if(args.length >= 3){
				posX = MathHelper.floor_double(func_110666_a(sender, (double)posX, args[0]));
				posY = MathHelper.floor_double(func_110666_a(sender, (double)posY, args[1]));
				posZ = MathHelper.floor_double(func_110666_a(sender, (double)posZ, args[2]));
			}
		}
		else throw new WrongUsageException("sulvicCommand.getBlock.usage", new Object[0]);
	}
	
}

package com.cyborgJenn.alphaCentauri.core.utils;

import java.io.File;
import java.io.PrintWriter;
import java.util.Map;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;

public class ListEntities 
{
	public ListEntities()
	{
		Map<Integer, Class<? extends Entity>> IDtoClassMap = EntityList.ID_TO_CLASS;
		try
		{
			File file = new File("config/AlphaCentauri/entitylist.txt");
			PrintWriter pw = new PrintWriter(file);
			if (!file.exists())
			{
				pw.print("This is the entityList for Mod AlphaCentauri - WIP");
				pw.close();
			}
			else
			{
				IDtoClassMap.forEach((k, v) -> 
				pw.print(k + " = " + v +"\r\n")
				);
				pw.close();
			}
		}
		catch (Throwable e)
		{
			AlphaCentauri.logger.warn("Unable to read the ENTITYLIST", e);
		}
	}
}

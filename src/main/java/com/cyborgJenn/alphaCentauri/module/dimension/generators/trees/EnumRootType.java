package com.cyborgJenn.alphaCentauri.module.dimension.generators.trees;

import java.util.Iterator;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.Vec3i;
import scala.reflect.internal.Trees.This;

public enum EnumRootType implements IStringSerializable{
	TYPE1(1),
	TYPE2(2),
	TYPE3(3),
	TYPE4(4);

	private final int typeIn;
	private EnumRootType(int typeIn)
    {
        this.typeIn = typeIn;
    }
	public int getTheType()
	{
		return this.typeIn;
		
	}
	
	
	private EnumRootType type;
	private String name = "rootType";
	@Override
	public String getName() 
	{
		return this.name;
	}

	public EnumRootType getType() 
	{
		return this.type;
	}
	
	public static enum Type implements Predicate<EnumRootType>, Iterable<EnumRootType> {
		TPYE;

		public static EnumRootType[] types()
		{
			return new EnumRootType[] {EnumRootType.TYPE1, EnumRootType.TYPE2, EnumRootType.TYPE3, EnumRootType.TYPE4};
		}
		public static EnumRootType random(Random rand) 
		{
			EnumRootType[] aenumtype = types();
			return aenumtype[rand.nextInt(aenumtype.length)];
		}
		@Override
		public boolean apply(@Nullable EnumRootType input) 
		{
			return input != null;
		}
		@Override
		public Iterator<EnumRootType> iterator() 
		{
			return Iterators.<EnumRootType>forArray(this.types());
		}
	}
}

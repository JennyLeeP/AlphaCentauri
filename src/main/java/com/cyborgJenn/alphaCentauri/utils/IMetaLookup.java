package com.cyborgJenn.alphaCentauri.utils;

/**
 * Every IProperty Enum class should use this
 * @author Draco18s
 *
 * @param <T>
 */
public interface IMetaLookup<T extends Enum> {
	public String getID();
	public T getByOrdinal(int i);

	public String getVariantName();
	public int getOrdinal();
}
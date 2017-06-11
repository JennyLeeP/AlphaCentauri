package com.cyborgJenn.alphaCentauri.core.utils;

import java.nio.charset.Charset;

public class Reference {
	public static final String MODID = "alphacentauri";
	public static final String NAME = "AlphaCentauri";
	public static final String VERSION = "@VERSION@";
	public static final String PROXY = "com.cyborgJenn.alphaCentauri.core.proxy.";
	public static final String CLIENTPROXY =  PROXY + "ClientProxy";
	public static final String SERVERPROXY = PROXY + "CommonProxy";
	public static final String TEXTURE = MODID + ":";
	public static String[] langFiles = { "/assets/alphaCentauri/lang/en_US.xml" };
	public static final String CHARSET_NAME = "UTF-8";
    public static final Charset CHARSET = Charset.forName(CHARSET_NAME);
    
	public static final int ACCESSORYGUI = 0;
	
}

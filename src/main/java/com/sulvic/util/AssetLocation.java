package com.sulvic.util;

import com.sulvic.lib.HashCore;

public class AssetLocation{
	
	private String assetDomain, assetPath;
	
	private AssetLocation(String[] domainPath){ this(domainPath[0], domainPath[1]); }
	
	public AssetLocation(String domainPath){ this(separateDomainAndPath(domainPath, ':')); }
	
	public AssetLocation(String domain, String path){
		assetDomain = domain;
		assetPath = path;
	}
	
	private static String[] separateDomainAndPath(String domainPath, char separator){
		String[] split = domainPath.indexOf(separator) != -1? domainPath.split("" + separator): new String[]{"shared", domainPath};
		for(int i = 0; i < split.length; i++) split[i] = split[i].toLowerCase();
		return split;
	}
	
	public int hashCode(){ return HashCore.create(25, 9).append(assetDomain).append(assetPath).asHash(); }
	
	public String getAssetDomain(){ return assetDomain; }
	
	public String getAssetPath(){ return assetPath; }
	
	public String toString(){ return assetDomain + ":" + assetPath; }
	
}

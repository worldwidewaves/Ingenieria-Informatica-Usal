package com.coti.textfiletools;
import java.io.File;

// Last compilation date
//
// 9/2/16 13:20
//
public interface TextUtils {
	public static final String lineSeparator = System.getProperty("line.separator");
	public String readString(File f);
	public boolean writeString(String str, File f);
	public boolean writeStringAppending(String str, File f);
	public boolean writeList(String[] list, File f);
	public boolean writeListAppending(String[] list, File f);
	public String[] readList(File f);
	public boolean writeDelimitedTable(String[][] table, String delimiter, File f);
	public boolean writeColumnarTable(String[][] table, int[] lengths, File f);
	public boolean writeColumnarTable(String[][] table, int[] lengths);
	public String[][] readDelimitedTable(String delimiter, File f);
	public String[][] readColumnarTable(int[] field_length, File f);
}

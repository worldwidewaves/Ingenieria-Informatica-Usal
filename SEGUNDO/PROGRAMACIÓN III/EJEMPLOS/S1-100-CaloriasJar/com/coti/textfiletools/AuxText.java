package com.coti.textfiletools;

import java.util.*;
import java.io.*;
import java.awt.Component;
import javax.swing.*;
/*
12/12/11 17:12
*/

// Last compilation date
//
// 9/2/16 13:20
//

import com.coti.textfiletools.*;

public class AuxText implements TextUtils,Serializable {
	private AuxTextLo lo = null;
	private AuxTextHi hi = null;
	private final int UNIX        = 0;
	private final int WINDOWS     = 1;
	TextUtils[][] preferred = null;
	private int platform;
  	private Component owner = null;
	public AuxText(Component owner)
	{
    this.owner= owner;
	lo = new AuxTextLo(owner);
	hi = new AuxTextHi(owner);
	TextUtils[][] tuned = { 
		/* Unix, Windows */
		{hi, lo}, /*  0 readString                        */
		{hi, hi}, /*  1 writeString              hi hi    */
		{hi, hi}, /*  2 writeStringAppending     hi hi    */
		{lo, lo}, /*  3 readList                          */
		{hi, hi}, /*  4 writeList                hi hi    */
		{hi, hi}, /*  5 writeListAppending       hi hi    */
		{lo, hi}, /*  6 writeDelimitedTable      lo hi    */
		{lo, lo}, /*  7 readDelimitedTable                */
		{lo, lo}, /*  8 writeColumnarTable                */
		{lo, lo}, /*  9 writeColumnarTable                */
		{lo, lo}  /* 10 readColumnarTable                 */
	};
	TextUtils[][] all_LO = { 
		/* Unix, Windows */
		{lo, lo}, /*  0 readString             */
		{lo, lo}, /*  1 writeString            */
		{lo, lo}, /*  2 writeStringAppending   */
		{lo, lo}, /*  3 readList               */
		{lo, lo}, /*  4 writeList              */
		{lo, lo}, /*  5 writeListAppending     */
		{lo, lo}, /*  6 writeDelimitedTable    */
		{lo, lo}, /*  7 readDelimitedTable     */
		{lo, lo}, /*  8 writeColumnarTable     */
		{lo, lo}, /*  9 writeColumnarTable     */
		{lo, lo}  /* 10 readColumnarTable      */
	};
	TextUtils[][] all_HI = { 
		/* Unix, Windows */
		{hi, hi}, /*  0 readString             */
		{hi, hi}, /*  1 writeString            */
		{hi, hi}, /*  2 writeStringAppending   */
		{hi, hi}, /*  3 readList               */
		{hi, hi}, /*  4 writeList              */
		{hi, hi}, /*  5 writeListAppending     */
		{hi, hi}, /*  6 writeDelimitedTable    */
		{hi, hi}, /*  7 readDelimitedTable     */
		{hi, hi}, /*  8 writeColumnarTable     */
		{hi, hi}, /*  9 writeColumnarTable     */
		{hi, hi}  /* 10 readColumnarTable      */
	};
	preferred = tuned; /* tuned, all_LO, all_HI */
	if (System.getProperty("os.name").indexOf("Windows") == -1)
		platform = UNIX;
	else
		platform = WINDOWS;
	}
	public void errMess(String message, String title)
	{
    JOptionPane.showMessageDialog(owner, message, title, JOptionPane.ERROR_MESSAGE);   
	}
	public String readString(File f)
	{
	return preferred[0][platform].readString(f);
	}
	public boolean writeString(String str, File f)
	{
	return preferred[1][platform].writeString(str, f);
	}
	public boolean writeStringAppending(String str, File f)
	{
	return preferred[2][platform].writeStringAppending(str, f);
	}
	public String[] readList(File f)
	{
	return preferred[3][platform].readList(f);
	}
	public boolean writeList(String[] list, File f)
	{
	return preferred[4][platform].writeList(list, f);
	}
	public boolean writeListAppending(String[] list, File f)
	{
	return preferred[5][platform].writeList(list, f);
	}
	public boolean writeDelimitedTable(String[][] table, String delimiter, File f)
	{
	return preferred[6][platform].writeDelimitedTable(table, delimiter, f);
	}
	public String[][] readDelimitedTable(String delimiter, File f)
	{
	return preferred[7][platform].readDelimitedTable(delimiter, f);
	}
	public boolean writeColumnarTable(String[][] table, int[] lengths, File f)
	{
	return preferred[8][platform].writeColumnarTable(table, lengths, f);
	}
	public boolean writeColumnarTable(String[][] table, int[] lengths)
	{
	return preferred[9][platform].writeColumnarTable(table, lengths);
	}
	public String[][] readColumnarTable(int[] field_length, File f)
	{
	return preferred[10][platform].readColumnarTable(field_length, f);
	}
	public String[][] createTable(int numRows, int numColumns)
	{
	return lo.createTable(numRows,numColumns);
	}
}

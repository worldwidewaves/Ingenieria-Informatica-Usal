package com.coti.textfiletools;
/*
 *@author coti
 *@version 1.6 - not final (will it ever be?)
 * 12/12/11 17:12
 *
        .-.
     ,-(  _)-.
  .-(_    (_  )-.
 (__            _)
    `-(______)-'
       `:::\
         `::\
           `:\
           /::'    IMPORTANT CHANGE
          /:'      ----------------
          `:\      This library will no longer append
            `\     data when writing. It will overwrite
              \    existing files.
                   This is in accordance with user
                   expectations; no-one wants a database
                   to be duplicated when saving after
                   changes have been made.

	However, appending is possible.
*/

// Last compilation date
//
// 9/2/16 13:20
//

import java.io.File;
import java.util.*;
import java.awt.Component;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.*;

public class AuxTextLo implements TextUtils,Serializable {
	private Component owner;
	public AuxTextLo(Component o)
	{
    owner = o;
	}
	public void errMess(String message, String title)
	{
    JOptionPane.showMessageDialog(owner, message, title, JOptionPane.ERROR_MESSAGE);   
	}
	public String readString(File f)
	{
  	FileInputStream br            = null;
  	int numberOfBytesWeWillRead   = 0;
	try
		{
		numberOfBytesWeWillRead = (int)f.length();
		byte[] buf              = new byte[numberOfBytesWeWillRead];
		br                      = new FileInputStream(f);
		br.read(buf);
		br.close();
		return new String(buf);
		}
	catch(Exception e)
		{
		errMess(e.toString(),"AuxTextLo:Error in String readString");
		return null;
		}
	}
	
	public boolean writeString(String str, File f)
	{
	try
		{
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		bw.write(str.toCharArray());
		bw.close();
		return true;
		}
	catch(Exception e)
		{
		errMess(e.toString(), "AuxTextLo: Error in boolean writeString(String, File)");
		return false;
		}
	}
	public boolean writeStringAppending(String str, File f)
	{
	String s=null;
	try
		{
		if (f.exists()) s = readString(f);
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		if (null != s) bw.write(s.toCharArray());
		bw.write(str.toCharArray());
		bw.close();
		return true;
		}
	catch(Exception e)
		{
		errMess(e.toString(), "AuxTextLo: Error in boolean writeStringAppending(String, File)");
		return false;
		}
	}
	
	public String[] readList(File f)
	{
  	try
  		{
		String s = readString(f);
		return s.split(lineSeparator);
    	}
    catch(Exception e)
    	{
		errMess(e.toString(), "AuxTextLo: Error in readList(File)");
		return null;
    	}
	}
	
	public boolean writeList(String[] list, File f)
	{
  	int i;
  	StringBuilder temp = null;
  	int numberOfRows;
	try
		{
		numberOfRows = list.length;
		temp = new StringBuilder(numberOfRows*list[0].length());
		for(i=0;i<numberOfRows;i++) temp.append(list[i]).append(lineSeparator);
		writeString(temp.toString(),f);
		return true;
		}
	catch(Exception e)
		{
		errMess(e.toString(), "AuxTextLo: Error in boolean writeList(String[], File)");
		return false;
		}
	}
	
	public boolean writeListAppending(String[] list, File f)
	{
  	int i;
  	StringBuilder temp = null;
  	int numberOfRows;
	try
		{
		numberOfRows = list.length;
		temp = new StringBuilder(numberOfRows*list[0].length());
		for(i=0;i<numberOfRows;i++) temp.append(list[i]).append(lineSeparator);
		writeStringAppending(temp.toString(),f);
		return true;
		}
	catch(Exception e)
		{
		errMess(e.toString(), "AuxTextLo: Error in boolean writeListAppending(String[], File)");
		return false;
		}
	}
	
	public String[][] createTable(int numRows, int numColumns)
	{
  	int i;
  	int j;
  	String[][] result = new String[numRows][numColumns];
  	for(i=0;i < numRows; i++)
  		for(j=0; j < numColumns; j++)
  			result[i][j] = "a["+i+"]["+j+"]";
  	return result;
	}
	
	public boolean writeDelimitedTable(String[][] table, String delimiter, File f)
	{
  	int i;
  	int j;
	StringBuilder s = null;
    try
    	{
		int number_of_rows = table.length;
		int number_of_columns = table[0].length;
		s = new StringBuilder(number_of_rows*number_of_columns*table[0][0].length());
		int lastCol = number_of_columns - 1;
		for(i=0;i<number_of_rows;i++)
			{
			for(j=0; j<number_of_columns-1;j++)
				s.append(table[i][j]).append(delimiter);
			s.append(table[i][lastCol]+"\n");
			}
		writeString(s.toString(),f);
		return true;
		}
    catch(Exception e)
		{
		errMess(e.toString(), "AuxTextLo: error in writeDelimitedTable(String[][],String,File");
		return false;
		}
	}
	
	public String[][] readColumnarTable(int[] field_length, File f)
	{
    int i;
    int j;
    String[][] table = null;
    StringBuilder temp = null;
    String[] list = null;
    int number_of_rows = 0, number_of_columns = 0;
    int number_of_fields = 0;
    list = readList(f); 
    if (null == list)
		{
        errMess("Could not read null file","AuxTextLo:readColumnarTable");
        return null;
		}
    number_of_rows = list.length; /* As many rows as lines we have read */
    if (0 == number_of_rows)
		{
        errMess("0 rows in table","AuxTextLo:readColumnarTable");
        return null;
		}
    number_of_columns = field_length.length; /* This is the number of fields */
    if (0 == number_of_columns)
		{
        errMess("no field widths given","AuxTextLo:readColumnarTable");
        return null;
		}
    table = new String[number_of_rows][number_of_columns];
    int field_start = 0;
    temp = new StringBuilder(8192);
    for(i=0;i<number_of_rows;i++)
		{
        field_start = 0;
        temp.append(list[i]);
        for(j=0;j<number_of_columns;j++)
			{
            try
				{
                table[i][j]=temp.substring( field_start,field_start+field_length[j]).trim();
                field_start += field_length[j];
				}
            catch(Exception e)
				{
                errMess("Line "+i+" is too short for field " +j+". Field left empty.","AuxTextLo:readColumnarTable");
                table[i][j]="";
				}
			}
		temp.delete(0,temp.length());
		}
    return table;
	}
	
	public boolean writeColumnarTable(String[][] table, int[] lengths, File f)
	{
	int i;
	int j;
    try
    	{
		int number_of_rows = table.length;
		int number_of_columns = table[0].length;
		CharArrayWriter cw = new CharArrayWriter(number_of_rows*number_of_columns*table[0][0].length());
		PrintWriter pw = new PrintWriter(cw);
		String[] format = new String[number_of_columns];
		for(i=0;i < number_of_columns;i++)
			format[i] = "%-"+lengths[i]+"s";
		for(i=0;i < number_of_rows;i++)
			{
			for(j=0; j<number_of_columns;j++)
				pw.printf(format[j],table[i][j]);
			pw.print(lineSeparator);
			}
		writeString(cw.toString(),f);
		return true;
		}
	catch(Exception e)
		{
		errMess(e.toString(),"AuxTextLo:writeColumnarTable(String[][],int[],File");
		return false;
		}
	}
	
	public boolean writeColumnarTable(String[][] table, int[] lengths)
	{
	int i;
	int j;
    try
    	{
		PrintWriter pw = new PrintWriter(System.out);
		int number_of_rows = table.length;
		int number_of_columns = table[0].length;
		String[] format = new String[number_of_columns];
		for(i=0;i < number_of_columns;i++)
			format[i] = "%-"+i+"s";
		for(i=0;i < number_of_rows;i++)
			{
			for(j=0; j<number_of_columns;j++)
				pw.printf(format[j],table[i][j]);
			pw.print(lineSeparator);
			}
		pw.close();
		return true;
		}
	catch(Exception e)
		{
		errMess(e.toString(),"AuxTextLo:writeColumnarTable(String[][],int[]");
		return false;
		}
	}
	
	public String[][] readDelimitedTable(String delimiter, File f)
	{
  	int i;
  	int numRows, numCols;
   	String[] rowOfFields;
  	String[] temp = readList(f);
	numRows = temp.length;
  	rowOfFields = temp[0].split(delimiter);
  	numCols = rowOfFields.length;
  	String[][] table = new String[numRows][numCols];
  	for(i=0;i<numRows;i++) table[i] = temp[i].split(delimiter);
  	return table;
	}
}

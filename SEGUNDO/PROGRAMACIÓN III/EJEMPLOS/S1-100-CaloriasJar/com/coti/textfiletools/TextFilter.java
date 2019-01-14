package com.coti.textfiletools;
import javax.swing.filechooser.FileFilter;
import java.io.File;

/*
 This is a simple file filter for text files.
 It will think that a file that ends with any
 of the strings stored in good is a text file.
 This could be much more sophisticated of course;
 the only way to be certain is to read all of
 the files charactes and see that they are
 really text. This is time consuming though.
 
 To Do - This can be done better with a set of
 Strings; then we can check wheter the substring
 from lastIndexOf(".") till the end belongs to
 the aforementioned set. The set must be all
 lowercase or uppercase, and the substring
 must equally all lowercase or uppercase.
 
 We can go one step further and create a filter-
 producing class, in wich text filters are ready,
 or a list of ending strings can be passed.
 
 One could also think of more sophisticated checking
 for special files, like jpg or gif perhaps. Anything
 with a recognizable signature.
 */

// Last compilation date
//
// 9/2/16 13:20
//

public class TextFilter extends FileFilter {
	
	public boolean accept(File f) {
		String[] good = {".txt", ".text", ".del", ".col"};
		String fn = f.getName().toUpperCase();
		boolean endsRight = false;
		int numberOfEndings = good.length;
		int fl = fn.length();
		
		for(int i=0;i<numberOfEndings;i++)
			if (endsRight = fn.lastIndexOf(good[i].toUpperCase())==fl-4)
				break;
		
		return endsRight;
		
	}
	
	public String getDescription() {
		
		return "Text file (txt text del col)";
		
	}
	
}

package com.coti.guitools;
import java.io.*;

public class JavaFileFilter implements FileFilter {
  private String extension;
  public JavaFileFilter(String xt) {
    extension = xt;
    if (xt.indexOf(".") == -1)
      extension = "." + extension;
  }
  public boolean accept(File f) {
    return f.getName().toUpperCase().endsWith(extension.toUpperCase());
    
  }
  String getDescription(){
    return "Just files of type " + extension + " .";
  }
}

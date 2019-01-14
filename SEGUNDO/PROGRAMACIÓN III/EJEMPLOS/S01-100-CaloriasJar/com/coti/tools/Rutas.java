/*
 * Now has package and git
 */

package com.coti.tools;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 *
 * @author bruegel
 */
public class Rutas {
    
    //
    // Path format
    //
    public static Path pathToDesktop() {
        Path p = FileSystems.getDefault().getPath(System.getProperty("user.home")
                                                  + File.separator
                                                  + "Desktop");
        return p;
    }
    
    public static Path pathToFolderOnDesktop(String nameOfFolder) {
        Path p = FileSystems.getDefault().getPath(System.getProperty("user.home"),
                                                  File.separator
                                                  + "Desktop"
                                                  + File.separator
                                                  + nameOfFolder);
        return p;
    }
    
    public static Path pathToFileOnDesktop(String nameOfFile) {
        Path p = FileSystems.getDefault().getPath(System.getProperty("user.home"),
                                                  File.separator
                                                  + "Desktop"
                                                  + File.separator
                                                  + nameOfFile);
        return p;
    }
    
    public static Path pathToFileInFolderOnDesktop(String nameOfFolder, String nameOfFile) {
        Path p = FileSystems.getDefault().getPath(System.getProperty("user.home"),
                                                  File.separator
                                                  + "Desktop"
                                                  + File.separator
                                                  + nameOfFolder
                                                  + File.separator
                                                  + nameOfFile);
        return p;
    }
    
}

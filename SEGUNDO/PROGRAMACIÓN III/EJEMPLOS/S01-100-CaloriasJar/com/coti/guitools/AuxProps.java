package com.coti.guitools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class AuxProps {
    
    public static Properties loadProps(File deDonde) {
        Properties props = new Properties();
        try {
            FileInputStream fis = new FileInputStream(deDonde);
            props.loadFromXML(fis);
            fis.close();
        } catch (IOException ex) {
            System.out.println(deDonde.getAbsolutePath());
            ex.printStackTrace();
        }
        return props;
    }
    
    public static ArrayList<String> extractKeys(Properties props) {
        int numDeProps;
        ArrayList<String> nombres = new ArrayList<String>();
        numDeProps = props.size();
        for (int i = 0; i < numDeProps/2; i++)
            nombres.add(props.getProperty(i+"*0"));
        return nombres;
    }     

    public static ArrayList<String> extractValues(Properties props) {
        int numDeProps;
        ArrayList<String> nombres = new ArrayList<String>();
        numDeProps = props.size();
        for (int i = 0; i < numDeProps/2; i++)
            nombres.add(props.getProperty(i+"*1"));
        return nombres;
    }     

    public static Properties rebuild(Properties temp) {
        Properties listaReconstruida = new Properties();
        for(int i=0;i<temp.size()/2;i++)
            {
                listaReconstruida.setProperty(
                				temp.getProperty(i+"*0"),
                				temp.getProperty(i+"*1"));
            }
        
        return listaReconstruida;
    }

    
}

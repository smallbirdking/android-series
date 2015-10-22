package com.example.smallbirdking.seriess;

import java.util.HashMap;
import java.util.List;

/**
 * Created by smallbirdking on 2015/10/15.
 */
public class content {
    static final  public String urlImage = "https://image.tmdb.org/t/p/w300";
    public static final String Serie_choosed = "item_id_choosed";
    public static long Serie_choosed_id = -1;
    public static final String [] locations = {"home"};
    public static HashMap<String, HashMap> Choosed_inSeie = new HashMap<String, HashMap>();
    public static HashMap<String, Boolean> Choosable_Place = new HashMap<String, Boolean>();
    public static HashMap<String, List<String>> Serie_atPlace =  new HashMap<String, List<String>>();
    public static HashMap<String, List<Integer>> Serie_atPlace_Id = new HashMap<String, List<Integer>>();
}

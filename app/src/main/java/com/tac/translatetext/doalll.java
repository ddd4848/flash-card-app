 package com.tac.translatetext;

import java.util.ArrayList;

public class doalll {
    ArrayList<String> en, vn ;
    public static ArrayList<String>  merge(ArrayList<String> en, ArrayList<String> vn){
        ArrayList<String> merged = new ArrayList<String>();
for (int n= 0; n< en.size(); n++){
            merged.add( en.get(n));
            merged.add( vn.get(n));


        }
return  merged;
};
public static ArrayList<String> spliten(ArrayList< String > file){
    ArrayList<String> en  = new   ArrayList<String>();

    for (int n= 0; n< file.size(); n++){ if ((n % 2 )== 0) {en.add (file.get(n ));}}
    return  en ;
}

    public static ArrayList<String> splitvn(ArrayList< String > file){
        ArrayList<String> vn = new   ArrayList<String>();

        for (int n= 0; n< file.size(); n++){ if ((n % 2)== 1) {vn.add (file.get(n ));}}


        return  vn ;
    }

}

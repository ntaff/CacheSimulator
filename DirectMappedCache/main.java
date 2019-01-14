package DirectMappedCache;

import java.io.*;

/**
 *
 * @author Taffoureau
 */
public class main {
    /**
     * @param args the command line arguments
     */
    public static final int n = 3 ;

    public static void main(String[] args) {

        Cache cache = new Cache(n);
        int[] tab = cache.LoadFile("C:\\Users\\Taffoureau\\Documents\\S6\\Architecture\\TP\\TP1\\matrice10.txt");
        for(Integer a : tab){
         System.out.println(a);
        }
    }
}

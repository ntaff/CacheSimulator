package DirectMappedCache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Cache {

    private static final byte BLOCKSIZE = 32;
    private int nbLignes = 0;
    private static int[] cache = null;
    private static int n = 0;

    public Cache(int valOfN){

        this.cache = new int[(int)(Math.pow(2,valOfN))];
        this.n = valOfN;

    }

    public static int[] LoadFile(String file){
    int[] results = {0,0,0};
        try{
            BufferedReader buff = new BufferedReader(new FileReader(file));
            try {
                String line;
                while ((line = buff.readLine()) != null) {

                    String[] decompose = line.split(":");
                    int adresse = Integer.parseInt(decompose[0]);
                    int numLigne = (adresse/BLOCKSIZE)%((int)Math.pow(2,n));
                    int etiquette = (adresse/BLOCKSIZE)/((int)Math.pow(2,n));

                    if (cache[numLigne] == etiquette){
                      results[0]++;

                    } else {
                        results[1]++;
                        cache[numLigne] = etiquette;
                    }
                }

            } finally {
                buff.close();
            }
        } catch (IOException ioe) {
            System.out.println("Erreur --" + ioe.toString());
        }
        return results;
    }
}

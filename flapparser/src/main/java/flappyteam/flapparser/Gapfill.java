package flappyteam.flapparser;

import java.util.ArrayList;

/** */
public final class Gapfill {

    /**
     *
     */
    private Gapfill() {
    }

    /** */
    public static final int MAX_SIZE = 10;

    /**
     * @param chaine comment here
     * @return comment here
     */
    public static ArrayList<Reponse> parser(final String chaine) {
        int taille = chaine.length();
        char[] tableau = chaine.toCharArray();

        ArrayList<Reponse> liste = new ArrayList<Reponse>();

        int i, j;

        for (i = 0; i < taille; i++) {
            if (tableau[i] == '{') {
                String reponse = "";
                int tailleReponse = 0;
                for (j = (i + 1); j < taille; j++) {
                    if (tableau[j] != ' ') {
                        break;
                    }
                }
                for (; j < taille; j++) {
                    if (tableau[j] == ' ' || tableau[j] == '_') {
                        break;
                    }
                    reponse += tableau[j];
                }
                for (j++; j < taille; j++) {
                    if (tableau[j] == '}') {
                        break;
                    }
                    if (tableau[j] >= '0' && tableau[j] <= '9') {
                        tailleReponse *= MAX_SIZE;
                        tailleReponse += (tableau[j] - '0');
                    }
                }
                if (tailleReponse == reponse.length()) {
                    //pas d'erreur
                    liste.add(new Reponse(true, reponse));
                    i = j;
                }
            }
        }
        return liste;
    }
}

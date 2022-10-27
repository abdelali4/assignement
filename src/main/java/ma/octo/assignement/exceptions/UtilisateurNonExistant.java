package ma.octo.assignement.Utilisateur.utilis;

public class UtilisateurNonExistant extends Exception{

    private static final long serialVersionUID = 1;

    private static String message =  "Utilisateur Non existant";
    public UtilisateurNonExistant(){
        super(message);
    }

    public UtilisateurNonExistant(String m){
        super(m);
    }
}

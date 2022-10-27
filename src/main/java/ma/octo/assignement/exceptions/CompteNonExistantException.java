package ma.octo.assignement.Compte.utilis;

public class CompteNonExistantException  extends  Exception{

    private static final long serialVersionUID = 1;

    private static String message =  "Compte Non existant";

    public CompteNonExistantException(){
        super(message);
    }
    public CompteNonExistantException(String m){
        super(m);
    }
}

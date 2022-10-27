package ma.octo.assignement.Operations.utilis;

public class SoldeDisponibleInsuffisantException extends  Exception{

    private static final long serialVersionUID = 1;

    private static String message =  "";

    public SoldeDisponibleInsuffisantException(){
        super(message);
    }

    public SoldeDisponibleInsuffisantException(String m){
        super(m);
    }

}

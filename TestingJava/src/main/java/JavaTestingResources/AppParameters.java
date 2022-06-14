package JavaTestingResources;

public class AppParameters {
    // afegir-hi objectes connexio de Base de Dades

    public static final String DOMAIN = "127.0.0.1";
    public static final String PORT = "80";
//    public static final Object BD_CON = new ClasseConnexioBBDD();
//    public static final Object MESSAGES_TRANSLATIONS;

    //IMPLEMENTAR SINGLETON PATTERN
    private static final AppParameters instance = new AppParameters();
    private AppParameters(){


    }

    private void initApp(){

        // codi necessari per la inicialització de l'app

    }
    public void resetApp(){

        // codi per reconfigurar l'App
    }

    public static AppParameters getInstance (){

        //if ( instance == null){

          //  instance = new AppParameters();

        //}

        return instance;
    }
    public static String deployedURL(){
        return "https://" + DOMAIN + ":" + PORT;
    }

}

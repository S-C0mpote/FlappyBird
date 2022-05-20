package fr.supocompote.jeu;

public enum TypeTuyaux {
    HIGH("assets/images/tuyauHaut.png"),LOW("assets/images/tuyauBas.png");

    private final String path;

    TypeTuyaux(String path){
        this.path = path;
    }

    public String getPath(){
        return path;
    }

}

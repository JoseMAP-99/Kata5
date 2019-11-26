package kata5;

public class Main {
    public static void main(String[] args){
        String URL = "jdbc:sqlite:libraries/prueba.db";
        DataBase dataBase = new DataBase(URL);
        dataBase.open();
        dataBase.selectPEOPLE();
        dataBase.close();
    }    
}

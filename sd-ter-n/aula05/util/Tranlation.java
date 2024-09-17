import java.io.Serializable;

public class Tranlation implements Serializable {

    private String Word;
    private Language language;
    private Status status; 

    public Tranlation(String Word, Language language){
        this.Word = Word;
        this.language = language;
    }

    public Tranlation (String Word, Status status){
        this.Word = Word;
        this.status = status;
    }

    public String getWord(){
        return Word;
    }

    public Language getLanguage(){
        return language; 
    }

    public Status getStatus(){
        return status; 
    }
}

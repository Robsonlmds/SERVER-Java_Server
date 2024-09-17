import java.net.Socket;
import java.util.HashMap;

public class Attendant extends Thread{
    private Communication communication;

    public Attendant (Socket client){
        communication = new Communication(client);
    }

    @Override
    public void run(){

        Tranlation request = (Tranlation)communication.receive();

        String resposne = translate(request.getWord());

        if(resposne != null){

            communication.Send(new Tranlation(resposne, Status.SUCCESS));

        }else{

            communication.Send(new Tranlation(resposne, Status.NOT_FOUND));
        }

    } 

    private String translate(String Word){

            HashMap <String, String> dictionaryIngPort = new HashMap<>();

        dictionaryIngPort.put("red", "vermelho");
        dictionaryIngPort.put("blue", "azul");
        dictionaryIngPort.put("white", "branco");
        dictionaryIngPort.put("black", "preto");

        return dictionaryIngPort.get(Word);
    } 
}

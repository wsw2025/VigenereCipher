public class VigenereCipher {
    private String key;
    private String alphabet;

    public VigenereCipher(String key){
        this.key = "";
        for (int i = 0; i<key.length();i++){
            if(key.charAt(i)<='Z'){ //test whether it is uppercase
                this.key+=(char)(key.charAt(i)+32); //if it is, convert to lowercase
            }else{
                this.key+=key.charAt(i);
            }

        }
        alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }

    public String getKey(){
        return key;
    }

    public void setKey(String key){
        for (int i = 0; i<key.length();i++){
            if(key.charAt(i)<='Z'){ //test whether it is uppercase
                this.key+=(char)(key.charAt(i)+32); //if it is, convert to lowercase
            }else{
                this.key+=key.charAt(i);
            }

        }
    }

    public String getAlphabet(){
        return alphabet;
    }

    public String encode(String msg){
        String lwrMsg = ""; //string msg with caps converted to lowercase
        for (int i = 0; i<msg.length();i++){
            if(msg.charAt(i)<='Z' && msg.charAt(i)>='A'){ //test whether it is uppercase
                lwrMsg+=(char)(msg.charAt(i)+32); //if it is, convert to lowercase
            }else{
                lwrMsg+=msg.charAt(i);
            }

        }

        String encodedMsg = "";
        for (int i = 0; i < lwrMsg.length(); i++){
            if(alphabet.indexOf(lwrMsg.charAt(i))!=-1){ //check whether character can be converted
                int increment = key.charAt(i%(this.key.length()))-'a'; //shift value
//                System.out.println(i + " " + i%(this.key.length()));
//                System.out.println("increment: "+increment);
//                if(lwrMsg.charAt(i)+increment>'z'){ //if adding the shift value to the character will exceed alphabet end
//                    increment = -('z'-(increment-('z'-lwrMsg.charAt(i))));
//                }
                char c = lwrMsg.charAt(i);
                for (int j = 0; j < increment; j++){ //loop, increment letter by one each time. If exceed alphabet end, go to 'a'
                    c++;
                    if(c>'z') c='a';
                }
                encodedMsg+=c;
            }else{
                encodedMsg+=lwrMsg.charAt(i);
            }
        }
        return encodedMsg;
    }

    public String decode(String msg){

        String dencodedMsg = "";
        for (int i = 0; i < msg.length(); i++){
            if(alphabet.indexOf(msg.charAt(i))!=-1){ //check whether character can be converted
                int increment = key.charAt(i%(this.key.length()))-'a'; //shift value
//                System.out.println(i + " " + i%(this.key.length()));
//                System.out.println("increment: "+increment);
//                if(lwrMsg.charAt(i)+increment>'z'){ //if adding the shift value to the character will exceed alphabet end
//                    increment = -('z'-(increment-('z'-lwrMsg.charAt(i))));
//                }
                char c = msg.charAt(i);
                for (int j = 0; j < increment; j++){ //loop, increment letter by one each time. If exceed alphabet end, go to 'a'
                    c--;
                    if(c<'a') c='z';
                }
                dencodedMsg+=c;
            }else{
                dencodedMsg+=msg.charAt(i);
            }
        }
        return dencodedMsg;
    }

}

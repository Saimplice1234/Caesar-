import java.util.Random;

class Main {
  
  public static String encrypt_ceasar_cipher(int key,String msg){
    
        String x="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftA=x.substring(key);
        String shiftB=x.substring(0,key);
        String shiftedAlphabet=shiftA+shiftB;
        String encrypt="";
        String outputEncrypt="";
        int[] stateCase=new int[msg.length()];

        for(int i=0;i<msg.length();i++){
            
            char letter=msg.charAt(i);
            
            int indexOfLetter=x.indexOf(Character.toUpperCase(letter));
          
            if(Character.isLowerCase(letter)){
              stateCase[i]=0;
            }else{
              stateCase[i]=1;
            }
            if(Character.isLetter(letter) == true && indexOfLetter != -1){
              encrypt+=shiftedAlphabet.charAt(indexOfLetter);
            }else if(Character.isWhitespace(letter)  == true){
              encrypt+=" ";
            }else{
              encrypt+=letter;
            }
        }
    
       for(int index=0;index<stateCase.length;index++){
           char current=encrypt.charAt(index);
           if(stateCase[index] == 1){
             outputEncrypt+=Character.toUpperCase(current);
           }else{
             outputEncrypt+=Character.toLowerCase(current);
           }
       }
    
       return outputEncrypt;
  }
  
  public static String encrypt_ceasar_cipher_d_key(int keyA,int keyB,String msg){
    
        String x="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
        String shiftAKeyA=x.substring(keyA);
        String shiftBKeyA=x.substring(0,keyA);
        String shiftedAlphabetKeyA=shiftAKeyA+shiftBKeyA;

        String shiftAKeyB=x.substring(keyB);
        String shiftBKeyB=x.substring(0,keyB);
        String shiftedAlphabetKeyB=shiftAKeyB+shiftBKeyB;
    
        String encrypt="";
        String outputEncrypt="";
        int[] stateCase=new int[msg.length()];


        for(int i=0;i<msg.length();i++){
            
            char letter=msg.charAt(i);
            
            int indexOfLetter=x.indexOf(Character.toUpperCase(letter));
          
            if(Character.isLowerCase(letter)){
              stateCase[i]=0;
            }else{
              stateCase[i]=1;
            }
            if(Character.isLetter(letter) == true && indexOfLetter != -1){

              if(i % 2 == 0){
                encrypt+=shiftedAlphabetKeyA.charAt(indexOfLetter);
              }else if(i % 2 != 0){
                encrypt+=shiftedAlphabetKeyB.charAt(indexOfLetter);
              }
            }else if(Character.isWhitespace(letter)  == true){
              encrypt+=" ";
            }else{
              encrypt+=letter;
            }
        }

        for(int index=0;index<stateCase.length;index++){
           char current=encrypt.charAt(index);
           if(stateCase[index] == 1){
             outputEncrypt+=Character.toUpperCase(current);
           }else{
             outputEncrypt+=Character.toLowerCase(current);
           }
       }
    
       return outputEncrypt;
  }

  public static String decrypt_ceasar_cipher_brutF(String encrypted){
    for(int key=0;key<=25;key++){
      String encrypt=encrypt_ceasar_cipher(26-key,encrypted);
      if(key < 10){
        System.out.println("Key:"+"0"+key+" "+encrypt);
      }else{
        System.out.println("Key:"+key+" "+encrypt);
      }
    }
    return "";
  }
  public static String decrypt_ceasar_cipher_d_key(int keyA,int keyB,String message){
  
    String process=encrypt_ceasar_cipher_d_key(26-keyA,26-keyB,message);
    return process;
    
  }

  public static void decrypt_ceasar_d_key_BF(String message,int key){

    if(key <=25){
     for(int i=0;i<=25;i++){
       String process=encrypt_ceasar_cipher_d_key(26-key,26-i,message);
       System.out.println("Key A: "+key+" Key B: "+i+" "+process);
     }
      System.out.println("***************************************************");
  
      decrypt_ceasar_d_key_BF(message,key+1);
    }  
    
  }
  
  public static void main(String[] args) {
      String msg="Hfs cpwewloj loks cd Hoto kyg Cyy.";
      decrypt_ceasar_d_key_BF(msg,1);  
  }
}
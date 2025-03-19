package bouda.med.company.shared;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.Random;
import java.util.UUID;


public class CodeGenerator {
    
    private static final int CODE_LENTH = 6 ;
    private final SecureRandom random = new SecureRandom();

     public String generateUniqueNumber() {
        
        long timestamp = Instant.now().toEpochMilli();

        
        String timestampStr = String.valueOf(timestamp);

        
        int randomDigitsLength = 15 - timestampStr.length();
        StringBuilder randomDigits = new StringBuilder();

        for (int i = 0; i < randomDigitsLength; i++) {
            randomDigits.append(random.nextInt(10));
        }

        return timestampStr + randomDigits.toString();
    }

    public String generateCode() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        
        for (int i = 0; i < CODE_LENTH; i++) {
            sb.append(random.nextInt(10)); 
        }

        return sb.toString();
    }

    public String generateCode(int length){

        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10)); 
        }

        return sb.toString();


    }

    public String generateCodeUnique(int length) {
        return UUID.randomUUID().toString().replace("-", "").substring(0, length);
    }



}

package bouda.med.company.user.PublicService;

import java.io.IOException;

import com.itextpdf.text.DocumentException;

public interface PublicService {

    byte[] getRenioSumary(String id) throws DocumentException, IOException ;

    byte[] getRenioSumaryOld(String id) throws DocumentException, IOException ;
    
}

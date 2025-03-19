package bouda.med.company.services.File;

import java.io.IOException;

import com.itextpdf.text.DocumentException;

import bouda.med.company.models.Projet;

public interface FileRenionService {

    public byte[] generateRenionSumary(Projet projet) throws DocumentException, IOException;


    public byte[] generateRenionSumaryOld(Projet projet) throws DocumentException, IOException ;



    
}

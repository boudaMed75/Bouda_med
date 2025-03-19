package bouda.med.company.user.PublicService;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.itextpdf.text.DocumentException;

import bouda.med.company.services.File.FileRenionService;
import bouda.med.company.services.Projet.ProjetService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PublicServiceImpl implements PublicService{

    private final ProjetService projetService;
    private final FileRenionService fileRenionService;

    @Override
    public byte[] getRenioSumary(String id) throws DocumentException, IOException {
        return fileRenionService.generateRenionSumary(projetService.findById(id));
    }

    @Override
    public byte[] getRenioSumaryOld(String id) throws DocumentException, IOException {
        return fileRenionService.generateRenionSumaryOld(projetService.findById(id));
    }

    

    


    
}

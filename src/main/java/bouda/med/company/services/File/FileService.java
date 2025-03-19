package bouda.med.company.services.File;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {


    public String extractFileExtension(String fileName);

    public void saveFile(MultipartFile file,String fileName) throws IllegalStateException, IOException;


    
}

package bouda.med.company.services.File;


import java.io.File;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import bouda.med.company.exception.InternalServerError;
import io.jsonwebtoken.io.IOException;

@Service
public class FileProfileService implements FileService{

    @Override
    public String extractFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    @Override
    public void saveFile(MultipartFile file, String fileName) throws IllegalStateException, java.io.IOException {
        try{
            String uploadDir = System.getProperty("user.dir") + "/uploads/imgProfil/null_0db36cf4.png" ;
            File uploadDirFile = new File(uploadDir);

            if (!uploadDirFile.exists()) {
                boolean mkdirs = uploadDirFile.mkdirs();
                if (!mkdirs) {
                    throw new InternalServerError("Failed to create upload directory");
                }
            }
            File uploadFile = new File(uploadDir + fileName + this.extractFileExtension(file.getOriginalFilename()));
            file.transferTo(uploadFile);
        }
        catch(IOException e){
            throw new InternalServerError(e.getMessage());
        }
    }
    
}

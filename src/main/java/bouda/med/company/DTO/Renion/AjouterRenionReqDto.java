package bouda.med.company.DTO.Renion;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AjouterRenionReqDto {

    private Date date ;

    private String titre ;

    private String type ; 
    private LocalTime heure;
    private String lieu;

    private String projet ;

    
}

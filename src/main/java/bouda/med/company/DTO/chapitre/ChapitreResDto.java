package bouda.med.company.DTO.chapitre;

import java.util.List;

import bouda.med.company.DTO.tache.TachesResDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChapitreResDto {

    private String id;
    private String name ;
    private String description ;

    private List<TachesResDto> tachesResDtos;
    
}

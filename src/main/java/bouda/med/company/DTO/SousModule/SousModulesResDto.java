package bouda.med.company.DTO.SousModule;

import java.util.Date;
import java.util.List;

import bouda.med.company.DTO.chapitre.ChapitreResDto;
import bouda.med.company.DTO.chapitre.ChapitreResSimpleDto;
import bouda.med.company.models.Chapitre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SousModulesResDto {

    private String id;
    private String name ;
    private String description ;
    private Date start_date ;
    private Date end_date ;
    private Boolean active ;
    private List<ChapitreResSimpleDto> chapitre;
    
}

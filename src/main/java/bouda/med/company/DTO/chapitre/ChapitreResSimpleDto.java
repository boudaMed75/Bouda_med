package bouda.med.company.DTO.chapitre;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ChapitreResSimpleDto {
    private String id;
    private String name ;
    private String description ;

}

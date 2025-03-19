package bouda.med.company.DTO.SousModule;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SousModulesSimpleResDto {
    
    private String id;
    private String name ;
    private String description ;
    private Date start_date ;
    private Date end_date ;
    private Boolean active ;
}

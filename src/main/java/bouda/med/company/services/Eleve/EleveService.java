package bouda.med.company.services.Eleve;

import bouda.med.company.DTO.Eleve.DemandeEleveDto;

public interface EleveService {
    

    public void ajouter(DemandeEleveDto req);

    public void accepter(Long id);

    public void refus(Long id);


    
    
}

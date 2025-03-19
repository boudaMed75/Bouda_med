package bouda.med.company.services.Eleve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bouda.med.company.DTO.Eleve.DemandeEleveDto;
import bouda.med.company.dao.ParticipantDao;
import bouda.med.company.exception.EntityNotFoundException;
import bouda.med.company.models.Participant;

@Service
public class EleveAdmin implements EleveService{

    @Autowired
    private ParticipantDao participantDao;

    @Override
    public void ajouter(DemandeEleveDto req) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ajouter'");
    }

    @Override
    public void accepter(Long id) {
        Participant eleve = participantDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Eleve Not Found")) ;

        eleve.setStatus(true);

    }

    @Override
    public void refus(Long id) {
        Participant eleve = participantDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Eleve Not Found")) ;

        eleve.setStatus(false);
    }
    
}

package bouda.med.company.services.Eleve;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bouda.med.company.DTO.Eleve.DemandeEleveDto;
import bouda.med.company.dao.ParticipantDao;
import bouda.med.company.exception.EntityAlreadyExistsException;
import bouda.med.company.models.Participant;

@Service
public class EleveImp1 implements EleveService{

    @Autowired
    private ParticipantDao participantDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void ajouter(DemandeEleveDto req) {

        participantDao.findByEmail(req.getEmail()).orElseThrow(()-> new EntityAlreadyExistsException("Eleve deja exist dans la base de donne "));

        Participant eleve = modelMapper.map(req,Participant.class);
        eleve.setStatus(false);

        participantDao.save(eleve);
        
    }

    @Override
    public void accepter(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accepter'");
    }

    @Override
    public void refus(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'refus'");
    }

    
    
}

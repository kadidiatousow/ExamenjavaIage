package Services;

import java.util.List;
import Entities.Professeur;

import Repository.ProfesseurRepository;

public class ProfesseurService {
    ProfesseurRepository professeurRepository=new ProfesseurRepository();
   
   public  List<Professeur>listerProfesseurs(){
    
        return professeurRepository.selectAll();
    }
}


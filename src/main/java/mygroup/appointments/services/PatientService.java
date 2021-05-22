package mygroup.appointments.services;


import mygroup.appointments.domain.Patient;
import mygroup.appointments.exceptions.PatientNotFoundExcep;
import mygroup.appointments.repositories.PatientRepository;
import mygroup.appointments.requests.UpdatePatientRequest;
import mygroup.appointments.specs.PatientSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Page<Patient> getAllpatientsBySpec(PatientSpec patientSpec,Pageable pageable){
        return patientRepository.findAll((Specification) patientSpec,pageable);
    }
    public Patient getPatientById(Long patientId) throws PatientNotFoundExcep {
        Optional<Patient> patient=patientRepository.findById(patientId);
        if(patient.isEmpty()){
            throw new PatientNotFoundExcep("No patient with such id");
        }
        return patient.get();
    }
    public Patient createPatient(Patient patient){
        return patientRepository.save(patient);
    }
    public void deletePatient(Long patientId) throws PatientNotFoundExcep{
        Patient patient=getPatientById(patientId);
        patientRepository.delete(patient);
    }
    public Patient updatePatient(Long patientId, UpdatePatientRequest patientRequestChanges){
        Patient patient=getPatientById(patientId);

        if(patientRequestChanges.getPhone()!=null){
            patient.setPhone(patientRequestChanges.getPhone());
        }
        if(patientRequestChanges.getAddress()!=null){
            patient.setAddress(patientRequestChanges.getAddress());
        }
        if(patientRequestChanges.getCity()!=null){
            patient.setCity(patientRequestChanges.getCity());
        }
        patientRepository.save(patient);
        return patient;
    }


}

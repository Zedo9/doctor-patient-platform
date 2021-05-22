package mygroup.appointments.controllers;


import mygroup.appointments.domain.Appointment;
import mygroup.appointments.domain.Patient;
import mygroup.appointments.exceptions.PatientNotFoundExcep;
import mygroup.appointments.requests.UpdatePatientRequest;
import mygroup.appointments.services.AppointmentService;
import mygroup.appointments.services.PatientService;
import mygroup.appointments.specs.PatientSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/patients")
public class PatientController {

    private final PatientService patientService;
    private final AppointmentService appointmentService;

     @Autowired
    public PatientController(PatientService patientService, AppointmentService appointmentService) {
        this.patientService = patientService;
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public ResponseEntity<Page<Patient>> getPatients(PatientSpec patientSpec, Pageable pageable){
         return new ResponseEntity<>(
                 (Page<Patient>) patientService.getAllpatientsBySpec(patientSpec,pageable),HttpStatus.OK
         );
    }

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient){
         return new ResponseEntity<>(
                 patientService.createPatient(patient),HttpStatus.CREATED

         );

    }
    @GetMapping(path="/{patientId}/appointments")
    public ResponseEntity<Page<Appointment>> getPatientAppointments(@PathVariable Long patientId, Pageable pageable)throws PatientNotFoundExcep {
         return new ResponseEntity<>(
                 appointmentService.getPatientAppointments(patientId,pageable),HttpStatus.OK
         );
    }
    @GetMapping(path="/{patientId}")
    public ResponseEntity<Patient> getPatient(@PathVariable Long patientId) throws PatientNotFoundExcep{
         return new ResponseEntity<>(patientService.getPatientById(patientId),HttpStatus.OK);
    }

    @PatchMapping("/{patientId}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long patientId, @RequestBody UpdatePatientRequest body) throws PatientNotFoundExcep{
         Patient patient=patientService.updatePatient(patientId,body);
         return new ResponseEntity<>(patient,HttpStatus.OK);
    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<Void> removePatient(@PathVariable Long patientId) throws PatientNotFoundExcep{
         patientService.deletePatient(patientId);
         return ResponseEntity.ok().build();
    }




}

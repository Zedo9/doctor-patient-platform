package mygroup.appointments.controllers;

import mygroup.appointments.domain.Appointment;
import mygroup.appointments.exceptions.AppointmentNotFoundException;
import mygroup.appointments.requests.UpdateAppointmentRequest;
import mygroup.appointments.services.AppointmentService;
import mygroup.appointments.services.DoctorService;
import mygroup.appointments.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;
    private final PatientService patientService;
    private final DoctorService doctorService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService, PatientService patientService, DoctorService doctorService) {
        this.appointmentService = appointmentService;
        this.patientService = patientService;
        this.doctorService = doctorService;
    }
    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment){
        return new ResponseEntity<>(appointmentService.createAppointment(appointment), HttpStatus.CREATED);
    }
    @PatchMapping("/{doctorId}/{appointmentId}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long appointmentId,@PathVariable Long doctorId,@RequestBody UpdateAppointmentRequest body){
        Appointment appointment=appointmentService.updateAppointment(appointmentId,doctorId,body);
        return new ResponseEntity<>(appointment,HttpStatus.OK);
    }
    @GetMapping(path="/{doctorId}/{appointmentId}")
    public ResponseEntity<Appointment> getAppointment(@PathVariable Long appointmentId,@PathVariable Long doctorId) throws AppointmentNotFoundException{


     return null;
    }

}

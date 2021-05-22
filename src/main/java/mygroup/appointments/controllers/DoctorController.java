package mygroup.appointments.controllers;

import mygroup.appointments.services.AppointmentService;
import mygroup.appointments.services.DoctorService;
import mygroup.appointments.requests.UpdateDoctorRequest;
import mygroup.appointments.domain.*;
import mygroup.appointments.exceptions.DoctorNotFoundException;
import mygroup.appointments.specs.DoctorSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    private final DoctorService doctorService;
    private final AppointmentService appointmentService;

    @Autowired
    public DoctorController(DoctorService doctorService, AppointmentService appointmentService){
        this.doctorService = doctorService;
        this.appointmentService = appointmentService;
    }

    // https://blog.tratif.com/2017/11/23/effective-restful-search-api-in-spring/
    @GetMapping
    public ResponseEntity<Page<Doctor>> getDoctors(DoctorSpec doctorSpec, Pageable pageable){
        return new ResponseEntity<>(
                (Page<Doctor>) doctorService.getAllDoctorsBySpec(doctorSpec, pageable),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        return new ResponseEntity<>(doctorService.createDoctor(doctor), HttpStatus.CREATED);
    }

    @GetMapping(path="/{doctorId}/appointments")
    public ResponseEntity<Page<Appointment>> getAppointmentsForDoctor  (
            @PathVariable Long doctorId,
            Pageable pageable) throws DoctorNotFoundException {
        return new ResponseEntity<>(
                appointmentService.getAppointmentsForDoctor(doctorId,pageable), HttpStatus.OK);
    }

    @GetMapping(path = "/{doctorId}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable Long doctorId) throws DoctorNotFoundException {
        return new ResponseEntity<>(doctorService.getDoctorById(doctorId), HttpStatus.OK);
    }

    @PatchMapping("/{doctorId}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long doctorId, @RequestBody UpdateDoctorRequest body) throws DoctorNotFoundException{
        Doctor doctor = doctorService.patchDoctor(doctorId, body);
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

    @DeleteMapping("/{doctorId}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long doctorId) throws DoctorNotFoundException {
        doctorService.deleteDoctor(doctorId);
        return ResponseEntity.ok().build();
    }
}


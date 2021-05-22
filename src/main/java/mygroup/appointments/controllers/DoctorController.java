package mygroup.appointments.controllers;

import mygroup.appointments.Services.AppointmentService;
import mygroup.appointments.Services.DoctorService;
import mygroup.appointments.UpdateDoctorRequest;
import mygroup.appointments.domain.*;
import mygroup.appointments.exception.DoctorNotFoundException;
import mygroup.appointments.specs.DoctorSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.Map;

/*TODO
GET /api/doctor/{doctorId}/appointments
POST /api/doctor/{doctorID}/appointments
GET /api/doctor/{doctorID}/appointments/{appointmentID}
PUT /api/doctor/{doctorID}/appointments/{appointmentID} // Status - Date - Time - Notes

PUT /api/doctors/{doctorId}
*/
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
        return new ResponseEntity<Page<Doctor>>(
                (Page<Doctor>) doctorService.getAllDoctorsBySpec(doctorSpec, pageable),
                HttpStatus.OK);
    }

    @GetMapping(path="/{doctorId}/appointments")
    public ResponseEntity<Page<Appointment>> getAppointmentsForDoctor  (
            @PathVariable Long doctorId,
            Pageable pageable) throws DoctorNotFoundException {
        return new ResponseEntity<Page<Appointment>>(
                appointmentService.getAppointmentsForDoctor(doctorId,pageable), HttpStatus.OK);
    }

    @GetMapping(path = "/{doctorId}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable Long doctorId) throws DoctorNotFoundException {
        return new ResponseEntity<Doctor>(doctorService.getDoctorById(doctorId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        return new ResponseEntity<Doctor>(doctorService.createDoctor(doctor), HttpStatus.CREATED);
    }

    @PatchMapping("/{doctorId}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long doctorId, @RequestBody UpdateDoctorRequest body){
        Doctor doctor = doctorService.patchDoctor(doctorId, body);
        return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
    }
}


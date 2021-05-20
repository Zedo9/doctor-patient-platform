package mygroup.appointments.controllers;

import mygroup.appointments.Services.DoctorService;
import mygroup.appointments.domain.*;
import mygroup.appointments.specs.DoctorSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*TODO
GET /api/doctor/{doctorId}/appointments
POST /api/doctor/{doctorID}/appointments
GET /api/doctor/{doctorID}/appointments/{appointmentID}
PUT /api/doctor/{doctorID}/appointments/{appointmentID} // Status - Date - Time - Notes

PUT /api/doctors/{doctorId}

Patients Controller
GET /api/patients/{patientId}/appointments
POST /api/patients/{patientId}/appointments
GET /api/patients/{patientId}/appointments/{appointmentID}

PUT /api/patients/{patientId}
 */
@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }

    // https://blog.tratif.com/2017/11/23/effective-restful-search-api-in-spring/
    @GetMapping
    public Page<Doctor> getDoctors(DoctorSpec doctorSpec, Pageable pageable){
        return doctorService.getAllDoctorsBySpec(doctorSpec, pageable);
    }

    @GetMapping(path = "/{doctorId}")
    public Doctor getDoctor(@PathVariable Long doctorId) throws Exception {
        return doctorService.getDoctorById(doctorId)
                .orElseThrow(Exception::new);//TODO Handle this exception
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorService.createDoctor(doctor);
    }

    @DeleteMapping("/{doctorId}")
    public ResponseEntity<?> deleteDoctor(@PathVariable Long doctorId) throws Exception {
        // TODO handle Exception
        doctorService.deleteDoctor(doctorId);
        return null; // TODO Will be replaced with error code in response
    }
}


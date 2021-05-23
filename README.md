# Doctor and Patients Appointment Managment System

## TODO

- Doctor Controller : Chedly

  - [x] GET /api/v1/doctors/{doctorId}/appointments (Sortable - Pageable)
  - [x] PATCH /api//v1/doctors/{doctorId} (Should only be accessed by the doctor himself)

- Appointments Controller : Mouwahed

  - [x] POST /api/v1/appointments
  - [x] PATCH /api/v1/appointments ( Status - Date - Time - Notes / Should on be accessed by a doctor)
  - [x] GET /api/v1/appointments/{appointmentID}

- Patients Controller : Mouwahed

  - [x] GET /api/v1/patients/{patientId}/appointments (Sortable - Pageable)
  - [x] GET /api/v1/patients/{patientId}/appointments/{appointmentID}
  - [x] PATCH /api/v1/patients/{patientId} (Should only be accessed by the patient himself)

- User Auth ESLEM (https://javatodev.com/spring-boot-jwt-authentication/) :

  - [ ] Add Spring Security
  - [ ] ReferralID (https://www.baeldung.com/spring-request-param)
  - [ ] User Confirmation
  - [ ] JWT

- Aspects : Chedly
  - [x] Logging Aspect
  - [x] Global Exception Handler
- Exceptions :
  - [x] Exceptions

## Good articles and resources

- [Managing multiple request params with Spring](https://blog.tratif.com/2017/11/23/effective-restful-search-api-in-spring/)
- [Spring Profiling aspect](https://howtodoinjava.com/spring-boot2/logging/performance-logging-aspectj-aop/)
- [Full logging aspect](https://makeinjava.com/logging-aspect-restful-web-service-spring-aop-request-response/)
- [Exception Handling](https://blog.devgenius.io/rest-api-exception-handling-in-spring-boot-d6b3272e7e21)
- [Pagination in Spring REST APIs](https://www.javadevjournal.com/spring/rest-pagination-in-spring/)
- [Exception Handling solutions](https://springframework.guru/exception-handling-in-spring-boot-rest-api/)
- [Exception handling best practices](https://howtodoinjava.com/best-practices/java-exception-handling-best-practices/)
- [Project structure and best practices](https://medium.com/the-resonant-web/spring-boot-2-0-project-structure-and-best-practices-part-2-7137bdcba7d3)
- [JWT Auth with Spring Security](https://javatodev.com/spring-boot-jwt-authentication/)
- [Real World Example app](https://github.com/gothinkster/spring-boot-realworld-example-app)

## User stories and features

- A user can create and manage his account, he can refer other users to sign up in order to obtain special offers/gifts.
- A user has to confirm his account in order to obtain full functionality access.
- A user can be a Doctor or a Patient.

### Doctors

A **Doctor**, in addition to his normal user abilities, can :

1. Create/Read/Update/Delete(Cancel) an appointment.
2. Checkout patients that have already had an appointment with him.
3. Accept or reject appointments requested by a patient.
4. List future appointments in a calendar.
5. Update his contact information.

### Patients

A **Patient**, in addition to his normal user abilities, can :

1. List all Doctors affiliated with this service and sort them by city/speciality...
2. Request an appointment with any doctor.
3. List his history of Appointments with any doctor.
4. List future appointments in a calendar.
5. Update his contact information.

## Entity Relationship Model

[ER Diagram Link](https://drive.google.com/file/d/1DUD2y6Z2Ej43MxXln2_BN-1rasQEu8Ne/view?ts=602ae58a)
![ERD](docs/ER.png)

## Front-end flow

![frontend](docs/frontend.png)

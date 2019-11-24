package com.robertsonwebdev.sunshadersrestservice.controllers;

        import com.robertsonwebdev.sunshadersrestservice.Appointment;
        import com.robertsonwebdev.sunshadersrestservice.AppointmentRepository;
        import com.robertsonwebdev.sunshadersrestservice.User;
        import com.robertsonwebdev.sunshadersrestservice.UserRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/scheduler")
public class SchedulerController {

    private final UserRepository userRepository;
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public SchedulerController(UserRepository userRepository, AppointmentRepository appointmentRepository){
        this.userRepository = userRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @GetMapping(path = "/login")
    public String customerLogin(){
        return "userLogin";
    }

    @PostMapping(path = "/schedule")
    public String appointmentScheduleRedirect(@RequestParam String email, Model model){
        User dbUser = userRepository.findByEmail(email);
        if (dbUser == null){
            return "userNotFound";
        } else {
            model.addAttribute("customerFirst", dbUser.getFirstname());
            model.addAttribute("customerLast", dbUser.getLastname());
            model.addAttribute("appointment", new Appointment());
            return "scheduler";
        }
    }

    @PostMapping(path = "/confirmation")
    public String appointmentScheduleForm(@ModelAttribute Appointment appointment, Model model){
        try {
            appointmentRepository.save(appointment);
            model.addAttribute(appointment);
            return "confirmation";
        } catch (Exception ex){
            return "redirect:/error";
        }

    }

    @GetMapping(path = "/register")
    public String userRegistration(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping(path = "/register")
    public String createNewUser(@ModelAttribute User user){
        userRepository.save(user);
        return "redirect:/scheduler/login";
    }

    @PostMapping(path = "/booking")
    public String bookCustomerAppointment(@ModelAttribute Appointment appointment, Model model){
        model.addAttribute("appointment", appointment);
        appointmentRepository.save(appointment);
        return "confirmation";
    }
}

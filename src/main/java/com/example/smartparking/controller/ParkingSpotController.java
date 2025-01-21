package com.example.smartparking.controller;

import com.example.smartparking.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ParkingSpotController {
    private final ParkingLotService parkingLotService;

    @Autowired
    public ParkingSpotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @GetMapping("/")
    public String viewParkingSpots(Model model) {
        model.addAttribute("spots", parkingLotService.getAllSpots());
        return "index";
    }

    @PostMapping("/reserve/{id}")
    public String reserveSpot(@PathVariable int id, RedirectAttributes redirectAttributes) {
        parkingLotService.reserveSpot(id);
        redirectAttributes.addFlashAttribute("message", "spot " + id + " has been reserved");
        return "redirect:/";
    }

    @PostMapping("/release/{id}")
    public String releaseSpot(@PathVariable int id, RedirectAttributes redirectAttributes) {
        parkingLotService.releaseSpot(id);
        redirectAttributes.addFlashAttribute("message", "spot " + id + " has been released");
        return "redirect:/";
    }
}

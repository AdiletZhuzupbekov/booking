package kg.megacom.booking.controller;

import kg.megacom.booking.microservices.json.HotelServiceResponse;
import kg.megacom.booking.service.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private final HotelService hotelService;

    public HomeController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/https://booking-kg.herokuapp.com/")
    public String homePage(Model model){
        model.addAttribute("title","Booking");
        HotelServiceResponse[] hotels = hotelService.getHotels();
        model.addAttribute("hotels", hotels);
        return "home";
    }
    @GetMapping("/findByCity")
    public String findByCity(Model model, @RequestParam(required = false) String city){
        HotelServiceResponse[] hotels = hotelService.findByCity(city);
        model.addAttribute("hotels", hotels);
        return "home";
    }
}

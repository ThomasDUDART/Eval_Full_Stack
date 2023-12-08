package fr.polytech.cours.controller;

import fr.polytech.cours.dto.request.AddRestaurantDto;
import fr.polytech.cours.dto.response.RestaurantDto;
import fr.polytech.cours.dto.response.UrlDto;
import fr.polytech.cours.service.RestaurantService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
public class RestaurantController {

    private final RestaurantService restauService;

    public RestaurantController(RestaurantService restauService) {
        this.restauService = restauService;
    }

    @GetMapping("/restau")
    public List<RestaurantDto> getRestaurant() {
        return this.restauService.getAllRestau();
    }

    @PostMapping("/restau")
    public RestaurantDto addRestaurant(@Valid @RequestBody AddRestaurantDto restauToCreate) {
        return this.restauService.addRestaurant(restauToCreate);
    }

    @GetMapping("/restau/{id}/cover")
    public UrlDto getRestauCoverById(@PathVariable Integer id) {
        return UrlDto.builder().url(this.restauService.getCoverDownloadUrl(id)).build();
    }

    @PutMapping("/restau/{id}/cover")
    public UrlDto putRestauCoverById(@PathVariable Integer id) {
        return UrlDto.builder().url(this.restauService.putCoverDownloadUrl(id)).build();
    }

}

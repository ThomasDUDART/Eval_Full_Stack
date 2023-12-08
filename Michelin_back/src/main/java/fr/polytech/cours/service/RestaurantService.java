package fr.polytech.cours.service;

import fr.polytech.cours.dto.request.AddRestaurantDto;
import fr.polytech.cours.dto.response.RestaurantDto;
import fr.polytech.cours.entity.RestaurantEntity;
import fr.polytech.cours.exception.ResourceNotFoundException;
import fr.polytech.cours.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final List<RestaurantDto> restaus = new ArrayList<>();

    private final S3Service s3Service;

    private final RestaurantRepository restaurantRepository;


    public List<RestaurantDto> getAllRestau() {
        return this.restaus;
    }

    public RestaurantDto addRestaurant(AddRestaurantDto addRestaurantDto) {
        final RestaurantDto result = RestaurantDto.builder().nom(addRestaurantDto.getNom()).build();
        this.restaus.add(result);

        return result;
    }

    public String putCoverDownloadUrl(final Integer restauId) {
        this.getRestauById(restauId);

        return this.s3Service.putDownloadUrl("ThomasRestau" + restauId);
    }

    public String getCoverDownloadUrl(final Integer restauId) {
        this.getRestauById(restauId);

        return this.s3Service.getDownloadUrl("ThomasRestau" + restauId);
    }

    public RestaurantEntity getRestauById(Integer restauId) {
        return this.restaurantRepository.findById(restauId).orElseThrow(() -> new ResourceNotFoundException("Livre with id " + restauId + " + not found"));
    }
}

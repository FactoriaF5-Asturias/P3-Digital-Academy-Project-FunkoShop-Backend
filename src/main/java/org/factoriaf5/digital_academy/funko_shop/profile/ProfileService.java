package org.factoriaf5.digital_academy.funko_shop.profile;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;


@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public Optional<Profile> getProfileById(Long id) {
        return profileRepository.findById(id);
    }

    public Profile saveProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }

    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public Profile updateProfile(Long id, @Valid ProfileDTO profileDTO) {
        return profileRepository.findById(id)
                .map(existingProfile -> {
                    existingProfile.setFirstName(profileDTO.getFirstName());
                    existingProfile.setLastName(profileDTO.getLastName());
                    existingProfile.setStreet(profileDTO.getStreet());
                    existingProfile.setPhoneNumber(profileDTO.getPhoneNumber());
                    existingProfile.setCity(profileDTO.getCity());
                    existingProfile.setRegion(profileDTO.getRegion());
                    existingProfile.setPostalCode(profileDTO.getPostalCode());
                    existingProfile.setCountry(profileDTO.getCountry());
                    existingProfile.isShipping();
                    existingProfile.isSuscribed();

                    return profileRepository.save(existingProfile);
                })
                .orElseThrow(() -> new RuntimeException("Profile not found with id " + id));
    }

    

    
}
package guru.springframework.sfgdi.config;

import PetServices.PetService;
import PetServices.PetServiceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

public class PetServiceConfig {

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("dog");
    }

    @Profile({"cat"})
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
    }
}

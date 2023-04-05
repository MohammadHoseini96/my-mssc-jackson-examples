package kian.springframework.mymsscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

/**
 * Created By Kian on 2023-04-05.
 */

// This way of defining naming strategy of the output json doesn't use application-profile.properties!
@JsonTest
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BeerDtoTestWithNamingStrategies extends BeerLoader {

    @Test
    void testSerialization() throws JsonProcessingException {

        BeerDto beerDto = getDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        System.out.println(jsonString);
    }

}

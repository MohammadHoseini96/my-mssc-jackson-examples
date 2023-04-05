package kian.springframework.mymsscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created By Kian on 2023-04-05.
 */

// Basic usage and testing of jsons with Jackson
@JsonTest
// We create a new profile called snake using application-snake.properties
// to set naming property of the output jason
@ActiveProfiles("snake")
class BeerDtoTest extends BeerLoader {

    // property names in jsonString will be snake case!
    @Test
    void testSerialization() throws JsonProcessingException {

        BeerDto beerDto = getDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        System.out.println(jsonString);
    }

    @Test
    void testDeserialize() throws IOException {

        // since id in BeerDto uses @JasonProperty, we should use the annotation value which is beerId in jason strings.
        String jsonString = "{\"beer_name\":\"BeerName\",\"beer_style\":\"Ale\",\"upc\":123123123123,\"price\":\"12.99\",\"created_date\":\"2023-04-06T01:13:21+0330\",\"last_updated_date\":\"2023-04-06T01:13:21.2260227+03:30\",\"my_local_date\":\"20230406\",\"beerId\":\"0cefeb3d-8980-4fba-8cb1-d2c34fdcb729\"}\n";

        BeerDto beerDto = objectMapper.readValue(jsonString, BeerDto.class);

        System.out.println(beerDto);
    }

    // Another way of setting property naming strategy is setting it with setters and no need for profiles!
    @Test
    public void createdInstanceIsIsolatedTest() {

        final ObjectMapper first = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        final ObjectMapper second = new ObjectMapper();

        // Precondition
        assertNotEquals(first, second);

        // Do
        // pass..

        // Verify
        assertNotSame(first.getPropertyNamingStrategy(), second.getPropertyNamingStrategy());
    }

}
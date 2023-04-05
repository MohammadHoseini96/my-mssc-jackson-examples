package kian.springframework.mymsscjacksonexamples.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Created By Kian on 2023-04-05.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

    @JsonProperty("beerId") // This will override NamingPropertyStrategy.
    @Null
    private UUID id;

    @NotBlank
    private String beerName;

    @NotBlank
    private String beerStyle;

    @Positive
    private Long upc;

    // We json formats we can change the way we output some specific properties
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal price;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ",shape = JsonFormat.Shape.STRING)
    private OffsetDateTime createdDate;
    private OffsetDateTime lastUpdatedDate;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate myLocalDate;
}
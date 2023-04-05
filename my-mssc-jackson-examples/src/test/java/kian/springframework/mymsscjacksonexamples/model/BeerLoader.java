package kian.springframework.mymsscjacksonexamples.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Created By Kian on 2023-04-05.
 */
public abstract class BeerLoader {

 @Autowired
 ObjectMapper objectMapper;

 BeerDto getDto(){
  return  BeerDto.builder()
          .beerName("BeerName")
          .beerStyle("Ale")
          .id(UUID.randomUUID())
          .createdDate(OffsetDateTime.now())
          .lastUpdatedDate(OffsetDateTime.now())
          .price(new BigDecimal("12.99"))
          .upc(123123123123L)
          .myLocalDate(LocalDate.now())
          .build();
 }
}
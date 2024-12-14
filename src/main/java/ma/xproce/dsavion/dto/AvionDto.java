package ma.xproce.dsavion.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AvionDto {
    String model;
    String color;
    String matricul;
    double price;

}
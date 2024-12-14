package ma.xproce.dsavion;

import ma.xproce.dsavion.dao.entities.Avion;
import ma.xproce.dsavion.dto.AvionDto;
import ma.xproce.dsavion.service.AvionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DsavionApplication {

    public static void main(String[] args) {
        SpringApplication.run(DsavionApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AvionService avionService){
        return  args -> {
            avionService.saveAvions(
                    List.of(
                            AvionDto.builder().model("model1").color("red").matricul("sdf64w6e").price(12345).build(),
                            AvionDto.builder().model("model2").matricul("ef6e+6").color("green").price(65489).build(),
                            AvionDto.builder().model("model3").matricul("ef64we8").color("yellow").price(89789).build(),
                            AvionDto.builder().model("model4").matricul("wrdqwqw").color("black").price(67489).build()
                    )

            );
        };
    }
}

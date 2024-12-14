package ma.xproce.dsavion.mapper;

import ma.xproce.dsavion.dao.entities.Avion;
import ma.xproce.dsavion.dto.AvionDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AvionMapper {

    private final ModelMapper mapper = new ModelMapper();
    public Avion fromAvionDtoToAvion(AvionDto avionDto){
        return mapper.map(avionDto, Avion.class);
    }

    public AvionDto fromAvionToAvionDto(Avion avion){
        return mapper.map(avion, AvionDto.class);
    }

}

package ma.xproce.dsavion.service;

import ma.xproce.dsavion.dto.AvionDto;

import java.util.List;

public interface AvionService {
    public AvionDto saveAvion(AvionDto avionDto);

    public boolean deleteAvion(Long id);

    public List<AvionDto> getAvionByModel(String model);

    public List<AvionDto> getAvionByModelAndPrice(String model, double price);

    public List<AvionDto> saveAvions(List<AvionDto> avionDtos);

}

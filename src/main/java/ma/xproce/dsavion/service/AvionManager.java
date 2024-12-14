package ma.xproce.dsavion.service;

import lombok.AllArgsConstructor;
import ma.xproce.dsavion.dao.entities.Avion;
import ma.xproce.dsavion.dao.repositories.AvionRepository;
import ma.xproce.dsavion.dto.AvionDto;
import ma.xproce.dsavion.mapper.AvionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
@AllArgsConstructor
public class AvionManager implements AvionService {

    private AvionRepository avionRepository;
    private AvionMapper avionMapper;

    @Override
    public AvionDto saveAvion(AvionDto avionDto) {
        Avion avion = avionMapper.fromAvionDtoToAvion(avionDto);
        avion = avionRepository.save(avion);
        avionDto = avionMapper.fromAvionToAvionDto(avion);
        return avionDto;

        //return avionMapper.fromAvionToAvionDto(avionRepository.save(avionMapper.fromAvionDtoToAvion(avionDto)));
    }

    @Override
    public boolean deleteAvion(Long id) {
        try {
            avionRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public List<AvionDto> getAvionByModel(String model) {
        List<Avion> avions = avionRepository.findByModel(model);
        List<AvionDto> avionDtos = new ArrayList<>();
        for (Avion avion : avions) {
            avionDtos.add(avionMapper.fromAvionToAvionDto(avion));
        }
        return avionDtos;
    }

    @Override
    public List<AvionDto> getAvionByModelAndPrice(String model, double price) {
        List<Avion> avions = avionRepository.findByModelAndPrice(model, price);
        List<AvionDto> avionDtos = new ArrayList<>();
        for (Avion avion : avions) {
            avionDtos.add(avionMapper.fromAvionToAvionDto(avion));
        }
        return avionDtos;
    }

    @Override
    public List<AvionDto> saveAvions(List<AvionDto> avionDtos) {

        List<Avion> avions = new ArrayList<>();
        for (AvionDto avionDto : avionDtos) {
            avions.add(avionMapper.fromAvionDtoToAvion(avionDto));
        }

        avions = avionRepository.saveAll(avions);

        avionDtos = new ArrayList<>();
        for (Avion avion : avions) {
            avionDtos.add(avionMapper.fromAvionToAvionDto(avion));
        }
        return avionDtos;
    }
}

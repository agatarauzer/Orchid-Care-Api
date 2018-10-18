package gardenproject.orchidcare.controller;

import gardenproject.orchidcare.domain.Orchid;
import gardenproject.orchidcare.domain.OrchidDto;
import gardenproject.orchidcare.exception.OrchidNotFoundException;
import gardenproject.orchidcare.mapper.OrchidMapper;
import gardenproject.orchidcare.service.OrchidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/orchid-care")
public class OrchidController {

    @Autowired
    private OrchidService orchidService;

    @Autowired
    private OrchidMapper orchidMapper;

    @GetMapping(value = "orchids")
    public List<OrchidDto> getOrchids() {
        List<Orchid> orchids = orchidService.getOrchidsList();
        return orchidMapper.mapToOrchidsDtosList(orchids);
    }

    @GetMapping(value = "orchid/{id}")
    public OrchidDto getOrchidById(@PathVariable Long id) throws OrchidNotFoundException {
        Orchid orchid = orchidService.getOrchidById(id).orElseThrow(OrchidNotFoundException::new);
        return orchidMapper.mapToOrchidDto(orchid);
    }

    @PostMapping(value = "orchid")
    public OrchidDto addOrchid(@RequestBody OrchidDto orchidDto) {
        Orchid orchid = orchidMapper.mapToOrchid(orchidDto);
        Orchid addedOrchid = orchidService.saveOrchid(orchid);
        return orchidMapper.mapToOrchidDto(addedOrchid);
    }

    @PutMapping(value = "orchid")
    public OrchidDto updateOrchid(@RequestBody OrchidDto orchidDto) {
        Orchid orchid = orchidMapper.mapToOrchid(orchidDto);
        Orchid addedOrchid = orchidService.saveOrchid(orchid);
        return orchidMapper.mapToOrchidDto(addedOrchid);
    }

    @DeleteMapping(value = "orchid")
    public void deleteOrchid(@RequestParam Long id) {
        orchidService.deleteOrchid(id);
    }
}

package gardenproject.orchidcare;

import gardenproject.orchidcare.controller.OrchidController;
import gardenproject.orchidcare.domain.*;
import gardenproject.orchidcare.mapper.OrchidMapper;
import gardenproject.orchidcare.service.OrchidService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(OrchidController.class)
public class OrchidControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrchidService service;

    @MockBean
    private OrchidMapper mapper;

    private Orchid testOrchid;
    private OrchidDto testOrchidDto;
    private List<Orchid> testOrchidsList = new ArrayList<>();
    private List<OrchidDto> testOrchidsDtosList = new ArrayList<>();
    private List<Watering> testWateringList = new ArrayList<>();
    private List<Transplanting> testTransplantingList = new ArrayList<>();

    @Before
    public void createTestData() {
        testWateringList.add(new Watering());
        testTransplantingList.add(new Transplanting());

        testOrchid = new Orchid(1L, "my_test_orchid", "white", BaseGroup.HYBRID, Kind.Phalaenopsis, "none",
                LocalDate.of(2000, 2, 23), testWateringList, testTransplantingList);

        testOrchidDto = new OrchidDto(1L, "my_test_orchid", "white", BaseGroup.HYBRID, Kind.Phalaenopsis, "none",
                LocalDate.of(2000, 2, 23), testWateringList, testTransplantingList);

        testOrchidsList.add(testOrchid);
        testOrchidsDtosList.add(testOrchidDto);

    }


    @Test
    public void shouldGetOrchidsList() throws Exception {
        //Given
        when(service.getOrchidsList()).thenReturn(testOrchidsList);
        when(mapper.mapToOrchidsDtosList(testOrchidsList)).thenReturn(testOrchidsDtosList);

        //When & Then

        mockMvc.perform(get("/v1/orchid-care/orchids").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));


        /*
        public List<OrchidDto> getOrchids() {
            List<Orchid> orchids = orchidService.getOrchidsList();
            return orchidMapper.mapToOrchidsDtosList(orchids);

        */


    }


}

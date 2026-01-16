package com.example.BerlinerKollektivRanking;

import com.example.BerlinerKollektivRanking.Model.*;
import com.example.BerlinerKollektivRanking.Service.*;
import com.example.BerlinerKollektivRanking.Repository.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest(properties = {
        "spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1",
        "spring.datasource.driver-class-name=org.h2.Driver",
        "spring.datasource.username=sa",
        "spring.datasource.password=",
        "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect",
        "spring.sql.init.mode=always"
})
@AutoConfigureMockMvc
public class BackendTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private KollektivService kollektivService;

    @MockBean
    private KollektivRepository kollektivRepository;

    @MockBean
    private UserRepository userRepository;


    // Happy Tests

    @Test
    @DisplayName("1. Model: Durchschnittsberechnung sollte korrekt sein")
    void testAverageCalculation() {
        Kollektiv k = new Kollektiv();
        Bewertung b1 = new Bewertung(); b1.setBewertung(5);
        Bewertung b2 = new Bewertung(); b2.setBewertung(3);
        k.addBewertung(b1);
        k.addBewertung(b2);
        assertEquals(4.0, k.getDurchschnittsBewertung());
    }

    @Test
    @DisplayName("2. Service: Kollektiv nach ID finden (Mock)")
    void testFindById() {
        Kollektiv k = new Kollektiv();
        k.setName("Test Kollektiv");
        when(kollektivRepository.findById(1L)).thenReturn(Optional.of(k));

        var result = kollektivService.getKollektivById(1L);
        assertTrue(result.isPresent());
        assertEquals("Test Kollektiv", result.get().getName());
    }

    @Test
    @DisplayName("3. API: Status OK bei Abfrage aller Kollektive")
    void testApiStatusOk() throws Exception {
        when(kollektivRepository.findAll()).thenReturn(List.of(new Kollektiv()));
        mockMvc.perform(get("/kollektiv/all"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("4. API: JSON Content Prüfung")
    void testApiJsonContent() throws Exception {
        Kollektiv k = new Kollektiv();
        k.setName("Rave Team");
        when(kollektivRepository.findAll()).thenReturn(List.of(k));

        mockMvc.perform(get("/kollektiv/all"))
                .andExpect(content().string(containsString("Rave Team")));
    }

    @Test
    @DisplayName("5. Service: User finden nach Email")
    void testUserByEmail() {
        User u = new User();
        u.setEmail("test@web.de");
        when(userRepository.findByEmail("test@web.de")).thenReturn(Optional.of(u));
        assertTrue(userRepository.findByEmail("test@web.de").isPresent());
    }


    // Sad Tests

    @Test
    @DisplayName("6. Service: Fehler wenn User bei Kollektiv-Erstellung fehlt")
    void testErrorNoUser() {
        when(userRepository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(IllegalArgumentException.class, () -> {
            kollektivService.saveKollektiv(new Kollektiv(), 99L);
        });
    }

    @Test
    @DisplayName("7. API: Leerer Body bei unbekannter Kollektiv-ID")
    void testApiNotFound() throws Exception {
        mockMvc.perform(get("/kollektiv/999"))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    @DisplayName("8. Model: Durchschnitt bei 0 Bewertungen")
    void testAverageEmpty() {
        Kollektiv k = new Kollektiv();
        k.updateDurchschnittsBewertung();
        assertEquals(0.0, k.getDurchschnittsBewertung());
    }

    @Test
    @DisplayName("9. API: Delete Aufruf wird an Repo weitergegeben")
    void testDeleteApi() throws Exception {
        mockMvc.perform(delete("/kollektiv/delete/1"))
                .andExpect(status().isOk());
        verify(kollektivRepository, times(1)).deleteById(1L);
    }

    @Test
    @DisplayName("10. Service: Ranked Liste ist leer wenn Repository leer")
    void testEmptyRankedList() {
        when(kollektivRepository.findAll()).thenReturn(new java.util.ArrayList<>());
        List<Kollektiv> list = kollektivService.getRankedKollektivs();
        assertTrue(list.isEmpty());
    }
}
package ru.neoflex.conveor.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.conveor.model.CreditDTO;
import ru.neoflex.conveor.model.LoanApplicationRequestDTO;
import ru.neoflex.conveor.model.LoanOfferDTO;
import ru.neoflex.conveor.model.ScoringDataDTO;
import ru.neoflex.conveor.service.CalculatorService;
import ru.neoflex.conveor.service.ConveyorService;

import java.util.List;

@RestController
@RequestMapping(ConveyorController.BASE_PATH)
@AllArgsConstructor
public class ConveyorController {

    public final static String BASE_PATH = "/conveyor";

    private final static String OFFERS_PATH = "/offers";

    private final static String CALCULATION_PATH = "/calculation";

    private final CalculatorService calculatorService;

    private final ConveyorService conveyorService;

    @PostMapping(OFFERS_PATH)
    public ResponseEntity<List<LoanOfferDTO>> offers(@RequestBody LoanApplicationRequestDTO req) {
        return ResponseEntity.ok(conveyorService.prepareOffers(req));
    }

    @PostMapping(CALCULATION_PATH)
    public ResponseEntity<CreditDTO> calculation(@RequestBody ScoringDataDTO req) {
        return ResponseEntity.ok(calculatorService.calculateCredit(req));
    }
}

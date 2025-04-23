package desafio.itau.springboot.controller;


import desafio.itau.springboot.dto.StatistcsResponse;
import desafio.itau.springboot.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("/estatistica")
public class StatistcsController {

    private final TransactionService transactionService;

    public StatistcsController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<StatistcsResponse> getStatics(){
        DoubleSummaryStatistics stats  = transactionService.getStatiscs();
        return ResponseEntity.ok(new StatistcsResponse(stats));
    }
}

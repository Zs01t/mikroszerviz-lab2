package com.example.mikroszerviz_lab2;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController("reservation")
@Validated
public class ReservationRest {
    //pl. localhost:8080/table/hello/Béla?name=Kiss esetén a kimenet "HELLO Kiss Béla"
    @GetMapping(path = "/hello/{path}")
    public String hello(

            @NotBlank @Parameter(description = "query name") @RequestParam("name") String pName,
            @NotBlank @Parameter(description = "path name") @PathVariable(name = "path") String pPath){
        return "HELLO " + pName + " " + pPath + "!";
    }



    //bezédesebb válaszkódok az alábbi függvény hívása esetén
    @ApiResponses(
            value={
                    @ApiResponse(responseCode = "200", description = "Sikeres hívás"),
                    @ApiResponse(responseCode = "400", description = "Rossz hívási paraméter")
            }
    )
    @Operation(summary = "Összetett helló", description = "Példa a leírásra")
    @GetMapping(path = "/helloobject")
    //pl. localhost:8080/table/helloobject?fname=Béla&lname=Kiss "HELLO Kiss Béla"
    //Ehhez a Name osztályt a megfelelő annotációkkal kell ellátni
    public String hello(@Valid Name pName){
        return "HELLO " + pName.getLname() + " " + pName.getFname() + "!";
    }

}

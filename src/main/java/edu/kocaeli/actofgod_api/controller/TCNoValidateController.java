package edu.kocaeli.actofgod_api.controller;

import edu.kocaeli.actofgod_api.dto.user.TcNoValidateDto;
import edu.kocaeli.actofgod_api.util.TCNoValidationUtil;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/v1/tcno-validate")
public class TCNoValidateController {
    @PostMapping
    public boolean validate(@RequestBody TcNoValidateDto dto) {
        return TCNoValidationUtil.validate(dto);
    }
}

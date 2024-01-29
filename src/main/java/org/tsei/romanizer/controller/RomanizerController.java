package org.tsei.romanizer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.tsei.romanizer.dto.RomanizerRequest;
import org.tsei.romanizer.dto.RomanizerResponse;
import org.tsei.romanizer.service.RomanizerService;

@RestController
@RequiredArgsConstructor
public class RomanizerController {
    private final RomanizerService romanizerService;

    //@PostMapping("/romanize")
    public @ResponseBody RomanizerResponse romanize(@RequestBody RomanizerRequest request) {
        return new RomanizerResponse(romanizerService.romanize(request.getText()));
    }
}

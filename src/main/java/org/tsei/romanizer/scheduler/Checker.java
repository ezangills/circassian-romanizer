package org.tsei.romanizer.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.tsei.romanizer.dto.RomanizerRequest;
import org.tsei.romanizer.dto.RomanizerResponse;

@Component
@Slf4j
public class Checker {

    @Value("${url}") private String url;

    @Scheduled(fixedRate = 10000)
    public void callItself() {
        ResponseEntity<String> romanizerResponseResponseEntity = new RestTemplate().postForEntity(url, new RomanizerRequest("Ти Мыекъуапэ къэлэ дах."), String.class);
        log.info("Scheduled status code: " + romanizerResponseResponseEntity.getStatusCode());
        log.info("Scheduled body: " + romanizerResponseResponseEntity.getBody());
    }

}

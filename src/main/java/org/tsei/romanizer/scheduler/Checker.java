package org.tsei.romanizer.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.tsei.romanizer.dto.RomanizerRequest;
import org.tsei.romanizer.dto.RomanizerResponse;

@Component
@Slf4j
public class Checker {

    @Value("${bot-token}") private String url;

    @Scheduled(fixedRate = 10000)
    public void callItself() {
        RomanizerResponse romanizerResponse = new RestTemplate().postForObject(url, new RomanizerRequest("Ти Мыекъуапэ къэлэ дах."), RomanizerResponse.class);
        log.info("Scheduled: " + romanizerResponse.getText());
    }

}

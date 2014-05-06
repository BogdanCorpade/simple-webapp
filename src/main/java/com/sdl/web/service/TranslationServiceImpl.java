package com.sdl.web.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sdl.web.domain.TranslationLog;
import com.sdl.web.domain.TranslationRequest;
import com.sdl.web.domain.TranslationResponse;
import com.sdl.web.repository.TranslationLogRepository;

@Component
public class TranslationServiceImpl implements TranslationService {

    @Autowired
    private TranslationLogRepository translationLogRepository;
    
    @Override
    public TranslationResponse translate(final TranslationRequest translationRequest) {
        String translation = "translated text: " + translationRequest.getText();

        Thread logger = new Thread(new Runnable() {
            public void run() {
                TranslationServiceImpl.this.translationLogRepository.log(new TranslationLog(new Date(), translationRequest));
            }
        });

        logger.start();
        
        TranslationResponse response = new TranslationResponse(translation, translationRequest.getFrom(), translationRequest.getTo());
        response.setNoChars(translationRequest.getText().length());
        return response;
    }

}

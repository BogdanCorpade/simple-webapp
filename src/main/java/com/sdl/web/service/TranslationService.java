package com.sdl.web.service;

import com.sdl.web.domain.TranslationRequest;
import com.sdl.web.domain.TranslationResponse;

public interface TranslationService {

	TranslationResponse translate(TranslationRequest translationRequest);
}

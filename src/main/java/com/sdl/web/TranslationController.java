package com.sdl.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdl.web.domain.TranslationRequest;
import com.sdl.web.domain.TranslationResponse;
import com.sdl.web.service.TranslationService;

@Controller
public class TranslationController {

	@Autowired
	private TranslationService translationService;

	@RequestMapping("/translate")
	@ResponseBody
	TranslationResponse login(@RequestParam("text") String text, @RequestParam("from") String from, @RequestParam("to") String to) {
		TranslationRequest request = new TranslationRequest(text, from, to);
		TranslationResponse response = translationService.translate(request);
		return response;
	}
}

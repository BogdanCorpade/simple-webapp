package com.sdl.web.domain;

public class TranslationResponse extends TranslationRequest {

    private static final long serialVersionUID = 1L;

    public TranslationResponse(String text, String from, String to) {
		super(text, from, to);
	}

	private int noChars;

	public int getNoChars() {
		return noChars;
	}

	public void setNoChars(int noChars) {
		this.noChars = noChars;
	}
}

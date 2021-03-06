package com.tappay.service;

import com.tappay.exception.TapPayInitialException;
import com.tappay.request.Cardholder;
import com.tappay.request.direct.PayByPrimeRequest;
import com.tappay.response.direct.PayByPrimeResponse;
import com.tappay.utils.StringUtil;
import com.tappay.utils.TapPayEnvironment;

public class TapPay {

	private String apiKey;
	private TapPayEnvironment environment;
	private static TapPay tapPay = null;

	private TapPay(String apiKey, TapPayEnvironment environment) {
		this.apiKey = apiKey;
		this.environment = environment;
	}

	private static void initialValidate() throws TapPayInitialException {
		if (tapPay == null) {
			throw new TapPayInitialException();
		}
	}

	public static void initial(String apiKey, TapPayEnvironment environment) throws TapPayInitialException {
		if (StringUtil.isEmpty(apiKey)) {
			throw new TapPayInitialException();
		}
		if (environment == null) {
			throw new TapPayInitialException();
		}
		if (tapPay == null) {
			synchronized (TapPay.class) {
				if (tapPay == null) {
					tapPay = new TapPay(apiKey, environment);
				}
			}
		}
	}

	public static TapPay getInstance() throws TapPayInitialException {
		initialValidate();
		return tapPay;
	}

	public String getApiKey() {
		return apiKey;
	}

	public TapPayEnvironment getEnvironment() {
		return environment;
	}

	public static DirectPay createDirectPay() throws TapPayInitialException {
		initialValidate();
		return DirectPay.newInstance();
	}

}

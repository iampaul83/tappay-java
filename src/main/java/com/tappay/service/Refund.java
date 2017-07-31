package com.tappay.service;

import com.google.gson.Gson;
import com.tappay.exception.TapPayInitialException;
import com.tappay.exception.TapPayServerConnectException;
import com.tappay.request.refund.RefundRequest;
import com.tappay.response.refund.RefundResponse;
import com.tappay.utils.ApiRequestUtil;

public class Refund {

	private static final String SANDBOX_REFUND_URL = "https://sandbox.tappayapis.com/tpc/partner/fastrefund";
	private static final String PRODUCTION_REFUND_URL = "https://prod.tappayapis.com/tpc/partner/fastrefund";

	private Refund() {}

	public static Refund newInstance() {
		return new Refund();
	}

	public RefundResponse refund(RefundRequest request) throws TapPayServerConnectException, TapPayInitialException {
		String responseJson = ApiRequestUtil.postJson(request.toJson(), getRefundUrl(),
				TapPay.getInstance().getApiKey());
		return new Gson().fromJson(responseJson, RefundResponse.class);
	}

	private String getRefundUrl() throws TapPayInitialException {
		switch (TapPay.getInstance().getEnvironment()) {
			case PRODUCTION:
				return PRODUCTION_REFUND_URL;
			case SANDBOX:
				return SANDBOX_REFUND_URL;
			default:
				throw new TapPayInitialException();
		}
	}

}

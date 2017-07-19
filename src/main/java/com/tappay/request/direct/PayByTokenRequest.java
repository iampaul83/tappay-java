package com.tappay.request.direct;

import com.google.gson.annotations.SerializedName;
import com.tappay.exception.ArgumentsValidException;
import com.tappay.exception.TapPayInitialException;
import com.tappay.request.TapPayRequest;
import com.tappay.service.TapPay;
import com.tappay.utils.StringUtil;

public class PayByTokenRequest extends TapPayRequest{

	@SerializedName("cardkey")
	String cardKey;
	@SerializedName("cardtoken")
	String cardToken;
	@SerializedName("partnerkey")
	String partnerKey;
	@SerializedName("merchantid")
	String merchantId;
	Integer amount;
	String currency;
	@SerializedName("ptradeid")
	String partnerTradeId;
	String details;
	Integer instalment;
	@SerializedName("authtocapperiodinday")
	Integer authToCapPeriodInDay;
	@SerializedName("orderid")
	String orderId;
	@SerializedName("cardccv")
	String cardCCV;

	private PayByTokenRequest(Builder builder) throws TapPayInitialException {
		this.partnerKey = TapPay.getInstance().getApiKey();
		this.cardKey = builder.cardKey;
		this.cardToken = builder.cardToken;
		this.merchantId = builder.merchantId;
		this.amount = builder.amount;
		this.currency = builder.currency;
		this.partnerTradeId = builder.partnerTradeId;
		this.orderId = builder.orderId;
		this.instalment = builder.instalment;
		this.authToCapPeriodInDay = builder.authToCapPeriodInDay;
		this.details = builder.details;
		this.cardCCV = builder.cardCCV;
	}

	public String getCardKey() {
		return cardKey;
	}

	public void setCardKey(String cardKey) {
		this.cardKey = cardKey;
	}

	public String getCardToken() {
		return cardToken;
	}

	public void setCardToken(String cardToken) {
		this.cardToken = cardToken;
	}

	public String getPartnerKey() {
		return partnerKey;
	}

	public void setPartnerKey(String partnerKey) {
		this.partnerKey = partnerKey;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getPartnerTradeId() {
		return partnerTradeId;
	}

	public void setPartnerTradeId(String partnerTradeId) {
		this.partnerTradeId = partnerTradeId;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Integer getInstalment() {
		return instalment;
	}

	public void setInstalment(Integer instalment) {
		this.instalment = instalment;
	}

	public Integer getAuthToCapPeriodInDay() {
		return authToCapPeriodInDay;
	}

	public void setAuthToCapPeriodInDay(Integer authToCapPeriodInDay) {
		this.authToCapPeriodInDay = authToCapPeriodInDay;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCardCCV() {
		return cardCCV;
	}

	public void setCardCCV(String cardCCV) {
		this.cardCCV = cardCCV;
	}

	public static class Builder {

		private String cardKey;
		private String cardToken;
		private String partnerKey;
		private String merchantId;
		private Integer amount;
		private String currency = "TWD";
		private String partnerTradeId;
		private String details;
		private Integer instalment = 0;
		private Integer authToCapPeriodInDay = 0;
		private String orderId;
		private String cardCCV;

		public Builder cardKey(String cardKey) {
			this.cardKey = cardKey;
			return this;
		}

		public Builder cardToken(String cardToken) {
			this.cardToken = cardToken;
			return this;
		}

		public Builder partnerKey(String partnerKey) {
			this.partnerKey = partnerKey;
			return this;
		}

		public Builder merchantId(String merchantId) {
			this.merchantId = merchantId;
			return this;
		}

		public Builder amount(Integer amount) {
			this.amount = amount;
			return this;
		}

		public Builder currency(String currency) {
			this.currency = currency;
			return this;
		}

		public Builder partnerTradeId(String partnerTradeId) {
			this.partnerTradeId = partnerTradeId;
			return this;
		}

		public Builder details(String details) {
			this.details = details;
			return this;
		}

		public Builder instalment(Integer instalment) {
			this.instalment = instalment;
			return this;
		}

		public Builder authToCapPeriodInDay(Integer authToCapPeriodInDay) {
			this.authToCapPeriodInDay = authToCapPeriodInDay;
			return this;
		}

		public Builder orderId(String orderId) {
			this.orderId = orderId;
			return this;
		}

		public Builder cardCCV(String cardCCV) {
			this.cardCCV = cardCCV;
			return this;
		}

		public PayByTokenRequest build() throws ArgumentsValidException, TapPayInitialException {
			if (StringUtil.isEmpty(cardKey)) {
				throw new ArgumentsValidException("Missing Arguments : cardKey");
			}
			if (StringUtil.isEmpty(cardToken)) {
				throw new ArgumentsValidException("Missing Arguments : cardToken");
			}
			if (StringUtil.isEmpty(merchantId)) {
				throw new ArgumentsValidException("Missing Arguments : MerchantId");
			}
			if (StringUtil.isEmpty(details)) {
				throw new ArgumentsValidException("Missing Arguments : MerchantId");
			}
			return new PayByTokenRequest(this);
		}

	}

	@Override
	public String toString() {
		return "PayByTokenRequest [cardKey=" + cardKey + ", cardToken=" + cardToken + ", partnerKey=" + partnerKey
				+ ", merchantId=" + merchantId + ", amount=" + amount + ", currency=" + currency + ", partnerTradeId="
				+ partnerTradeId + ", orderId=" + orderId + ", details=" + details + ", instalment=" + instalment
				+ ", authToCapPerionInDay=" + authToCapPeriodInDay + ", cardCCV=" + cardCCV + "]";
	}

}
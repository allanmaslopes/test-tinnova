package com.br.tinnova.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchUsdPriceDTO {

    @JsonProperty(value = "USDBRL")
    private UsdBrl usdBrl;

    public SearchUsdPriceDTO() {
    }

    public UsdBrl getUsdBrl() {
        return usdBrl;
    }

    public void setUsdBrl(UsdBrl usdBrl) {
        this.usdBrl = usdBrl;
    }
}

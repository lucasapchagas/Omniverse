package com.lucasapchagas.OmniVerse.external;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucasapchagas.OmniVerse.Constant;
import com.lucasapchagas.OmniVerse.entities.common.AddressRecord;
import com.lucasapchagas.OmniVerse.utils.Formatter;
import com.lucasapchagas.OmniVerse.utils.Log;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

public class RequestCep extends RestTemplate {
    private final String TAG = RequestCep.class.getName();
    private AddressRecord result;

    public RequestCep(String cep) {
        super();

        try {
            this.result = new AddressRecord(
                    Objects.requireNonNull(this.getForObject(
                            Constant.viacepOrigin.replace("$", cep),
                            ViacepRecord.class
                    ))
            );
        } catch (Exception e) {
           this.result = new AddressRecord(cep, "", "", "", "", "");
           Log.d(TAG, "Exception while retrieving cep - " + e);
        }
    }

    public AddressRecord getResult() {
        return result;
    }
}

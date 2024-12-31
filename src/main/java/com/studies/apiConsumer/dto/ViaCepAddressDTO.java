package com.studies.apiConsumer.dto;

import com.studies.apiConsumer.model.Address;
import lombok.Data;

import java.util.Map;

@Data
public class ViaCepAddressDTO {
    private String cep;
    private String logradouro;
    private String complemento;
    private String unidade;
    private String bairro;
    private String localidade;
    private String uf;
    private String estado;
    private String regiao;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

    public Address toAddress(){
        Address address = new Address();

        address.setCep(this.cep);
        address.setPublicPlace(this.logradouro);
        address.setComplement(this.complemento);
        address.setUnity(this.unidade);
        address.setNeighborhood(this.bairro);
        address.setLocality(this.localidade);
        address.setUf(this.uf);
        address.setState(this.estado);
        address.setRegion(this.regiao);
        address.setIbge(this.ibge);
        address.setGia(this.gia);
        address.setDdd(this.ddd);
        address.setSiafi(this.siafi);

        return address;
    }

    public ViaCepAddressDTO(Map<String, Object> input){
        this.cep = (String) input.get("cep");
        this.logradouro = (String) input.get("logradouro");
        this.complemento = (String) input.get("complemento");
        this.unidade = (String) input.get("unidade");
        this.bairro = (String) input.get("bairro");
        this.localidade = (String) input.get("localidade");
        this.uf = (String) input.get("uf");
        this.estado = (String) input.get("estado");
        this.regiao = (String) input.get("regiao");
        this.ibge = (String) input.get("ibge");
        this.gia = (String) input.get("gia");
        this.ddd = (String) input.get("ddd");
        this.siafi = (String) input.get("siafi");
    }
}

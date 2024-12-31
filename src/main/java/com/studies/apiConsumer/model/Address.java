package com.studies.apiConsumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Address {

   @EqualsAndHashCode.Include
   private String cep;
   private String publicPlace;
   private String complement;
   private String unity;
   private String neighborhood;
   private String locality;
   private String uf;
   private String state;
   private String region;
   private String ibge;
   private String gia;
   private String ddd;
   private String siafi;
}
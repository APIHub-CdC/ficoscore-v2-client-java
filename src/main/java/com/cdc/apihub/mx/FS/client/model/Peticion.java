package com.cdc.apihub.mx.FS.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Datos generales de la persona a consultar.")
public class Peticion {
  @SerializedName("folio")
  private String folio = null;

  @SerializedName("persona")
  private Persona persona = null;

  public Peticion folio(String folio) {
    this.folio = folio;
    return this;
  }


  @ApiModelProperty(example = "0000001", value = "Folio de la consulta con relación al otorgante")
  public String getFolio() {
    return folio;
  }

  public void setFolio(String folio) {
    this.folio = folio;
  }

  public Peticion persona(Persona persona) {
    this.persona = persona;
    return this;
  }


  @ApiModelProperty(required = true, value = "")
  public Persona getPersona() {
    return persona;
  }

  public void setPersona(Persona persona) {
    this.persona = persona;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Peticion peticion = (Peticion) o;
    return Objects.equals(this.folio, peticion.folio) &&
        Objects.equals(this.persona, peticion.persona);
  }

  @Override
  public int hashCode() {
    return Objects.hash(folio, persona);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Peticion {\n");
    
    sb.append("    folio: ").append(toIndentedString(folio)).append("\n");
    sb.append("    persona: ").append(toIndentedString(persona)).append("\n");
    sb.append("}");
    return sb.toString();
  }


  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}


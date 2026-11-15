package com.aula8.estadosmunicipios.dto;

/** Municipio ja com o NOME do estado (e nao so o codigo) para ser devolvido em JSON. */
public record MunicipioDTO(Long id, String nome, Long estadoId, String estadoNome, String estadoSigla) {
}

package com.example.desafio.Dto;

import org.antlr.v4.runtime.misc.NotNull;

public record AnuncioDTO(
    @NotNull Long idImovel,
    @NotNull Long idCorretor,
    String nomeCorretor,
    String tipoImovel,
    String bairro
) {}


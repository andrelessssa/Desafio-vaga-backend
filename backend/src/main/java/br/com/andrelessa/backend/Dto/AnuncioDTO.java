package br.com.andrelessa.backend.Dto;

import jakarta.validation.constraints.NotNull;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AnuncioDTO(
    @NotNull(message = "Id do imóvel é obrigatório") Long idImovel,
    @NotNull(message = "Id do corretor é obrigatório") Long idCorretor,
    @NotBlank(message = "Nome do corretor é obrigatório")
    @Size(min = 3, max = 100) String nomeCorretor,
    @NotBlank(message = "Tipo do imóvel é obrigatório")
    @Size(max = 50) String tipoImovel,
    @NotBlank(message = "Bairro é obrigatório")
    @Size(max = 100) String bairro
) {}


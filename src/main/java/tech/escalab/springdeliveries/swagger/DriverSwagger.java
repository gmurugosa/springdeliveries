package tech.escalab.springdeliveries.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import tech.escalab.springdeliveries.domain.driver.Driver;
import tech.escalab.springdeliveries.dto.driver.DriverRequestDto;
import tech.escalab.springdeliveries.dto.driver.DriverResponseDto;

import java.util.List;
import java.util.UUID;

@Tag(name = "Driver", description = "API de Drivers")
public interface DriverSwagger {
    @Operation(
            summary = "Listar Drivers",
            description = "Endpoint que nos ayuda a listar todos los drivers de la base de datos"
    )
    @ApiResponse(
            responseCode = "200", content = { @Content(schema = @Schema(implementation = DriverRequestDto.class), mediaType = "application/json") }
    )
    List<DriverResponseDto> findAll();

    @Operation(
            summary = "Crear un Driver",
            description = "Endpoint que nos ayuda a crear un driver por su uuid"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = DriverRequestDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = DriverRequestDto.class), mediaType = "application/json") })
    })
    DriverResponseDto save(DriverRequestDto driver);

    @Operation(
            summary = "Actualizar un Driver",
            description = "Endpoint que nos ayuda a actualizar un driver por su uuid"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = DriverRequestDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = DriverRequestDto.class), mediaType = "application/json") })
    })
    void update(UUID uuid,DriverRequestDto driver);

    @Operation(
            summary = "Eliminar un Driver",
            description = "Endpoint que nos ayuda a eliminar un driver por su uuid"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = DriverRequestDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = DriverRequestDto.class), mediaType = "application/json") })
    })
    DriverResponseDto delete(UUID uuid);

}

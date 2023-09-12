package tech.escalab.springdeliveries.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import tech.escalab.springdeliveries.domain.truck.Truck;
import tech.escalab.springdeliveries.dto.truck.TruckRequestDto;
import tech.escalab.springdeliveries.dto.truck.TruckResponseDto;

import java.util.List;
import java.util.UUID;

@Tag(name = "Truck", description = "API de Trucks")
public interface TruckSwagger {
    @Operation(
            summary = "Listar Trucks",
            description = "Endpoint que nos ayuda a listar todos los trucks de la base de datos"
    )
    @ApiResponse(
            responseCode = "200", content = { @Content(schema = @Schema(implementation = TruckRequestDto.class), mediaType = "application/json") }
    )
    List<TruckResponseDto> findAll();

    @Operation(
            summary = "Crear un Truck",
            description = "Endpoint que nos ayuda a crear un truck por su uuid"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TruckRequestDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = TruckRequestDto.class), mediaType = "application/json") })
    })
    TruckResponseDto save(TruckRequestDto truck);

    @Operation(
            summary = "Actualizar un Truck",
            description = "Endpoint que nos ayuda a actualizar un truck por su uuid"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TruckRequestDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = TruckRequestDto.class), mediaType = "application/json") })
    })
    void update(UUID uuid,TruckRequestDto truck);

    @Operation(
            summary = "Eliminar un Truck",
            description = "Endpoint que nos ayuda a eliminar un truck por su uuid"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TruckRequestDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = TruckRequestDto.class), mediaType = "application/json") })
    })
    TruckResponseDto delete(UUID uuid);

}

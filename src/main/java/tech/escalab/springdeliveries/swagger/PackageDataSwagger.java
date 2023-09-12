package tech.escalab.springdeliveries.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tech.escalab.springdeliveries.domain.packagedata.PackageData;
import tech.escalab.springdeliveries.domain.packagedata.PackageStatus;
import tech.escalab.springdeliveries.dto.packagedata.PackageDataRequestDto;
import tech.escalab.springdeliveries.dto.packagedata.PackageDataResponseDto;

import java.util.List;
import java.util.UUID;

@Tag(name = "Packages", description = "API de Packages")
public interface PackageDataSwagger {
    @Operation(
            summary = "Listar packages",
            description = "Endpoint que nos ayuda a listar todos los packages de la base de datos"
    )
    @ApiResponse(
            responseCode = "200", content = { @Content(schema = @Schema(implementation = PackageDataRequestDto.class), mediaType = "application/json") }
    )
    List<PackageDataResponseDto> findAll();

    @Operation(
            summary = "Crear un package",
            description = "Endpoint que nos ayuda a crear un package por su uuid"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = PackageDataRequestDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = PackageDataRequestDto.class), mediaType = "application/json") })
    })
    PackageDataResponseDto save(PackageDataRequestDto packageData);

    @Operation(
            summary = "Actualizar un package",
            description = "Endpoint que nos ayuda a actualizar un truck por su uuid"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = PackageDataRequestDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = PackageDataRequestDto.class), mediaType = "application/json") })
    })
    void update(UUID uuid,PackageDataRequestDto packageData);

    @Operation(
            summary = "Actualizar status de un package",
            description = "Endpoint que nos ayuda a actualizar status de un package por su uuid"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = PackageDataRequestDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = PackageDataRequestDto.class), mediaType = "application/json") })
    })
    PackageDataResponseDto udpatePackageStatus(UUID uuid, PackageStatus status);

    @Operation(
            summary = "Eliminar un package",
            description = "Endpoint que nos ayuda a eliminar un package por su uuid"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = PackageDataRequestDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = PackageDataRequestDto.class), mediaType = "application/json") })
    })
    PackageDataResponseDto delete(UUID uuid);
    @Operation(
            summary = "Eliminar lista de productos en un package",
            description = "Endpoint que nos ayuda a eliminar una lista de productos en un package por su uuid"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = PackageDataRequestDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = PackageDataRequestDto.class), mediaType = "application/json") })
    })
    PackageDataResponseDto deletePackageProductsList(@PathVariable UUID uuid, @RequestBody List<String> packageProductsDeleteList) throws Exception;

}

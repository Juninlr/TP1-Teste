package br.unitins.tp1.resource;

import br.unitins.tp1.dto.MemoriaDTO;
import br.unitins.tp1.dto.MemoriaResponseDTO;
import br.unitins.tp1.model.Fornecedor;
import br.unitins.tp1.model.Memoria;
import br.unitins.tp1.service.FornecedorService;
import br.unitins.tp1.service.MemoriaService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/memorias")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MemoriaResource {

    @Inject
    MemoriaService service;
    @Inject
    FornecedorService fornecedorService;

    @GET
    public Response listar() {
        return Response.ok(service.findAll().stream()
        .map(MemoriaResponseDTO::fromEntity)
        .toList()).build();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        return Response.ok(MemoriaResponseDTO.fromEntity(service.findById(id))).build();
    }

    @GET
    @Path("/marca/{marca}")
    public Response buscarPorMarca(@PathParam("marca") String marca) {
        return Response.ok(service.findByMarca(marca).stream().map
        (MemoriaResponseDTO::fromEntity).toList()).build();
    }

    @GET
    @Path("/modelo/{modelo}")
    public Response buscarPorModelo(@PathParam("modelo") String modelo) {
        return Response.ok(service.findByModelo(modelo).stream().map(MemoriaResponseDTO::fromEntity).toList()).build();
    }

    @GET
    @Path("/gigas/{gigas}")
    public Response buscarPorGigas(@PathParam("gigas") String gigas) {
        return Response.ok(service.findByGigas(gigas).stream().map(MemoriaResponseDTO::fromEntity).toList()).build();
    }

    @GET
    @Path("/velocidade/{velocidade}")
    public Response buscarPorVelocidade(@PathParam("velocidade") String velocidade) {
        return Response.ok(service.findByVelocidade(velocidade).stream().map(MemoriaResponseDTO::fromEntity).toList()).build();
    }

    @POST
    public Response inserir(@Valid MemoriaDTO dto) {
        Memoria memoria = new Memoria();
        memoria.setMarca(dto.marca());
        memoria.setModelo(dto.modelo());
        memoria.setGigas(dto.gigas());
        memoria.setVelocidade(dto.velocidade());

        Fornecedor fornecedor = fornecedorService.findById(dto.fornecedorId());
        memoria.setFornecedor(fornecedor);

        return Response.status(Response.Status.CREATED).entity(MemoriaResponseDTO.fromEntity(service.create(memoria))).build();
    } 

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, @Valid MemoriaDTO dto) {
        Memoria memoria = new Memoria();
        memoria.setMarca(dto.marca());
        memoria.setModelo(dto.modelo());
        memoria.setGigas(dto.gigas());
        memoria.setVelocidade(dto.velocidade());

        Fornecedor fornecedor = fornecedorService.findById(dto.fornecedorId());
        memoria.setFornecedor(fornecedor);

        service.update(id, memoria);
        return Response.noContent().build();
    } 

    @DELETE
    @Path("/{id}")
    public Response excluir(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }


}

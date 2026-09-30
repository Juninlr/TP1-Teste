package br.unitins.tp1.resource;

import br.unitins.tp1.dto.FornecedorDTO;
import br.unitins.tp1.dto.FornecedorResponseDTO;
import br.unitins.tp1.model.Fornecedor;
import br.unitins.tp1.service.FornecedorService;
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

@Path("/fornecedores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FornecedorResource {

    @Inject
    FornecedorService service;

    @GET
    public Response listar() {
        return Response.ok(service.findAll().stream()
                .map(FornecedorResponseDTO::fromEntity)
                .toList()).build();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        return Response.ok(FornecedorResponseDTO.fromEntity(service.findById(id))).build();
    }

    @POST
    public Response inserir(@Valid FornecedorDTO dto) {
        Fornecedor fornecedor = new Fornecedor();
        preencherFornecedor(fornecedor, dto);
        Fornecedor criado = service.create(fornecedor);
        return Response.status(Response.Status.CREATED)
                .entity(FornecedorResponseDTO.fromEntity(criado))
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, @Valid FornecedorDTO dto) {
        Fornecedor fornecedor = new Fornecedor();
        preencherFornecedor(fornecedor, dto);
        service.update(id, fornecedor);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    public Response excluir(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }

    private void preencherFornecedor(Fornecedor fornecedor, FornecedorDTO dto) {
        fornecedor.setNome(dto.nome());
        fornecedor.setCnpj(dto.cnpj());
        fornecedor.setTelefone(dto.telefone());
        fornecedor.setEmail(dto.email());
    }
}
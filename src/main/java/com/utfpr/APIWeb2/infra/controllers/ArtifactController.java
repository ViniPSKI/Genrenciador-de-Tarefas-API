package com.utfpr.APIWeb2.infra.controllers;

import com.utfpr.APIWeb2.core.implementation.CreateArtifactUseCaseImpl;
import com.utfpr.APIWeb2.core.implementation.DeleteArtifactUseCaseImpl;
import com.utfpr.APIWeb2.core.implementation.GetArtifactUseCaseImpl;
import com.utfpr.APIWeb2.infra.DTO.ArtifactDto;
import com.utfpr.APIWeb2.infra.converters.ArtifactMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("artifact")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class ArtifactController {

    private CreateArtifactUseCaseImpl createArtifactUseCase;
    private final DeleteArtifactUseCaseImpl deleteArtifactUseCase;
    public final GetArtifactUseCaseImpl getArtifactUseCase;
    private ArtifactMapper artifactMapper;

    @PostMapping
    public ArtifactDto createArtifact(@RequestBody ArtifactDto artifact){
        var ArtifactSave = artifactMapper.toSave(artifact);
        var artifactResponse = createArtifactUseCase.createArtifact(ArtifactSave);
        return artifactMapper.toDto(artifactResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteArtifact(@PathVariable(value = "id") UUID id){
        try {
            return ResponseEntity.ok().body(artifactMapper.toDto(deleteArtifactUseCase.deleteArtifact(id)));
        }catch (RuntimeException e){
            throw new RuntimeException("An error occurred during login: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getArtificat(@PathVariable(value = "id") UUID id){
        return ResponseEntity.ok().body(artifactMapper.toDto(getArtifactUseCase.findArtifact(id)));
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Object> getArtificats(@PathVariable(value = "id") UUID sourceTask){
        return ResponseEntity.ok().body(getArtifactUseCase.findArtifacts(sourceTask));
    }

}

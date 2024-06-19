package com.utfpr.APIWeb2.infra.configuration;

import com.utfpr.APIWeb2.core.implementation.*;
import com.utfpr.APIWeb2.core.ports.ArtifactService;
import com.utfpr.APIWeb2.core.ports.EmailService;
import com.utfpr.APIWeb2.core.ports.TaskService;
import com.utfpr.APIWeb2.core.ports.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public CreateUserUseCaseImpl createUserUseCase(UserService userService, EmailService emailService){
        return new CreateUserUseCaseImpl(userService, emailService);
    }

    @Bean
    public GetTaskUseCaseImpl getTaskUseCase(TaskService taskService){
        return new GetTaskUseCaseImpl(taskService);
    }

    @Bean
    public CreateTaskUseCaseImpl createTaskUseCase(TaskService taskService){
        return new CreateTaskUseCaseImpl(taskService);
    }

    @Bean
    public EmailValidationUseCaseImpl emailValidationUseCase(EmailService emailService){
        return new EmailValidationUseCaseImpl(emailService);
    }

    @Bean
    public CreateArtifactUseCaseImpl createArtifactUseCase(ArtifactService artifactService){
        return new CreateArtifactUseCaseImpl(artifactService);
    }

    @Bean
    public DeleteTaskUseCaseImpl deleteTaskUseCase(TaskService taskService){
        return new DeleteTaskUseCaseImpl(taskService);
    }

    @Bean
    public EditTaskUseCaseImpl editTaskUseCase(TaskService taskService){
        return new EditTaskUseCaseImpl(taskService);
    }

    @Bean
    public DeleteArtifactUseCaseImpl deleteArtifactUseCase(ArtifactService artifactService){
        return new DeleteArtifactUseCaseImpl(artifactService);
    }

    @Bean
    public GetArtifactUseCaseImpl getArtifactUseCase(ArtifactService artifactService){
        return new GetArtifactUseCaseImpl(artifactService);
    }

    @Bean
    public GetUserUseCaseImpl getUserUseCase(UserService userService){
        return new GetUserUseCaseImpl(userService);
    }

    @Bean
    public DeleteUserUseCaseImpl deleteUserUseCase(UserService userService){
        return new DeleteUserUseCaseImpl(userService);
    }


}

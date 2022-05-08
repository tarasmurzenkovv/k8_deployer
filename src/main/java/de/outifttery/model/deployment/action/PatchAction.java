package de.outifttery.model.deployment.action;

import de.outifttery.actions.deployment.model.Operation;
import de.outifttery.model.deployment.DeploymentElement;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder(builderMethodName = "patch")
@RequiredArgsConstructor
public record PatchAction<T extends DeploymentElement>(
        Operation operation,
        String jsonPath,
        T value) {
}

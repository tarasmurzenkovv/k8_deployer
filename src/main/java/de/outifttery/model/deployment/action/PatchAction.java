package de.outifttery.model.deployment.action;

import de.outifttery.actions.deployment.model.Operation;
import de.outifttery.model.deployment.K8Element;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
public record PatchAction<T extends K8Element>(
        Operation operation,
        String jsonPath,
        T value) {
}

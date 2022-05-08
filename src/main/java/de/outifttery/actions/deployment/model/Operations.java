package de.outifttery.actions.deployment.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.outifttery.model.deployment.K8Element;
import de.outifttery.model.deployment.action.PatchAction;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class Operations {
    private final ObjectMapper DEFAULT_MAPPER = new ObjectMapper();
    private final List<PatchAction<? extends K8Element>> operations = new ArrayList<>();

    public <T extends K8Element> Operations add(PatchAction<T > patchAction) {
        operations.add(patchAction);
        return this;
    }

    @SneakyThrows
    public String asStrategicMergePatchStr() {
        return DEFAULT_MAPPER.writeValueAsString(operations);
    }
}

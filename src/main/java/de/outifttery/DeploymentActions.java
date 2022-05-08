package de.outifttery;

import de.outifttery.actions.deployment.model.*;
import de.outifttery.model.deployment.Container;
import de.outifttery.model.deployment.DeploymentDescription;
import de.outifttery.model.deployment.DeploymentElement;
import de.outifttery.model.deployment.action.PatchAction;
import io.kubernetes.client.custom.V1Patch;
import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.models.V1Deployment;
import io.kubernetes.client.util.PatchUtils;

import java.util.function.Consumer;

import io.kubernetes.client.openapi.apis.AppsV1Api;
import lombok.SneakyThrows;

import static de.outifttery.actions.deployment.model.Operation.REPLACE;
import static de.outifttery.model.deployment.action.PatchAction.patch;
import static io.kubernetes.client.custom.V1Patch.PATCH_FORMAT_STRATEGIC_MERGE_PATCH;

public class DeploymentActions {
    public static Consumer<ApiClient> updateImageVersion(Container container, DeploymentDescription deploymentDescription) {
        final var operations = new Operations()
                .add(singleImageVersionUpdate(container))
                .asStrategicMergePatchStr();
        return apiClient -> patchSneakely(deploymentDescription, operations, apiClient);
    }

    private static PatchAction<DeploymentElement> singleImageVersionUpdate(Container container) {
        return patch()
                .operation(REPLACE)
                .value(container)
                .jsonPath("/spec/template/spec/containers/0/image")
                .build();
    }

    @SneakyThrows
    private static V1Deployment patchSneakely(DeploymentDescription deploymentDescription, String operations, ApiClient apiClient) {
        return PatchUtils.patch(
                V1Deployment.class,
                () -> new AppsV1Api(apiClient).patchNamespacedDeploymentCall(
                        deploymentDescription.getDeploymentName(),
                        deploymentDescription.getNameSpace(),
                        new V1Patch(operations),
                        null,
                        null,
                        null, // field-manager is optional
                        null,
                        null, null),
                PATCH_FORMAT_STRATEGIC_MERGE_PATCH,
                apiClient);
    }
}

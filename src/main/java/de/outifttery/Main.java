package de.outifttery;

import de.outifttery.model.deployment.Container;
import de.outifttery.model.deployment.DeploymentDescription;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import static de.outifttery.DeploymentActions.updateImageVersion;
import static de.outifttery.K8Manager.withK8SClient;
import static io.kubernetes.client.util.ClientBuilder.standard;

@Slf4j
public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        withK8SClient(standard().build())
                .addActionToPipeline(
                        updateImageVersion(
                                Container.builder().imageName("nginx").imageTag("1.14.2").build(),
                                DeploymentDescription.builder().deploymentName("nginx-deployment").build()
                        ))
                .runActions()
                .getResults();
    }
}
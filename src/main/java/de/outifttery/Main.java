package de.outifttery;

import de.outifttery.model.deployment.Container;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import static de.outifttery.DeploymentActions.updateImageVersion;
import static de.outifttery.K8Manager.withK8SClient;
import static de.outifttery.model.deployment.DeploymentDescription.deployment;
import static io.kubernetes.client.util.ClientBuilder.standard;

@Slf4j
public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        withK8SClient(standard().build())
                .addActionToPipeline(
                        updateImageVersion(
                                Container.image().imageName("nginx").imageTag("1.14.2").build(),
                                deployment().deploymentName("nginx-deployment").build()
                        ))
                .runActions()
                .getResults();
    }
}
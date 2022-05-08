package de.outifttery.model.deployment;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(builderMethodName = "deployment")
public class DeploymentDescription {
    private final String nameSpace = "default";
    private final String deploymentName;
}

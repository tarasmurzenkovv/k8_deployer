package de.outifttery.model.deployment;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder(builderMethodName = "image")
@RequiredArgsConstructor
public final class Container extends DeploymentElement {
    private final String imageName, imageTag;
}

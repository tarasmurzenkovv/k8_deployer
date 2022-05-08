package de.outifttery.model.deployment;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
public final class Container extends K8Element {
    private final String imageName, imageTag;
}

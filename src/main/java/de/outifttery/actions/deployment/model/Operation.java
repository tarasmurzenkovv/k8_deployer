package de.outifttery.actions.deployment.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Operation {
    REPLACE("replace");
    private final String operation;
}

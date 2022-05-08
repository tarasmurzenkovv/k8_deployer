package de.outifttery;

import io.kubernetes.client.openapi.ApiClient;

public class K8Manager {
    public static K8Manager withK8SClient(ApiClient build) {
        return null;
    }

    public K8Manager addActionToPipeline() {
        return this;
    }

    public K8Manager addActionToPipeline(Object updateImageVersion) {
        return this;
    }

    public K8Manager runActions() {
        return this;
    }

    public void getResults() {
    }
}

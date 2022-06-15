package io.debezium.server.graal;

import javax.enterprise.context.Dependent;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.debezium.server.StreamNameMapper;

@Dependent
public class GraalNameMapper implements StreamNameMapper{
    @ConfigProperty(name = "mapper.tenant")
    String tenant;

    @ConfigProperty(name = "mapper.namespace")
    String namespace;

    @Override
    public String map(String topic) {
        return tenant + "/" + namespace + '/' + topic;
    }
}
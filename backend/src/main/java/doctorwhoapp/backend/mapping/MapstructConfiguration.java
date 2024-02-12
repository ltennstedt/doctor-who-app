package doctorwhoapp.backend.mapping;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingConstants.ComponentModel;

@MapperConfig(
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        componentModel = ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MapstructConfiguration {}

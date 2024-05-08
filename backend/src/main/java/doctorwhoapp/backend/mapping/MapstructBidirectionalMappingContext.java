package doctorwhoapp.backend.mapping;

import com.google.common.annotations.VisibleForTesting;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.TargetType;
import org.springframework.lang.NonNull;

public final class MapstructBidirectionalMappingContext {
    private final Map<Object, Object> knownInstances = Collections.synchronizedMap(new IdentityHashMap<>());

    @BeforeMapping
    public <S, T> T get(final @NonNull S source, @TargetType final @NonNull Class<T> targetType) {
        Objects.requireNonNull(source, "source");
        Objects.requireNonNull(targetType, "targetType");
        return targetType.cast(knownInstances.get(source));
    }

    @AfterMapping
    public <S, T> void put(final @NonNull S source, @MappingTarget final @NonNull T target) {
        Objects.requireNonNull(source, "source");
        Objects.requireNonNull(target, "target");
        knownInstances.put(source, target);
    }

    @VisibleForTesting
    Map<Object, Object> getKnownInstances() {
        return knownInstances;
    }
}

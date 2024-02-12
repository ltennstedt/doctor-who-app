package doctorwhoapp.backend.mapping;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MapstructBidirectionalMappingContextTests {
    private MapstructBidirectionalMappingContext context;

    @BeforeEach
    void beforeEach() {
        context = new MapstructBidirectionalMappingContext();
    }

    @Test
    void get_should_throw_Exception_when_source_is_null() {
        assertThatNullPointerException()
                .isThrownBy(() -> context.get(null, Object.class))
                .withMessage("source")
                .withNoCause();
    }

    @Test
    void get_should_throw_Exception_when_targetType_is_null() {
        assertThatNullPointerException()
                .isThrownBy(() -> context.get(new Object(), null))
                .withMessage("targetType")
                .withNoCause();
    }

    @Test
    void get_should_return_target() {
        final var source = new Object();
        final var target = "target";
        context.getKnownInstances().put(source, target);

        assertThat(context.get(source, String.class)).isSameAs(target);
    }

    @Test
    void put_should_throw_Exception_when_source_is_null() {
        assertThatNullPointerException()
                .isThrownBy(() -> context.put(null, new Object()))
                .withMessage("source")
                .withNoCause();
    }

    @Test
    void put_should_throw_Exception_when_target_is_null() {
        assertThatNullPointerException()
                .isThrownBy(() -> context.put(new Object(), null))
                .withMessage("target")
                .withNoCause();
    }

    @Test
    void put_should_put_source_and_target() {
        final var source = new Object();
        final var target = new Object();
        context.put(source, target);

        assertThat(context.getKnownInstances().get(source)).isSameAs(target);
    }
}

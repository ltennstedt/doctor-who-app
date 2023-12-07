package ltennstedt.doctorwhoapp.backend;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class DoctorWhoApplicationTests {
    @Autowired
    private ApplicationContext context;

    @Test
    void context_should_load() {
        assertThat(context.getStartupDate()).isPositive();
    }
}

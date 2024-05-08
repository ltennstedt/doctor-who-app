package doctorwhoapp.backend.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

final class DoctorModelTests {
    private final DoctorModel predecessor = new DoctorModel(1, 0, null, null, null, null, null, null, null);
    private final DoctorModel successor = new DoctorModel(3, 0, null, null, null, null, null, null, null);
    private final DoctorModel doctor = new DoctorModel(null, 0, null, null, null, null, null, predecessor, successor);

    @Test
    void getPredecessorId_should_return_predecessorId() {
        assertThat(doctor.getPredecessorId()).isOne();
    }

    @Test
    void getSuccessorId_should_return_successorId() {
        assertThat(doctor.getSuccessorId()).isEqualByComparingTo(3);
    }
}

CREATE
    SEQUENCE doctor_seq
START WITH
    1 INCREMENT BY 50;

CREATE
    TABLE
        doctor(
            id BIGINT NOT NULL,
            incarnation_number INTEGER NOT NULL,
            incarnation_name VARCHAR(255) NOT NULL,
            slogan VARCHAR(255),
            gender VARCHAR(255) NOT NULL CHECK(
                gender IN(
                    'FEMALE',
                    'MALE'
                )
            ),
            english_wikipedia_url VARCHAR(255) NOT NULL,
            german_wikipedia_url VARCHAR(255) NOT NULL,
            predecessor_id BIGINT UNIQUE,
            successor_id BIGINT UNIQUE,
            created_on TIMESTAMP(6) WITH TIME ZONE NOT NULL,
            updated_on TIMESTAMP(6) WITH TIME ZONE NOT NULL,
            version BIGINT NOT NULL,
            PRIMARY KEY(id)
        );

ALTER TABLE
    doctor ADD CONSTRAINT FKh4bgxvv4x7u4l8bru55najkd6 FOREIGN KEY(predecessor_id) REFERENCES doctor;

ALTER TABLE
    doctor ADD CONSTRAINT FKdp5pxjh615cu6oc67euluk191 FOREIGN KEY(successor_id) REFERENCES doctor;

CREATE
    SEQUENCE companion_seq
START WITH
    1 INCREMENT BY 50;

CREATE
    TABLE
        companion(
            id BIGINT NOT NULL,
            species VARCHAR(255) NOT NULL CHECK(
                species IN(
                    'GALLIFREYAN',
                    'HUMAN'
                )
            ),
            home_planet VARCHAR(255) NOT NULL CHECK(
                home_planet IN(
                    'GALLIFREY',
                    'EARTH'
                )
            ),
            gender VARCHAR(255) NOT NULL CHECK(
                gender IN(
                    'FEMALE',
                    'MALE'
                )
            ),
            english_wikipedia_url VARCHAR(255) NOT NULL,
            german_wikipedia_url VARCHAR(255) NOT NULL,
            created_on TIMESTAMP(6) WITH TIME ZONE NOT NULL,
            updated_on TIMESTAMP(6) WITH TIME ZONE NOT NULL,
            version BIGINT NOT NULL,
            PRIMARY KEY(id)
        );

CREATE
    TABLE
        companion_doctors(
            companion_id BIGINT NOT NULL,
            doctor_id BIGINT NOT NULL,
            UNIQUE(
                companion_id,
                doctor_id
            )
        );

ALTER TABLE
    companion_doctors ADD CONSTRAINT FKgmabd2mlj0uajj1fyjsxbfgn4 FOREIGN KEY(companion_id) REFERENCES companion;

ALTER TABLE
    companion_doctors ADD CONSTRAINT FK4jp72al8p26lbdmnf8lky1336 FOREIGN KEY(doctor_id) REFERENCES doctor;

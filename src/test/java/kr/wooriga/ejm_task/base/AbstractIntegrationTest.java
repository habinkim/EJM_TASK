package kr.wooriga.ejm_task.base;

import kr.wooriga.ejm_task.EjmTaskApplication;
import kr.wooriga.ejm_task.common.util.StringUtils;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest(
        classes = EjmTaskApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public abstract class AbstractIntegrationTest {

    @Autowired
    protected StringUtils stringUtils;

    private static final String ENV_TZ = "TZ";
    private static final String ASIA_SEOUL = "Asia/Seoul";

    private static final String MYSQL_IMAGE_NAME = "mysql:latest";
    @Container
    public static final MySQLContainer<?> MYSQL_CONTAINER =
            new MySQLContainer<>(DockerImageName.parse(MYSQL_IMAGE_NAME))
                    .withEnv(ENV_TZ, ASIA_SEOUL)
                    .withDatabaseName("code")
                    .withUsername("test")
                    .withPassword("test")
                    .withCommand(
                            "--character-set-server=utf8mb4",
                            "--collation-server=utf8mb4_unicode_ci",
                            "--skip-character-set-client-handshake",
                            "--default-time-zone=+09:00"
                    );

    @DynamicPropertySource
    public static void properties(DynamicPropertyRegistry registry) {
        MYSQL_CONTAINER.start();
        registry.add("spring.datasource.url",
                () -> String.format("jdbc:mysql://localhost:%d/%s", MYSQL_CONTAINER.getFirstMappedPort(), MYSQL_CONTAINER.getDatabaseName()));
        registry.add("spring.datasource.username", MYSQL_CONTAINER::getUsername);
        registry.add("spring.datasource.password", MYSQL_CONTAINER::getPassword);
    }


}

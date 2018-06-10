package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa;

import java.util.HashMap;
import java.util.Map;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.domain.User;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.persistence.UserRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;

public class JpaUserRepository extends NSheetsJpaRepositoryBase<User, Long> implements UserRepository {

    JpaUserRepository(PersistenceSettings settings) {
        super(settings);
    }

    @Override
    public User findByEmail(String email) {
        final Map<String, Object> params = new HashMap<>();
        params.put("email", email);

        return matchOne("e.email=:email", params);
    }
}

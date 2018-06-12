package pt.isep.nsheets.server.lapr4.blue.n1050475.s1.persistence;

import pt.isep.nsheets.shared.lapr4.blue.n1050475.s1.extensions.Conditional;
import eapli.framework.persistence.repositories.Repository;

public interface ConditionalRepository extends Repository<Conditional, Long> {
    public void remove(Conditional conditional);
}

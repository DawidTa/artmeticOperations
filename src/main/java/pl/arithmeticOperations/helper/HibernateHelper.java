package pl.arithmeticOperations.helper;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;
import pl.arithmeticOperations.entity.HistoryOperation;

@Service
public class HibernateHelper {

    public SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(HistoryOperation.class);
        StandardServiceRegistryBuilder registryBuilder =
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        return configuration.buildSessionFactory(registryBuilder.build());
    }
}

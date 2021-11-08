package com.training.utils;

import com.training.entities.Computer;
import com.training.entities.Manufacture;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author: VuiSK
 * @created: 08/11/2021-1:57 PM
 * @mailto: sanvankhanh@gmail.com
 */

public class HibernateUtils {
    private static final SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration();

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        configuration.addAnnotatedClass(Computer.class);
        configuration.addAnnotatedClass(Manufacture.class);
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void closeSession() {
        sessionFactory.close();
    }
}

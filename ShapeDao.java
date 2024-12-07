package org.example;

import org.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.SelectionQuery;

import java.util.List;

public class ShapeDao {

    public static void save(Shape shape) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(shape);
        transaction.commit();
        session.close();
    }

    public static void update(Shape shape, int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Shape shapeTemp = session.get(Shape.class, id);
        if (shapeTemp != null) {
            shapeTemp.setColor(shape.getColor());
            transaction.commit();
        }

        session.close();
    }

    public static List<Shape> getAllShapes() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        SelectionQuery<Shape> query = session.createSelectionQuery("FROM Shape", Shape.class);
        List<Shape> shapeList = query.list();
        session.close();
        return shapeList;
    }

    public static Shape getById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Shape shape = session.get(Shape.class, id);
        session.close();
        return shape;
    }

    public static void deleteById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Shape shape = session.get(Shape.class, id);
        if (shape != null) {
            session.remove(shape);
            transaction.commit();
        } else {
            System.out.println("This shape cannot be found in the database.");
        }
        session.close();
    }
}
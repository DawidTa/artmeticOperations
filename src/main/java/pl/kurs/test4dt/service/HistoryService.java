package pl.kurs.test4dt.service;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kurs.test4dt.entity.HistoryOperation;
import pl.kurs.test4dt.helper.HibernateHelper;
import pl.kurs.test4dt.model.AritmeticModel;
import pl.kurs.test4dt.repository.HistoryRepository;

import javax.transaction.Transactional;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class HistoryService {

    @Autowired
    HistoryRepository historyRepository;
    @Autowired
    HibernateHelper hibernateHelper;

    public void saveRecord(AritmeticModel aritmeticModel) throws UnknownHostException {
        HistoryOperation historyOperation = new HistoryOperation();
        historyOperation.setN1(aritmeticModel.getN1());
        historyOperation.setN2(aritmeticModel.getN2());
        historyOperation.setOperator(aritmeticModel.getOperator());
        historyOperation.setUserIPAddress(InetAddress.getLocalHost().getHostAddress());
        historyOperation.setCreatedDateTime(Timestamp.valueOf(LocalDateTime.now()));
        historyRepository.save(historyOperation);
    }

    @Transactional
    public List<HistoryOperation> getRecords(String operator, String dateFrom, String dateTo) {
        String className = HistoryOperation.class.getCanonicalName();

        String hql = "from " + className + " where (:operator is null or operator = :operator) " +
                "and (:dateFrom is null or created_date >= :dateFrom) " +
                "and (:dateTo is null or created_date <= :dateTo)";

        Session session = hibernateHelper.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery(hql);

        query.setParameter("operator", null);
        query.setParameter("dateFrom", null);
        query.setParameter("dateTo", null);

        if (operator != null) {
            query.setParameter("operator", operator);
        }
        if (dateFrom != null) {
            query.setParameter("dateFrom", dateFrom);
        }
        if (dateTo != null) {
            query.setParameter("dateTo", dateTo);
        }
        return query.list();
    }
}

package pl.kurs.test4dt.service;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kurs.test4dt.entity.HistoryOperation;
import pl.kurs.test4dt.helper.DateTimeHelper;
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
    DateTimeHelper dateTimeHelper;
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
        //String hql = "from " + className + " where 1=1";
        StringBuilder hql = new StringBuilder("from " + className);

        Session session = hibernateHelper.getSessionFactory().getCurrentSession();
        session.beginTransaction();


        if (operator != null) {
            hql.append(" where operator = :operator");
            Query query = session.createQuery(hql.toString());
            query.setParameter("operator", operator);
            return query.list();
        }
        if (dateFrom != null) {

        }
        if (dateTo != null) {

        }
        Query query = session.createQuery(hql.toString());
        return query.list();
    }

//    public List<HistoryOperation> getRecords(String operator, String dateFrom, String dateTo) {
//
//        if (operator != null) {
//            return historyRepository.findByOperator(operator);
//
//        } else if (dateFrom != null) {
//
//            Timestamp convertedDateTime = dateTimeHelper.convertStringToDateTime(dateFrom);
//            return historyRepository.findByCreatedDateTimeGreaterThan(convertedDateTime);
//
//        } else if (dateTo != null && dateFrom != null) {
//
//            Timestamp convertedDateTimeFrom = dateTimeHelper.convertStringToDateTime(dateFrom);
//            Timestamp convertedDateTimeTo = dateTimeHelper.convertStringToDateTime(dateTo);
//            return historyRepository.findByCreatedDateTimeBetween(convertedDateTimeFrom, convertedDateTimeTo);
//
//        } else if (dateFrom != null && operator != null) {
//
//            Timestamp convertedDateTime = dateTimeHelper.convertStringToDateTime(dateFrom);
//            return historyRepository.findByCreatedDateTimeGreaterThanAndOperator(convertedDateTime, operator);
//
//        } else if (dateTo != null && operator != null) {
//
//            Timestamp convertedDateTime = dateTimeHelper.convertStringToDateTime(dateTo);
//            return historyRepository.findByCreatedDateTimeLessThanAndOperator(convertedDateTime, operator);
//
//        } else if (dateFrom != null && dateTo != null && operator != null) {
//
//            Timestamp convertedDateTimeFrom = dateTimeHelper.convertStringToDateTime(dateFrom);
//            Timestamp convertedDateTimeTo = dateTimeHelper.convertStringToDateTime(dateTo);
//            return historyRepository.findByCreatedDateTimeBetweenAndOperator(convertedDateTimeFrom, convertedDateTimeTo, operator);
//
//        } else if (dateTo != null) {
//
//            Timestamp convertedDateTime = dateTimeHelper.convertStringToDateTime(dateTo);
//            return historyRepository.findByCreatedDateTimeLessThan(convertedDateTime);
//
//        }
//        return historyRepository.findAll();
//    }
}

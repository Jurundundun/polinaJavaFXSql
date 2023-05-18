package com.example.polinajavafxsql.jdbc;

import com.example.polinajavafxsql.entity.*;

import java.sql.*;

public class InsertEntityInDb {
    public static void insertTrainingInDb(Connection connection, Training training) throws SQLException {
        connection = ConnectionDb.connectingToDatabase();
        String query = "INSERT INTO " +
                "Запись_о_прохождении_квалификации(Код_записи,Код_сотрудника,Наименование_курса,Дата_записи,Лицензионный_номер,Дата_получения,Дата) " +
                "VALUES(?,?,?,?,?,?,?) ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,training.getId());
        preparedStatement.setInt(2,training.getIdEmployee());
        preparedStatement.setString(3,training.getName());
        preparedStatement.setDate(4,Date.valueOf(training.getRecordingDate()));
        preparedStatement.setString(5,training.getLicenseNumber());
        preparedStatement.setDate(6,Date.valueOf(training.getDateOfReceiving()));
        preparedStatement.setDate(7,Date.valueOf(training.getData()));

        preparedStatement.execute();

    }
    public static void insertReportInDb(Connection connection, Report report) throws SQLException {
        connection = ConnectionDb.connectingToDatabase();
        String query = "INSERT INTO " +
                "Отчетность_занятия(Код_отчетности,Код_услуги,Дата,Код_договора,Код_сотрудника) " +
                "VALUES(?,?,?,?,?) ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,report.getId());
        preparedStatement.setInt(2,report.getIdService());
        preparedStatement.setDate(3,Date.valueOf(report.getData()));
        preparedStatement.setInt(4,report.getIdContract());
        preparedStatement.setInt(5,report.getIdEmployee());

        preparedStatement.execute();

    }
    public static void insertClientInDb(Connection connection, Client client) throws SQLException {
        connection = ConnectionDb.connectingToDatabase();
        String query = "INSERT INTO " +
                "Клиенты(Код_клиента,ФИО_ребенка,ФИО_законного_представителя,Дата_рождения_ребенка,Телефон,Электронная_Почта) " +
                "VALUES(?,?,?,?,?,?) ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,client.getId());
        preparedStatement.setString(2,client.getFioChild());
        preparedStatement.setString(3,client.getFioParent());
        preparedStatement.setDate(4,Date.valueOf(client.getBirthDateChild()));
        preparedStatement.setString(5,client.getPhoneNumber());
        preparedStatement.setString(6,client.getEmail());

        preparedStatement.execute();
    }
    public static void insertEmployeeInDb(Connection connection, Employee employee) throws SQLException {
        connection = ConnectionDb.connectingToDatabase();
        String query = "INSERT INTO " +
                "Сотрудники(Код_Сотрудника,ФИО,Дата_рождения,Пол,Номер_телефона,Электронная_почта,Код_Организации,Код_Должности) " +
                "VALUES(?,?,?,?,?,?,?,?) ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,employee.getId());
        preparedStatement.setString(2,employee.getFio());
        preparedStatement.setDate(3,Date.valueOf(employee.getBirthDate()));
        preparedStatement.setString(4,employee.getGen());
        preparedStatement.setString(5,employee.getPhoneNumber());
        preparedStatement.setString(6,employee.getEmail());
        preparedStatement.setInt(7,employee.getIdOrganization());
        preparedStatement.setInt(8,employee.getIdPosition());

        preparedStatement.execute();
    }
    public static void insertServiceInDb(Connection connection, Service service) throws SQLException {
        connection = ConnectionDb.connectingToDatabase();
        String query = "INSERT INTO " +
                "Услуги(Код_услуги,Наименование,Цена,Код_организации) " +
                "VALUES(?,?,?,?) ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,service.getId());
        preparedStatement.setString(2,service.getName());
        preparedStatement.setDouble(3,Double.parseDouble(service.getPrice()));
        preparedStatement.setInt(4,service.getIdOrganization());

        preparedStatement.execute();
    }
    public static void insertPDSInDb(Connection connection, Employee employee) throws SQLException {
        connection = ConnectionDb.connectingToDatabase();
        String query = "insert into " +
                "ПДС(Код_клиента,ФИО,Серия_паспорта,Номер_паспорта,Код_подразделения,Кем_выдан,Когда_выдан)" +
                "VALUES(?,?,?,?,?,?,?) ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, employee.getId());
        preparedStatement.setString(2, employee.getFio());
        preparedStatement.setInt(3, employee.getPassportSeries());
        preparedStatement.setInt(4, employee.getPasportNumber());
        preparedStatement.setString(5, employee.getIdSubdivision());
        preparedStatement.setString(6, employee.getIssuedBy());
        preparedStatement.setDate(7,Date.valueOf(employee.getWhenIssued()));

        preparedStatement.execute();

    }
    public static void insertPDKInDb(Connection connection, Client client) throws SQLException {
        connection = ConnectionDb.connectingToDatabase();
        String query = "insert into " +
                "ПДК(Код_клиента,ФИО,Серия_паспорта,Номер_паспорта,Код_подразделения,Кем_выдан,Когда_выдан)" +
                "VALUES(?,?,?,?,?,?,?) ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,client.getId());
        preparedStatement.setString(2,client.getFioParent());
        preparedStatement.setInt(3,client.getPassportSeries());
        preparedStatement.setInt(4,client.getPasportNumber());
        preparedStatement.setString(5,client.getIdSubdivision());
        preparedStatement.setString(6,client.getIssuedBy());
        preparedStatement.setDate(7,Date.valueOf(client.getWhenIssued()));

        preparedStatement.execute();

    }
    public static void insertContractInDb(Connection connection, Contract contract) throws SQLException {
        connection = ConnectionDb.connectingToDatabase();
        String query = "INSERT INTO " +
                "Договор_с_клиентом(Код_договора,Код_клиента,Код_организации,Дата_договора,Дата_оплаты) " +
                "VALUES(?,?,?,?,?) ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,contract.getId());
        preparedStatement.setInt(2,contract.getIdClient());
        preparedStatement.setInt(3,contract.getIdOrganization());
        preparedStatement.setDate(4,Date.valueOf(contract.getContractData()));
        preparedStatement.setDate(5,Date.valueOf(contract.getDateOfPayment()));

        preparedStatement.execute();

    }
    public static void insertReceiptInDb(Connection connection, Receipt receipt) throws SQLException {
        connection = ConnectionDb.connectingToDatabase();
        String query = "INSERT INTO " +
                "Квитанции_на_оплату(Код_квитанции,Код_договора) " +
                "VALUES(?,?) ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,receipt.getId());
        preparedStatement.setInt(2,receipt.getIdContract());

        preparedStatement.execute();

    }
    public static void insertTabletimeInDb(Connection connection, Tabletime tabletime) throws SQLException {
        connection = ConnectionDb.connectingToDatabase();
        String query = "INSERT INTO " +
                "Расписание(Код_строки,Дата,День_недели,Время,Код_услуги,Код_организации) " +
                "VALUES(?,?,?,?,?,?) ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, tabletime.getId());
        preparedStatement.setDate(2, Date.valueOf(tabletime.getTime()));
        preparedStatement.setString(3, tabletime.getDayOfTheWeek());
        preparedStatement.setString(4, tabletime.getTime());
        preparedStatement.setInt(5, tabletime.getIdService());
        preparedStatement.setInt(6, tabletime.getIdOrganization());

        preparedStatement.execute();

    }
}

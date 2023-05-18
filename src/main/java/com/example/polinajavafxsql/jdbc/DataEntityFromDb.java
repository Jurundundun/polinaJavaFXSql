package com.example.polinajavafxsql.jdbc;

import com.example.polinajavafxsql.entity.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class DataEntityFromDb {
    public static ObservableList<Tabletime> getTabletimesFromDb(Connection connection){
        ObservableList<Tabletime> tabletimes = FXCollections.observableArrayList();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("select * from Расписание");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                tabletimes.add(new Tabletime(
                        LocalDate.parse(resultSet.getString("Дата")),
                        resultSet.getString("День_недели"),
                        Integer.parseInt(resultSet.getString("Код_строки")),
                        Integer.parseInt(resultSet.getString("Код_организации")),
                        Integer.parseInt(resultSet.getString("Код_услуги")),
                        resultSet.getString("Время")));
            }
        }catch (Exception e){

        }

        return tabletimes;
    }
    public static ObservableList<Reviews> getReviewsFromDb(Connection connection){
        ObservableList<Reviews> reviews = FXCollections.observableArrayList();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("select * from Отзывы");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                reviews.add(new Reviews(
                        Integer.parseInt(resultSet.getString("Код_отзыва")),
                        Integer.parseInt(resultSet.getString("Код_клиента")),
                        resultSet.getString("Отзыв")
                ));
            }
        }catch (Exception e){

        }

        return reviews;
    }
    public static ObservableList<CompaniInfo> getInfoCompaniFromDb(Connection connection){
        ObservableList<CompaniInfo> companiInfos = FXCollections.observableArrayList();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("select * from Сведения_компании");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                companiInfos.add(new CompaniInfo(
                        resultSet.getString("Фактический_Адрес"),
                        resultSet.getString("Электронная_почта"),
                        resultSet.getString("ФИО_Директора"),
                        Integer.parseInt(resultSet.getString("Код_организации")),
                        resultSet.getString("Юридический_Адрес"),
                        resultSet.getString("Наименование_учреждения"),
                        resultSet.getString("Телефон")

                ));
            }
        }catch (Exception e){

        }

        return companiInfos;
    }
    public static ObservableList<Employee> getEmployeeFromDb(Connection connection){
        ObservableList<Employee> employees = FXCollections.observableArrayList();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("select * from Сотрудники");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                employees.add(new Employee(
                        LocalDate.parse(resultSet.getString("Дата_рождения")),
                        resultSet.getString("Электронная_почта"),
                        resultSet.getString("ФИО"),
                        resultSet.getString("Пол"),
                        Integer.parseInt(resultSet.getString("Код_Сотрудника")),
                        resultSet.getString("Номер_телефона"),
                        Integer.parseInt(resultSet.getString("Код_Организации")),
                        Integer.parseInt(resultSet.getString("Код_Должности"))

                ));
            }
        }catch (Exception e){

        }

        return employees;
    }
    public static ObservableList<Employee> getInfoEmployeeByGenFromDb(Connection connection,String gen){
        ObservableList<Employee> employees = FXCollections.observableArrayList();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Сотрудники.Код_Сотрудника,Сотрудники.ФИО, Сотрудники.Дата_рождения,Сотрудники.Пол,Сотрудники.Номер_телефона, Сотрудники.Электронная_почта, Запись_о_прохождении_квалификации.Дата, Запись_о_прохождении_квалификации.Наименование_курса, ПДС.Серия_паспорта, ПДС.Номер_паспорта, ПДС.Код_подразделения, ПДС.Кем_выдан, ПДС.Когда_выдан FROM Сотрудники INNER JOIN Запись_о_прохождении_квалификации ON Сотрудники.Код_Сотрудника = Запись_о_прохождении_квалификации.Код_сотрудника INNER JOIN ПДС ON Сотрудники.Код_Сотрудника = ПДС.Код_сотрудника WHERE Сотрудники.Пол LIKE "+"\'%М%\';");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                employees.add(new Employee(
                        LocalDate.parse(resultSet.getString("Дата_рождения")),
                        LocalDate.parse(resultSet.getString("Дата")),
                        resultSet.getString("Электронная_почта"),
                        resultSet.getString("ФИО"),
                        resultSet.getString("Пол"),
                        Integer.parseInt(resultSet.getString("Код_Сотрудника")),
                        resultSet.getString("Код_подразделения"),
                        resultSet.getString("Кем_выдан"),
                        resultSet.getString("Наименование_курса"),
                        Integer.parseInt( resultSet.getString("Номер_паспорта")),
                        Integer.parseInt(resultSet.getString("Серия_паспорта")),
                        resultSet.getString("Номер_телефона"),
                        LocalDate.parse(resultSet.getString("Когда_выдан")),
                        Integer.parseInt(resultSet.getString("Код_Организации")),
                        Integer.parseInt(resultSet.getString("Код_Должности"))

                ));
            }
        }catch (Exception e){

        }

        return employees;
    }

    public static ObservableList<Employee> getInfoEmployeeFromDb(Connection connection){
        ObservableList<Employee> employees = FXCollections.observableArrayList();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Сотрудники.Код_Сотрудника,Сотрудники.ФИО, Сотрудники.Дата_рождения," +
                    "Сотрудники.Пол,Сотрудники.Номер_телефона,Сотрудники.Код_Организации,Сотрудники.Код_Должности, Сотрудники.Электронная_почта, " +
                    "Запись_о_прохождении_квалификации.Дата, Запись_о_прохождении_квалификации.Наименование_курса, ПДС.Серия_паспорта, " +
                    "ПДС.Номер_паспорта, ПДС.Код_подразделения, ПДС.Кем_выдан, ПДС.Когда_выдан " +
                    "FROM Сотрудники INNER JOIN Запись_о_прохождении_квалификации ON " +
                    "Сотрудники.Код_Сотрудника = Запись_о_прохождении_квалификации.Код_сотрудника INNER JOIN ПДС ON Сотрудники.Код_Сотрудника = ПДС.Код_сотрудника;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                employees.add(new Employee(
                        LocalDate.parse(resultSet.getString("Дата_рождения")),
                        LocalDate.parse(resultSet.getString("Дата")),
                        resultSet.getString("Электронная_почта"),
                        resultSet.getString("ФИО"),
                        resultSet.getString("Пол"),
                        Integer.parseInt(resultSet.getString("Код_Сотрудника")),
                        resultSet.getString("Код_подразделения"),
                        resultSet.getString("Кем_выдан"),
                        resultSet.getString("Наименование_курса"),
                        Integer.parseInt( resultSet.getString("Номер_паспорта")),
                        Integer.parseInt(resultSet.getString("Серия_паспорта")),
                        resultSet.getString("Номер_телефона"),
                        LocalDate.parse(resultSet.getString("Когда_выдан")),
                        Integer.parseInt(resultSet.getString("Код_Организации")),
                        Integer.parseInt(resultSet.getString("Код_Должности"))

                ));
            }
        }catch (Exception e){

        }

        return employees;
    }
    public static ObservableList<Service> getServiceFromDb(Connection connection){
        ObservableList<Service> services = FXCollections.observableArrayList();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("select * from Услуги");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                services.add(new Service(
                        Integer.parseInt(resultSet.getString("Код_услуги")),
                        resultSet.getString("Наименование"),
                        resultSet.getString("Цена"),
                        Integer.parseInt(resultSet.getString("Код_организации"))

                ));
            }
        }catch (Exception e){

        }

        return services;
    }
    public static ObservableList<Client> getClientFromDb(Connection connection){
        ObservableList<Client> clients = FXCollections.observableArrayList();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Клиенты.Код_клиента, Клиенты.ФИО_ребенка, " +
                    "Клиенты.ФИО_законного_представителя, Клиенты.Дата_рождения_ребенка,Клиенты.Телефон, Клиенты.Электронная_Почта, " +
                    "Договор_с_клиентом.Код_договора, Договор_с_клиентом.Дата_договора, Договор_с_клиентом.Дата_оплаты, " +
                    "Квитанции_на_оплату.Код_квитанции, ПДК.Серия_паспорта, ПДК.Номер_паспорта, ПДК.Код_подразделения, ПДК.Кем_выдан, " +
                    "ПДК.Когда_выдан,Отзывы.Отзыв FROM Клиенты INNER JOIN Отзывы ON Клиенты.Код_клиента = Отзывы.Код_клиента " +
                    "INNER JOIN ПДК ON Клиенты.Код_клиента = ПДК.Код_клиента INNER JOIN Договор_с_клиентом " +
                    "ON Клиенты.Код_клиента = Договор_с_клиентом.Код_клиента INNER JOIN Квитанции_на_оплату " +
                    "ON Договор_с_клиентом.Код_договора = Квитанции_на_оплату.Код_договора;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                clients.add(new Client(
                    LocalDate.parse(resultSet.getString("Дата_рождения_ребенка")),
                    resultSet.getString("Электронная_Почта"),
                    resultSet.getString("ФИО_ребенка"),
                    resultSet.getString("ФИО_законного_представителя"),
                    Integer.parseInt(resultSet.getString("Код_клиента")),
                    resultSet.getString("Телефон"),
                    LocalDate.parse(resultSet.getString("Дата_договора")),
                    LocalDate.parse(resultSet.getString("Дата_оплаты")),
                    Integer.parseInt(resultSet.getString("Код_договора")),
                    Integer.parseInt(resultSet.getString("Код_квитанции")),
                    resultSet.getString("Код_подразделения"),
                    resultSet.getString("Кем_выдан"),
                    Integer.parseInt(resultSet.getString("Номер_паспорта")),
                    Integer.parseInt(resultSet.getString("Серия_паспорта")),
                    resultSet.getString("Отзыв"),
                    LocalDate.parse(resultSet.getString("Когда_выдан"))

                ));
            }
        }catch (Exception e){

        }

        return clients;
    }
    public static ObservableList<Contract> getContractFromDb(Connection connection){
        ObservableList<Contract> contracts = FXCollections.observableArrayList();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("select * from Договор_с_клиентом");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                contracts.add(new Contract(
                    LocalDate.parse(resultSet.getString("Дата_договора")),
                    LocalDate.parse(resultSet.getString("Дата_оплаты")),
                    Integer.parseInt(resultSet.getString("Код_договора")),
                    Integer.parseInt(resultSet.getString("Код_клиента")),
                    Integer.parseInt(resultSet.getString("Код_организации"))

                ));
            }
        }catch (Exception e){

        }

        return contracts;
    }
    public static ObservableList<Receipt> getReceiptFromDb(Connection connection){
        ObservableList<Receipt> receipts = FXCollections.observableArrayList();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("select * from Квитанции_на_оплату");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                receipts.add(new Receipt(
                    Integer.parseInt(resultSet.getString("Код_квитанции")),
                    Integer.parseInt(resultSet.getString("Код_договора"))
                ));
            }
        }catch (Exception e){

        }

        return receipts;
    }
    public static ObservableList<Report> getReportFromDb(Connection connection){
        ObservableList<Report> reports = FXCollections.observableArrayList();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("select * from Отчетность_занятия;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                reports.add(new Report(
                        LocalDate.parse(resultSet.getString("Дата")),
                        Integer.parseInt(resultSet.getString("Код_отчетности")),
                        Integer.parseInt(resultSet.getString("Код_договора")),
                        Integer.parseInt(resultSet.getString("Код_сотрудника")),
                        Integer.parseInt(resultSet.getString("Код_услуги"))

                ));
            }
        }catch (Exception e){

        }

        return reports;
    }
}

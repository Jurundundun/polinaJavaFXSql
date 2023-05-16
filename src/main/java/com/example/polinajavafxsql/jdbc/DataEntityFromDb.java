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
                        Integer.parseInt(resultSet.getString("Код_Сотрудника")),
                        resultSet.getString("ФИО"),
                        LocalDate.parse(resultSet.getString("Дата_рождения")),
                        resultSet.getString("Пол"),
                        resultSet.getString("Номер_телефона"),
                        resultSet.getString("Электронная_почта"),
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
            PreparedStatement preparedStatement = connection.prepareStatement("select * from Клиенты");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                clients.add(new Client(
                    LocalDate.parse(resultSet.getString("Дата_рождения_ребенка")),
                    resultSet.getString("Электронная_Почта"),
                    resultSet.getString("ФИО_ребенка"),
                    resultSet.getString("ФИО_законного_представителя"),
                    Integer.parseInt(resultSet.getString("Код_клиента")),
                    resultSet.getString("Телефон")

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
                    Integer.parseInt(resultSet.getString("Код_договора")),
                    Integer.parseInt(resultSet.getString("Код_договора"))
                ));
            }
        }catch (Exception e){

        }

        return receipts;
    }
}

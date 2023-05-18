package com.example.polinajavafxsql.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DownloadTables {
    public static void downloadTables() throws SQLException {
        Connection connection = ConnectionDb.connectingToDatabase();
        if(connection != null) {
            Statement statement = connection.createStatement();
            //create
            statement.executeUpdate("CREATE TABLE Сведения_компании(\n" +
                    "Код_организации INT PRIMARY KEY NOT NULL,\n" +
                    "Наименование_учреждения text NOT NULL,\n" +
                    "Юридический_Адрес text NOT NULL,\n" +
                    "Фактический_Адрес text NOT NULL,\n" +
                    "Телефон text NOT NULL,\n" +
                    "Электронная_почта text NOT NULL,\n" +
                    "ФИО_Директора text NOT NULL); \n" +
                    "\n" +
                    "INSERT INTO Сведения_компании\n" +
                    "(Код_организации,\n" +
                    "Наименование_учреждения,\n" +
                    "Юридический_Адрес,\n" +
                    "Фактический_Адрес,\n" +
                    "Телефон,\n" +
                    "Электронная_почта," +
                    "ФИО_Директора)\n" +
                    "VALUES\n" +
                    "(1,\n" +
                    "'Центр дополнительно образования \"Dash it!\"',\n" +
                    "'г. Казань, ул. Зинина, 7',\n" +
                    "'г. Казань, ул. Зинина, 7',\n" +
                    "'55800110',\n" +
                    "'dashit@org.ru'," +
                    "'УнинаЛФ');"

            );
            statement.executeUpdate("CREATE TABLE Услуги(\n" +
                    "Код_услуги INT PRIMARY KEY NOT NULL,\n" +
                    "Наименование text NOT NULL,\n" +
                    "Цена real NOT NULL,\n" +
                    "Код_организации INT,\n" +
                    "FOREIGN KEY (Код_организации) REFERENCES Сведения_компании(Код_организации));"

            );
            statement.executeUpdate("INSERT INTO Услуги(Код_услуги,Наименование,Цена,Код_организации)\n" +
                    "VALUES\n" +
                    "(1,'Занятие по Русскому Языку',1500.0,1); ");
            statement.executeUpdate("CREATE TABLE Расписание(\n" +
                    "Код_строки int primary key not null,\n" +
                    "Дата date not NULL,\n" +
                    "День_недели text NULL,\n" +
                    "Время text NOT NULL,\n" +
                    "Код_услуги int not NULL,\n" +
                    "Код_организации int not null,\n" +
                    "FOREIGN KEY (Код_организации) REFERENCES Сведения_компании(Код_организации),\n" +
                    "FOREIGN KEY (Код_услуги) REFERENCES Услуги(Код_услуги));\n" +
                    "\n" +
                    "INSERT INTO Расписание(Код_строки, Дата,День_недели,Время,Код_услуги,Код_организации)\n" +
                    "VALUES\n" +
                    "(1,'03.01.2023','ПН','13:00', 1,1); "

            );
            statement.executeUpdate("\n" +
                    "CREATE TABLE Должности(\n" +
                    "Код_должности INT PRIMARY KEY NOT NULL,\n" +
                    "Наименование text not NULL,\n" +
                    "Оклад money not NULL,\n" +
                    "Код_организации int not NULL,\n" +
                    "FOREIGN KEY (Код_организации) REFERENCES Сведения_компании(Код_организации));\n" +
                    "\n" +
                    "INSERT INTO Должности(Код_должности,Наименование,Оклад,Код_организации)\n" +
                    "VALUES\n" +
                    "(1,'Директор','80000',1)," +
                    "(2,'Администратор','40000',1)," +
                    "(3,'Преподаватель','30000',1); "

            );
            statement.executeUpdate("CREATE TABLE Сотрудники (\n" +
                    "Код_Сотрудника int primary key NOT NULL,\n" +
                    "ФИО text NOT NULL,\n" +
                    "Дата_рождения date NOT NULL, \n" +
                    "Пол text NOT NULL,\n" +
                    "Номер_телефона text NOT NULL,\n" +
                    "Электронная_почта text NULL,\n" +
                    "Код_Организации int NOT NULL,\n" +
                    "Код_Должности int NOT NULL,\n" +
                    "FOREIGN KEY (Код_Организации) REFERENCES Сведения_компании(Код_организации));\n" +
                    "\n" +
                    "INSERT INTO Сотрудники(\n" +
                    "Код_Сотрудника,\n" +
                    "ФИО,\n" +
                    "Дата_рождения,\n" +
                    "Пол,\n" +
                    "Номер_телефона,\n" +
                    "Электронная_почта,\n" +
                    "Код_Организации,\n" +
                    "Код_Должности)\n" +
                    "VALUES \n" +
                    "(1,'Дектянников Даниил Юрьевич', '01.01.2002', 'М','81231212121', '1@org.ru',1,3)," +
                    "(2,'Иванов Иван Иванович', '03.02.2000', 'М','868854858585', '2@org.ru',1,2)," +
                    "(3,'Даниилов Данил Данилович', '10.10.2005', 'М','8126436346', '3@org.ru',1,1);"

            );

            statement.executeUpdate("CREATE TABLE Запись_о_прохождении_квалификации(\n" +
                    "Код_записи INT primary key NOT NULL,\n" +
                    "Код_сотрудника int NOT NULL,\n" +
                    "Наименование_курса text NOT NULL,\n" +
                    "Дата_записи date not null,\n" +
                    "Лицензионный_номер text not null,\n" +
                    "Дата_получения date not null,\n" +
                    "Дата date NOT NULL,\n" +
                    "FOREIGN KEY (Код_сотрудника) REFERENCES Сотрудники(Код_Сотрудника));\n" +
                    "INSERT INTO Запись_о_прохождении_квалификации(Код_записи,Код_сотрудника,Наименование_курса,Дата_записи,Лицензионный_номер,Дата_получения,Дата)\n" +
                    "VALUES\n" +
                    "(1,1,'Игровые технологии в обучении: математические игры и головоломки в начальной и средней школе','10/01/2013', '123456789','12/01/2023','13/02/2023');"

            );
            statement.executeUpdate("CREATE TABLE ПДС(\n" +
                    "Код_сотрудника INT PRIMARY KEY NOT NULL,\n" +
                    "ФИО text NOT NULL,\n" +
                    "Серия_паспорта int NOT NULL,\n" +
                    "Номер_паспорта int NOT NULL,\n" +
                    "Код_подразделения text NOT NULL,\n" +
                    "Кем_выдан text NOT NULL,\n" +
                    "Когда_выдан date not null,\n" +
                    "FOREIGN KEY (Код_сотрудника) REFERENCES Сотрудники(Код_Сотрудника));\n" +
                    "\n" +
                    "INSERT INTO ПДС(\n" +
                    "Код_сотрудника,\n" +
                    "ФИО,\n" +
                    "Серия_паспорта,\n" +
                    "Номер_паспорта,\n" +
                    "Код_подразделения,\n" +
                    "Кем_выдан,\n" +
                    "Когда_выдан\n" +
                    ")\n" +
                    "VALUES\n" +
                    "(1,\n" +
                    "'Дектянников Даниил Юрьевич',\n" +
                    "5555,\n" +
                    "123432,\n" +
                    "'123-546',\n" +
                    "'ГУ МВД г.Казань',\n" +
                    "'05.04.2001') ;"

            );
            statement.executeUpdate("CREATE TABLE Клиенты(\n" +
                    "Код_клиента INT PRIMARY KEY NOT NULL,\n" +
                    "ФИО_ребенка text not NULL,\n" +
                    "ФИО_законного_представителя text NOT NULL,\n" +
                    "Дата_рождения_ребенка date NOT NULL,\n" +
                    "Телефон text NOT NULL,\n" +
                    "Электронная_Почта text NULL\n" +
                    ");\n" +
                    "\n" +
                    "INSERT INTO Клиенты(\n" +
                    "Код_клиента,\n" +
                    "ФИО_ребенка,\n" +
                    "ФИО_законного_представителя,\n" +
                    "Дата_рождения_ребенка,\n" +
                    "Телефон,\n" +
                    "Электронная_Почта\n" +
                    ")VALUES\n" +
                    "(1,\n" +
                    "'Якимов Евгений Владиславович',\n" +
                    "'Якимов Владислав Юрьевич',\n" +
                    "'05.03.2015',\n" +
                    "'+7231457681',\n" +
                    "'klient1@icloud.com');"

            );
            statement.executeUpdate(
                    "CREATE TABLE Отзывы(\n" +
                    "Код_отзыва INT PRIMARY KEY NOT NULL,\n" +
                    "Отзыв text NULL,\n" +
                    "Код_клиента int NULL\n" +
                    ");\n" +
                    "\n" +
                    "INSERT INTO Отзывы(Код_отзыва,Отзыв,Код_клиента)\n" +
                    "VALUES\n" +
                    "(1,'Супер!',1);"

            );
            statement.executeUpdate("CREATE TABLE ПДК(\n" +
                    "Код_клиента INT PRIMARY KEY NOT NULL,\n" +
                    "ФИО text NOT NULL,\n" +
                    "Серия_паспорта int NOT NULL,\n" +
                    "Номер_паспорта int NOT NULL,\n" +
                    "Код_подразделения text NOT NULL,\n" +
                    "Кем_выдан text NOT NULL,\n" +
                    "Когда_выдан date not null,\n" +
                    "FOREIGN KEY (Код_клиента) REFERENCES Клиенты(Код_клиента));\n" +
                    "\n" +
                    "INSERT INTO ПДК(\n" +
                    "Код_клиента,\n" +
                    "ФИО,\n" +
                    "Серия_паспорта,\n" +
                    "Номер_паспорта,\n" +
                    "Код_подразделения,\n" +
                    "Кем_выдан,\n" +
                    "Когда_выдан\n" +
                    ")\n" +
                    "VALUES\n" +
                    "(1,\n" +
                    "'Якимов Владислав Юрьевич',\n" +
                    "4444,\n" +
                    "098765,\n" +
                    "'123-546',\n" +
                    "'ГУ МВД г.Казань',\n" +
                    "'01.01.2001') ;"

            );
            statement.executeUpdate("CREATE TABLE Договор_с_клиентом(\n" +
                    "Код_договора INT PRIMARY KEY NOT NULL,\n" +
                    "Код_клиента int NOT NULL,\n" +
                    "Код_организации int NOT NULL,\n" +
                    "Дата_договора date NOT NULL,\n" +
                    "Дата_оплаты date NOT NULL,\n" +
                    "FOREIGN KEY (Код_клиента) REFERENCES Клиенты(Код_клиента),\n" +
                    "FOREIGN KEY (Код_организации) REFERENCES Сведения_компании(Код_организации));\n" +
                    "\n" +
                    "INSERT INTO  Договор_с_клиентом(\n" +
                    "Код_договора,\n" +
                    "Код_клиента,\n" +
                    "Код_организации,\n" +
                    "Дата_договора,\n" +
                    "Дата_оплаты)\n" +
                    "VALUES\n" +
                    "(1,1,1,'01.01.2022','03.01.2022') ;"

            );
            statement.executeUpdate("CREATE TABLE Квитанции_на_оплату(\n" +
                    "Код_квитанции INT PRIMARY KEY NOT NULL,\n" +
                    "Код_договора INT not null,\n" +
                    "FOREIGN KEY (Код_договора) REFERENCES Договор_с_клиентом(Код_договора)\n" +
                    ");\n" +
                    "\n" +
                    "\n" +
                    "INSERT INTO Квитанции_на_оплату\n" +
                    "(Код_квитанции,\n" +
                    "Код_договора)\n" +
                    "VALUES\n" +
                    "(1,1)  ;"

            );
            statement.executeUpdate("CREATE TABLE Оказываемые_услуги(\n" +
                    "Код_договора INT NOT NULL,\n" +
                    "Код_услуги int NOT NULL, \n" +
                    "FOREIGN KEY (Код_договора) REFERENCES Договор_с_клиентом(Код_договора),\n" +
                    "PRIMARY Key (Код_договора, Код_услуги));\n" +
                    "INSERT INTO Оказываемые_услуги(\n" +
                    "Код_договора,\n" +
                    "Код_услуги)\n" +
                    "VALUES\n" +
                    "(1,1);"

            );
            statement.executeUpdate("CREATE TABLE Отчетность_занятия (\n" +
                    "Код_отчетности int NOT NULL,\n" +
                    "Код_услуги int not NULL,\n" +
                    "Дата date not NULL,\n" +
                    "Код_договора int not NULL,\n" +
                    "Код_сотрудника int not NULL,\n" +
                    "PRIMARY KEY (Код_отчетности, Код_договора, Код_сотрудника));\n" +
                    "\n" +
                    "INSERT INTO Отчетность_занятия (\n" +
                    "Код_отчетности,\n" +
                    "Код_услуги,\n" +
                    "Дата,\n" +
                    "Код_договора,\n" +
                    "Код_сотрудника)\n" +
                    "VALUES \n" +
                    "(1,1, '01.01.2002', 1,1);"

            );






        }
    }
}

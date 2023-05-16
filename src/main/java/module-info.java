module com.example.polinajavafxsql {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;


    opens com.example.polinajavafxsql to javafx.fxml;
    exports com.example.polinajavafxsql;
    opens com.example.polinajavafxsql.entity to javafx.fxml;
    exports com.example.polinajavafxsql.entity;

}
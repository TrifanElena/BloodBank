package com.bloodbank.dao;

import com.bloodbank.db.DatabaseConnector;
import com.bloodbank.model.Utilizator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilizatorDAO {
    public Utilizator getUtilizatorByUsernameAndPassword(String username, String password) {
        String query = "SELECT * FROM utilizatori WHERE username = ? AND password = ?";
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Utilizator(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addUtilizator(Utilizator utilizator) {
        String query = "INSERT INTO utilizatori (username, password) VALUES (?, ?)";
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, utilizator.getUsername());
            statement.setString(2, utilizator.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUtilizator(Utilizator utilizator) {
        String query = "UPDATE utilizatori SET username = ?, password = ? WHERE id = ?";
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, utilizator.getUsername());
            statement.setString(2, utilizator.getPassword());
            statement.setInt(3, utilizator.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUtilizator(int id) {
        String query = "DELETE FROM utilizatori WHERE id = ?";
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

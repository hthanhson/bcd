package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Client;

public class ClientDAO extends DAO {

    public ClientDAO() {
        super();
    }

    public List<Client> searchClientsByName(String name) {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT id, code, name, depositamount FROM tblclient WHERE name LIKE ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getInt("id"));
                client.setCode(rs.getString("code"));
                client.setName(rs.getString("name"));
                client.setDepositamount(rs.getInt("depositamount"));
                clients.add(client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clients;
    }
}

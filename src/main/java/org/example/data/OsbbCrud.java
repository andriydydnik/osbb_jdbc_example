package org.example.data;

import org.apache.log4j.Logger;
import org.flywaydb.core.Flyway;

import java.io.Closeable;
import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.example.Config.*;

public class OsbbCrud implements Closeable {
    private static final Logger logger = Logger.getLogger(OsbbCrud.class);

    private Connection conn = null;

    private static final String sqlMembersWithAutoNotAllowedQuery = "select m.* \n" +
            "\n" +
            "from members m\n" +
            "join members_to_flats m2f on m2f.member_id = m.id\n" +
            "join tenants t on t.member_id = m.id\n" +
            "\n" +
            "where not t.auto_allow\n";

    private static final String sqlMemberByIdQuery = "select m.* \n" +
            "\n" +
            "from members m\n" +
            "where m.id = ? AND m.names LIKE ?\n";

    private void fwMigration() {
        logger.debug("Flyway migration execute");

        Flyway.configure()
                .dataSource(jdbcUrl, username, password)
                .locations("classpath:flyway/scripts")
                .load()
                .migrate();
    }

    public OsbbCrud init() throws SQLException {
        logger.info("Crud has initialized");

        fwMigration();

        conn = DriverManager.getConnection(jdbcUrl, username, password);
        return this;
    }

    @Override
    public void close() throws IOException {
        try {
            conn.close();
            conn = null;
        } catch (SQLException e) {
            throw new IOException(e);
        }
    }

    public List<Member> getMembersWithAutoNotAllowed() throws SQLException {
        logger.trace("Call getting members with auto not allowed method");

        final List<Member> result = new LinkedList<>();
        try (PreparedStatement preparedStatement = conn.prepareStatement(sqlMembersWithAutoNotAllowedQuery)) {
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                result.add(
                        new Member()
                                .setId(resultSet.getInt("id"))
                                .setName(resultSet.getString("names")));
        }

        return result;
    }

    public Optional<Member> getMemberById(final int id) throws SQLException {
        logger.trace("Call getting member by ID method");

        try (PreparedStatement preparedStatement = conn.prepareStatement(sqlMemberByIdQuery)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, "%Олексій%");
            final ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                return Optional.of(
                        new Member()
                                .setId(resultSet.getInt("id"))
                                .setName(resultSet.getString("names")));
        }

        return Optional.empty();
    }
}

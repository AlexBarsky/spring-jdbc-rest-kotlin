package ru.barsky.cargo.repository

import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.stereotype.Repository
import ru.barsky.cargo.model.Cargo
import ru.barsky.cargo.util.getIntOrNull

@Repository
class CargoRepositoryImpl(
    private val jdbcTemplate: NamedParameterJdbcTemplate,
) : CargoRepository {

    override fun getAll(): List<Cargo> =
        jdbcTemplate.query(
            "SELECT * FROM cargo ORDER BY title",
            ROW_MAPPER,
        )

    override fun findById(id: Int): Cargo? =
        jdbcTemplate.query(
            "SELECT * FROM cargo WHERE id = :id",
            mapOf(
                "id" to id
            ),
            ROW_MAPPER,
        ).firstOrNull()

    override fun create(title: String, passengerCount: Int?): Int {
        val keyHolder = GeneratedKeyHolder()

        jdbcTemplate.update(
            "INSERT INTO cargo (title, passenger_count) VALUES (:title, :passengerCount)",
            MapSqlParameterSource(
                mapOf(
                    "title" to title,
                    "passengerCount" to passengerCount,
                )
            ),
            keyHolder,
            listOf("id").toTypedArray()
        )
        return keyHolder.keys?.getValue("id") as Int
    }

    override fun update(id: Int, title: String, passengerCount: Int?) {
        jdbcTemplate.update(
            "UPDATE cargo SET title = :title, passenger_count = :passengerCount WHERE id = :id",
            mapOf(
                "id" to id,
                "title" to title,
                "passengerCount" to passengerCount,
            )
        )
    }

    override fun deleteById(id: Int) {
        jdbcTemplate.update(
            "DELETE FROM cargo WHERE id = :id",
            mapOf(
                "id" to id,
            )
        )
    }

    private companion object {
        val ROW_MAPPER = RowMapper<Cargo> { rs, _ ->
            Cargo(
                id = rs.getInt("id"),
                title = rs.getString("title"),
                passengerCount = rs.getIntOrNull("passenger_count"),
            )
        }
    }
}
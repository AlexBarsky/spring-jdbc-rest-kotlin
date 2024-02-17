package ru.barsky.cargo.repository

import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
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

    override fun create(model: Cargo) {
        TODO("Not yet implemented")
    }

    override fun update(id: Int, model: Cargo) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int) {
        TODO("Not yet implemented")
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